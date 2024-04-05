package com.orobas.librairie.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "borrow")
public class Borrow {

    public static Integer dailyCost = 1;
    public static List<Integer> conditionCost = List.of(0, 1, 3, 5, 8);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, insertable=false, updatable=false)
    private User user;

    @Column(name = "book_id")
    private Integer book_id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false, insertable=false, updatable=false)
    private Book book;

    @NotNull
    @Column(name = "start_at", nullable = false)
    private LocalDate startAt;

    @NotNull
    @Column(name = "should_return_at", nullable = false)
    private LocalDate shouldReturnAt;

    @Column(name = "return_at")
    private LocalDate returnAt;

    @Size(max = 50)
    @NotNull
    @Column(name = "start_condition", nullable = false, length = 50)
    private String startCondition;

    @Size(max = 50)
    @Column(name = "end_condition", length = 50)
    private String endCondition;

    @Column(name = "cost")
    private Integer cost;

    public Integer defineConditionCost() {
        Integer initial_value = Book.conditions.get(this.startCondition);
        Integer final_value = Book.conditions.get(this.endCondition);

        return (initial_value - final_value ) * this.book.getValue() / 100;
    }

    public Integer calculateCost() {
//      Condition 1 : La date de fin n'est pas vide
        if (this.returnAt == null) {
            return null;
        }

        Integer condition_cost = this.defineConditionCost();

//      Condition 2 : La date de fin est vide et la date de rendue n'est pas dépassée
        if(this.shouldReturnAt.isAfter(this.returnAt) || this.shouldReturnAt.isEqual(this.returnAt)) {
            Integer normal_cost = (int) ChronoUnit.DAYS.between(this.startAt, this.returnAt) * Borrow.dailyCost;
            return normal_cost + condition_cost;
        }

//      Condition 3 : La date de fin est vide et la date de rendue est dépassée
        Integer normal_cost = (int) ChronoUnit.DAYS.between(this.startAt, this.shouldReturnAt) * Borrow.dailyCost;
        Integer late_cost = (int) ChronoUnit.DAYS.between(this.shouldReturnAt, this.returnAt) * Borrow.dailyCost * 2;

        return normal_cost + late_cost + condition_cost;
    }

}