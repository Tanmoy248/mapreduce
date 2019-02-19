package helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import com.opencsv.CSVReader;

public class CSVToTilde {
	public String validate(String input, String output) throws IOException{
        @SuppressWarnings("resource")
		CSVReader csvInput = new CSVReader(new FileReader(input));
        String[] columns;
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
        writer.close();
        
        BufferedWriter appendWriter = new BufferedWriter(new FileWriter(output,true));
        while((columns = csvInput.readNext())!= null){
        	String joined = StringUtils.join(columns, "~");
        	System.out.println(joined);
        	appendWriter.append(joined);
        }
        appendWriter.close();
        return output;
	}
}
