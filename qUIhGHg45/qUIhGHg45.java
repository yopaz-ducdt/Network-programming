package qUIhGHg45;

import java.net.*;

public class qUIhGHg45 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String msg = ";B22DCCN222;UIhGHg45";
        socket.send(new DatagramPacket(msg.getBytes(),msg.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket pk = new DatagramPacket(buf, buf.length);
        socket.receive(pk);
        String line = new String(pk.getData(), 0, pk.getLength());
        
        String[] parts = line.split(";", 2);
        String requestId = parts[0];
        String[] nums = parts[1].split(",");
        String num1 = nums[0];
        String num2 = nums[1];
        
        int b1 = Integer.parseInt(num1, 2);
        int b2 = Integer.parseInt(num2, 2);
        
        int sum = b1 + b2;
        
        String res = requestId + ";" + sum;
        socket.send(new DatagramPacket(res.getBytes(),res.getBytes().length, addr, port));
        
        socket.close();
    }
}
