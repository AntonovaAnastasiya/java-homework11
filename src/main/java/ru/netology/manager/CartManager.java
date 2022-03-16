package ru.netology.manager;

import ru.netology.domain.StringObject;

public class CartManager {

    private StringObject[] objects = new StringObject[0];
    private int numberOfFilm = 10;


    public CartManager(int numberOfFilm) {
        this.numberOfFilm = numberOfFilm;
    }


    public void addFilm(StringObject object) {
        // создаём новый массив размером на единицу больше
        int length = objects.length + 1;
        StringObject[] tmp = new StringObject[length];

        for (int i = 0; i < objects.length; i++) {
            tmp[i] = objects[i];
        }
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = object;
        objects = tmp;
    }

    public StringObject[] findAll() {
        StringObject[] result = new StringObject[objects.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = objects.length - i - 1;
            result[i] = objects[index];
        }
        return result;
    }

    public StringObject[] findLast() {
        int resultLength;
        if (objects.length > numberOfFilm) {
            resultLength = numberOfFilm;
        } else {
            resultLength = objects.length;
        }

        StringObject[] result = new StringObject[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = objects[objects.length - i - 1];
        }
        return result;
    }
}
