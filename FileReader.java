import java.io.*;
import java.util.*;
class FileReader{

	public Dictionary readFile(){
		Dictionary d=new Dictionary();
		try{
			File f=new File("words.txt");
			Scanner scan=new Scanner(f);
			while(scan.hasNextLine()){
				String line=scan.nextLine();
				String[] arr=line.split("-");
				d.add(arr[0],arr[1]);
			}
			scan.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		return d;
	}
	
}