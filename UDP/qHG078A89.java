package UDP;

import java.io.*;
import java.net.*;

public class qHG078A89 {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        
        String mess = ";B22DCCN222;HG078A89";
        socket.send(new DatagramPacket(mess.getBytes(), mess.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket pk = new DatagramPacket(buf, buf.length);
        socket.receive(pk);
        byte[] data = pk.getData();
        
        String requesId = new String(data, 0, 8);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(data, 8, pk.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product p = (Product) ois.readObject();
        ois.close();
        
        String[] parts = p.name.split(" ");
        if (parts.length > 1) {
            String dao = parts[0];
            parts[0] = parts[parts.length - 1];
            parts[parts.length - 1] = dao;
        }
        p.name = String.join(" ", parts);
        
        String soluong = new StringBuilder(String.valueOf(p.quantity)).reverse().toString();
        p.quantity = Integer.parseInt(soluong);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(requesId.getBytes());
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(p);
        oos.flush();
        
        System.out.println(oos);
        
        byte[] sendDt = baos.toByteArray();
        DatagramPacket dps = new DatagramPacket(sendDt, sendDt.length, addr, port);
        socket.send(dps);
        
        socket.close();
    }
}

class Product implements Serializable {

    private static final long serialVersionUID = 20161107L;
    
    String id, code, name;
    int quantity;
    
    public Product () {
        
    }

    public Product(String id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    
    
 }