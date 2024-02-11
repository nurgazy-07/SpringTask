package java12.service.impl;

import java12.dao.GenericDao;
import java12.entity.Student;
import java12.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("studentService")
public class StudentServiceImpl implements GenericService<Student, Long> {
 @Autowired
 @Qualifier("studentDaoImpl")
 private final GenericDao genericDao;
    public StudentServiceImpl(@Qualifier("studentDaoImpl") GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public void save(Student entity) {
        genericDao.save(entity);
    }

    @Override
    public Student findById(Long aLong) {
        return (Student) genericDao.findById(aLong);
    }

    @Override
    public List<Student> getAll() {
        return genericDao.getAll();
    }

    @Override
    public Student update(Long aLong, Student newEntity) {
        return (Student) genericDao.update(aLong, newEntity);
    }

    @Override
    public void deleteById(Long aLong) {
        genericDao.deleteById(aLong);
    }
}
