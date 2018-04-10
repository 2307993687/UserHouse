package cn.one;
/**
 * 用户表
 */
public class Users {
    public Users() {
        super();
    }

    public Users(int id) {
        this.id = id;
    }

    public Users(int id, String name, String passWord, String telePhone, String userName, String isAdmin) {
        this.id = id;
        this.name = name;
        passWord = passWord;
        telePhone = telePhone;
        userName = userName;
        isAdmin = isAdmin;
    }

    public Users(String name, String passWord, String telePhone, String userName, String isAdmin) {
        this.name = name;
        passWord = passWord;
        telePhone = telePhone;
        userName = userName;
        isAdmin = isAdmin;
    }

    private int id;//用户编号
    private String name;//用户名
    private String passWord;//密码
    private String telePhone;//电话
    private String userName;//姓名
    private String isAdmin;//是否是管理员

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", telePhone='" + telePhone + '\'' +
                ", userName='" + userName + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                '}';
    }
}
