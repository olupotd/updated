package testpackage;

public class SSL_Test {

	public SSL_Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			java.net.URLConnection urlc = new java.net.URL(
					"https://localhost:8443/index.html").openConnection();
			java.io.InputStreamReader isr = new java.io.InputStreamReader(
					urlc.getInputStream(), "UTF-8");
			java.io.BufferedReader br = new java.io.BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			while (true) {
				String s = br.readLine();
				if (s == null)
					break;
				sb.append(s + "\n");
			}
			br.close();
			System.out.print(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
