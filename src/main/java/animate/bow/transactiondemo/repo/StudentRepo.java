package animate.bow.transactiondemo.repo;


import animate.bow.transactiondemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Long, Student> {

    @Query("UPDATE Student s set s.name=:name where s.id=:id")
    public void updateNameById(Long id,String name);

    @Query("UPDATE Student s set s.name=:lastName where s.id=:id")
    public void updateLastNameById(Long id,String lastName);

    @Query("UPDATE Student s set s.name=:phoneNumber where s.id=:id")
    public void updatePhoneNumberById(Long id,String phoneNumber);
}
