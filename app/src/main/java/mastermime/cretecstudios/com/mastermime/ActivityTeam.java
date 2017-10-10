package mastermime.cretecstudios.com.mastermime;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import org.greenrobot.greendao.query.Query;

public class ActivityTeam extends AppCompatActivity {

    Button add;
    ListView teams_list;

    AlertDialog add_team_dialog;

    TeamItemListAdapter adapterListView;
    ArrayList<TeamItemList> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        findMyViews();

        fillTeams();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAddTeamDialog();

            }
        });

    }

    public void findMyViews(){

        add = (Button) findViewById(R.id.bt_team_add);
        teams_list = (ListView) findViewById(R.id.teams_list);

    }

    public void showAddTeamDialog(){

        LayoutInflater li = getLayoutInflater();

        Button cancel, ok;
        final EditText team_name;

        View dialog = li.inflate(R.layout.dialog_add_team, null);

        cancel = (Button) dialog.findViewById(R.id.add_team_cancel);
        ok = (Button) dialog.findViewById(R.id.add_team_ok);
        team_name = (EditText) dialog.findViewById(R.id.edt_add_team);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add_team_dialog.dismiss();

            }
        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (testaValores(team_name)) {

                    String teamName = team_name.getText().toString();

                    insertTeam(teamName);

                    add_team_dialog.dismiss();

                }


            }
        });

        fillTeams();

        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityTeam.this);
        builder.setTitle("");
        builder.setView(dialog);
        add_team_dialog = builder.create();
        add_team_dialog.show();

    }


    public boolean testaValores(TextView team_name){

        boolean test;

        if (team_name.getText().toString().equals("")) {
            team_name.setError("Digite um Nome!");
            test = false;
        } else {
            test = true;
        }


        return test;
    }

    public void insertTeam(String team_name){
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        ObjectTeamDao teamDao = daoSession.getObjectTeamDao();

        ObjectTeam team = new ObjectTeam();

        team.setName(team_name);
        teamDao.insert(team);
    }

    public void fillTeams(){

        itens = new ArrayList<TeamItemList>();

        HelperDataBase hdb = new HelperDataBase(getApplicationContext());
        SQLiteDatabase db = hdb.getWritableDatabase();

        Cursor c = db.query("team", new String[]{"name", "code"}, null, null, null, null, "name");

        if (c.getCount() > 0) {

            while (c.moveToNext()) {

                TeamItemList item = new TeamItemList(c.getString(0), c.getString(1));

                itens.add(item);

            }

        }

        adapterListView = new TeamItemListAdapter(this, itens);

        teams_list.setAdapter(adapterListView);

        db.close();

    }

}
