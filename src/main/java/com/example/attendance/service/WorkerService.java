package com.example.attendance.service;
import com.example.attendance.entity.Worker;
import com.example.attendance.repository.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class WorkerService {
    @Autowired private WorkerRepo workerRepo;
    public Worker addWorker(Worker worker) { return workerRepo.save(worker); }
    public List<Worker> getAllWorkers() { return workerRepo.findAll(); }
}
