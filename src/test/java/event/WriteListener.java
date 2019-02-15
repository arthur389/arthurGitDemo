package event;

import java.util.EventListener;

/**
 * @author 张亚舒
 * @Title: WriteListener
 * @ProjectName firstSparkDemo
 * @Description: 监听器接口
 * @date 2019/2/1413:50
 */
public interface WriteListener extends EventListener {
    /**
     * 监听的动作
     *
     * @param writerEvent
     */
    void addNovel(WriterEvent writerEvent);
}
