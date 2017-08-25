package alexd10s.com.footballdatabase.interfaces;

import android.view.View;

/**
 * Created by alex on 13/08/2017.
 */

public interface ILeagueClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
