package java12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "course")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String email;
    @Column(name = "year_of_birth")
    private LocalDate yearOfBirth;
    @ManyToOne
    private Course course;

    public Student(String firstName, String email, LocalDate yearOfBirth) {
        this.firstName = firstName;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
    }
}
