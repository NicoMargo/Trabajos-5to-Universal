package com.example.tp5_face;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.microsoft.projectoxford.face.FaceServiceClient;
import com.microsoft.projectoxford.face.FaceServiceRestClient;
import com.microsoft.projectoxford.face.contract.Face;
import com.microsoft.projectoxford.face.contract.FaceRectangle;
import java.io.InputStream;
import static com.example.tp5_face.FRecognitionFragment._img;
import static com.example.tp5_face.FRecognitionFragment.imgResultAzure;
import static com.example.tp5_face.FRecognitionFragment.txtResult;


//the asynchronous task that get an image in bitmap format
public class AsyncProcessImage extends AsyncTask<InputStream,Void, Face[]> {
    private InputStream stream;
    private FaceServiceRestClient ImageProcessor;

    IOnFinishListener _event;

    public void set_onFinishListener(IOnFinishListener onFinishListener) {
        _event = onFinishListener;
    }

    public AsyncProcessImage(FaceServiceRestClient processor) {
        ImageProcessor = processor;
    }

    protected Face[] doInBackground(InputStream... imageInput) {
        Face[] results = null;
        try {
            FaceServiceClient.FaceAttributeType[] attributes;
            attributes = new FaceServiceClient.FaceAttributeType[]{
                    FaceServiceClient.FaceAttributeType.Age,
                    FaceServiceClient.FaceAttributeType.Glasses,
                    FaceServiceClient.FaceAttributeType.Smile,
                    FaceServiceClient.FaceAttributeType.FacialHair,
                    FaceServiceClient.FaceAttributeType.Gender
            };
            results = ImageProcessor.detect(imageInput[0], true, false, attributes);
        } catch (Exception error) {
            Log.d("error", error.getMessage());
        }
        return results;
    }

    //event called when onPostExecute finishes
    public interface IOnFinishListener {
        void onFinish(Bitmap bitmapImage, ImageView imgvPoster);
    }

    @Override
    protected void onPostExecute(Face[] result) {
        super.onPostExecute(result);
        if (result != null) {
            if (result.length > 0) {
                frameFace(_img,result);
                processResultFaces(result);
            }else {
                txtResult.setText("no se encontro a ninguna persona");
            }
        } else {
            txtResult.setText("error");
        }
    }

    void frameFace(Bitmap origianlPhoto, Face[] result) {
        Bitmap paintedFPhoto;
        paintedFPhoto = origianlPhoto.copy(Bitmap.Config.ARGB_8888, true);
        Canvas thisCanvas;
        thisCanvas = new Canvas(paintedFPhoto);
        Paint Brush;
        Brush = new Paint();
        Brush.setAntiAlias(true);
        Brush.setStyle(Paint.Style.STROKE);
        Brush.setColor(Color.GREEN);
        Brush.setStrokeWidth(4);
        for (Face oneFace : result) {
            FaceRectangle rectangleFace;
            rectangleFace = oneFace.faceRectangle;
            thisCanvas.drawRect(rectangleFace.left, rectangleFace.top, rectangleFace.left + rectangleFace.width, rectangleFace.top + rectangleFace.height, Brush);
        }
        imgResultAzure.setImageBitmap(paintedFPhoto);
    }

    void processResultFaces(Face[] FacesToProcess){
        String msg = "";
        int quantM = 0, quantF = 0;
        for (int i = 0; i<FacesToProcess.length;i++){
            msg+="\n Persona: "+(i+1);
            msg+=" Edad: "+ FacesToProcess[i].faceAttributes.age;
            msg+=" anteojos: "+ FacesToProcess[i].faceAttributes.glasses;
            msg+=" sonrisa: "+ FacesToProcess[i].faceAttributes.smile;
            msg+=" genero: "+ FacesToProcess[i].faceAttributes.gender;
            msg+=" barba: "+ FacesToProcess[i].faceAttributes.facialHair.beard;
            if ( FacesToProcess[i].faceAttributes.gender != "male"){
                quantM++;
            }else{
                quantF++;
            }
            if(i<FacesToProcess.length-1){
                msg+="\n";
            }
        }
        msg+= "\n cant Hombres: "+ quantM+"\n cant Mujeres: "+quantF;
        txtResult.setText(msg);
    }
}