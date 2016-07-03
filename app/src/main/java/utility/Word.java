package utility;

/**
 * Created by Ayush on 01-07-2016.
 */
public class Word {
    private String englishTranslation;
    private String miwokTranslation;
    private int imageResourceId;
    private int songResourceId;

    public Word(String englishTranslation, String miwokTranslation, int songResourceId) {
        this.englishTranslation = englishTranslation;
        this.miwokTranslation = miwokTranslation;
        this.songResourceId = songResourceId;
    }

    public Word(String englishTranslation, String miwokTranslation, int imageResourceId, int songResourceId) {
        this.englishTranslation = englishTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = imageResourceId;
        this.songResourceId = songResourceId;
    }

    public int getSongResourceId() {
        return songResourceId;
    }

    public void setSongResourceId(int songResourceId) {
        this.songResourceId = songResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        this.englishTranslation = englishTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public void setMiwokTranslation(String miwokTranslation) {
        this.miwokTranslation = miwokTranslation;
    }

    @Override
    public String toString() {
        return "" + songResourceId ;
    }
}
