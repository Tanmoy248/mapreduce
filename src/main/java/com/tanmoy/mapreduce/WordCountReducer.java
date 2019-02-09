package com.wordcount;

import java.io.*;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapred.lib.MultipleOutputs;
 
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException {
  //("the",[1,1,1,1])
        int count = 0;
        
        for(IntWritable val : values) {
            count = count + val.get();
         //("the",[1,1,1,1]) --> ("the", 4)  
        }
        
        try {
			context.write(key, new IntWritable(count));
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}     
	
    }
}