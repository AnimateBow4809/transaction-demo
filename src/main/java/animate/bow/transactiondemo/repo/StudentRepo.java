package animate.bow.transactiondemo.repo;


import animate.bow.transactiondemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student,Long> {
    @Modifying
    @Query("UPDATE Student s set s.name=:name where s.id=:id")
    public void updateNameById(Long id,String name);
    @Modifying
    @Query("UPDATE Student s set s.lastName=:lastName where s.id=:id")
    public void updateLastNameById(Long id,String lastName);
    @Modifying
    @Query("UPDATE Student s set s.phoneNumber=:phoneNumber where s.id=:id")
    public void updatePhoneNumberById(Long id,String phoneNumber);
}
