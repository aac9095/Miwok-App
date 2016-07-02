/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import adapter.wordAdapter;
import utility.Word;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.mipmap.number_one));
        words.add(new Word("two", "otiiko",R.mipmap.number_two));
        words.add(new Word("three", "tolookosu",R.mipmap.number_three));
        words.add(new Word("four", "oyyisa",R.mipmap.number_four));
        words.add(new Word("five", "massokka",R.mipmap.number_five));
        words.add(new Word("six", "temmokka",R.mipmap.number_six));
        words.add(new Word("seven", "kenekaku",R.mipmap.number_seven));
        words.add(new Word("eight", "kawinta",R.mipmap.number_eight));
        words.add(new Word("nine", "wo’e",R.mipmap.number_nine));
        words.add(new Word("ten", "na’aacha",R.mipmap.number_ten));

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.numbers_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        wordAdapter mAdapter = new wordAdapter(words,3);
        mRecyclerView.setAdapter(mAdapter);
    }
}
