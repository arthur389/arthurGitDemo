import org.apache.spark.{SparkConf, SparkContext}

/**
  * @Title: myFirstScala
  * @ProjectName firstSparkDemo
  * @Description: TODO
  * @author 张亚舒
  * @date 2018/8/2210:29
  */
object myFirstScala {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setAppName("myfirstSpark")
    conf.setMaster("local")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(List(1,2,3,4,5,6)).map(_*3)
    val mappedRDD = rdd.filter(_>10).collect()
    //集合求和
    println(rdd.reduce(_+_))
    //输出大于10的元素
    for(arg <- mappedRDD) {
      print(arg + " ")
    }
    println()
    println("math is work")
  }
}
