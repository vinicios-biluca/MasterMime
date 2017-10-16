package mastermime.cretecstudios.com.mastermime;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinicios-biluca on 18/09/17.
 */

@Entity
public class ObjectWord {

    @Transient
    final String ACTION = "AÇÃO";
    @Transient
    final String ANIMALS = "ANIMAIS";
    @Transient
    final String FOODS = "COMIDAS";
    @Transient
    final String MIX = "DIVERSOS";
    @Transient
    final String MOVIES = "FILMES e SÉRIES";
    @Transient
    final String OBJECT = "OBJETOS";
    @Transient
    final String PERSONS = "PESSOAS";
    @Transient
    final String PLACES = "LUGARES";
    @Transient
    public ArrayList<String> categories = new ArrayList<>();


    @Id(autoincrement = true)
    Long id;

    @Property
    String word;

    @Property
    String tip;

    @Property
    String category;

    @Property
    String status;

    @Transient
    int image;

    @Generated(hash = 1546803797)
    public ObjectWord(Long id, String word, String tip, String category,
            String status) {
        this.id = id;
        this.word = word;
        this.tip = tip;
        this.category = category;
        this.status = status;

    }

    @Generated(hash = 1556957847)
    public ObjectWord() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTip() {
        return this.tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImage(int image){
        this.image = image;
    }

    public int getImage() {

        if(this.category.equals(ACTION)){
            this.image = R.drawable.actions_icon;
        }

        if(this.category.equals(ANIMALS)){
            this.image = R.drawable.animals_icon;
        }

        if(this.category.equals(FOODS)){
            this.image = R.drawable.food_icon;
        }

        if(this.category.equals(MIX)){
            this.image = R.drawable.mix_icon;
        }

        if(this.category.equals(MOVIES)){
            this.image = R.drawable.movies_icon;
        }

        if(this.category.equals(OBJECT)){
            this.image = R.drawable.objects_icon;
        }

        if(this.category.equals(PERSONS)){
            this.image = R.drawable.famous_icon;
        }

        if(this.category.equals(PLACES)){
            this.image = R.drawable.places_icon;
        }

        return this.image;
    }

    public ArrayList<String> getCategories(){

        this.categories.add(ACTION);
        this.categories.add(ANIMALS);
        this.categories.add(FOODS);
        this.categories.add(MIX);
        this.categories.add(MOVIES);
        this.categories.add(OBJECT);
        this.categories.add(PERSONS);
        this.categories.add(PLACES);

        return this.categories;

    }


}