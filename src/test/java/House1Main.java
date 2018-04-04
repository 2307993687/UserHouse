import cn.entity.House;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 房屋信息表
 */
public class House1Main {
    public static void main(String[] args) {
        //加载配置文件
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取会话
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       House h =(House)session.get(House.class,1);
        System.out.println(h.getTitle());
        transaction.commit();
        session.close();
    }
}
