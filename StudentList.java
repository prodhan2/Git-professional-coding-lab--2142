import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static String FileReader()
	{
		String studentData = null;
		try{
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			studentData = reader.readLine();

		}catch (Exception e)
		{
			System.out.println(e);
		}
		return studentData;

	}
	public static void fileWriter(String content)
	{
		try{BufferedWriter writer = new BufferedWriter(
				new FileWriter("students.txt", true));
			writer.write(content);
			writer.close();


		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");
			String studentData = FileReader();
			String studentName[] = studentData.split(",");
			for(String name : studentName) {
				System.out.println(name);

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");
			String studentData = FileReader();

			String studentName[] = studentData.split(",");
			Random random = new Random();
			int index = random.nextInt(studentName.length);
			System.out.println(studentName[index]);

			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {

			String newStudentName = args[0].substring(1);
	        Date currentDate = new Date();
	        String dataFormatPattern = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(dataFormatPattern);
	        String formattedDate= dateFormat.format(currentDate);
			fileWriter(", "+newStudentName+"\nList last updated on "+formattedDate);
			} catch (Exception e){
				System.out.println(e);
			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			

			String studentData = FileReader();
			String studentName[] = studentData.split(",");
			boolean found = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<studentName.length && !found; idx++) {
				if(studentName[idx].equals(t)) {
					System.out.println("We found it!");
					found=true;
				}
			}

			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			

			String studentData = FileReader();
			char characters[] = studentData.toCharArray();
			boolean in_word = false;
			int wordCount=0;
			for(char character:characters) {
				if(character ==' ')
				{
					if (!in_word) {
						wordCount++;
						in_word =true;
					}
					else {
						in_word=false;
					}
				}
			}
			System.out.println(wordCount +" word(s) found " );

			System.out.println("Data Loaded.");				
		}
		else {
			System.out.println("!Invalid Argument .");
		}
	}
}