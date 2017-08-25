package alexd10s.com.footballdatabase.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import alexd10s.com.footballdatabase.R;
import alexd10s.com.footballdatabase.model.League;

/**
 * Created by alex on 12/08/2017.
 */

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.ViewHolder>  {

    private ArrayList<League> mDataset;
    private int currentPosition = 0;
    private LayoutInflater inflater;
    Context cntx;
    private String TAG = "LeagueAdapter";

    public LeagueAdapter(Context xntx, ArrayList<League> list) {
        inflater = LayoutInflater.from(xntx);
        cntx = xntx;
        mDataset = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mImageView;
        public TextView mName;

        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.item_club_img);
            mName = (TextView) v.findViewById(R.id.item_club_title);
        }
    }

    @Override
    public LeagueAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.league_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        League league = mDataset.get(position);
        holder.mName.setText(league.getCaption());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
