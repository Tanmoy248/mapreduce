package com.tanmoy.mapreduce.wordCountCustomPartitioner;

import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioner extends Partitioner<Text,Text > implements
    Configurable {

  private Configuration configuration;
  HashMap<String, Integer> reduceMap = new HashMap<String, Integer>();

  /**
   * Set up the months hash map in the setConf method.
   */
  
  public void setConf(Configuration configuration) {
    this.configuration = configuration;
    /*
     * Frequency of words in a document as per research
     * a	11.682%	
b	4.434%	
c	5.238%	
d	3.174%	
e	2.799%	
f	4.027%	
g	1.642%	
h	4.200%	
i	7.294%	
j	0.511%	
k	0.456%	
l	2.415%	
m	3.826%	
n	2.284%	
o	7.631%	
p	4.319%	
q	0.222%	
r	2.826%	
s	6.686%	
t	15.978%	
u	1.183%	
v	0.824%	
w	5.497%	
x	0.045%	
y	0.763%	
z	0.045%
     */
    reduceMap.put("a", 0);
    reduceMap.put("b", 1);
    reduceMap.put("c", 1);
    reduceMap.put("d", 2);
    reduceMap.put("e", 2);
    reduceMap.put("f", 2);
    reduceMap.put("g", 3);
    reduceMap.put("h", 3);
    reduceMap.put("i", 4);
    reduceMap.put("j", 3);
    reduceMap.put("k", 3);
    reduceMap.put("l", 3);
    reduceMap.put("m", 3);
    reduceMap.put("n", 4);
    reduceMap.put("o", 4);
    reduceMap.put("p", 5);
    reduceMap.put("q", 5);
    reduceMap.put("r", 5);
    reduceMap.put("s", 6);
    reduceMap.put("t", 7);
    reduceMap.put("u", 8);
    reduceMap.put("v", 8);
    reduceMap.put("w", 8);
    reduceMap.put("x", 8);
    reduceMap.put("y", 8);
    reduceMap.put("z", 8);    
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
	  String bucket = value.toString().substring(0, 1);
	  // 9 is the default bucket
	  Integer reducerNum = reduceMap.containsKey(bucket) ? reduceMap.get(bucket) : 9;
    return reducerNum;
  }
}
