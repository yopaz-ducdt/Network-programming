/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qq2Hsiff7;

import java.net.*;
import java.util.*;
/**
 *
 * @author Tducdz
 */
public class qq2Hsiff7 {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String mess = ";B22DCCN222;q2Hsiff7";
        socket.send(new DatagramPacket(mess.getBytes(), mess.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket pk = new DatagramPacket(buf, buf.length);
        socket.receive(pk);
        
        String line = new String(pk.getData(), 0, pk.getLength());
        String[] parts = line.split(";", 2);
        String requestId = parts[0];
        String[] nums = parts[1].split(",");
        
        int[] Array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Array[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(Array);
        
        int max2 = Array[Array.length - 2];
        int min2 = Array[1];
        
        String res = requestId + ";" + max2 + "," + min2;
        socket.send(new DatagramPacket(res.getBytes(), res.getBytes().length, addr, port));
        
        socket.close();
        
    }
}
