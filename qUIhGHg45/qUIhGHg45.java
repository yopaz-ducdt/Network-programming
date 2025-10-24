package qUIhGHg45;

import java.net.*;

public class qUIhGHg45 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        
        String req = ";B22DCCN222;UIhGHg45";
        socket.send(new DatagramPacket(req.getBytes(), req.getBytes().length, addr, 2208));
        
        byte[] buf = new byte[1024];
        DatagramPacket pk = new DatagramPacket(buf, buf.length);
        socket.receive(pk);
        String line = new String(pk.getData(), 0, pk.getLength());
        
        String[] parts = line.split(";", 2);
        String requestId = parts[0];
        String[] nums = parts[1].split(",", 2);
        
        int b1 = Integer.parseInt(nums[0], 2);
        int b2 = Integer.parseInt(nums[1], 2);
        
        b1 += b2;
        
        String res = requestId + ";" + b1;
        
        socket.send(new DatagramPacket(res.getBytes(), res.getBytes().length, addr, 2208));
        socket.close();
    }
}
