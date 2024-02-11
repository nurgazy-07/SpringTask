package java12.dao.impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java12.dao.GenericDao;
import java12.entity.Lesson;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class LessonDaoImpl implements GenericDao<Lesson, Long> {
    @PersistenceContext
    private final EntityManager entityManager;
    public LessonDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(Lesson entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Lesson findById(Long aLong) {
        Lesson lesson = null;
        try {
            entityManager.getTransaction().begin();
            lesson = entityManager.find(Lesson.class, aLong);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return lesson;
    }

    @Override
    public List<Lesson> getAll() {
        List<Lesson> lessons = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            lessons = entityManager.createQuery("select c from Lesson c").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return lessons;
    }

    @Override
    public Lesson update(Long aLong, Lesson newEntity) {
        Lesson lesson = null;
        try {
            entityManager.getTransaction().begin();
            lesson = entityManager.find(Lesson.class, aLong);
            lesson.setTitle(newEntity.getTitle());
            lesson.setDescription(newEntity.getDescription());
            lesson.setPresentation(newEntity.isPresentation());
            lesson.setPublishedDate(newEntity.getPublishedDate());
            lesson.setVideoLink(newEntity.getVideoLink());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return lesson;
    }

    @Override
    public void deleteById(Long aLong) {
        try {
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, aLong);
            entityManager.remove(lesson);
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
