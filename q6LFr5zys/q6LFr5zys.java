package q6LFr5zys;

import java.io.*;
import java.net.*;

public class q6LFr5zys {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        out.write("B22DCCN222;6LFr5zys".getBytes());
        out.flush();
        
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String line = new String(buf, 0, len);
        
        int sum = 0;
        String[] nums = line.split("\\|");
        for (String s : nums) {
            sum += Integer.parseInt(s);
        }
        
        out.write(String.valueOf(sum).getBytes());
        out.flush();
        socket.close();
    }
}
