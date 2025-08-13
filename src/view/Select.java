package view;

import models.Movie;
import models.Review;
import models.Series;
import models.User;

import java.util.List;
import java.util.Scanner;

public class Select {

    static Scanner scanner = new Scanner(System.in);

    /*
    public User selectUser () {


    }

    public Review selectReview() {


    }
     */

    public Movie selectMovie(List<Movie> movies){

        System.out.println("Selecione um filme:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + " - " + movies.get(i).getName());
        }
        int idx = Integer.parseInt(scanner.nextLine());


        return movies.get(idx);
    }

    public Series selectSeries(List<Series> series) {


        System.out.println("Selecione uma série:");
        for (int i = 0; i < series.size(); i++) {
            System.out.println(i + " - " + series.get(i).getName());
        }
        int idx = Integer.parseInt(scanner.nextLine());


        return series.get(idx);
    }
    
}
