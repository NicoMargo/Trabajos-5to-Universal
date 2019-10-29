package com.example.tp5_face;

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

import com.microsoft.projectoxford.face.FaceServiceClient;
import com.microsoft.projectoxford.face.FaceServiceRestClient;
import com.microsoft.projectoxford.face.contract.Face;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


//the asynchronous task that get an image in bitmap format
public class AsyncProcessImage extends AsyncTask<InputStream,Void, Face[]> {
    private InputStream stream;
    private FaceServiceRestClient ImageProcessor;

    IOnFinishListener _event;
    public void set_onFinishListener(IOnFinishListener onFinishListener){
        _event = onFinishListener;
    }

    public AsyncProcessImage(FaceServiceRestClient processor) {
        ImageProcessor = processor;
    }

    protected Face[] doInBackground(InputStream ...imageInput){
        Face[] results = null;
        try{
            FaceServiceClient.FaceAttributeType[] attributes;
            attributes = new FaceServiceClient.FaceAttributeType[]{
                    FaceServiceClient.FaceAttributeType.Age,
                    FaceServiceClient.FaceAttributeType.Glasses,
                    FaceServiceClient.FaceAttributeType.Smile,
                    FaceServiceClient.FaceAttributeType.FacialHair,
                    FaceServiceClient.FaceAttributeType.Gender
            };
            results = ImageProcessor.detect(imageInput[0],true, false,attributes);
        }catch(Exception error){

        }
        return results;
    }

    //event called when onPostExecute finishes
    public interface IOnFinishListener{
        void onFinish(Bitmap bitmapImage, ImageView imgvPoster);
    }

}