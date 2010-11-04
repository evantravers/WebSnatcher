class Websnatcher {
	public static void main(String args[]) {
		// make sure the BDTree exists
		Spider s = new Spider();
		try {
			String target = args[0];
			if (!(target.indexOf("http") > -1)) {
				System.out.println("Please format your request as http://www.website.com");
				System.exit(0);
			}
			s.run(target);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		// run Spider on the URL, ensure that the argument is formatted correctly
	}
}