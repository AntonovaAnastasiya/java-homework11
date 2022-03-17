package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    Movie first = new Movie(11, 1, "Bladshot", "action movie");
    Movie second = new Movie(22, 2, "Forward", "cartoon");
    Movie third = new Movie(33, 3, "Hotel Belgrad", "comedy");
    Movie fourth = new Movie(44, 4, "Gentleman", "action movie");
    Movie fifth = new Movie(55, 5, "Invisible Man", "horrors");
    Movie sixth = new Movie(66, 6, "Trolls", "cartoon");
    Movie seventh = new Movie(77, 7, "Number One", "comedy");
    Movie eighth = new Movie(88, 8, "Cry", "horrors");
    Movie ninth = new Movie(99, 9, "9/5", "action movie");
    Movie tenth = new Movie(100, 10, "Wind", "cartoon");
    Movie eleven = new Movie(110, 11, "Trio", "comedy");


    @Test
    void addFilm() {
        MovieManager movieManager = new MovieManager(0);
        movieManager.addFilm(first);

        Movie[] expected = new Movie[] {first};
        Movie[] actual = movieManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        MovieManager movieManager = new MovieManager(4);
        movieManager.addFilm(first);
        movieManager.addFilm(second);
        movieManager.addFilm(third);
        movieManager.addFilm(fourth);

        Movie[] expected = new Movie[] { fourth, third, second, first };
        Movie[] actual = movieManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll2() {
        MovieManager movieManager = new MovieManager(1);
        movieManager.addFilm(first);


        Movie[] expected = new Movie[] { first };
        Movie[] actual = movieManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findLast() {
        MovieManager movieManager = new MovieManager(5);
        movieManager.addFilm(first);
        movieManager.addFilm(second);
        movieManager.addFilm(third);
        movieManager.addFilm(fourth);
        movieManager.addFilm(fifth);
        movieManager.addFilm(sixth);
        movieManager.addFilm(seventh);

        Movie[] expected = new Movie[] {seventh, sixth, fifth, fourth, third };
        Movie[] actual = movieManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastThanMoreNumberOfFilm() {
        MovieManager movieManager = new MovieManager();
        movieManager.addFilm(first);
        movieManager.addFilm(second);
        movieManager.addFilm(third);
        movieManager.addFilm(fourth);
        movieManager.addFilm(fifth);
        movieManager.addFilm(sixth);
        movieManager.addFilm(seventh);
        movieManager.addFilm(eighth);
        movieManager.addFilm(ninth);
        movieManager.addFilm(tenth);
        movieManager.addFilm(eleven);

        Movie[] expected = new Movie[] {eleven, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second };
        Movie[] actual = movieManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastThanLessNumberOfFilm() {
        MovieManager movieManager = new MovieManager();
        movieManager.addFilm(first);
        movieManager.addFilm(second);
        movieManager.addFilm(third);

        Movie[] expected = new Movie[] { third, second, first };
        Movie[] actual = movieManager.findLast();

        assertArrayEquals(expected, actual);
    }
}