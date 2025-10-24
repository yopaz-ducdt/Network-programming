/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2T7MzkKp;

import java.net.*;
import java.util.*;
/**
 *
 * @author Tducdz
 */
public class q2T7MzkKp {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String mess = ";B22DCCN222;2T7MzkKp";
        socket.send(new DatagramPacket(mess.getBytes(), mess.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket pk = new DatagramPacket(buf, buf.length);
        socket.receive(pk);
        
        String line = new String(pk.getData(), 0, pk.getLength());
        String[] parts = line.split(";", 2);
        String requestId = parts[0];
        String[] words = parts[1].split(" ");
        
        Arrays.sort(words, (a, b) -> b.compareToIgnoreCase(a));
        
        String res = requestId + ";" + String.join(",", words);
        socket.send(new DatagramPacket(res.getBytes(), res.getBytes().length, addr, port));
        
        socket.close();
    }
}
