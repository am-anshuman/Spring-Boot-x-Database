package org.aman.jpaRelationshipDemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Inverse side
    // @OneToMany(
    //         mappedBy = "department",
    //         // cascade = CascadeType.PERSIST
    //         // cascade = CascadeType.REMOVE
    //         cascade = CascadeType.ALL
    // )
    // private List<Student> students = new ArrayList<>();
}
