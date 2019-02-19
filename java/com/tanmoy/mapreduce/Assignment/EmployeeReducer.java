package com.tanmoy.mapreduce.Assignment;

import java.io.*;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapred.lib.MultipleOutputs;
 
public class EmployeeReducer extends Reducer<Text, Text, Text, Text>{
	
    public void reduce(Text key, Text value, Context context) throws IOException {
    // write the incoming records(name and dob) in proper month. 
    // the partitioner will handle that
        
        try {
			context.write(key, value);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}     
	
    }
}