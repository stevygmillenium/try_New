package file_Compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Zip_file {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String files[]= {"",""};
		//System.out.println(zip_files(files,"filename.zip"));
		System.out.println(view_files("filename.zip"));
		System.out.println(unzip_files("filename.zip"));
	}
	public static String zip_files(String files[],String filename) throws IOException {		
		FileOutputStream fos = new FileOutputStream(filename);
		ZipOutputStream zipout = new ZipOutputStream(fos);
		for(String fl:files) {
			File file =new File(fl);
			FileInputStream fis = new FileInputStream(file);
			ZipEntry ze=new ZipEntry(file.getName());
			zipout.putNextEntry(ze);
			byte[]fb=fis.readAllBytes();
			zipout.write(fb,0,fb.length);
			fis.close();
		}
		zipout.close();
		fos.close();
		return filename+" created.";
	}
	public static String view_files(String file) throws IOException {
		ZipFile zf=new ZipFile(file);
		Enumeration<? extends ZipEntry> entries=zf.entries();
		StringBuilder sb=new StringBuilder();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			String name = entry.getName();
			sb.append(name+"\n");
		}
		zf.close();
		return sb.toString();
	}
	public static int unzip_files(String file) throws IOException {
		String dir="";
		ZipFile zf=new ZipFile(file);
		Enumeration<? extends ZipEntry> entries=zf.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			BufferedInputStream bis=new BufferedInputStream(zf.getInputStream(entry));
			File file_out=new File(dir, entry.getName());
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file_out));
			byte[]fb=bis.readAllBytes();
			bos.write(fb,0,fb.length);
			bis.close();
			bos.close();
		}
		int count=zf.size();
		zf.close();
		return count;
	}

}
