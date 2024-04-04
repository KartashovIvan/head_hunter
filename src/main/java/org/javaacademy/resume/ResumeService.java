package org.javaacademy.resume;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public User createUser(String name, String email) {
        User user = new User(name, email);
        if (resumeRepository.checkUser(user)) {
            throw new RuntimeException("Пользователь " + user.getName() + " существует");
        }
        resumeRepository.addUser(user);
        return user;
    }

    public Resume addResume(String name, String email, BigDecimal desiredSalary, String skill) {
        User user = new User(name, email);
        if (!resumeRepository.checkUser(user)) {
            throw new RuntimeException("Пользователь " + user.getName() + " не существует");
        }
        Resume resume = new Resume(user, desiredSalary, skill);
        resumeRepository.addResume(user, resume);
        return resume;
    }

    public List<Resume> takeAllResume() {
        return resumeRepository.takeResumes();
    }

    public void cleanRepository() {
        resumeRepository.deleteAll();
    }
}
