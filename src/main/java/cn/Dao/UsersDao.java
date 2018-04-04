package cn.Dao;

import cn.entity.Users;
import cn.util.HibernateComm;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * 用户表操作
 */
public class UsersDao {
    /***
     * 根据条件查询用户表
     * 当传过来的对象为空时，查询全部
     * 当对象不为空时，根据对象来拼接SQL语句
     * @param users  对象（条件）
     * @param sql  SQL语句
     * @return
     */
    public static List<Users> query(Users users, String sql){
        Session ss=HibernateComm.session();//打开会话
        Transaction tt=HibernateComm.transaction(ss);//打开事物
        Query query=null;
        if(users==null) {
            query = ss.createQuery(sql);
        }else{
            if(users.getId()>0){
                sql+="and id = :id";
            }
            if(users.getName() !=null && !"".equals(users.getName())){
                sql+=" and name like :name";
            }
            if(users.getPassWord()!=null && !"".equals(users.getPassWord())){
                sql+="and PassWord like :passWord ";
            }
            query = ss.createQuery(sql);
            query.setProperties(users);
        }
        List<Users> list = query.list();
        HibernateComm.close(tt,ss);//提交事物关闭会话
        return list;
    }

}
