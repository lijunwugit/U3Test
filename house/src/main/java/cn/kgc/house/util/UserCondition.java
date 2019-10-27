package cn.kgc.house.util;

public class UserCondition extends PageUtil {
    private String name;
    private String telephone;

    public UserCondition() {
    }

    public UserCondition(Integer page, Integer rows, String name, String telephone) {
        super(page, rows);
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
