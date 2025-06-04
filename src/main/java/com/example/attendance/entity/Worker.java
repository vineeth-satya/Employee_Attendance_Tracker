package com.example.attendance.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Getter @Setter
public class Worker {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private String designation;
}
