package com.example.tp4omdb2;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FDetailsFragment extends Fragment {
    //View
    private View rootView;
    private ListView lvList;
    private TextView txtTitle;
    private TextView txtYear;
    private TextView txtType;
    private ImageView imgvPoster;
    private Button btnMain;

    private AsyncGetDetails _asyncGetDetails;
    private AsyncGetImage _asyncGetImage;
    private ArrayList<String> _details;
    private ArrayAdapter _myAdapter;
    private Movie _movie;
    public void setMovie(Movie movie){
        _movie = movie;
    }

    public FDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_details, container, false);
        getReferences();
        _details = new ArrayList<String>();
        _myAdapter = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_list_item_1,_details);
        _asyncGetDetails = new AsyncGetDetails(_movie.get_id(), _movie);
        _asyncGetImage = new AsyncGetImage(imgvPoster);
        setListeners();
        //_myTask.setAdapterAndArray(_myAdapter,lvList);
        _asyncGetDetails.execute();
        return rootView;
    }

    protected void getReferences() {
        lvList = (ListView) rootView.findViewById(R.id.lvDetails);
        txtTitle = (TextView) rootView.findViewById(R.id.txtTitle);
        txtYear = (TextView) rootView.findViewById(R.id.txtYear);
        txtType = (TextView) rootView.findViewById(R.id.txtType);
        imgvPoster = (ImageView) rootView.findViewById(R.id.imgPoster);
        btnMain = (Button) rootView.findViewById(R.id.btnMain);
    }

    protected void setListeners() {
        _asyncGetDetails.set_onFinishListener(asyncGetDetails_onFinish);
        _asyncGetImage.set_onFinishListener(asyncGetImage_onFinish);
        btnMain.setOnClickListener(btnMain_Click);
    }

    AsyncGetDetails.IOnFinishListener asyncGetDetails_onFinish = new AsyncGetDetails.IOnFinishListener() {
        @Override
        public void onFinish(Movie movie) {
            txtTitle.setText("Title: "+movie.get_title());
            txtYear.setText("Year: "+movie.get_year());
            txtType.setText("Type: "+movie.get_type());
            _details.clear();
            _asyncGetImage.execute(movie.get_poster());
            for ( String key: movie.get_details().keySet()) {
                _details.add(key+": "+ movie.get_details().get(key));
            }
            lvList.setAdapter(_myAdapter);
        }
    };

    AsyncGetImage.IOnFinishListener asyncGetImage_onFinish = new AsyncGetImage.IOnFinishListener() {
        @Override
        public void onFinish(Bitmap bitmapImage, ImageView imgvPoster) {
            if(imgvPoster!=null)
                imgvPoster.setImageBitmap(bitmapImage);
        }
    };
    private View.OnClickListener btnMain_Click= new View.OnClickListener() {
        public void onClick(View v) {
            StartMainFragment();
        }
    };

    private void StartMainFragment(){
        FragmentManager adminFragment;
        FragmentTransaction transacFragment;
        FMainFragment fragmentMain = new FMainFragment();

        adminFragment   = getFragmentManager();
        transacFragment = adminFragment.beginTransaction();
        transacFragment.replace(R.id.lytMain, fragmentMain);
        transacFragment.commit();
    }
}