package com.example.storage;

import com.example.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
            storage[size] = r;
            size++;
    }

    public void update(Resume r){

    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if(storage[i].getUuid().equals(uuid)){
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.stream(storage).limit(size).toArray(Resume[]::new);
    }

    public int size(){
        return size;
    }
}
