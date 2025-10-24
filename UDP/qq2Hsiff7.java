package UDP;

import java.net.*;
import java.io.*;
import java.util.*;

public class qq2Hsiff7 {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String mess = ";B22DCCN222;q2Hsiff7";
        socket.send(new DatagramPacket(mess.getBytes(), mess.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket recpk = new DatagramPacket(buf, buf.length);
        socket.receive(recpk);
        String line = new String(recpk.getData(), 0, recpk.getLength());
        
        String[] parts = line.split(";", 2);
        String requestId = parts[0];
        String[] nums = parts[1].split(",");
        
        int[] dayso = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dayso[i] = Integer.parseInt(nums[i]);
        }
        
        Arrays.sort(dayso);
        
        String send = requestId + ";" + dayso[dayso.length - 2] + "," + dayso[1];
        socket.send(new DatagramPacket(send.getBytes(), send.getBytes().length, addr, port));
        socket.close();
    }
}
