package com.wes.study.flink

import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.scala._

object HelloWorld {

  def main(args: Array[String]): Unit = {
    // 创建执行环境
    val env = ExecutionEnvironment.getExecutionEnvironment

    // 配置执行参数
    val dataset = env.fromElements("hello world", "hello flink", "hello wzp")

    dataset.flatMap(_.split("\\s"))
      .map((_, 1))
      .groupBy(0)
      .sum(1)
      .print()
  }
}
