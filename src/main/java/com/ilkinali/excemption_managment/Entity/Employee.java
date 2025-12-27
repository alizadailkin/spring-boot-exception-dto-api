package com.ilkinali.excemption_managment.Entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="employee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Department department;
}
