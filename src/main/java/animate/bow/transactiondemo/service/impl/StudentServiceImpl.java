package animate.bow.transactiondemo.service.impl;

import animate.bow.transactiondemo.entity.Student;
import animate.bow.transactiondemo.repo.StudentRepo;
import animate.bow.transactiondemo.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo repo;

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void updateNameById(Long id, String name) {
        repo.updateNameById(id,name);
    }
    @Transactional(propagation=Propagation.NESTED)
    @Override
    public void updateLastNameById(Long id, String lastName) {
        repo.updateLastNameById(id,lastName);
    }
    @Transactional(propagation=Propagation.NESTED)
    @Override
    public void updatePhoneNumberById(Long id, String phoneNumber) {
        repo.updatePhoneNumberById(id,phoneNumber);
    }

    @Transactional(propagation=Propagation.NESTED)
    @Override
    public void updateEveryThingById(Long id,String name,String lastName,String phoneNumber) {
        updateNameById(id,name);
        updateLastNameById(id,lastName);
        updatePhoneNumberById(id,lastName);
    }

    @Override
    public void save(Student student) {
        repo.save(student);
    }
}
