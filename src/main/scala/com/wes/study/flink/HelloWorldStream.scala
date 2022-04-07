package com.wes.study.flink

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

object HelloWorldStream {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    env.setParallelism(1)

    val ds = env.socketTextStream("127.0.0.1", 7777)

    ds.flatMap(_.split("\\s"))
      .map((_, 1))
      .keyBy(0)
      .sum(1)
      .print()

    env.execute("world count streaming")
  }

}
