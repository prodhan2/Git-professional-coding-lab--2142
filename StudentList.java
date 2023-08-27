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
		if(args.length<1)
		{
			System.out.println(Constant.INVALID);

		}
		 else if(args[0].equals(Constant.SHOW_DATA)) {
			System.out.println(Constant.LOADING_DATA);

			for(String name : FileReader().split(Constant.SPLIT)) {
				System.out.println(name);

			}
			System.out.println(Constant.LOADED_DATA);
		}
		else if(args[0].equals(Constant.RANDOM_DATA))
		{
			System.out.println(Constant.LOADING_DATA);

			int index =  new Random().nextInt(FileReader().split(Constant.SPLIT).length);
			System.out.println(FileReader().split(Constant.SPLIT)[index]);

			System.out.println(Constant.LOADED_DATA);
		}
		else if(args[0].contains(Constant.ADD_DATA)){
			System.out.println(Constant.LOADING_DATA);
			try {

			fileWriter(", "+args[0].substring(1)+Constant.LAST_UPDATE+new SimpleDateFormat( Constant.DATE_FORMATE).format(new Date()));
			} catch (Exception e){
				System.out.println(e);
			}
							
			System.out.println(Constant.LOADED_DATA);
		}
		else if(args[0].contains(Constant.SEARCH_DATA))
		{
			System.out.println(Constant.LOADING_DATA);

			boolean found = false;

			for(int idx = 0; idx<FileReader().split(Constant.SPLIT).length && !found; idx++) {
				if(FileReader().split(Constant.SPLIT)[idx].equals(args[0].substring(1))) {
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

			System.out.println(FileReader().split(Constant.SPLIT).length +Constant.WORDS_FOUND );

			System.out.println(Constant.LOADED_DATA);
		}
		else {
			System.out.println(Constant.INVALID);
		}
	}
}