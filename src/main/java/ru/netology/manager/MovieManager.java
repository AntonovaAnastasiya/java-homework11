package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
public class MovieManager {

    private Movie[] objects = new Movie[0];
    private int numberOfFilm = 10;

    public MovieManager(int numberOfFilm) {
        this.numberOfFilm = numberOfFilm;
    }

    public void addFilm(Movie object) {
        // создаём новый массив размером на единицу больше
        int length = objects.length + 1;
        Movie[] tmp = new Movie[length];
//        for (int i = 0; i < objects.length; i++) {
//            tmp[i] = objects[i];
//        }
        System.arraycopy(objects, 0, tmp, 0, objects.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = object;
        objects = tmp;
    }

    public Movie[] findAll() {
        Movie[] result = new Movie[objects.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = objects.length - i - 1;
            result[i] = objects[index];
        }
        return result;
    }

    public Movie[] findLast() {
        int resultLength;
        if (objects.length > numberOfFilm) {
            resultLength = numberOfFilm;
        } else {
            resultLength = objects.length;
        }

        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = objects[objects.length - i - 1];
        }
        return result;
    }
}
