package com.example.storage;

import com.example.model.Resume;

import java.util.Arrays;


public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);


    Resume[] getAll();

    int size();
}
