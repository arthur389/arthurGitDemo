package event;

import java.util.EventObject;

/**
 * @author 张亚舒
 * @Title: WriterEvent
 * @ProjectName firstSparkDemo
 * @Description: 事件源，这个是事件触发模型的核心类，通过这个类赋予被观察者即事件对象本身的事件特性
 * @date 2019/2/1413:52
 */
public class WriterEvent extends EventObject {

    private static final long serialVersionUID = -7385578705301384072L;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public WriterEvent(Object source) {
        super(source);
    }

    public Writer getWriter(){
        return (Writer) super.source;
    }
}
