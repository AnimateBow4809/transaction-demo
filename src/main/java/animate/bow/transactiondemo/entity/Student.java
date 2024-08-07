package animate.bow.transactiondemo.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false,columnDefinition = "varchar2(255)")
    private String name;


    @Column(name = "last_name",nullable = false,columnDefinition = "varchar2(255)")
    private String lastName;

    @Column(name = "phone_number",nullable = false,columnDefinition = "varchar2(255)")
    private String phoneNumber;
}
