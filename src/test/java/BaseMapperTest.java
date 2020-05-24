import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.benjamin.bean.Department;
import com.benjamin.dao.DepartmentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class BaseMapperTest {

    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDao departmentDao = context.getBean("departmentDao",
                DepartmentDao.class);

        // 分页查询
        Page<Department> departmentPage = departmentDao.selectPage(new Page<Department>(1,
                        1),
                null);
        System.out.println("total:" + departmentPage.getTotal() + "\ncontent:" + departmentPage.getRecords());
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDao departmentDao = context.getBean("departmentDao",
                DepartmentDao.class);
        Department d = new Department();
        //        d.setId(1);
        d.setDname("研发部");
        List<Department> result = departmentDao.findAllByCondition(d);
        System.out.println(result);
        result = departmentDao.findAllByCondition(d);
        System.out.println(result);

    }

    @Test
    public void test03() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDao departmentDao = context.getBean("departmentDao",
                DepartmentDao.class);
        TransactionTemplate transactionTemplate = context.getBean("transactionTemplate",
                TransactionTemplate.class);

        //同一个事务，同一个session，一级缓存优化
        //        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
        //            @Override
        //            protected void doInTransactionWithoutResult(TransactionStatus status) {
        //                List<Department> departments = departmentDao.selectList(null);
        //                System.out.println(departments);
        //                departments = departmentDao.selectList(null);
        //                System.out.println(departments);
        //            }
        //        });

        //没开启事务，不同session，无一级缓存优化，发起两条sql查询
        //没开启事务，不同session，开启二级缓存优化，第二次相同查询，不重复发起sql查询
        List<Department> departments = departmentDao.selectList(null);
        System.out.println(departments);
        departments = departmentDao.selectList(null);
        System.out.println(departments);
    }

    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDao departmentDao = context.getBean("departmentDao",
                DepartmentDao.class);

        // BaseEntity下的字段dateCreated，加上注解@TableField(fill = ...)，自动填充
        // 自动填充处理器：BaseEntityMetaObjectHandler
        Department d = new Department();
        d.setDname("销售部");

        int insert = departmentDao.insert(d);
    }

    @Test
    public void test05(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDao departmentDao = context.getBean("departmentDao",
                DepartmentDao.class);

        // BaseEntity下 @TableLogic注解，开启逻辑删除
        // 逻辑删除仅作用于 mp自带方法删除和查找都会附带逻辑删除功能 (自己写的xml不会)
        int i = departmentDao.deleteById(3);
    }
}
