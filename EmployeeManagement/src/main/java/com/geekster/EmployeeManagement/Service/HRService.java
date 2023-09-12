package com.geekster.EmployeeManagement.Service;

import com.geekster.EmployeeManagement.ExceptionHandler.HRNotFoundException;
import com.geekster.EmployeeManagement.Model.HR;
import com.geekster.EmployeeManagement.Repository.IHR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HRService {

    private final IHR hrRepository;

    @Autowired
    public HRService(IHR hrRepository) {
        this.hrRepository = hrRepository;
    }



    public HR findByUsername(String username) {
        return hrRepository.findByUsername(username);
    }

    public HR createHR(HR hr) {

        return hrRepository.save(hr);
    }

    public HR updateHR(HR hr) {

        return hrRepository.save(hr);
    }
    public HR deleteHR(Long id) {

        Optional<HR> existingHR = hrRepository.findById(id);

        if (existingHR.isPresent()) {

            HR hrToDelete = existingHR.get();
            hrRepository.delete(hrToDelete);
            return hrToDelete;
        } else {
            throw new HRNotFoundException("HR record not found");
        }
    }
}
