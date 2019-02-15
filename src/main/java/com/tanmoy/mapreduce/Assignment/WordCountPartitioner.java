package com.tanmoy.mapreduce.Assignment;

import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioner extends Partitioner<Text,Text > implements
    Configurable {

  private Configuration configuration;
  HashMap<String, Integer> months = new HashMap<String, Integer>();

  /**
   * Set up the months hash map in the setConf method.
   */
  
  public void setConf(Configuration configuration) {
    this.configuration = configuration;
    months.put("1", 0);
    months.put("2", 1);
    months.put("3", 2);
    months.put("4", 3);
    months.put("5", 4);
    months.put("6", 5);
    months.put("7", 6);
    months.put("8", 7);
    months.put("9", 8);
    months.put("10", 9);
    months.put("11", 10);
    months.put("12", 11);
  }
  

  /**
   * Implement the getConf method for the Configurable interface.
   */
  public Configuration getConf() {
    return configuration;
  }

  /**
   * You must implement the getPartition method for a partitioner class.
   * This method receives the three-letter abbreviation for the month
   * as its value. (It is the output value from the mapper.)
   * It should return an integer representation of the month.
   * Note that January is represented as 0 rather than 1.
   * 
   * For this partitioner to work, the job configuration must have been
   * set so that there are exactly 12 reducers.
   * Intermediate Key-value pairs are in the form of  (<IP> , <Jan>)
   * the getPartition method directs the hadoop framework to choose the reducer 
   * number returned by the method
   */
  public int getPartition(Text key, Text value, int numReduceTasks) {
	  String bucket = value.toString().split("/")[0];
	  // 9 is the default bucket
    return months.get(bucket);
  }
}
