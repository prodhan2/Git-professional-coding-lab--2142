import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {



	public static String FileReader()
	{
		Constants Constant = new Constants();

		String studentData = null;
		try{
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constant.FILE_PATH)));
			studentData = reader.readLine();

		}catch (Exception e)
		{
			System.out.println(e);
		}
		return studentData;

	}
	public static void fileWriter(String content)
	{
		Constants Constant = new Constants();
		try{BufferedWriter writer = new BufferedWriter(
				new FileWriter(Constant.FILE_PATH, true));
			writer.write(content);
			writer.close();


		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Constants Constant = new Constants();

//		Check arguments
		if(args[0].equals(Constant.SHOW_DATA)) {
			System.out.println(Constant.LOADING_DATA);
			String studentData = FileReader();
			String studentName[] = studentData.split(Constant.SPLIT);
			for(String name : studentName) {
				System.out.println(name);

			}
			System.out.println(Constant.LOADED_DATA);
		}
		else if(args[0].equals(Constant.RANDOM_DATA))
		{
			System.out.println(Constant.LOADING_DATA);
			String studentData = FileReader();

			String studentName[] = studentData.split(",");
			Random random = new Random();
			int index = random.nextInt(studentName.length);
			System.out.println(studentName[index]);

			System.out.println(Constant.LOADED_DATA);
		}
		else if(args[0].contains(Constant.ADD_DATA)){
			System.out.println(Constant.LOADING_DATA);
			try {

			String newStudentName = args[0].substring(1);
	        Date currentDate = new Date();
	        String dataFormatPattern = Constant.DATE_FORMATE;
	        DateFormat dateFormat = new SimpleDateFormat(dataFormatPattern);
	        String formattedDate= dateFormat.format(currentDate);
			fileWriter(", "+newStudentName+Constant.LAST_UPDATE+formattedDate);
			} catch (Exception e){
				System.out.println(e);
			}
							
			System.out.println(Constant.LOADED_DATA);
		}
		else if(args[0].contains(Constant.SEARCH_DATA))
		{
			System.out.println(Constant.LOADING_DATA);

			String studentData = FileReader();
			String studentName[] = studentData.split(Constant.SPLIT);
			boolean found = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<studentName.length && !found; idx++) {
				if(studentName[idx].equals(t)) {
					System.out.println(Constant.FOUND);
					found=true;
				}

			}
			if(found==false)
			{
				System.out.println(Constant.NOT_FOUND);
			}

			System.out.println(Constant.LOADED_DATA);
		}
		else if(args[0].contains(Constant.COUNT_WORDS))
		{
			System.out.println(Constant.LOADING_DATA);

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
			System.out.println(wordCount +Constant.WORDS_FOUND );

			System.out.println(Constant.LOADED_DATA);
		}
		else {
			System.out.println(Constant.INVALID);
		}
	}
}