package mastermime.cretecstudios.com.mastermime;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by vinicios-biluca on 17/09/17.
 */

public class WordItemList {

    int image;
    int id;
    String word_text;
    String category_text;

    public WordItemList() {

    }

    public WordItemList(int image, String word_text, String category_text, int id) {

        this.image = image;
        this.word_text = word_text;
        this.category_text = category_text;
        this.id = id;

    }

    public String getWordText() {
        return this.word_text;
    }

    public String getCategoryText() {
        return this.category_text;
    }

    public int getImage() {
        return this.image;
    }

    public int getId() {
        return this.id;
    }
}
