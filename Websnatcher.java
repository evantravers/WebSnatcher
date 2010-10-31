class Websnatcher {
	public static void main(String args[]) {
		// make sure the BDTree exists
		Spider s = new Spider();
		try {
			s.run(args[0]);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		// run Spider on the URL, ensure that the argument is formatted correctly
	}
}