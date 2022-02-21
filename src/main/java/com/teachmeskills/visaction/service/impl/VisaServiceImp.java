/*package com.teachmeskills.visaction.service.impl;

import com.teachmeskills.visaction.model.Visa;
import com.teachmeskills.visaction.repository.VisaRepo;
import com.teachmeskills.visaction.service.VisaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaServiceImp implements VisaService {

    private VisaRepo visaRepo;

    public VisaServiceImp(VisaRepo visaRepo) {
        this.visaRepo = visaRepo;
    }

    @Override
    public List<Visa> findAll() {
        return visaRepo.findAll();
    }

    @Override
    public List<Visa> findByCriteria(String tag, String text) {
        return visaRepo.findByTagContainingOrTextContaining(tag,text);
    }

    @Override
    public void save(Visa message) {
        visaRepo.save(message);
    }
}*/
