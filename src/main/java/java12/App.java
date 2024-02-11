package java12;
import java12.config.HiberanteConfig;
import java12.entity.Course;
import java12.entity.Lesson;
import java12.entity.Student;
import java12.service.impl.CourseServiceImpl;
import java12.service.impl.LessonServiceImpl;
import java12.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HiberanteConfig.class);
        CourseServiceImpl service = context.getBean("service", CourseServiceImpl.class);
        LessonServiceImpl lessonService = context.getBean("lessonService", LessonServiceImpl.class);
        StudentServiceImpl studentService = context.getBean("studentService", StudentServiceImpl.class);

                   // COURSE
        //1
//        service.save(new Course("java", 14000, LocalDate.of(2023, 12,12)));
        //2
//        System.out.println(service.findById(1L));
        //3
//        System.out.println(service.getAll());
        //4
//        System.out.println(service.update(2L, new Course("javaScript", 14000, LocalDate.of(2023, 12, 12))));
        //5
//        service.deleteById(1L);


                  // LESSON
        //6
//        lessonService.save(new Lesson("oku", "kechigu", "asfdafsd", LocalDate.of(2023,12,12), true));
        //7
//        System.out.println(lessonService.findById(1L));
        //8
//        System.out.println(lessonService.getAll());
        //9
//        System.out.println(lessonService.update(1L, new Lesson("adfs", "asdfdfsa", "fasdsddsffds", LocalDate.of(2023, 12,12), true)));
        //10
//        lessonService.deleteById(1L);


                  // STUDENT
        //11
//        studentService.save(new Student("Nurgazy", "nur@gmail.com", LocalDate.of(2004, 12,12)));
        //12
//        System.out.println(studentService.findById(1L));
        //13
//        System.out.println(studentService.getAll());
        //14
//        System.out.println(studentService.update(1L, new Student("Nurbolot" , "nur@gmail.com", LocalDate.of(2007, 9,29))));
        //15
//        studentService.deleteById(1L);


    }
}
