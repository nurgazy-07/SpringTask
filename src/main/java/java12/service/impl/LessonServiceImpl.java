package java12.service.impl;
import java12.dao.GenericDao;
import java12.entity.Lesson;
import java12.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("lessonService")
public class LessonServiceImpl implements GenericService<Lesson, Long> {
    @Autowired
    @Qualifier("lessonDaoImpl")
    private final GenericDao genericDao;
    public LessonServiceImpl(@Qualifier("lessonDaoImpl") GenericDao genericDao) {
        this.genericDao = genericDao;
    }
    @Override
    public void save(Lesson entity) {
        genericDao.save(entity);
    }
    @Override
    public Lesson findById(Long aLong) {
        return (Lesson) genericDao.findById(aLong);
    }
    @Override
    public List<Lesson> getAll() {
        return genericDao.getAll();
    }
    @Override
    public Lesson update(Long aLong, Lesson newEntity) {
        return (Lesson) genericDao.update(aLong, newEntity);
    }
    @Override
    public void deleteById(Long aLong) {
       genericDao.deleteById(aLong);
    }
}
