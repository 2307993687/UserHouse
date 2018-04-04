package cn.Dao;

import cn.entity.House;
import cn.util.HibernateComm;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * 房屋信息表
 */
public class HouseDao {
   public static List<House> getList(House house,String sql){
        Session ss=HibernateComm.session();
        Transaction tt=HibernateComm.transaction(ss);
        Query query=null;
        if(house == null) {
            query = ss.createQuery(sql);
        }else{
            if(house.getPrice() !=null && !"".equals(house.getPrice())){
                sql+=" and price = :price ";
            }
            if(house.getContact()!=null &&  !"".equals(house.getContact())){
                sql+=" and contact like :contact ";
            }
            if(house.getPubDate()!=null && !"".equals(house.getPubDate())){
                sql+=" and pubDate > :pubDate ";
                //发布日期最近一个月的add_months(sysdate,-1)
            }
            query = ss.createQuery(sql);
            query.setProperties(house);
        }
        List<House> list = query.list();
        HibernateComm.close(tt,ss);
        return list;
    }
}
