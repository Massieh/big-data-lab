import java.util.Arrays;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class WordCount {
    public static void main(String[] args) throws Exception { 
        String inputFile = "/opt/wordcount/filesample.txt";
        String outputFile = "/opt/wordcount/result";

        SparkConf conf = new SparkConf().setAppName("WordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);
        Path outputPath = new Path(outputFile);
        FileSystem fs = FileSystem.get(sc.hadoopConfiguration());
        if (fs.exists(outputPath)) {
            fs.delete(outputPath, true);
        }

        long t1 = System.currentTimeMillis();

        JavaRDD<String> data = sc.textFile(inputFile)
                                 .flatMap(s -> Arrays.asList(s.split(" ")).iterator());

        JavaPairRDD<String, Integer> counts = data
                .mapToPair(w -> new Tuple2<>(w, 1))
                .reduceByKey((c1, c2) -> c1 + c2);

        counts.saveAsTextFile(outputFile);

        long t2 = System.currentTimeMillis();
        System.out.println("======================");
        System.out.println("time in ms :" + (t2 - t1));
        System.out.println("======================");

        sc.close(); 
    }
}
