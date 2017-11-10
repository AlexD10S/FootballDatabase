package alexd10s.com.footballdatabase.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import alexd10s.com.footballdatabase.R;
import alexd10s.com.footballdatabase.model.Team;
import alexd10s.com.footballdatabase.utils.ImageLoader;

/**
 * Created by alex on 06/09/2017.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private ArrayList<Team> mDataset;
    private LayoutInflater inflater;
    Context cntx;
    private String TAG = "TeamsAdapter";

    public TeamsAdapter(Context xntx, ArrayList<Team> list) {
        inflater = LayoutInflater.from(xntx);
        cntx = xntx;
        mDataset = list;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        //public ImageView mImageView;
        //public ImageView mImageView;
        public TextView mName;


        public ViewHolder(View v) {
            super(v);
            //mImageView = (ImageView) v.findViewById(R.id.item_table_img);
            //mImageView = (ImageView) v.findViewById(R.id.item_team_img);
            mName = (TextView) v.findViewById(R.id.item_teams_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.teams_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = mDataset.get(position);

        //ImageLoader.LoadClubImagesInTo(cntx, team.getCrestUrl(), holder.mImageView);

        //holder.mImageView.loadDataWithBaseURL(null,"<html><head></head><body><table style=\"width:100%; height:100%;\"><tr><td style=\"vertical-align:middle;\"><img src=\"" + team.getCrestUrl() + "\"></td></tr></table></body></html>","html/css", "utf-8", null);
        holder.mName.setText(team.getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
