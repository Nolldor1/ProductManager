package ru.netology.repository;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(int id) {
        super(" Товар с id " + id + " уже добавлен ");
    }
}
