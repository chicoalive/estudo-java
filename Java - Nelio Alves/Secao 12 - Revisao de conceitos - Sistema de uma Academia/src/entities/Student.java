package entities;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String name;
    private LocalDate dateOfBirth;
    private Double baseMonthlyFee;
    private Integer months;

    // Construction
    public Student(String name, LocalDate dateOfBirth, Double baseMonthlyFee, Integer months) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.baseMonthlyFee = baseMonthlyFee;
        this.months = months;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public Integer getMonths() {
        return months;
    }

    // Methods
    public Integer calculateAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public Double finalMonthlyPayment() {
        if (months > 12) {
            double discount = baseMonthlyFee - baseMonthlyFee * 0.1;
            return discount;
        } else {
            return baseMonthlyFee;
        }
    }


    @Override
    public String toString() {
        return "Nome: " + name + "\n"
                + "Idade: " + calculateAge() + "\n"
                + "Mensalidade: R$" + String.format("%.2f", finalMonthlyPayment());
    }
}
