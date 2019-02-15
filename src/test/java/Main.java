import event.Reader;
import event.Writer;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张亚舒
 * @Title: Main
 * @ProjectName firstSparkDemo
 * @Description: TODO
 * @date 2018/11/2011:14
 */
public class Main {

    public static void main(String[] args){
//        System.out.println("持续时间：" + (1542696140200L-1542695481163L)/1000/60);

       /* Pattern p = Pattern.compile(".*collage.*");
        String uri = "http://svr.doyd.cn/box-yhb-api/v1/activity/detail";
        Matcher m = p.matcher(uri);
        if (m.find())
        {
            System.out.println("uri匹配出拼团业务！");
        } else {
            System.out.println("未匹配出结果！");
        }*/

        //1-创建监听器
        Reader readerA = new Reader("读者A");
        Reader readerB = new Reader("读者B");
        Reader readerC = new Reader("读者C");
        Reader readerD = new Reader("读者D");

        //2-创建事件源
        Writer writerA = new Writer("莫言");
        Writer writerB = new Writer("路遥");

        writerA.addWriterListener(readerA);
        writerA.addWriterListener(readerB);
        writerA.addWriterListener(readerC);
        writerA.addWriterListener(readerD);
        writerB.addWriterListener(readerA);
        writerB.addWriterListener(readerD);

        writerA.publishBook("平凡的世界");
        writerB.publishBook("白鹿原");

        writerB.removeWriterListener(readerD);
        writerB.publishBook("十月围城");
    }

    /**
     * @return
     * 获取前一天开始的时间戳
     */
    public static long getYesterdayTime(){
        Date dNow = new Date(); //当前时间
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1); //设置为前一天
        Date dBefore = calendar.getTime(); //得到前一天的时间
        return dBefore.getTime();
    }
}
