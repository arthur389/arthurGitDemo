package event;

import java.io.Serializable;

/**
 * @author 张亚舒
 * @Title: User
 * @ProjectName firstSparkDemo
 * @Description: 人物基础实体类
 * @date 2019/2/1413:49
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5901889626420688980L;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
