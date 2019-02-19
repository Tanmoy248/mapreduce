package helpers;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
//import java.nio.file.Path;





import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IOUtils;

import java.nio.file.Files;


public class UrlToHdfsFile {
  public Path convertUriToHdfs(String uri, Configuration conf ) throws IOException{
	  //Path uriOfFile = new Path(uri);
	  System.setProperty("https.protocols", "SSLv3,TLSv1,TLSv1.1,TLSv1.2");
	  BufferedInputStream dataStream = new BufferedInputStream(new FileInputStream(uri));
	  String dst = "/tmp/input_hdfs.txt";
	//Destination file in HDFS
	 FileSystem fs = FileSystem.get(URI.create(dst), conf);
	  OutputStream out = fs.create(new Path(dst));

	  //Copy file from local to HDFS
	  IOUtils.copyBytes(dataStream, out, 4096, true);

	  System.out.println(dst + " copied to HDFS");
	  return new Path(dst);
	  
  }
}
