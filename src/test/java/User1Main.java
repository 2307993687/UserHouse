import cn.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class User1Main {
    public static void main(String[] args) {
        //加载配置文件
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取会话
        Session ss = sessionFactory.openSession();
        Transaction tt = ss.beginTransaction();
/*
        Users user=(Users)ss.get(Users.class,1);
        System.out.println("输出"+user);//根据id 查询
        */
/*
        Users user =new Users("打法是否撒","fsfgdf",
                "8794562131","dfdf","不是");
        Serializable serializable = ss.save(user);//添加数据    返回执行的序列号
        System.out.println(serializable);
        */

/*
        Users user =new Users(2,"sfasf","123465",
                "18746857853","曾数据","是");
        ss.update(user);//修改 ，无返回方法*/
    /*    Users user =new Users(2);
        ss.delete(user);
       System.out.println("删除成功");
       */


        tt.commit();
        ss.close();
    }
}
