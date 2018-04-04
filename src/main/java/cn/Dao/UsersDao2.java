package cn.Dao;

import cn.entity.Users;
import cn.util.HibernateComm;
import cn.util.Pager;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * 分页查询
 *
 */
public class UsersDao2 {
    /**
     * @param index  当前页数
     * @param size   每页条数
     * @param users
     * @return
     */
    public static Pager<Users> getList(int index,int size,Users users){
        Pager<Users> pa=new Pager<Users>();
        pa.setPargerIndex(index);//当前页数
        pa.setPargerSize(size);//每页条数
        Session ss=HibernateComm.session();//打开会话
        Transaction tt=HibernateComm.transaction(ss);//打开事物
        Criteria criteria = ss.createCriteria(Users.class);

        if(users == null){
//            criteria.add(Restrictions.in("where 1=1"));
        }else {
            //  select * from users where name like users.getName()
            //   MatchMode.ANYWHERE)代表: 在users.getName()前后都加上百分号%users.getName()%
            if (users.getName() != null && !"".equals(users.getName())) {
                criteria.add(Restrictions.ilike("name", users.getName(), MatchMode.ANYWHERE));
            }
            //【END：以什么结尾】 【EXACT ：精确的】 【ANYWHERE ：在任何地方】【START：以什么开头】
            if (users.getPassWord() != null && !"".equals(users.getPassWord())) {
                criteria.add(Restrictions.ilike("PassWord", users.getPassWord(), MatchMode.ANYWHERE));
            }
            if (users.getTelePhone() != null && !"".equals(users.getTelePhone())) {
                criteria.add(Restrictions.ilike("TelePhone", users.getTelePhone(), MatchMode.START));
            }
            //  select * from users where id = users.getId()
            if(users.getId()>0){
                criteria.add(Restrictions.eq( "id",users.getId()));
            }
        }
        //select count(id) from users where name like '%fdsa%'
        criteria.setProjection(Projections.count("id"));
        pa.setPargerCount( ((Long)criteria.uniqueResult()).intValue());  //设置总行数

        //  (总行数+每页行数-1)/每页行数
        pa.setPargerSum( (pa.getPargerCount()+size-1)/size );

        //select * from emp where name like users.getName()
        criteria.setProjection(null);//清除Projections.count("id")效果
        criteria.setFirstResult( (index-1)*size ).setMaxResults(size);
        //设置返回的一条记录的位置,设置最大返回记录数
        pa.setList(criteria.list());
        return pa;
//        git config --global user.name "2307993687"
//        git config --global user.email "2307993687@qq.com"
    }
}
