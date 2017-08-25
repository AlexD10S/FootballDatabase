package alexd10s.com.footballdatabase.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

/**
 * Created by alex on 13/08/2017.
 */

public class ImageLoader {

    public static void LoadClubImagesInTo(Context cntx, String url, ImageView view) {


        Glide.with(cntx).load(url).into(view);
    }
}
