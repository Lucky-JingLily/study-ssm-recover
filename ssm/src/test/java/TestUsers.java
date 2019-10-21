import com.jyj.ssm.dao.impl.UserDaoImpl;
import com.jyj.ssm.domain.User;
import com.jyj.ssm.service.BaseService;
import com.jyj.ssm.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @Classname TestUsers
 * @Description TODO
 * @Date 2019/10/18 10:12 上午
 * @Created by lipeijing
 */
public class TestUsers {

    @Test
    public void selectCount() {
        BaseService<User> userBaseService = new UserServiceImpl();

        System.out.println(userBaseService.selectCount());
    }

    @Test
    public void insertUser() {
        BaseService<User> userBaseService = new UserServiceImpl();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("李" + i);
            user.setAge(i + 1);
            userBaseService.insert(user);
        }
    }

    @Test
    public void selectAll() {
        UserDaoImpl dao = new UserDaoImpl();

        List<User> users = dao.selectAll();
        for (User user :
                users) {
            System.out.println(user.getName());
        }
    }
}
