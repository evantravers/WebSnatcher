import java.util.*;
import java.io.*;
import java.net.*;

public class Spider {
	Vector vectorToSearch = new Vector();
	Vector vectorSearched = new Vector();
	Vector vectorMatches = new Vector();
	
	public static final int SEARCH_LIMIT = 500;
	
	// the main function assumes that 
	public static void main(String args[]) {
		
	}
	
	public void run(String target) throws Exception {
		// get index file
		URL url;
		String strURL;
		int numberSearched = 0;
		int numberFound = 0;
		
		// initialize search data structures
		vectorToSearch.removeAllElements();
		vectorSearched.removeAllElements();
		vectorMatches.removeAllElements();
		vectorToSearch.addElement(target);

		// time to start the crawler
		while (vectorToSearch.size() > 0) {
			strURL = (String) vectorToSearch.elementAt(0);
			
			// get the url off the top of the queue
			try { 
				url = new URL(strURL);
		    } catch (MalformedURLException e) {
				System.out.println("ERROR: invalid URL " + strURL);
				break;
		    }	
		
			// mark the URL as searched 
		    vectorToSearch.removeElementAt(0);
		    vectorSearched.addElement(strURL);
		
			// TODO check http https
			// download/stream the file
			if (url.getProtocol().compareTo("http") != 0) {
				break;
			}
			try {
				// try opening the URL
				URLConnection urlConnection = url.openConnection();

				urlConnection.setAllowUserInteraction(false);

				InputStream urlStream = url.openStream();
				String type = urlConnection.guessContentTypeFromStream(urlStream);
				
				// TODO reevaluate this
				// if (type == null) {
				// 	System.out.println("oh noes");
				//     break;
				// }
				// 			
				// if (type.compareTo("text/html") != 0) {
				// 	System.out.println("oh noes2");
				// 	break;
				// }
				
				int lngth = urlStream.available()+1000;
				
				byte b[] = new byte[lngth];
				
				try {
					int numRead = urlStream.read();
				} catch (NullPointerException e) {
					// TODO handle overflow
				}
				
				// read it to a string
				int numRead = urlStream.read(b);
				String content = new String(b, 0, numRead);
				while (numRead != -1) {
					numRead = urlStream.read(b);
					if (numRead != -1) {
						String newContent = new String(b, 0, numRead);
						content += newContent;
				    }
				}
				urlStream.close();
				
				String lowerCaseContent = content.toLowerCase();
				
				// parse it for hrefs/src
				ArrayList<String> links = evaluate(lowerCaseContent);
				
				// work your way through the list it just returned
				while (!links.isEmpty()) {
					String tmp = links.remove(0);
					if (!vectorSearched.contains(tmp)) {
						vectorToSearch.add(tmp);
					}
				}
				
				// if it hasn't been visited, add it to the todo list
				
			} catch (IOException e) {
				System.out.println("ERROR: couldn't open URL " + url);
				continue;
		    }
		
			// do the next thing
		}
	}
	
	public ArrayList<String> evaluate(String content) {
		System.out.println(content);
		ArrayList<String> links = new ArrayList<String>();
		// if href and not css

			// if link is local and not followed then add it to todo

			// localize link for the placer
			
			// if css or favicon
			
				// download, hash, replace link

		// if src

			// download and hash

			// replace link with new link
			
		// send the finished content to the placer for processing
		return links;
	}
}