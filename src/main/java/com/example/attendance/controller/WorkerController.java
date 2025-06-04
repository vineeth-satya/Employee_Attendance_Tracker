package com.example.attendance.controller;
import com.example.attendance.entity.Worker;
import com.example.attendance.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/workers")
public class WorkerController {
    @Autowired private WorkerService workerService;
    @PostMapping public Worker addWorker(@RequestBody Worker worker) { return workerService.addWorker(worker); }
    @GetMapping public List<Worker> getAllWorkers() { return workerService.getAllWorkers(); }
}
