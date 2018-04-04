package cn.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 公共包
 */
public class HibernateComm {

    private static SessionFactory ss;
    static {
        //加载配置文件
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        ss = configure.buildSessionFactory();
    }

    /**
     * 打开会话
     * @return
     */
    public static Session session(){
        return ss.openSession();
    }

    /**
     * 打开事物
     * @param session 会话
     * @return
     */
    public static Transaction transaction(Session session){
        return session.beginTransaction();
    }

    /**
     * 提交事物，关闭会话
     * @param transaction  事物
     * @param session  会话
     */
    public static void close(Transaction transaction,Session session){
        if(transaction !=null){
            transaction.commit();
        }
        if(session !=null){
            session.close();
        }
    }
}
