/* GenerateNames.scala */
/* generates 4 million random alphanumeric string with length 5 and persists them into outputDir. */
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import scala.util.Random
object GenerateNames {
	val outputDir = "/home/jung/sparkapp/output/part"
	def main(args: Array[String]) {
		val conf = new SparkConf()
		.setMaster("local[3]")
		.setAppName("GenerateNames")
		val sc = new SparkContext(conf)
		for (partition <- 0 to 3) {
			val data = Seq.fill(1000000)(Random.alphanumeric.take(5).mkString)
			sc.parallelize(data, 1).saveAsTextFile(outputDir + "_" + partition)
		}
	}
}