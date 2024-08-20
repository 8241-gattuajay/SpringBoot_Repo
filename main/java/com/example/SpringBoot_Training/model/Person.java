package com.example.SpringBoot_Training.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    public long id;
    @Column(name = "name")
    public String name;
    @Column(name = "role")
    public String role;
}
