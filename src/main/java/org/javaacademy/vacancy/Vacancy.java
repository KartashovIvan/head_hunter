package org.javaacademy.vacancy;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class Vacancy {
    private final String jobTitle;
    private final String description;
    private final BigDecimal salary;
    private final String currency;
}
