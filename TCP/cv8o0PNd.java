import java.io.*;
import java.net.*;

public class cv8o0PNd {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        String datasend = "B22DCCN222;cv8o0PNd";
        os.write(datasend.getBytes());

        byte[] buffer = new byte[1024];
        int bytesRead = is.read(buffer);
        String datarec = new String(buffer, 0, bytesRead);

        String[] numbers = datarec.split("\\|");
        long sum = 0;
        for (String num : numbers) {
            sum += Long.parseLong(num.trim());
        }
        String sumstr = String.valueOf(sum);
        os.write(sumstr.getBytes());

        os.close();
        is.close();
        socket.close();
    }
}