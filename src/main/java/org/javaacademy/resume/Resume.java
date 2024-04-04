package org.javaacademy.resume;

import java.math.BigDecimal;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Resume {
    @NonNull
    private User user;
    @NonNull
    public BigDecimal desiredSalary;
    @NonNull
    public String skill;
}
