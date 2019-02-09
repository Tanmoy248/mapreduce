package com.wordcount;

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
		Mapper<LongWritable, Text, Text, IntWritable> {
	//input=(byte offset, text) output=(word, 1)
	@Override
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
	
    	
 //The course 2 of = ["The", "course", "2", "of"] 
		String st [] = value.toString().split("\\s+");
		
		
        for(String st1 :  st) {
     
            context.write(new Text(st1.replaceAll("[^a-zA-Z]","").toLowerCase()), new IntWritable(1)); 
            //"The"="the"
        }

	}
}
