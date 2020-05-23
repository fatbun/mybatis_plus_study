import com.benjamin.bean.Department;
import com.benjamin.dao.DepartmentDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BaseMapperTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDao departmentDao = context.getBean("departmentDao",
                DepartmentDao.class);

        List<Department> departments = departmentDao.selectList(null);
        System.out.println(departments);
    }
}
