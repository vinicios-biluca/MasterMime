package mastermime.cretecstudios.com.mastermime;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vinicios-biluca on 17/09/17.
 */

public class WordItemListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<ObjectWord> itens;

    public WordItemListAdapter(Context context, ArrayList<ObjectWord> itens)    {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.itens.size();
    }

    @Override
    public Object getItem(int position) {
        return this.itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //Pega o item de acordo com a posção.
        ObjectWord item = itens.get(position);
        //infla o team_itemlist para podermos preencher os dados
        view = mInflater.inflate(R.layout.words_itemlist, null);

        //atravez do team_itemlist pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.

        TextView word_text = (TextView) view.findViewById(R.id.itemlist_wordtext);
        TextView category_text = (TextView) view.findViewById(R.id.itemlist_categorytext);
        ImageView image = (ImageView) view.findViewById(R.id.itemlist_image);

        word_text.setText(item.getWord());
        category_text.setText(item.getCategory());

        int aux = item.getImage();

        image.setImageResource((item.getImage()));

        return view;
    }
}
