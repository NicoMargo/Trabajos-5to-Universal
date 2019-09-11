package com.example.tp4omdb2;


import android.app.Fragment;
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
    //
    private AsyncGetDetails _myTask;
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
        _myAdapter = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_list_item_1,_details);
        _myTask = new AsyncGetDetails("tt1905041", _movie);
        setListeners();
        //_myTask.setAdapterAndArray(_myAdapter,lvList);
        _myTask.execute();
        return rootView;
    }

    protected void getReferences() {
        lvList = (ListView) rootView.findViewById(R.id._lvList);
        txtTitle = (TextView) rootView.findViewById(R.id.txtTitle);
    }

    protected void setListeners() {
        _myTask.set_onFinishListener(async_onFinish);
    }

    AsyncGetDetails.IOnFinishListener async_onFinish = new AsyncGetDetails.IOnFinishListener() {
        @Override
        public void onFinish(Movie movie) {
            txtTitle.setText(movie.get_title());
        }
    };

}