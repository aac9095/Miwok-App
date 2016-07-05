package adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.miwok.R;

import java.util.ArrayList;

import fragments.Fragments;
import utility.Word;

/**
 * Created by Ayush on 04-07-2016.
 */
public class PageAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Numbers", "Colors", "Family", "Phrases" };

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        Fragments fragments = new Fragments();
        ArrayList<Word> words = new ArrayList<Word>();
        if (position == 0) {
            words.add(new Word("one", "lutti", R.mipmap.number_one,R.raw.number_one));
            words.add(new Word("two", "otiiko",R.mipmap.number_two,R.raw.number_two));
            words.add(new Word("three", "tolookosu",R.mipmap.number_three,R.raw.number_three));
            words.add(new Word("four", "oyyisa",R.mipmap.number_four,R.raw.number_four));
            words.add(new Word("five", "massokka",R.mipmap.number_five,R.raw.number_five));
            words.add(new Word("six", "temmokka",R.mipmap.number_six,R.raw.number_six));
            words.add(new Word("seven", "kenekaku",R.mipmap.number_seven,R.raw.number_seven));
            words.add(new Word("eight", "kawinta",R.mipmap.number_eight,R.raw.number_eight));
            words.add(new Word("nine", "wo’e",R.mipmap.number_nine,R.raw.number_nine));
            words.add(new Word("ten", "na’aacha",R.mipmap.number_ten,R.raw.number_ten));
            args.putParcelableArrayList("arrayList",words);
            args.putInt("color",R.color.category_numbers);
        }else if(position == 1){
            words.add(new Word("red", "weṭeṭṭi",R.mipmap.color_red,R.raw.color_red));
            words.add(new Word("green", "chokokki",R.mipmap.color_green,R.raw.color_green));
            words.add(new Word("brown", "ṭakaakki",R.mipmap.color_brown,R.raw.color_brown));
            words.add(new Word("gray", "ṭopoppi",R.mipmap.color_gray,R.raw.color_gray));
            words.add(new Word("black", "kululli",R.mipmap.color_black,R.raw.color_black));
            words.add(new Word("white", "kelelli",R.mipmap.color_white,R.raw.color_white));
            words.add(new Word("dusty yellow", "ṭopiisә",R.mipmap.color_dusty_yellow,R.raw.color_dusty_yellow));
            words.add(new Word("mustard yellow", "chiwiiṭә",R.mipmap.color_mustard_yellow,R.raw.color_mustard_yellow));
            args.putParcelableArrayList("arrayList",words);
            args.putInt("color",R.color.category_colors);
        }else if(position == 2){
            words.add(new Word("father", "әpә",R.mipmap.family_father,R.raw.family_father));
            words.add(new Word("mother", "әṭa",R.mipmap.family_mother,R.raw.family_mother));
            words.add(new Word("son", "angsi",R.mipmap.family_son,R.raw.family_son));
            words.add(new Word("daughter", "tune",R.mipmap.family_daughter,R.raw.family_daughter));
            words.add(new Word("older brother", "taachi",R.mipmap.family_older_brother,R.raw.family_older_brother));
            words.add(new Word("younger brother", "chalitti",R.mipmap.family_younger_brother,R.raw.family_younger_brother));
            words.add(new Word("older sister", "teṭe",R.mipmap.family_older_sister,R.raw.family_older_sister));
            words.add(new Word("younger sister", "kolliti",R.mipmap.family_younger_sister,R.raw.family_younger_sister));
            words.add(new Word("grandmother", "ama",R.mipmap.family_grandmother,R.raw.family_grandmother));
            words.add(new Word("grandfather", "paapa",R.mipmap.family_grandfather,R.raw.family_grandfather));
            args.putParcelableArrayList("arrayList",words);
            args.putInt("color",R.color.category_family);
        }else {
            words.add(new Word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
            words.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
            words.add(new Word("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
            words.add(new Word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
            words.add(new Word("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
            words.add(new Word("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
            words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
            words.add(new Word("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
            words.add(new Word("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
            words.add(new Word("Come here.", "әnni'nem",R.raw.phrase_come_here));
            args.putParcelableArrayList("arrayList",words);
            args.putInt("color",R.color.category_phrases);
        }
        fragments.setArguments(args);
        return fragments;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
