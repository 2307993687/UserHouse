import cn.Dao.UsersDao;
import cn.Dao.UsersDao1;
import cn.Dao.UsersDao2;
import cn.entity.Users;
import cn.util.Pager;

import java.util.List;

/**
 * 用户表
 */
public class UserMain {
    public static void main(String[] args) {
  /*      UsersDao ud=new UsersDao();
        String sql ="from Users where 1=1";
        Users users=new Users();List<Users> list =ud.query(null,sql);
        for (Users e:list ) {System.out.println(e);}
           查询全部 */

 /*  String sql ="from Users where name like :name";
      Users users=new Users();
      users.setId(3);
     users.setName("%d%");users.setPassWord("%admin%");
      List<Users> list = ud.query(users,sql);for (Users e:list ) {System.out.println(e);}
         查询用户名中包含‘d'的用户信息*/

/*        Pager<Users> list= UsersDao1.getList(1,3,null);
        System.out.println("第"+list.getPargerIndex() +"页,每页"+ list.getPargerSize()+"行,总页数:"
                +list.getPargerSum()+" ,总行数:"+list.getPargerCount());
        for (Users e:list.getList() ) {System.out.println(e);}
        分页查询
        */
        Users uu=new Users();
        uu.setId(2);
//        uu.setName("d");
//        uu.setPassWord("ad");
//        uu.setTelePhone("1");
        Pager<Users> list= UsersDao2.getList(1,3,uu);
        System.out.println("第"+list.getPargerIndex() +"页,每页"+ list.getPargerSize()+"行,总页数:"
                +list.getPargerSum()+" ,总行数:"+list.getPargerCount());
        for (Users e:list.getList() ) {System.out.println(e);}
        /* 分页查询效果同上，，建议使用这中方法*/
    }
}
