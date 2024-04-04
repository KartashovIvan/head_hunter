package org.javaacademy.vacancy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VacancyRepository {
    private final HashMap<Company, List<Vacancy>> repository = new HashMap<>();

    public void addCompany(Company company) {
        repository.put(company, new ArrayList<>());
    }

    public boolean checkCompany(String name) {
        return repository.containsKey(new Company(name));
    }

    public void addVacancy(String companyName, String jobTitle, String description, BigDecimal salary, String currency) {
        Vacancy vacancy = new Vacancy(jobTitle, description, salary, currency);
        log.info("Создана вакансия - {}", vacancy);
        repository.get(new Company(companyName)).add(vacancy);
    }

    public List<Vacancy> takeVacancy(String companyName) {
        return repository.get(new Company(companyName));
    }

    public void deleteAll() {
        repository.clear();
    }
}
