package app;

import app.config.HibernateConfig;
import app.services.MovieServices;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

        long startTime = System.currentTimeMillis();

        MovieServices movieServices = new MovieServices();

        movieServices.getMoviesWithPeoplesAndGenres(emf);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Task runtime: " + duration + " milliseconds");

        emf.close();
    }
}