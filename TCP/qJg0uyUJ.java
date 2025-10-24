import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Comparator;

public class qJg0uyUJ {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        socket.setSoTimeout(5000);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String datasend = "B22DCCN222;qJg0uyUJ";
        out.write(datasend);
        out.newLine();
        out.flush();

        String line = in.readLine();
        String[] words = line.split(" ");
        Arrays.sort(words, Comparator.comparingInt(String::length).thenComparing((w1, w2) -> 0));
        String resulString = String.join(", ", words);

        out.write(resulString);
        out.newLine();
        out.flush();

        out.close();
        in.close();
        socket.close();
    }
}
