package animate.bow.transactiondemo;

import animate.bow.transactiondemo.entity.Student;
import animate.bow.transactiondemo.service.interfaces.StudentService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TransactionDemoApplication.class)
@AutoConfigureMockMvc

class TransactionDemoApplicationTests {

    @Autowired
    StudentService service;
    /*
        This test aims to rollback from an invalid lastname change
     */
    @Test
    void rollbackFromLastName() {
        service.save(new Student(2L,"ali","dd","0910"));
        try {
            service.updateEveryThingById(2L, "mohamad", null, "0912");
        }catch (Exception e){}
        Assert.assertEquals(service.findStudentById(2L),new Student(2L,"ali","dd","0910"));
    }

    /*
        This test aims to rollback from an invalid name change
     */
    @Test
    void rollbackFromName() {
        service.save(new Student(2L,"ali","dd","0910"));
        try {
            service.updateEveryThingById(2L, null, "golzar", "0912");
        }catch (Exception e){}
        Assert.assertEquals(service.findStudentById(2L),new Student(2L,"ali","dd","0910"));
    }

    /*
        This test aims to rollback from an invalid phone number change
     */
    @Test
    void rollbackFromPhoneNumber() {
        service.save(new Student(2L,"ali","dd","0910"));
        try {
            service.updateEveryThingById(2L, "mohamad", "golzar", null);
        }catch (Exception e){}
        Assert.assertEquals(service.findStudentById(2L),new Student(2L,"ali","dd","0910"));
    }

    /*
        This test aims to show a valid transaction
     */
    @Test
    void noRollback() {
        service.save(new Student(2L,"ali","dd","0910"));
        service.updateEveryThingById(2L, "mohamad", "golzar", "0912");
        Assert.assertEquals(service.findStudentById(2L),new Student
                (2L,"mohamad","golzar","0912"));
    }

}
