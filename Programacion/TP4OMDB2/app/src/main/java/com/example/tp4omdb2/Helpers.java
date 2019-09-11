package com.example.tp4omdb2;

import java.util.ArrayList;

public class Helpers {
    public static ArrayList<Movie> getSubListMovies(ArrayList<Movie> movies, int position, int quantity) {
        ArrayList<Movie> subList = new ArrayList<Movie>();
        if (movies.size()>(position+1)*quantity){
            for(int i = position*quantity; i<(position+1)*quantity; i++){
                subList.add(movies.get(i));
            }
        }else if(movies.size()>position*quantity){
            for(int i = position*quantity; i<movies.size(); i++){
                subList.add(movies.get(i));
            }
        }
        return subList;
    }
}
