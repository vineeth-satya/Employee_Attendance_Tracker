package com.example.attendance.service;
import com.example.attendance.entity.AttendanceRecord;
import com.example.attendance.entity.Worker;
import com.example.attendance.repository.AttendanceRepo;
import com.example.attendance.repository.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class AttendanceService {
    @Autowired private AttendanceRepo attendanceRepo;
    @Autowired private WorkerRepo workerRepo;
    public AttendanceRecord markAttendance(Long workerId, LocalDate date, String status) {
        Worker worker = workerRepo.findById(workerId).orElseThrow(() -> new RuntimeException("Worker not found"));
        AttendanceRecord record = new AttendanceRecord();
        record.setWorker(worker); record.setDate(date); record.setStatus(status);
        return attendanceRepo.save(record);
    }
    public List<AttendanceRecord> getByWorker(Long workerId) {
        Worker worker = workerRepo.findById(workerId).orElseThrow(() -> new RuntimeException("Worker not found"));
        return attendanceRepo.findByWorker(worker);
    }
    public List<AttendanceRecord> getByDate(LocalDate date) {
        return attendanceRepo.findByDate(date);
    }
    public List<AttendanceRecord> getByDepartmentAndDate(String department, LocalDate date) {
        return attendanceRepo.findByDepartmentAndDate(department, date);
    }
}
