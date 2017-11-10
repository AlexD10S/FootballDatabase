package alexd10s.com.footballdatabase.interfaces;

import android.view.View;
/**
 * Created by alex on 28/09/2017.
 */


public interface IClubClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}