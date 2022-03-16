package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.StringObject;

import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {

    StringObject first = new StringObject(11, 1, "Bladshot", "action movie");
    StringObject second = new StringObject(22, 2, "Forward", "cartoon");
    StringObject third = new StringObject(33, 3, "Hotel Belgrad", "comedy");
    StringObject fourth = new StringObject(44, 4, "Gentleman", "action movie");
    StringObject fifth = new StringObject(55, 5, "Invisible Man", "horrors");
    StringObject sixth = new StringObject(66, 6, "Trolls", "cartoon");
    StringObject seventh = new StringObject(77, 7, "Number One", "comedy");
    StringObject eighth = new StringObject(88, 8, "Cry", "horrors");
    StringObject ninth = new StringObject(99, 9, "9/5", "action movie");
    StringObject tenth = new StringObject(100, 10, "Wind", "cartoon");


    @Test
    void addFilm() {
        CartManager cartManager = new CartManager(0);
        cartManager.addFilm(first);

        StringObject[] expected = new StringObject[] {first};
        StringObject[] actual = cartManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        CartManager cartManager = new CartManager(4);
        cartManager.addFilm(first);
        cartManager.addFilm(second);
        cartManager.addFilm(third);
        cartManager.addFilm(fourth);

        StringObject[] expected = new StringObject[] { fourth, third, second, first };
        StringObject[] actual = cartManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findLast() {
        CartManager cartManager = new CartManager(5);
        cartManager.addFilm(first);
        cartManager.addFilm(second);
        cartManager.addFilm(third);
        cartManager.addFilm(fourth);
        cartManager.addFilm(fifth);
        cartManager.addFilm(sixth);
        cartManager.addFilm(seventh);

        StringObject[] expected = new StringObject[] {seventh, sixth, fifth, fourth, third };
        StringObject[] actual = cartManager.findLast();
    }
}