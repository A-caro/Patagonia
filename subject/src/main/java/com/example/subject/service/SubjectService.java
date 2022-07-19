package com.example.subject.service;

import com.example.subject.entity.Subject;
import com.example.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAll(){
        return subjectRepository.findAll();
    }

  /*  public Loan saveLoan(Loan loan){
        Loan newloan = loanRepository.save(loan);
        return newloan;
    }*/
    public Subject saveSubject(Subject subject){
        return subjectRepository.save(subject);
    }


}
