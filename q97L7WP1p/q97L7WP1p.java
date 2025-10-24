package q97L7WP1p;

import java.net.*;

public class q97L7WP1p {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String msg = ";B22DCCN222;97L7WP1p";
        socket.send(new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket pk = new DatagramPacket(buf, buf.length);
        socket.receive(pk);
        String line = new String(pk.getData(), 0, pk.getLength());
        
        String[] parts = line.split(";", 2);
        String requestId = parts[0];
        String nums[] = parts[1].split(",");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (String num : nums) {
            int s = Integer.parseInt(num);
            if (s > max) max = s;
            if (s < min) min = s;
        }
        
        String res = requestId + ";" + max + "," + min;
        socket.send(new DatagramPacket(res.getBytes(), res.getBytes().length, addr, port));
        
        socket.close();
    }
}
