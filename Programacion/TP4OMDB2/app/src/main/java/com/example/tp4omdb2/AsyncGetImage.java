package com.example.tp4omdb2;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AsyncGetImage extends AsyncTask<String,Void,Bitmap> {
    IOnFinishListener _event;
    private ImageView _imgPoster;
    public AsyncGetImage(ImageView imgPoster){
        _imgPoster = imgPoster;
    }

    public void set_onFinishListener(IOnFinishListener onFinishListener){
        _event = onFinishListener;
    }
    protected Bitmap doInBackground(String ... url){
        Bitmap bitmapImage = null;
        try{
            URL myUrl;
            myUrl = new URL(url[0]);
            HttpURLConnection conectionUrl;
            conectionUrl = (HttpURLConnection) myUrl.openConnection();
            if (conectionUrl.getResponseCode() == 200){
                InputStream dataBody=conectionUrl.getInputStream();
                BufferedInputStream inputLector = new BufferedInputStream(dataBody);
                bitmapImage = BitmapFactory.decodeStream(inputLector);
                conectionUrl.disconnect();
            }else{
                Log.d("error response code",conectionUrl.getResponseCode() +"");
            }
        }catch(Exception error){
            Log.d("Error xd", "Error:"+error.getMessage().toString());
        }
        return bitmapImage;
    }


    protected void onPostExecute(Bitmap bitmapImage){
        if(bitmapImage != null)
            _event.onFinish(bitmapImage, _imgPoster);
    }

    public interface IOnFinishListener{
        void onFinish(Bitmap bitmapImage, ImageView imgPoster);
    }

}