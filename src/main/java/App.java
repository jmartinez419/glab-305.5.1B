import model.Department;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        oneToMany();
    }
    public static void oneToMany(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        //creating teacher
        Teacher t1 = new Teacher("1000","MHaseeb");
        Teacher t2 = new Teacher("2220","Shahparan");
        Teacher t3 = new Teacher("3000","James");
        Teacher t4 = new Teacher("40000","Joseph");
        Teacher t5 = new Teacher("200","Ali");

        //Add teacher entity object to the list
        ArrayList<Teacher> teachersList = new ArrayList<>();
        teachersList.add(t1);
        teachersList.add(t2);
        teachersList.add(t3);
        teachersList.add(t4);
        teachersList.add(t5);
        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        session.persist(t4);
        session.persist(t5);
        //Creating Department
        Department department = new Department();
        department.setDeptName("Development");
        department.setTeacherList(teachersList);
        //Storing Department
        session.persist(department);
        Department department2 = new Department();
        department2.setDeptName("IT");
//        department.setTeacherList(teachersList);
        //Storing Department
        session.persist(department2);
        Department department3 = new Department();
        department3.setDeptName("HR");
//        department.setTeacherList(teachersList);
        //Storing Department
        session.persist(department3);
        t.commit();    }
}

