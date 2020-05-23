import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.benjamin.bean.Department;
import com.benjamin.dao.DepartmentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BaseMapperTest {

    @Test
    public void test01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDao departmentDao = context.getBean("departmentDao",
                DepartmentDao.class);

        List<Department> departments = departmentDao.selectList(null);
        System.out.println(departments);
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDao departmentDao = context.getBean("departmentDao",
                DepartmentDao.class);
        Page<Department> departmentPage = departmentDao.selectPage(new Page<Department>(1,
                        1),
                null);
        System.out.println("total:" + departmentPage.getTotal() + "\ncontent:" + departmentPage.getRecords());
    }
}
