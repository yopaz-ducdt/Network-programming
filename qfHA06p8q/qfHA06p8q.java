package qfHA06p8q;

import java.io.*;
import java.net.*;
import java.util.*;
public class qfHA06p8q {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        out.write("B22DCCN222;fHA06p8q\n");
        out.flush();
        
        String line = in.readLine();
        
        Map<Character, Integer> count = new LinkedHashMap<>();
        for (char c : line.toCharArray()) {
            if (Character.isLetterOrDigit(c)) count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        count.forEach((k, v) -> {
            if (v > 1) {
                sb.append(k).append(":").append(v).append(",");
            }
        });
        
        out.write(sb.toString());
        out.flush();
        socket.close();
    }
}
