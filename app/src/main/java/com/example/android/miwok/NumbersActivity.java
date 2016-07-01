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

import java.util.ArrayList;

import adapter.numberAdapter;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> myDataset = new ArrayList<String>();
        myDataset.add(0,"one");
        myDataset.add(1,"two");
        myDataset.add(2,"three");
        myDataset.add(3,"four");
        myDataset.add(4,"five");
        myDataset.add(5,"six");
        myDataset.add(6,"seven");
        myDataset.add(7,"eight");
        myDataset.add(8,"nine");
        myDataset.add(9,"ten");

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.numbers_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        numberAdapter mAdapter = new numberAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
