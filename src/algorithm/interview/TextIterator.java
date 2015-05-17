package algorithm.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TextIterator implements Iterator<String>{
	private BufferedReader br;


	public static void main(String[] args) {
		try {
			TextIterator it = new TextIterator("/Users/guannan/test");
			while(it.hasNext()){
				System.out.println(it.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TextIterator(String filePath) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(filePath));
	}


	@Override
	public boolean hasNext() {
		try {
			br.mark(1);
			if (br.read() < 0){
				return false;
			}
			br.reset();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	@Override
	public String next() {
		try {
			return br.readLine();
		} catch (IOException e) {
			return null;
		}
	}

}
