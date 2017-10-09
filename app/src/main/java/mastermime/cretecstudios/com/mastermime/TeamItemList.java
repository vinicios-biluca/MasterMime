package mastermime.cretecstudios.com.mastermime;

/**
 * Created by vinicios-biluca on 03/10/17.
 */

public class TeamItemList {

    int image;
    String code;
    String team_name;

    public TeamItemList(String team_name, String id){

        this.team_name = team_name;
        this.code = id;

    }

    public String getTeam_name() {
        return this.team_name;
    }

    public String getId() {
        return this.code;
    }
}
