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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import adapter.wordAdapter;
import utility.Word;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi",R.mipmap.color_red,R.raw.color_red));
        words.add(new Word("green", "chokokki",R.mipmap.color_green,R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki",R.mipmap.color_brown,R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi",R.mipmap.color_gray,R.raw.color_gray));
        words.add(new Word("black", "kululli",R.mipmap.color_black,R.raw.color_black));
        words.add(new Word("white", "kelelli",R.mipmap.color_white,R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә",R.mipmap.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә",R.mipmap.color_mustard_yellow,R.raw.color_mustard_yellow));

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.colors_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        wordAdapter mAdapter = new wordAdapter(words,R.color.category_colors);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        wordAdapter.releaseMediaPlayer();
    }
}
