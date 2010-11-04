import java.util.*;
import java.io.*;
import java.net.*;

public class Spider {
	static LinkedList visited = new LinkedList();
	
	// the main function assumes that 
	public static void main(String args[]) {
		
	}
	
	private void get(String location) throws Exception {
		// TODO detect whether this is a page or a component
		URL u;
		InputStream is = null;
		BufferedReader dis;
		String s;
		Scanner scan;
		u = new URL(location);
		is = u.openStream();
		dis = new BufferedReader(new InputStreamReader(is));
		scan = new Scanner(is);

		// while ((s = dis.readLine()) != null) {
		// 			scan = new Scanner(s);
		// 			s = evaluate(s);
		// 		}
		is.close();
	}
	
	public void run(String target) throws Exception{
		// get current file
		get(target);
		
		// crawl through the page 

		// if component
		
		// hash all over that stuff.
		
		// if link
			// check to see if visited and inside current domain
				// visit recursively
				// localize the URL.
		
		visited.add(target);
		// do the next thing
	}
	
	private String evaluate(String s) {
		return s;
	}
}