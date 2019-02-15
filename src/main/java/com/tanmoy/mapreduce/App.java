package com.tanmoy.mapreduce;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import com.opencsv.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        //CSVReader input = new CSVReader(new FileReader("./datasets/HR_Dataset.csv"));
        @SuppressWarnings("resource")
		CSVReader csvInput = new CSVReader(new FileReader("./datasets/HR_Dataset.csv"));
        String[] columns;
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./datasets/HR_Dataset.txt")));
        writer.close();
        }
        catch(Exception e){
        	e.printStackTrace();
        	BufferedWriter writer = new BufferedWriter(new FileWriter("./datasets/HR_Dataset.txt"));
        	writer.write("");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("./datasets/HR_Dataset.txt",true));
        while((columns = csvInput.readNext())!= null){
        	String joined = StringUtils.join(columns, "~");
        	System.out.println(joined);
        	try{
        	writer.append(joined+ "\n");
        	}catch(Exception e){
        		writer.write(joined);
        	}
        		
        }
        //writer.close();
    }
}
