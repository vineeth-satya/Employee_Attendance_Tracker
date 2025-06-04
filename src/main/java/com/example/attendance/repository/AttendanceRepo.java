package com.example.attendance.repository;
import com.example.attendance.entity.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface AttendanceRepo extends JpaRepository<AttendanceRecord, Long> {
    List<AttendanceRecord> findByWorker(Worker worker);
    List<AttendanceRecord> findByDate(LocalDate date);
    @Query("SELECT a FROM AttendanceRecord a WHERE a.worker.department = :department AND a.date = :date")
    List<AttendanceRecord> findByDepartmentAndDate(@Param("department") String department, @Param("date") LocalDate date);
}

