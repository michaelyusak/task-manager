package com.idana.task_manager.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    
    private final StatusRepository statusRepository;
    
    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getStatus() {
        return statusRepository.findAll();
    }
}
