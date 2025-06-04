package com.example.attendance.controller;
import com.example.attendance.entity.AttendanceRecord;
import com.example.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController @RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired private AttendanceService attendanceService;
    @PostMapping("/mark")
    public AttendanceRecord markAttendance(@RequestParam Long workerId, @RequestParam LocalDate date, @RequestParam String status) {
        return attendanceService.markAttendance(workerId, date, status);
    }
    @GetMapping("/worker/{workerId}")
    public List<AttendanceRecord> getByWorker(@PathVariable Long workerId) {
        return attendanceService.getByWorker(workerId);
    }
    @GetMapping("/date/{date}")
    public List<AttendanceRecord> getByDate(@PathVariable LocalDate date) {
        return attendanceService.getByDate(date);
    }
    @GetMapping("/department/{department}/date/{date}")
    public List<AttendanceRecord> getByDepartmentAndDate(@PathVariable String department, @PathVariable LocalDate date) {
        return attendanceService.getByDepartmentAndDate(department, date);
    }
}
