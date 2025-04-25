package gr.aueb.cf;

import gr.aueb.cf.model.Course;
import gr.aueb.cf.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class App {
   private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("school7PU");
   private final static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
//        Teacher teacher = new Teacher(null, "Alice", "W.", null);
//        Course java = new Course(null, "Java", null);
//        teacher.addCourse(java);

        em.getTransaction().begin();

//        Course course = em.find(Course.class, 2L);
//        em.remove(course);

//        Teacher alice = em.find(Teacher.class, 1L);
//        Course databases = new Course(null, "Databases", null);
       // alice.setLastname("Wonderland");
        //alice.addCourse(databases);

        //em.persist(databases);
        //em.merge(alice);

//        em.persist(teacher);
//        em.persist(java);

        // Select όλους τους teachers
//        String sql = "SELECT t FROM Teacher t";
//        TypedQuery<Teacher> query = em.createQuery(sql, Teacher.class);
//        List<Teacher> teachers = query.getResultList();
//        teachers.forEach(System.out::println);

        // Select all courses
//        String sql = "SELECT c FROM Course c";
//        List<Course> courses = em.createQuery(sql, Course.class).getResultList();
//        courses.forEach(System.out::println);

        // Select courses που διδάσκει ο Μ. Καραμπάτσης
//        String sql = "SELECT c FROM Course c WHERE c.teacher.firstname = :firstname";   // SQL Injection attack and alias
//        TypedQuery<Course> query = em.createQuery(sql, Course.class);
//        query.setParameter("firstname", "Μάρκος");
//        List<Course> courses = query.getResultList();

//        List<Course> courses = em.createQuery(sql, Course.class)
//                .setParameter("firstname", "Μάρκος")
//                .getResultList();
//        courses.forEach(System.out::println);

        // Select teachers και τίτλους courses που διδάσκουν οι teachers
        String sql = "SELECT t, c.title FROM Teacher t JOIN t.courses c";   // INNER JOIN
        TypedQuery<Object[]> query = em.createQuery(sql, Object[].class);
        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            Teacher teacher = (Teacher) result[0];
            String courseTitle = (String) result[1];
            System.out.println("Teacher: " + teacher.getLastname() + ", Course: " + courseTitle);
        }


        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
