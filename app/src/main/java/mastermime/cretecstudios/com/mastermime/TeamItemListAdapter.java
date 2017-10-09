package mastermime.cretecstudios.com.mastermime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vinicios-biluca on 03/10/17.
 */

public class TeamItemListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<TeamItemList> teams;

    public TeamItemListAdapter(Context context, ArrayList<TeamItemList> teams) {
        //Itens que preencheram o listview
        this.teams = teams;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.teams.size();
    }

    @Override
    public Object getItem(int position) {
        return this.teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        TeamItemList team = teams.get(position);

        view = mInflater.inflate(R.layout.team_itemlist, null);

        TextView team_name = (TextView) view.findViewById(R.id.itemlist_teamname);

        team_name.setText(team.getTeam_name());

        return view;
    }
}
