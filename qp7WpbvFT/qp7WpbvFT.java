    package qp7WpbvFT;

    import java.math.*;
    import java.net.*;
 
    public class qp7WpbvFT {
        public static void main(String[] args) throws Exception {
            DatagramSocket socket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("203.162.10.109");
            int port = 2207;

            String mess = ";B22DCCN222;p7WpbvFT";
            socket.send(new DatagramPacket(mess.getBytes(), mess.getBytes().length, addr, port));

            byte[] buf = new byte[1024];
            DatagramPacket pk = new DatagramPacket(buf, buf.length);
            socket.receive(pk);
            String line = new String(pk.getData(), 0, pk.getLength());

            String[] parts = line.split(";", 3);
            String requestId = parts[0];
            BigInteger a = new BigInteger(parts[1]);       
            BigInteger b = new BigInteger(parts[2]);

            BigInteger sum = a.add(b);
            BigInteger diff = a.subtract(b);

            String res = requestId + ";" + sum + "," + diff;
            socket.send(new DatagramPacket(res.getBytes(), res.getBytes().length, addr, port));

            socket.close();
        }
    }
