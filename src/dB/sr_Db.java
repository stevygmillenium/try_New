package dB;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class sr_Db {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("How many records to enter?");
		Scanner sc=new Scanner(System.in);
		int amt=sc.nextInt();
		Person[]persons = null;//=new Person[amt];
		Person person = null;
		System.out.println(amt);
		if(amt==1) {
			System.out.println("Please enter the name");
			String nm=sc.next();
			System.out.println("Please enter the email");
			String em=sc.next();
			System.out.println("Please enter the type (0-staff/1-student)");
			int type=sc.nextInt();
			Per_type p_type;
			switch(type) {
			case 0:
				p_type=Per_type.staff;
				break;
			case 1:
				p_type=Per_type.student;
				break;
			default:
				p_type=null;
			}
			person= new Person(nm, em, p_type);
			show_person(person);
		}
		else if(amt>1) {
			persons=new Person[amt];
			for(int i=0;i<persons.length;i++) {
				System.out.println("Please enter the name");
				String nm=sc.next();
				System.out.println("Please enter the email");
				String em=sc.next();
				System.out.println("Please enter the type (0-staff/1-student)");
				int type=sc.nextInt();
				Per_type p_type;
				switch(type) {
				case 0:
					p_type=Per_type.staff;
					break;
				case 1:
					p_type=Per_type.student;
					break;
				default:
					p_type=null;
				}
				person= new Person(nm, em, p_type);
				persons[i]=person;
				show_person(persons[i]);
			}
		}
		else {
			System.out.println("Error.");
		}
		System.out.println("Create new file?(t/f)");
		Boolean ch=sc.nextBoolean();
		if(ch==true) {
			System.out.print(ch+"\n");
			if(amt==1) {
				person.writefile();}
			else if(amt>1) {
				persons[0].writefile();
				for(int i=1;i<persons.length;i++) {
					persons[i].appendfile();
				}
			}
			else {
				System.out.println("Error.");
			}
		}
		else if(ch==false) {
			System.out.print(ch+"\n");
			if(amt==1) {
				person.appendfile();}
			else if(amt>1) {
				//persons[0].writefile();
				for(int i=0;i<persons.length;i++) {
					persons[i].appendfile();
				}
			}
			else {
				System.out.println("Error.");
			}
		}
		else {}
		sc.close();
		readfile();
		//System.out.print(rec_search("a"));
	}
	public static void show_person(Person p) {
		System.out.println(p.name);
		System.out.println(p.email);
		System.out.println(p.p_type);
	}
	public static void readfile() throws IOException {
		File file=new File("data.txt");
		String line=null;
		FileReader reader=new FileReader(file);
		BufferedReader br=new BufferedReader(reader);
		StringBuffer str=new StringBuffer("");
		while((line=br.readLine())!=null) {
			str.append(line+"\n");
		}
		System.out.print(str);
		reader.close();
	}
	public static String rec_search(String em) throws IOException {
		File file=new File("data.txt");
		String line=null;
		FileReader reader=new FileReader(file);
		BufferedReader br=new BufferedReader(reader);
		//StringBuffer str=new StringBuffer("");
		Path path=Paths.get(file.getAbsolutePath());
		int lc=(int) Files.lines(path).count(),i = 0;
		Person[]persons =new Person[lc];
		while((line=br.readLine())!=null) {
			String ln[]=line.split(",");
			Per_type p_type;
			if(ln[2].equals("staff")) {
				p_type=Per_type.staff;
			}
			else if(ln[2].equals("student")) {
				p_type=Per_type.student;
			}
			else {
				p_type=null;
			}
			Person person=new Person(ln[0], ln[1], p_type);
			persons[i]=person;
			i++;
		}
		reader.close();
		List<Person>pl=Arrays.asList(persons);
		Person p;
		String rec = null;
		Iterator<Person>pi=pl.iterator();
		while(pi.hasNext()) {
			p=pi.next();
			if(p.email.equals(em)) {
				rec=p.name+" "+p.email+" "+p.p_type;
			}
		}
		return rec;
	}

}
