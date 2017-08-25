package alexd10s.com.footballdatabase.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import alexd10s.com.footballdatabase.R;
import alexd10s.com.footballdatabase.model.Standing;
import alexd10s.com.footballdatabase.utils.ImageLoader;

/**
 * Created by alex on 13/08/2017.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    private ArrayList<Standing> mDataset;
    private int currentPosition = 0;
    private LayoutInflater inflater;
    Context cntx;
    private String TAG = "TableAdapter";



    public TableAdapter(Context xntx, ArrayList<Standing> list) {
        inflater = LayoutInflater.from(xntx);
        cntx = xntx;
        mDataset = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mImageView;
        public TextView mRank;
        public TextView mName;
        public TextView mMatches;
        public TextView mGoals;
        public TextView mGoalsAgainst;
        public TextView mGoalsDiff;
        public TextView mPoints;

        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.item_table_img);
            mRank = (TextView) v.findViewById(R.id.item_table_rank);
            mName = (TextView) v.findViewById(R.id.item_table_name);
            mMatches = (TextView) v.findViewById(R.id.item_table_plays);
            mGoals = (TextView) v.findViewById(R.id.item_table_goals);
            mGoalsAgainst = (TextView) v.findViewById(R.id.item_table_goalsAgainst);
            mGoalsDiff = (TextView) v.findViewById(R.id.item_table_goalsDiff);
            mPoints = (TextView) v.findViewById(R.id.item_table_points);
        }
    }

    @Override
    public TableAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.table_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Standing standing = mDataset.get(position);

        ImageLoader.LoadClubImagesInTo(cntx, standing.getCrestURI(), holder.mImageView);
        holder.mName.setText(standing.getTeam());
        holder.mRank.setText(String.valueOf(standing.getRank()));
        holder.mMatches.setText(String.valueOf(standing.getPlayedGames()));
        holder.mGoals.setText(String.valueOf(standing.getGoals()));
        holder.mGoalsAgainst.setText(String.valueOf(standing.getGoalsAgainst()));
        holder.mGoalsDiff.setText(String.valueOf(standing.getGoalDifference()));
        holder.mPoints.setText(String.valueOf(standing.getPoints()));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
