package UDP;

import java.net.*;
import java.util.*;

public class q2cVrIiE6 {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String mess = ";B22DCCN222;2cVrIiE6";
        socket.send(new DatagramPacket(mess.getBytes(), mess.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket recpk = new DatagramPacket(buf, buf.length);
        socket.receive(recpk);
        String line = new String(recpk.getData(), 0, recpk.getLength());
        
        String[] parts = line.split(";", 2);
        String requestId = parts[0];
        String[] nums = parts[1].split(",");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (String v : nums) {
            int so = Integer.parseInt(v);
            if (so > max) max = so;
            if (so < min) min = so;
        }        
        
        String send = requestId + ";" + max + "," + min;
        socket.send(new DatagramPacket(send.getBytes(), send.getBytes().length, addr, port));
        socket.close();
        
    }
}
