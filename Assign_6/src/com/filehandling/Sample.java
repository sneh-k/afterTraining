package com.filehandling;
import java.io.File;
import java.io.FilenameFilter;

public class Sample {

	public static void main(String[] args) {
		Filter f=new Filter();
		f.finder("D:/Data_shared/Core_java/Assignments");
		System.out.println(f);
	}

}


class Filter {

    public File[] finder( String dirName){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() { 
                 public boolean accept(File dir, String filename)
                      { return filename.endsWith(".txt"); }
        } );

    }

}