package animate.bow.transactiondemo.service.impl;

import animate.bow.transactiondemo.entity.Student;
import animate.bow.transactiondemo.repo.StudentRepo;
import animate.bow.transactiondemo.service.interfaces.StudentService;
import jakarta.persistence.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo repo;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    @Override
    public void updateNameById(Long id, String name) {
        try {
            repo.updateNameById(id, name);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error occured");
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    @Override
    public void updateLastNameById(Long id, String lastName) {
        try {
            repo.updateLastNameById(id, lastName);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error occured");
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    @Override
    public void updatePhoneNumberById(Long id, String phoneNumber) {
        try {
            repo.updatePhoneNumberById(id, phoneNumber);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error occured");
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public void updateEveryThingById(Long id, String name, String lastName, String phoneNumber) {
        updateNameById(id, name);
        updateLastNameById(id, lastName);
        updatePhoneNumberById(id, phoneNumber);
    }

    @Override
    public Student findStudentById(Long id){
        return repo.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        repo.save(student);
    }
}
