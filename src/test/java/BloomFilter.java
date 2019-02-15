
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 张亚舒
 * @Title: BloomFilter 布隆过滤器
 * @ProjectName firstSparkDemo
 * @Description: TODO
 * @date 2018/11/2012:41
 */
public class BloomFilter {

    public static final int NUM_SLOTS=1024*1024*8;
    public static final int NUM_HASH=8;
    private BigInteger bitmap = new BigInteger("0");

    public static void main(String[] args)
    {
        System.out.println("开始执行时间：" + System.currentTimeMillis());
        //测试代码
        BloomFilter bf = new BloomFilter();
        ArrayList<String> tempcontents = new ArrayList<>();
        tempcontents.add("sldkjelsjf");
        tempcontents.add("ggl;ker;gekr");
        tempcontents.add("wieoneomfwe");
        tempcontents.add("sldkjelsvrnlkjf");
        tempcontents.add("ksldkflefwefwefe");
        tempcontents.add("sldkjeewtuertlsjf");
        tempcontents.add("ggl;ker;gelyuikr");
        tempcontents.add("wieoneocvnhfemfwe");
        tempcontents.add("sldkjelpiurhfjsjf");
        tempcontents.add("ggl;ker;gek465dgr");
        tempcontents.add("wieoneo34sdrgeamfwe");
        tempcontents.add("我爱你");
        tempcontents.add("我是一棵草");
        tempcontents.add("我是一个草");

        ArrayList<String> contents = new ArrayList<>();
        contents.addAll(tempcontents);

        for (int i = 1; i < 5001; i++) {
            for (String string: tempcontents) {
                string  = string + String.valueOf(i);
                contents.add(string);
            }
        }

        for(int i=0;i<contents.size();i++){
            bf.addElement(contents.get(i));
        }
        System.out.println("执行结束时间：" + System.currentTimeMillis());

        System.out.println("开始检测时间：" + System.currentTimeMillis());
        System.out.println(bf.check("我是一棵草"));
        System.out.println(bf.check("我是一个小草"));

        System.out.println("结束检测时间：" + System.currentTimeMillis());
    }

    private boolean check(String string)
    {
        for(int i=0;i<NUM_HASH;i++){
            int hashcode = getHash(string,i);
            if(!this.bitmap.testBit(hashcode)){
                return false;
            }
        }
        return true;
    }

    private int getHash(String string, int n)
    {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            string = string + String.valueOf(n);//把np拼接到md5字符串的最后
            byte[] bytes = string.getBytes();
            md5.update(bytes);
            BigInteger bigInt = new BigInteger(md5.digest());
            return Math.abs(bigInt.intValue())%NUM_SLOTS;
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(BloomFilter.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }

    private void addElement(String message) {
        for(int i=0;i<NUM_HASH;i++){
            int hashcode = getHash(message,i);
            if(!bitmap.testBit(hashcode)){
                bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
            }
        }
    }
    
    
}
