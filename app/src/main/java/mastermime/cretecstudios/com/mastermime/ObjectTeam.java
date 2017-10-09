package mastermime.cretecstudios.com.mastermime;

import java.util.ArrayList;

/**
 * Created by vinicios-biluca on 29/09/17.
 */

public class ObjectTeam {

    String code;
    String name;

    //TODO Criar a possibilidade de vincular um simbolo à Equipe;
    int symbol;

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public String insertTeam() {

        return "INSERT INTO team VALUES(null,'" + this.code + "','" + this.name + "');";

    }



}
