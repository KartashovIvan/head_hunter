package org.javaacademy.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ResumeRepository {
    private final HashMap<User, Resume> repository = new HashMap<>();

    public void addUser(User user) {
        repository.put(user, null);
    }

    public boolean checkUser(User user) {
        return repository.containsKey(user);
    }

    public void addResume(User user, Resume resume) {
        repository.put(user, resume);
    }

    public List<Resume> takeResumes() {
        return new ArrayList<>(repository.values());
    }

    public void deleteAll() {
        repository.clear();
    }
}
