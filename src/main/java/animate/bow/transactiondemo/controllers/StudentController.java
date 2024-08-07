package animate.bow.transactiondemo.controllers;

import animate.bow.transactiondemo.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    for accessing through the web
 */
@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    StudentService service;

    @RequestMapping("transaction/{id}/{name}/{lastName}/{phoneNumber}")
    public void transaction(@PathVariable String id, @PathVariable String lastName
            , @PathVariable String name, @PathVariable String phoneNumber){
        try {
            service.updateEveryThingById(Long.valueOf(id),name,lastName,phoneNumber);
        } catch (UnexpectedRollbackException e) {
            System.out.println("Did Rollback");
        }
    }
}
