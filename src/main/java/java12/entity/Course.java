package java12.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;


@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "students", "lessons"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_gen")
    @SequenceGenerator(name = "courses_gen", sequenceName = "courses_seq", allocationSize = 1)
    private Long id;
    private String name;
    private int price;
    @Column(name = "date_of_start")
    private LocalDate dateOfStart;
    @OneToMany(mappedBy = "course",
    cascade = {REMOVE, PERSIST, MERGE})
    private List<Student> students;
    @OneToMany(cascade = {REMOVE, PERSIST})
    private List<Lesson> lessons;

    public Course( String name, int price, LocalDate dateOfStart) {
        this.name = name;
        this.price = price;
        this.dateOfStart = dateOfStart;
    }
}
