package com.example.attendance.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity @Getter @Setter
public class AttendanceRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "worker_id") private Worker worker;
    private LocalDate date;
    private String status;
}
