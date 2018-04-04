import cn.Dao.HouseDao;
import cn.entity.House;

import java.util.Calendar;
import java.util.List;

/**
 * 房屋信息表
 */
public class HouseMain {
    public static void main(String[] args) {
        HouseDao hd=new HouseDao();
        String sql="from House where 1=1";
        House hu=new House();
//        hu.setPrice(8000);
//        hu.setContact("%李明%");
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        hu.setPubDate(cal.getTime());
        List<House> list=hd.getList(hu,sql);
        for (House e:list) {
            System.out.println(e);
        }
    }
}
