package utility;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ayush on 01-07-2016.
 */
public class Word implements Parcelable{
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.englishTranslation);
        dest.writeString(this.miwokTranslation);
        dest.writeInt(this.imageResourceId);
        dest.writeInt(this.songResourceId);
    }

    protected Word(Parcel in) {
        this.englishTranslation = in.readString();
        this.miwokTranslation = in.readString();
        this.imageResourceId = in.readInt();
        this.songResourceId = in.readInt();
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel source) {
            return new Word(source);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };
}
