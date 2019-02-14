package com.tanmoy.mapreduce.Assignment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class WordCountMapper extends
		Mapper<LongWritable, Text, Text, Text> {
	//input=(byte offset, text) output=(word, 1)
	@Override
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
    	
 //The course 2 of = ["The", "course", "2", "of"] 
		String st [] = value.toString().split("\n");
		
		
        for(String st1 :  st) {
        	String intermediateKey = st1.split(",")[0] + "|" +  st1.split(",")[1];
        	String intermediateValue = st1.split(",")[12];
     
            context.write(new Text(intermediateKey.replaceAll("[^a-zA-Z]","").toLowerCase()), new Text(intermediateValue)); 
            //"The"="the"
        }

	}
}
