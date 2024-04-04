package org.javaacademy.head_hunter;

import org.javaacademy.resume.ResumeService;
import org.javaacademy.vacancy.JobPostingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class HeadHunterServiceTest {
    @Autowired
    private HeadHunterService headHunterService;
    @Autowired
    private JobPostingService jobPostingService;
    @Autowired
    private ResumeService resumeService;

    @BeforeEach
    void init() {
        jobPostingService.cleanRepository();
        resumeService.cleanRepository();
    }

    @Test
    void createCompanySuccess() {
        assertDoesNotThrow(this::newCompany);
    }

    @Test
    void createExistCompany() {
        newCompany();
        assertThrows(RuntimeException.class, this::newCompany);
    }

    @Test
    void createVacancySuccess() {
        newCompany();
        headHunterService.createCompanyVacancy("Сбер",
                "Разработчик",
                "Java",
                BigDecimal.valueOf(100));
        assertEquals(1, headHunterService.getAllVacancyCompany("Сбер").size());
    }

    @Test
    void createVacancyNotExistCompanySuccess() {
        assertThrows(RuntimeException.class, () -> headHunterService.createCompanyVacancy("Сбер",
                "Разработчик",
                "Java",
                BigDecimal.valueOf(100)));
    }

    @Test
    void createUserSuccess() {
        assertDoesNotThrow(this::newUser);
    }

    @Test
    void createExistUser() {
        newUser();
        assertThrows(RuntimeException.class, this::newUser);
    }

    @Test
    void createResumeSuccess() {
        newUser();
        resumeService.addResume("Ivan", "mail", BigDecimal.valueOf(100), "Java");
        assertEquals(1, resumeService.takeAllResume().size());
    }

    @Test
    void createResumeNotExistUser() {
        assertThrows(RuntimeException.class, () -> resumeService.addResume("Ivan", "mail", BigDecimal.valueOf(100), "Java"));
    }

    void newCompany() {
        headHunterService.createCompany("Сбер");
    }

    void newUser() {
        resumeService.createUser("Ivan", "mail");
    }

}