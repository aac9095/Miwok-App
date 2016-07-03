package adapter;

/**
 * Created by Ayush on 30-06-2016.
 */
import java.util.ArrayList;

import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.R;

import utility.Word;

public class wordAdapter extends RecyclerView.Adapter<wordAdapter.ViewHolder> {
    private ArrayList<Word> mDataset;
    private int color;
    static public MediaPlayer mediaPlayer;
    static private int songID;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView noEnglish,noMiwok;
        public ImageView imageView;
        public RelativeLayout relativeLayout_image,relativeLayout_text;


        public ViewHolder(View v) {
            super(v);
            noEnglish = (TextView) v.findViewById(R.id.number_in_english);
            noMiwok = (TextView) v.findViewById(R.id.number_in_miwok);
            imageView = (ImageView) v.findViewById(R.id.image);
            relativeLayout_image = (RelativeLayout) v.findViewById(R.id.image_layout);
            relativeLayout_text = (RelativeLayout) v.findViewById(R.id.textview_layout);
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
    public wordAdapter(ArrayList<Word> myDataset,int type) {
        mDataset = myDataset;
        color = type;
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.noEnglish.setText(mDataset.get(position).getEnglishTranslation());
        holder.noMiwok.setText(mDataset.get(position).getMiwokTranslation());
        holder.relativeLayout_text.setBackgroundColor(ContextCompat.getColor(holder.noEnglish.getContext(),color));
        releaseMediaPlayer();
        final Word word = mDataset.get(position);
        mediaPlayer = MediaPlayer.create(holder.noEnglish.getContext(), word.getSongResourceId());
        songID=word.getSongResourceId();
        holder.relativeLayout_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(mediaPlayer != null && mediaPlayer.isPlaying() && songID == word.getSongResourceId()) {
                        mediaPlayer.pause();
                    }
                    else {
                        //Log.e("Release MediaPlayer","from word adapter");
                        releaseMediaPlayer();
                        mediaPlayer = MediaPlayer.create(holder.noEnglish.getContext(), word.getSongResourceId());
                        songID=word.getSongResourceId();
                        mediaPlayer.start();
                    }

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            //Log.e("Release MediaPlayer","from OnCompletionListener");
                            releaseMediaPlayer();
                        }
                    });
                }
                catch (IllegalStateException i){
                    Log.e("Stack Trace",i.toString());
                    i.printStackTrace();
                }
                catch (NullPointerException n){
                    Log.e("Exception",n.toString());
                    n.printStackTrace();
                }
            }
        });

        if(word.getImageResourceId()!=0)
            holder.imageView.setImageResource(word.getImageResourceId());
        else{
            holder.imageView.setVisibility(View.GONE);
            holder.relativeLayout_image.setVisibility(View.GONE);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static public void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            songID=0;
            mediaPlayer = null;
        }
    }

}
