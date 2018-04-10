package cn.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 公共包
 */
public class HibernateComm {

    private static ThreadLocal<Session> th = new ThreadLocal<Session>();
    private static SessionFactory ss;
    static {
        //加载配置文件
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        ss = configure.buildSessionFactory();
    }

    //打开会话
    public static Session openSession(){
        Session session = th.get();
        if(session == null){
            session = ss.openSession();
            th.set(session);
        }
        return session;
    }

    /**
     * 打开事物
     * @param session 会话
     * @return
     */
    public static Transaction transaction(Session session){
        return session.beginTransaction();
    }

}
