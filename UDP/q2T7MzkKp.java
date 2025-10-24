package UDP;

import java.io.*;
import java.util.*;
import java.net.*;

public class q2T7MzkKp {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String mess = ";B22DCCN222;2T7MzkKp";
        socket.send(new DatagramPacket(mess.getBytes(), mess.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket recpk = new DatagramPacket(buf, buf.length);
        socket.receive(recpk);
        String line = new String(recpk.getData(), 0, recpk.getLength());
        
        String[] parts = line.split(";", 2);
        String requesId = parts[0];
        String[] words = parts[1].split(" ");
        
        Arrays.sort(words, (a, b) -> b.compareToIgnoreCase(a));
        
        String result = String.join(",", words);
        String senddata = requesId + ";" + result;
        socket.send(new DatagramPacket(senddata.getBytes(), senddata.getBytes().length, addr, port));
        socket.close();
    }
}
