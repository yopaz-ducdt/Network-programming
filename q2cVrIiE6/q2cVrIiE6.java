package q2cVrIiE6;

/**
 *
 * @author Tducdz
 */
import java.net.*;


public class q2cVrIiE6 {
    public static void main(String[] args) throws Exception {
//        Tạo kết nối
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
//        Gui du lieu
        String mess = ";B22DCCN222;2cVrIiE6";
        byte[] sendData = mess.getBytes();
        socket.send(new DatagramPacket(sendData, sendData.length, addr, port));
        
//        Nhan du lieu
        byte[] buf = new byte[1024];
        DatagramPacket pk = new DatagramPacket(buf, buf.length);
        socket.receive(pk);
        String line = new String(pk.getData(), 0, pk.getLength());
        
//        Xu ly
        String[] parts  = line.split(";", 2);
        String requestId = parts[0];
        String[] nums = parts[1].split(",");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (String s : nums) {
            int v = Integer.parseInt(s);
            if (v > max) max = v;
            if (v < min) min = v;
        }

//        Gui ket qua
        String res = requestId + ";" + max + "," + min;
        byte[] out = res.getBytes();
        socket.send(new DatagramPacket(out, out.length, addr, port));
        
        socket.close();
    }
}
 