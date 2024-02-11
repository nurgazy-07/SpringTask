package java12.service.impl;
import java12.dao.GenericDao;
import java12.entity.Course;
import java12.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("service")
public class CourseServiceImpl implements GenericService<Course, Long> {
    @Autowired
    @Qualifier("courseDaoImpl")
    private final GenericDao genericDao;
    public CourseServiceImpl(@Qualifier("courseDaoImpl") GenericDao genericDao) {
        this.genericDao = genericDao;
    }
    @Override
    public void save(Course entity) {
        genericDao.save(entity);
    }

    @Override
    public Course findById(Long aLong) {
        return (Course) genericDao.findById(aLong);
    }

    @Override
    public List<Course> getAll() {
        return genericDao.getAll();
    }

    @Override
    public Course update(Long aLong, Course newEntity) {
        return (Course) genericDao.update(aLong, newEntity);
    }

    @Override
    public void deleteById(Long aLong) {
        genericDao.deleteById(aLong);
    }
}
