package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.miwok.R;

import java.util.ArrayList;

import adapter.wordAdapter;
import utility.Word;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragments extends Fragment {


    public Fragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_list,container,false);

        ArrayList<Word> words = getArguments().getParcelableArrayList("arrayList");

        int color = getArguments().getInt("color");

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        wordAdapter mAdapter = new wordAdapter(words,color);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        wordAdapter.releaseMediaPlayer();
    }
}