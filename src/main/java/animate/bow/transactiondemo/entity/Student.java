package animate.bow.transactiondemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


/*
    Student Class
    no fields are null
 */

@Data
@Entity
@Table(name = "student")
@AllArgsConstructor
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false,columnDefinition = "varchar2(255)")
    private String name;

    @Column(name = "last_name",nullable = false,columnDefinition = "varchar2(255)")
    private String lastName;

    @Column(name = "phone_number",nullable = false,columnDefinition = "varchar2(255)")
    private String phoneNumber;


    public Student() {

    }
}
