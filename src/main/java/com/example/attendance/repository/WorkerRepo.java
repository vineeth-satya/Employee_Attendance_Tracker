package com.example.attendance.repository;
import com.example.attendance.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {}

