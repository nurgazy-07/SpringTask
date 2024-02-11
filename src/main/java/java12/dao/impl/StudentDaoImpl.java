package java12.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java12.dao.GenericDao;
import java12.entity.Lesson;
import java12.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentDaoImpl implements GenericDao<Student, Long> {
    @PersistenceContext
    private final EntityManager entityManager;
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Student findById(Long aLong) {
        Student student = null;
        try {
            entityManager.getTransaction().begin();
            student = entityManager.find(Student.class, aLong);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            students = entityManager.createQuery("select c from Student c").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return students;
    }

    @Override
    public Student update(Long aLong, Student newEntity) {
        Student student = null;
        try {
            entityManager.getTransaction().begin();
            student = entityManager.find(Student.class, aLong);
            student.setFirstName(newEntity.getFirstName());
            student.setEmail(newEntity.getEmail());
            student.setYearOfBirth(newEntity.getYearOfBirth());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return student;
    }
    @Override
    public void deleteById(Long aLong) {
        try {
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class, aLong);
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
    }
}
