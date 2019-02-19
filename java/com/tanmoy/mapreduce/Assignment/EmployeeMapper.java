package com.tanmoy.mapreduce.Assignment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.slf4j.Logger;
public class EmployeeMapper extends
		Mapper<LongWritable, Text, Text, Text> {
	//input=(byte offset, text) output=(word, 1)
	@Override
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
    	
 //The course 2 of = ["The", "course", "2", "of"] 
		String lineBuffer [] = value.toString().split("~");
		
		// read each line in csv, extract name , id, and dob
		// extract month from dob and write as intermediate value
        //for(String 
		    //String st1 =  lineBuffer;
        	String[] columns = lineBuffer;
        	String birthday = columns[12].split("/")[0] + "-" + columns[12].split("/")[1];
        	String intermediateKey = columns[0] + "|" +  columns[1] + "|" + birthday;
        	String intermediateValue = columns[12].split("/")[0];
        	
        	Pattern p = Pattern.compile("[a-z]");
        	Matcher m = p.matcher(intermediateValue);
        	//("Sending intermediate key value pairs");
        	
        	//if (m.find()) {
            context.write(new Text(intermediateKey), new Text(intermediateValue)); 
        	//}
       // }

	}
}
