package event;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 张亚舒
 * @Title: Writer
 * @ProjectName firstSparkDemo
 * @Description: 事件源相當於被觀察者
 * @date 2019/2/1413:54
 */
public class Writer {

    private User writer;

    private String lastBook;

    Set<WriteListener> writeListenerSet = new HashSet<>();

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public String getLastBook() {
        return lastBook;
    }

    public void setLastBook(String lastBook) {
        this.lastBook = lastBook;
    }

    public Writer(String username) {
        super();
        writer = new User();
        writer.setUserName(username);

        WriterManager.getInstance().addWriter(this);
    }

    public void publishBook(String bookName) {
        System.out.println("事件源（作者） : " + writer.getUserName() + ";   发布了新书: " + bookName + " ... ... ");
        lastBook = bookName;

        //设置被观察发生改变的状态,并通知所有监听器
        triggerEvent();
    }

    /*
     * 这个触发器将事件源特性赋予母对象，并且添加到事件监听器中
     */
    private void triggerEvent() {
        WriterEvent writerEvent = new WriterEvent(this);
        for (WriteListener writerEventListener:writeListenerSet
             ) {
            writerEventListener.addNovel(writerEvent);
        }
    }

    //监听器的添加
    public void addWriterListener(WriteListener writerListener){
        writeListenerSet.add(writerListener);
    }

    //监听器的取消
    public void removeWriterListener(WriteListener writerListener){
        writeListenerSet.remove(writerListener);
    }
}
