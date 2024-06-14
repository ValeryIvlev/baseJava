import java.util.Arrays;
import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size()+1; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume == null) {
                return null;
            }
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int count = size();
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            }
        }
        storage = Arrays.stream(storage).filter(Objects::nonNull).toArray(Resume[]::new);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.stream(storage).filter(Objects::nonNull).toArray(Resume[]::new);
    }

    int size() {
        return (int) Arrays.stream(storage).filter(Objects::nonNull).count();
    }
}
