package com.example.tp4omdb2;


import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.Math;
import java.util.ArrayList;

public class FResultFragment extends Fragment {

    private ListView lvList;
    private View rootView;
    private TextView txtResult;
    private Button btnPrev;
    private Button btnNext;
    private Button btnMain;

    private static ArrayList<Movie> _movies;
    private MovieAdapter _myAdapter;
    private int _pagePosition = 0;
    public static final int ITEMS_PER_PAGE = 4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        getReferences();
        setListeners();
        _movies = new ArrayList<Movie>();
        _myAdapter = new MovieAdapter(/*_movies,*/this.getContext());
        AsyncGetMovies myTask = new AsyncGetMovies(_movies, MainActivity.getSearchString());
        myTask.setAdapterAndArray(_myAdapter,lvList);
        myTask.execute();
        Log.d("Result Fragment 1","Result Fragment 1");
        return rootView;
    }

    private void getReferences(){
        lvList = (ListView) rootView.findViewById(R.id._lvList);
        txtResult = (TextView) rootView.findViewById(R.id.txtResult);
        btnPrev = rootView.findViewById(R.id.btnPrevious);
        btnNext = rootView.findViewById(R.id.btnNext);
        btnMain = rootView.findViewById(R.id.btnMain);
    }

    public void setListeners(){
        lvList.setOnItemClickListener(lvList_Item_Click);
        btnNext.setOnClickListener(btnNext_Click);
        btnPrev.setOnClickListener(btnPrevious_Click);
        btnMain.setOnClickListener(btnMain_Click);
    }

    private ListView.OnItemClickListener lvList_Item_Click = new ListView.OnItemClickListener(){
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            StartDetailFragment(position);
        }
    };

    private void StartDetailFragment(int position){
        FragmentManager adminFragment;
        FragmentTransaction transacFragment;
        Fragment fragmentDetails = new FDetailsFragment();
        ((FDetailsFragment) fragmentDetails).setMovie(_movies.get(position));

        adminFragment   = getFragmentManager();
        transacFragment = adminFragment.beginTransaction();
        transacFragment.replace(R.id.lytMain, fragmentDetails);
        transacFragment.commit();
    }

    private View.OnClickListener btnPrevious_Click= new View.OnClickListener() {
        public void onClick(View v) {
            if(_pagePosition >0) {
                _pagePosition--;
                _myAdapter.setMoviesList(Helpers.getSubListMovies(_movies, _pagePosition, ITEMS_PER_PAGE));
                lvList.setAdapter(_myAdapter);
            }
        }
    };

    private View.OnClickListener btnNext_Click= new View.OnClickListener() {
        public void onClick(View v) {
            if(_pagePosition < Math.ceil(_movies.size() * 1.0f / ITEMS_PER_PAGE - 1)) {
                _pagePosition++;
                _myAdapter.setMoviesList(Helpers.getSubListMovies(_movies, _pagePosition, ITEMS_PER_PAGE));
                lvList.setAdapter(_myAdapter);
            }
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

    public void setResultText(String result){
        txtResult.setText(result);
    }


}
