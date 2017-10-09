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

import java.util.ArrayList;

public class ActivityWords extends AppCompatActivity {

    ListView words_list;
    TextView words_count;
    EditText search_text;
    Button add_word;

    AlertDialog add_word_dialog;
    AlertDialog delete_word_dialog;

    WordItemListAdapter adapterListView;
    ArrayList<WordItemList> itens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_words);

        findMyViews();
        fillWordsList();

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

                WordItemList item = itens.get(index);

                showDeleteWordDialog(item.getId(), item.getWordText());

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

    //Método para vincular as Views
    public void findMyViews() {

        words_list = (ListView) findViewById(R.id.words_list);
        words_count = (TextView) findViewById(R.id.words_count);
        search_text = (EditText) findViewById(R.id.words_search_text);

        add_word = (Button) findViewById(R.id.bt_words_add);


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
    public void showDeleteWordDialog(int id, String word) {

        final int cod_id = id;

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
        HelperDataBase hdb = new HelperDataBase(getApplicationContext());
        SQLiteDatabase db = hdb.getWritableDatabase();

        ObjectWord word_object = new ObjectWord();

        word_object.setWord(word);
        word_object.setTip(tip);
        word_object.setCategory(category);

        String sql = word_object.insertWord();

        db.execSQL(sql);

        db.close();

        fillWordsList();

        Toast toast = Toast.makeText(getApplicationContext(), "Palavra Salva!", Toast.LENGTH_SHORT);
        toast.show();

    }

    //Método que deleta uma palavra na Base de Dados
    public void deleteWord(int id) {
        HelperDataBase hdb = new HelperDataBase(getApplicationContext());
        SQLiteDatabase db = hdb.getWritableDatabase();

        ObjectWord word_object = new ObjectWord();
        word_object.setId(id);

        String sql = word_object.deleteWord();

        db.execSQL(sql);

        db.close();

        fillWordsList();

        Toast toast = Toast.makeText(getApplicationContext(), "Palavra Deletada!", Toast.LENGTH_SHORT);
        toast.show();
    }

    //Preenche a lista de Categorias salvas no banco
    public void fillCategorias(Spinner categorias) {

        HelperDataBase hdb = new HelperDataBase(getApplicationContext());
        SQLiteDatabase db = hdb.getWritableDatabase();

        Cursor c = db.query(true, "word", new String[]{"category"}, null, null, null, null, "category", "10");

        ArrayList<String> categories = new ArrayList<String>();

        if (c.getCount() > 0) {

            while (c.moveToNext()) {

                categories.add(c.getString(0));

            }

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.words_category_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(adapter);

        db.close();

    }

    //Preenche a lista de palavras com todas as palavras salvas no banco
    public void fillWordsList() {

        itens = new ArrayList<WordItemList>();

        HelperDataBase hdb = new HelperDataBase(getApplicationContext());
        SQLiteDatabase db = hdb.getWritableDatabase();

        Cursor c = db.query("word", new String[]{"word", "category", "id"}, null, null, null, null, "word");

        if (c.getCount() > 0) {

            words_count.setText(String.valueOf(c.getCount()) + " palavras encontradas");

            while (c.moveToNext()) {

                int icon = getCategoryIcon(c.getString(1));

                WordItemList item = new WordItemList(icon, c.getString(0), c.getString(1), c.getInt(2));

                itens.add(item);

            }

        } else {

            words_count.setText("Nenhuma palavra encontrada");

        }

        adapterListView = new WordItemListAdapter(this, itens);

        words_list.setAdapter(adapterListView);


        db.close();

    }

    //Preenche a lista de palavras conforme uma String de Filtro
    public void fillWordsList(String search_text) {

        itens = new ArrayList<WordItemList>();

        HelperDataBase hdb = new HelperDataBase(getApplicationContext());
        SQLiteDatabase db = hdb.getWritableDatabase();

        Cursor c = db.query("word", new String[]{"word", "category", "id"}, "word like ?", new String[]{"%" + search_text + "%"}, null, null, "word");

        if (c.getCount() > 0) {

            words_count.setText(String.valueOf(c.getCount()) + " palavras encontradas");

            while (c.moveToNext()) {

                int icon = getCategoryIcon(c.getString(1));

                WordItemList item = new WordItemList(icon, c.getString(0), c.getString(1), c.getInt(2));

                itens.add(item);

            }

        } else {

            words_count.setText("Nenhuma palavra encontrada");

        }

        adapterListView = new WordItemListAdapter(this, itens);

        words_list.setAdapter(adapterListView);


        db.close();

    }

    //Método que retorna o ícone adequado conforme a Categoria
    public int getCategoryIcon(String category) {

        if (category.equals("ACTION")) {
            return R.drawable.actions_icon;
        }

        if (category.equals("ANIMALS")) {
            return R.drawable.animals_icon;
        }

        if (category.equals("FAMOUS")) {
            return R.drawable.famous_icon;
        }

        if (category.equals("FOODS")) {
            return R.drawable.food_icon;
        }

        if (category.equals("MIX")) {
            return R.drawable.mix_icon;
        }

        if (category.equals("MOVIES")) {
            return R.drawable.movies_icon;
        }

        if (category.equals("OBJECT")) {
            return R.drawable.objects_icon;
        }

        if (category.equals("PLACES")) {
            return R.drawable.places_icon;
        }

        return R.drawable.info_icon;

    }
}
