package com.tanmoy.mapreduce.Assignment;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.mapred.lib.MultipleOutputs;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;
import org.apache.hadoop.conf.*;

import helpers.*;

// ./datasets/HR_Dataset.csv output3 ./datasets/HR_Dataset.txt

 
public class AssignmentDriver extends Configured implements Tool{
	 
	
	public static void main(String[] args) throws Exception {
	        int returnStatus = ToolRunner.run(new Configuration(), new AssignmentDriver(), args);
	        System.exit(returnStatus);
	    }

    
	public int run(String[] args) throws IOException{
   
  
  
    	Job job = new Job(getConf());
    	
    	
    	 job.setJobName("Word Count");
    	
    	 job.setJarByClass(AssignmentDriver.class);

    	 job.setOutputKeyClass(Text.class);
    	 job.setOutputValueClass(Text.class);
    	 
    	 job.setMapperClass(EmployeeMapper.class);
    	 //job.setCombinerClass(WordCountReducer.class);
    	 job.setReducerClass(EmployeeReducer.class);
    	 // set no of reducer should match the total buckets in the custom partitioner
    	 job.setNumReduceTasks(12);
    	 job.setPartitionerClass(MonthwisePartitioner.class);
    	 
    	 Configuration conf = new Configuration();
    	 System.out.println("Connecting to -- "+conf.get("fs.defaultFS"));
    	
    	//UrlToHdfsFile helperFunction = new UrlToHdfsFile();
    	//Path inputPath = helperFunction.convertUriToHdfs(args[0], conf);
    	 //String hdfsInput = new CSVToTilde().validate(args[0], args[3]);
    	//String file = CSVToTilde(args[0], args[3]) ;
    	 
    	FileInputFormat.addInputPath(job, new Path(args[0]));
    	FileOutputFormat.setOutputPath(job,new Path(args[1]));
    	   	
    	
    	try {
			return job.waitForCompletion(true) ? 0 : 1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    	
    	
      
    }
 
   
 
}