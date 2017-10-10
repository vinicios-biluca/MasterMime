package mastermime.cretecstudios.com.mastermime;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by vinicios-biluca on 18/09/17.
 */

@Entity
public class ObjectWord {

    @Id
    long id;
    @Unique
    String word;
    String category;
    String tip;
    String status;
    @Generated(hash = 29622079)
    public ObjectWord(long id, String word, String category, String tip, String status) {
        this.id = id;
        this.word = word;
        this.category = category;
        this.tip = tip;
        this.status = status;
    }
    @Generated(hash = 1556957847)
    public ObjectWord() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getWord() {
        return this.word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getTip() {
        return this.tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    /*public ObjectWord() {

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
    */

}
