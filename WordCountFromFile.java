import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCountFromFile {

    public static void main(String[] args){
        String fileName = "mountains.txt";
        String content = readFile(fileName);
        
        if (content!=null) {
            int wordCount=countWords(content);
            System.out.println("Total words in the file"+wordCount);
            
            System.out.println("Printing the words from the file:");
            printWords(content);
        } else {
            System.out.println("Failed to read file: " + fileName);
        }
    }

    private static String readFile(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return contentBuilder.toString();
    }

    private static int countWords(String inputText) {
        StringTokenizer tokenizer = new StringTokenizer(inputText, " \t\n\r\f,.:;?![]'");
        return tokenizer.countTokens();
    }

    public static void printWords(String inputText) {
        StringTokenizer tokenizer = new StringTokenizer(inputText, " \t\n\r\f,.:;?![]'");
		Scanner scan=new Scanner(System.in);
		 ArrayList<String> list=new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
			String token=tokenizer.nextToken();
            System.out.println(token);
			
			list.add(token);
        }
        String key;
        do{
		System.out.println("Enter any string you want to count its repetitions:");
		key=scan.next();
		int count=0;
		for(String i:list){
			if(i.equals(key)){
				count++;
		
	}
		}
	System.out.println("'" +key+ "'" +" appeared "+count+" times");	
	}while(!(key.equals("exit")));
}
}
//now we need a text file
//eg:mountains.txt