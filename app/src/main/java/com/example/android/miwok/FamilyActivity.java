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

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә",R.mipmap.family_father));
        words.add(new Word("mother", "әṭa",R.mipmap.family_mother));
        words.add(new Word("son", "angsi",R.mipmap.family_son));
        words.add(new Word("daughter", "tune",R.mipmap.family_daughter));
        words.add(new Word("older brother", "taachi",R.mipmap.family_older_brother));
        words.add(new Word("younger brother", "chalitti",R.mipmap.family_younger_brother));
        words.add(new Word("older sister", "teṭe",R.mipmap.family_older_sister));
        words.add(new Word("younger sister", "kolliti",R.mipmap.family_younger_sister));
        words.add(new Word("grandmother", "ama",R.mipmap.family_grandmother));
        words.add(new Word("grandfather", "paapa",R.mipmap.family_grandfather));

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.family_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        wordAdapter mAdapter = new wordAdapter(words,2);
        mRecyclerView.setAdapter(mAdapter);

    }
}
