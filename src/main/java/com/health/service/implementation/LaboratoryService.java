package com.health.service.implementation;

import com.health.model.Exam;
import com.health.model.Laboratory;
import com.health.repository.IExamRepository;
import com.health.repository.IGenericRepository;
import com.health.repository.ILaboratoryRepository;
import com.health.service.IExamService;
import com.health.service.ILaboratoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LaboratoryService extends GenericService<Laboratory, Integer> implements ILaboratoryService {
    private final ILaboratoryRepository repo;

    protected IGenericRepository<Laboratory, Integer> getRepo() {return repo;}
}
