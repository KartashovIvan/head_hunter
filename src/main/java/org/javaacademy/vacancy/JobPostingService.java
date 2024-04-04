package org.javaacademy.vacancy;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobPostingService {
    private final VacancyRepository vacancyRepository;
    @Value("${currency}")
    private String currency;

    public Company createCompany(String name) {
        if (vacancyRepository.checkCompany(name)) {
            throw new RuntimeException("Компания " + name + " существует");
        }
        Company company = new Company(name);
        vacancyRepository.addCompany(company);
        return company;
    }

    public void createVacancy(String companyName, String jobTitle, String description, BigDecimal salary) {
        if (!vacancyRepository.checkCompany(companyName)) {
            throw new RuntimeException("Нет компании " + companyName);
        }
        vacancyRepository.addVacancy(companyName, jobTitle, description, salary, currency);
    }

    public List<Vacancy> takeAllVacancy(String companyName) {
        return vacancyRepository.takeVacancy(companyName);
    }

    public void cleanRepository() {
        vacancyRepository.deleteAll();
    }
}
