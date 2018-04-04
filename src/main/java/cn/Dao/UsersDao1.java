package cn.Dao;

import cn.entity.Users;
import cn.util.HibernateComm;
import cn.util.Pager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * 分页查询用户
 *
 */
public class UsersDao1 {
    /**
     * @param index  当前页数
     * @param size   每页条数
     * @param users
     * @return
     */
    public static Pager<Users> getList(int index, int size, Users users){
        Pager<Users> pa=new Pager<Users>();
        pa.setPargerIndex(index);//当前页数
        pa.setPargerSize(size);//每页条数
        pa.setPargerCount(UsersDao1.queryEmpsRows(users));//数据总条数
        //  (总行数+每页行数-1)/每页行数
        pa.setPargerSum((pa.getPargerCount()+pa.getPargerSize()-1)/pa.getPargerSize());//总页数
        pa.setList(queryEmps2(pa.getPargerIndex(),pa.getPargerSize(),users));
        return  pa;
    }

    /**
     * 显示总条数
     * @param users
     * @return
     */
    public static int queryEmpsRows(Users users){
        String sql = "select count(id) from Users where 1=1";
        return UsersDao1.query1(users,sql);
    }


    public static Integer query1(Users users, String sql){
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
        Long o =(Long)query.uniqueResult();//获取唯一结果
        HibernateComm.close(tt,ss);//提交事物关闭会话
        return o.intValue();
    }

    /**
     * 按条件查找，在按页数输出
     * @param pageNo  当页数
     * @param pageSize  每页条数
     * @param users
     * @return
     */
    public static List<Users> queryEmps2(int pageNo,int pageSize,Users users){
        Session ss=HibernateComm.session();//打开会话
        Transaction tt=HibernateComm.transaction(ss);//打开事物
        String sql = "from Users where 1=1";
        Query query=null;
        if(users ==null) {
            query = ss.createQuery(sql);
        }else {
            if (users.getId() > 0) {
                sql += "and id = :id";
            }
            if (users.getName() != null && !"".equals(users.getName())) {
                sql += " and name like :name";
            }
            if (users.getPassWord() != null && !"".equals(users.getPassWord())) {
                sql += "and PassWord like :passWord ";
            }
            query = ss.createQuery(sql);
            query.setProperties(users);
        }
        query.setFirstResult( (pageNo-1)*pageSize );//设置返回的一条记录的位置
        query.setMaxResults(pageSize);//设置最大返回记录数

        List<Users> list = query.list();
        HibernateComm.close(tt,ss);//提交事物关闭会话
        return list;
    }
}
