package mastermime.cretecstudios.com.mastermime;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

public class ActivityWords extends AppCompatActivity {

    ListView words_list;
    TextView words_count;
    EditText search_text;
    Button add_word;

    AlertDialog add_word_dialog;
    AlertDialog delete_word_dialog;

    WordItemListAdapter adapterListView;
    ArrayList<ObjectWord> itens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_words);

        findMyViews();

        fillWordsList();

    }

    //Método para vincular as Views
    public void findMyViews() {

        words_list = (ListView) findViewById(R.id.words_list);
        words_count = (TextView) findViewById(R.id.words_count);
        search_text = (EditText) findViewById(R.id.words_search_text);

        add_word = (Button) findViewById(R.id.bt_words_add);

        //Mosta o Diálogo para adicionar uma nova Palavra
        add_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAddWordDialog();

            }
        });

        //Mostra o Diálogo que pergunta se o Usuário quer deletar a palavra selecionada
        words_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int index, long id) {

                ObjectWord item = itens.get(index);

                showDeleteWordDialog(item.getId(), item.getWord());

                return false;
            }
        });

        //Método para filtrar a lista de palavras conforme o texto digitado
        search_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                String search_sequence = search_text.getText().toString().toUpperCase();

                if (search_sequence.length() > 0) {

                    fillWordsList(search_sequence);

                } else {
                    fillWordsList();
                }


            }
        });


    }

    //Diálogo para adicionar uma palavra
    public void showAddWordDialog() {

        LayoutInflater li = getLayoutInflater();

        final Spinner categorias;
        Button cancel, ok;
        final EditText word, tip;

        View dialog = li.inflate(R.layout.dialog_add_word, null);

        categorias = (Spinner) dialog.findViewById(R.id.add_word_categorias);
        cancel = (Button) dialog.findViewById(R.id.add_word_cancel);
        ok = (Button) dialog.findViewById(R.id.add_word_ok);

        word = (EditText) dialog.findViewById(R.id.edt_add_word);
        tip = (EditText) dialog.findViewById(R.id.edt_add_tip);

        fillCategorias(categorias);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add_word_dialog.dismiss();

            }
        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (testaValores(word, tip)) {

                    String word_text = word.getText().toString();
                    String tip_text = tip.getText().toString();
                    String category_text = categorias.getSelectedItem().toString();

                    insertWord(word_text, tip_text, category_text);

                    word.setText("");

                    add_word_dialog.dismiss();

                }


            }
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityWords.this);
        builder.setTitle("");
        builder.setView(dialog);
        add_word_dialog = builder.create();
        add_word_dialog.show();

    }

    //Diálogo para deletar uma palavra
    public void showDeleteWordDialog(Long id, String word) {

        final Long cod_id = id;

        LayoutInflater li = getLayoutInflater();

        TextView deleted_word;
        Button cancel, ok;

        View dialog = li.inflate(R.layout.dialog_delete_word, null);

        deleted_word = (TextView) dialog.findViewById(R.id.deleted_word);
        ok = (Button) dialog.findViewById(R.id.delete_word_ok);
        cancel = (Button) dialog.findViewById(R.id.delete_word_cancel);

        deleted_word.setText(word);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                delete_word_dialog.dismiss();

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteWord(cod_id);

                delete_word_dialog.dismiss();

            }
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityWords.this);
        builder.setTitle("");
        builder.setView(dialog);
        delete_word_dialog = builder.create();
        delete_word_dialog.show();

    }

    //Testa os valores na adição das palavras
    public boolean testaValores(TextView word, TextView tip) {

        boolean test;

        if (word.getText().toString().equals("")) {
            word.setError("Digite uma Palavra!");
            test = false;
        } else {
            test = true;
        }

        if (tip.getText().toString().equals("")) {
            tip.setError("Digita uma Dica!");
            test = false;
        } else {
            test = true;
        }

        return test;
    }

    //Método que insere uma palavra na Base de Dados
    public void insertWord(String word, String tip, String category) {

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();

        ObjectWord word_object = new ObjectWord();

        word_object.setWord(word.toUpperCase());
        word_object.setTip(tip);
        word_object.setCategory(category);

        daoSession.getObjectWordDao().insert(word_object);

        fillWordsList();

        Toast toast = Toast.makeText(getApplicationContext(), "Palavra Salva!", Toast.LENGTH_SHORT);
        toast.show();

    }

    //Método que deleta uma palavra na Base de Dados
    public void deleteWord(Long id) {

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();

        ObjectWord word_object = new ObjectWord();

        word_object.setId(id);

        daoSession.getObjectWordDao().delete(word_object);

        fillWordsList();

        Toast toast = Toast.makeText(getApplicationContext(), "Palavra Deletada!", Toast.LENGTH_SHORT);
        toast.show();
    }

    //Preenche a lista de Categorias salvas no banco
    public void fillCategorias(Spinner categorias) {

        ObjectWord word = new ObjectWord();

        ArrayList<String> categories = word.getCategories();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.words_category_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(adapter);


    }

    //Preenche a lista de palavras com todas as palavras salvas no banco
    public void fillWordsList() {

        itens = new ArrayList<ObjectWord>();

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();

        List<ObjectWord> words = daoSession.getObjectWordDao().loadAll();

        for (ObjectWord w : words) {

            Long id = w.getId();
            String word = w.getWord();
            String tip = w.getTip();
            String category = w.getCategory();
            String status = w.getStatus();
            int image = w.getImage();

            ObjectWord aux = new ObjectWord(id, word, tip, category, status);
            aux.setImage(image);

            itens.add(aux);


        }

        if (itens.size() > 0) {
            words_count.setText(itens.size() + " palavras encontradas");
        } else {
            words_count.setText("0 palavras encontradas");
        }

        adapterListView = new WordItemListAdapter(this, itens);
        words_list.setAdapter(adapterListView);


    }

    //Preenche a lista de palavras a partir do filtro
    public void fillWordsList(String search_text) {

        itens = new ArrayList<ObjectWord>();

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();

        Query<ObjectWord> query = daoSession.getObjectWordDao().queryRawCreate("WHERE WORD like ?", "%" + search_text.toUpperCase() + "%");
        List<ObjectWord> words = query.list();

        for (ObjectWord w : words) {

            Long id = w.getId();
            String word = w.getWord();
            String tip = w.getTip();
            String category = w.getCategory();
            String status = w.getStatus();
            int image = w.getImage();

            ObjectWord aux = new ObjectWord(id, word, tip, category, status);
            aux.setImage(image);

            itens.add(aux);


        }

        if (itens.size() > 0) {
            words_count.setText(itens.size() + " palavras encontradas");
        } else {
            words_count.setText("0 palavras encontradas");
        }

        adapterListView = new WordItemListAdapter(this, itens);
        words_list.setAdapter(adapterListView);


    }


}
