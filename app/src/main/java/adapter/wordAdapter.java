package adapter;

/**
 * Created by Ayush on 30-06-2016.
 */
import java.util.ArrayList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.miwok.R;

import utility.Word;

public class wordAdapter extends RecyclerView.Adapter<wordAdapter.ViewHolder> {
    private ArrayList<Word> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView noEnglish,noMiwok;

        public ViewHolder(View v) {
            super(v);
            noEnglish = (TextView) v.findViewById(R.id.number_in_english);
            noMiwok = (TextView) v.findViewById(R.id.number_in_miwok);
        }
    }

    public void add(int position, Word item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Word item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public wordAdapter(ArrayList<Word> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public wordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_adapter, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.noEnglish.setText(mDataset.get(position).getEnglishTranslation());
        holder.noMiwok.setText(mDataset.get(position).getMiwokTranslation());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
