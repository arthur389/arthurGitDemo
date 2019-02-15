package event;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张亚舒
 * @Title: WriterManager
 * @ProjectName firstSparkDemo
 * @Description: 觀察者管理器
 * @date 2019/2/1414:07
 */
public class WriterManager {

    //1-作者集合
    private Map<String, Writer> writerMap = new HashMap<String, Writer>();

    //2-添加作者
    public void addWriter(Writer writer){
        writerMap.put(writer.getWriter().getUserName(), writer);
    }

    //3-删除作者
    public void removeWriter(Writer writer){
        writerMap.remove(writer.getWriter().getUserName());
    }
    //4-获取作者
    public Writer getWriter(String writerName){
        return writerMap.get(writerName);
    }

    //5-作者是否存在
    public Boolean isWriter(String writerName){
        return writerMap.containsKey(writerName);
    }

    //获取作者集合单例
    private WriterManager(){}
    public static WriterManager getInstance(){
        return WriterManagerInstance.writerManager;
    }
    private static class WriterManagerInstance{
        static WriterManager writerManager = new WriterManager();
    }


    public Map<String, Writer> getWriterMap() {
        return writerMap;
    }
    public void setWriterMap(Map<String, Writer> writerMap) {
        this.writerMap = writerMap;
    }

}
