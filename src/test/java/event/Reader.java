package event;

/**
 * @author 张亚舒
 * @Title: Reader
 * @ProjectName firstSparkDemo
 * @Description: 监听者，相当于观察者
 * @date 2019/2/1414:18
 */
public class Reader implements WriteListener{
    private User reader;

    public Reader(String readerName){
        super();
        reader = new User();
        reader.setUserName(readerName);
    }
    @Override
    public void addNovel(WriterEvent writerEvent) {
        System.out.println("监听器(读者) ：" + reader.getUserName() + ";  收到事件源(作者) : " + writerEvent.getWriter().getWriter().getUserName() +
                ", 发布了 -->" + writerEvent.getWriter().getLastBook());
    }

    public User getReader() {
        return reader;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }
}
