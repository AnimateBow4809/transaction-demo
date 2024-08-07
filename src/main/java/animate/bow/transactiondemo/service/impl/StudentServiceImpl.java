package animate.bow.transactiondemo.service.impl;

import animate.bow.transactiondemo.repo.StudentRepo;
import animate.bow.transactiondemo.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo repo;

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void updateNameById(Long id, String name) {

    }
    @Transactional(propagation=Propagation.NESTED)
    @Override
    public void updateLastNameById(Long id, String lastName) {

    }
    @Transactional(propagation=Propagation.NESTED)
    @Override
    public void updatePhoneNumberById(Long id, String phoneNumber) {

    }
}
