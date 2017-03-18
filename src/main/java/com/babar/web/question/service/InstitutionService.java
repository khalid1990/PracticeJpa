package com.babar.web.question.service;

import com.babar.db.entity.Institution;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author babar
 * @since 3/19/17.
 */
@Service
public class InstitutionService {
    public List<Institution> getAll() {
        List<Institution> institutions = new ArrayList<>();

        Institution institution1 = new Institution();
        institution1.setInstitutionName("BPSC");
        institution1.setId(0);

        Institution institution2 = new Institution();
        institution2.setInstitutionName("TechNet");
        institution2.setId(1);

        institutions.add(institution1);
        institutions.add(institution2);

        return institutions;
    }
}
