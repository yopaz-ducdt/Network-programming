import java.io.*;
import java.net.*;

public class ISG8VVhS {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        socket.setSoTimeout(5000);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String studentCode = "B22DCCN222";
        String qCode = "ISG8VVhS";

        out.write(studentCode + ";" + qCode);
        out.newLine();
        out.flush();

        String response = in.readLine();

        String[] domains = response.split(",\\s*");
        for (String domain : domains) {
            if (domain.endsWith(".edu")) {
                out.write(domain);
                out.newLine();
                out.flush();
            }
        }

        in.close();
        out.close();
        socket.close();

    }
}
