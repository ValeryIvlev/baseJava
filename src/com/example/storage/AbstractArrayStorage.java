package com.example.storage;

import com.example.exception.ExistStorageException;
import com.example.exception.NotExistStorageException;
import com.example.exception.StorageException;
import com.example.model.Resume;

import java.util.Arrays;
import java.util.List;


public abstract class AbstractArrayStorage extends AbstractStorage {
    public static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void doSave(Resume r, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, (Integer) index);
            size++;
        }
    }

    @Override
    public void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    protected abstract Integer getSearchKey(String uuid);
}