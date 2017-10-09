package mastermime.cretecstudios.com.mastermime;

/**
 * Created by vinicios-biluca on 18/09/17.
 */

public class ObjectWord {

    int id;
    String word;
    String category;
    String tip;
    String status;

    public ObjectWord() {

    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getCategory() {
        return category;
    }

    public String getTip() {
        return tip;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String insertWord() {

        word = word.toUpperCase();

        return ("INSERT INTO word VALUES(null,'" + this.word + "','" + this.tip + "','" + this.category + "', 'FREE')");

    }

    public String deleteWord() {

        return ("DELETE FROM word WHERE id = " + this.id + ";");

    }

}
