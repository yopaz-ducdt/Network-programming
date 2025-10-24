/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qMWKZkCaY;

import java.net.*;
/**
 *
 * @author Tducdz
 */
public class qMWKZkCaY {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String mess = ";B22DCCN222;MWKZkCaY";
        socket.send(new DatagramPacket(mess.getBytes(), mess.length(), addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket pk = new DatagramPacket(buf, buf.length);
        socket.setSoTimeout(5000);
        socket.receive(pk);
        
        String line = new String(pk.getData(), 0, pk.getLength());
        String[] parts = line.split(";", 2);
        String requestId = parts[0];
        String data = parts[1];
        
        String[] words = data.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
               
            }
        }
        String newData = String.join(" ", words);
        String res = requestId  + ";" + newData;
        
        socket.send(new DatagramPacket(res.getBytes(), res.length(), addr, port));
        
        socket.close();
                
    }
}
