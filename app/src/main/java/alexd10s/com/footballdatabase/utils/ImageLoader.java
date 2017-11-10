package alexd10s.com.footballdatabase.utils;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParseException;
import com.larvalabs.svgandroid.SVGParser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import alexd10s.com.footballdatabase.R;

/**
 * Created by alex on 13/08/2017.
 */

public class ImageLoader {




    public static void LoadClubImagesInTo(Context cntx, String urlImg, ImageView view) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final URL urlLogo;
        try {


            urlLogo = new URL(urlImg);
            //urlLogo = new URL("http://upload.wikimedia.org/wikipedia/de/d/da/Manchester_United_FC.svg");
            HttpURLConnection urlConnection = (HttpURLConnection) urlLogo.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.connect();
            InputStream input = urlConnection.getInputStream();
            //Bitmap myBitmap = BitmapFactory.decodeStream(input);
            //InputStream inputStream = urlConnection.getInputStream();
            SVG svg = SVGParser.getSVGFromInputStream(input);
            Drawable drawable = svg.createPictureDrawable();
            view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            view.setImageDrawable(drawable);
        }
        catch (SVGParseException e) {
            Log.e("ImageLoader", e.getMessage(), e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Glide.with(cntx).load(url).into(view);
    }
}
