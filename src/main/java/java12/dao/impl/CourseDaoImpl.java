package java12.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java12.dao.GenericDao;
import java12.entity.Course;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CourseDaoImpl implements GenericDao<Course, Long> {
    @PersistenceContext
    private final EntityManager entityManager;
    public CourseDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(Course entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public Course findById(Long aLong) {
        Course course = null;
        try {
            entityManager.getTransaction().begin();
            course = entityManager.find(Course.class, aLong);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return course;
    }

    @Override
    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            courses = entityManager.createQuery("select c from Course c").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return courses;
    }

    @Override
    public Course update(Long aLong, Course newEntity) {
        Course course = null;
        try {
            entityManager.getTransaction().begin();
            course = entityManager.find(Course.class, aLong);
            course.setName(newEntity.getName());
            course.setPrice(newEntity.getPrice());
            course.setDateOfStart(newEntity.getDateOfStart());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return course;
    }

    @Override
    public void deleteById(Long aLong) {
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, aLong);
            entityManager.remove(course);
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
