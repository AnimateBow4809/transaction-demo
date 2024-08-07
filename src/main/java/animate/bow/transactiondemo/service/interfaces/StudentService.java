package animate.bow.transactiondemo.service.interfaces;

import animate.bow.transactiondemo.entity.Student;
import org.springframework.data.jpa.repository.Query;

public interface StudentService {

    public void updateNameById(Long id,String name);

    public void updateLastNameById(Long id,String lastName);

    public void updatePhoneNumberById(Long id,String phoneNumber);

    public void updateEveryThingById(Long id,String name,String lastName,String phoneNumber);

    Student findStudentById(Long id);

    public void save(Student student);
}
