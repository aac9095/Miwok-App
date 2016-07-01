package utility;

/**
 * Created by Ayush on 01-07-2016.
 */
public class Word {
    private String englishTranslation;
    private String miwokTranslation;

    public Word(String englishTranslation, String miwokTranslation) {
        this.englishTranslation = englishTranslation;
        this.miwokTranslation = miwokTranslation;
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
}
