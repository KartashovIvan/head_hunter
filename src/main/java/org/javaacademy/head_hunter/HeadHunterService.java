package org.javaacademy.head_hunter;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.javaacademy.resume.Resume;
import org.javaacademy.resume.ResumeService;
import org.javaacademy.vacancy.JobPostingService;
import org.javaacademy.vacancy.Vacancy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeadHunterService {
    private final ResumeService resumeService;
    private final JobPostingService jobPostingService;

    public void createCompany(String nameCompany) {
        jobPostingService.createCompany(nameCompany);
    }

    public void createCompanyVacancy(String companyName, String jobTitle, String description, BigDecimal salary) {
        jobPostingService.createVacancy(companyName, jobTitle, description, salary);
    }

    public List<Vacancy> getAllVacancyCompany(String companyName) {
        return jobPostingService.takeAllVacancy(companyName);
    }

    public void createUser(String name, String email) {
        resumeService.createUser(name, email);
    }

    public void createUserResume(String name, String email, BigDecimal desiredSalary, String skill) {
        resumeService.addResume(name, email, desiredSalary, skill);
    }

    public List<Resume> takeAllResume() {
        return resumeService.takeAllResume();
    }
}
