package algorithm.chap4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TextIndex {
	
	private static Map<String, List<Pos>> textIndex = null;
	private static String text = null;
	
	public static Map<String, List<Pos>> getTextIndex(String fileName) throws FileNotFoundException{
		File file = new File(fileName);
		textIndex = new HashMap<>();
		if(file.length() == 0 || !file.exists()) {
			return textIndex;
		}
		Scanner scanner = new Scanner(file);
		StringBuilder stringBuilder = new StringBuilder();
		String key = null;
		int index = 0;
		int pos = 1;
		while(scanner.hasNext()) {
			key = scanner.next();
			if(textIndex.containsKey(key)) {
				List<Pos> indexes = textIndex.get(key);
				indexes.add(new Pos(index,pos));
			}else {
				List<Pos> indexes = new ArrayList<>(8);
				indexes.add(new Pos(index,pos));
				textIndex.put(key, indexes);
			}
			index += key.length()+1;
			pos++;
			stringBuilder.append(" "+key);
		}
		text = stringBuilder.toString();
		return textIndex;
		
	}
	
	public static void getIndex(String query) {
		String firstKey = query.split(" ")[0];
		int length = query.length();
		boolean found = false;
		int times = 0;
		if(textIndex.containsKey(firstKey)) {
			List<Pos> indexes = textIndex.get(firstKey);
			for(Pos pos:indexes) {
				String temp = text.length() > pos.index+length+1 ? text.substring(pos.index+1, pos.index+length+1):text.substring(pos.index+1, text.length());
				if(temp.equals(query)) {
					found = true;
					times++;
					System.out.println("Pos: "+pos.pos+" Index: "+pos.index+" "+temp);
				}
			}
			if(found) {
				System.out.println(query+" ≥ˆœ÷¡À "+times+" times");
			}
		}
		if(!found)
		System.out.println("--"+query);
	}
	
}
class Pos{
	int index;
	int pos;
	public Pos(int index,int pos) {
		this.index = index;
		this.pos = pos;
	}
}
