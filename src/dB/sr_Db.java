package dB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
			person= new Person(nm, em);
			show_person(person);
		}
		else if(amt>1) {
			persons=new Person[amt];
			for(int i=0;i<persons.length;i++) {
				System.out.println("Please enter the name");
				String nm=sc.next();
				System.out.println("Please enter the email");
				String em=sc.next();
				person= new Person(nm, em);
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
				persons[0].writefile();
				for(int i=1;i<persons.length;i++) {
					persons[i].appendfile();
				}
			}
			else {
				System.out.println("Error.");
			}
		}
		else {}
		readfile();
	}
	public static void show_person(Person p) {
		System.out.println(p.name);
		System.out.println(p.email);
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

}
