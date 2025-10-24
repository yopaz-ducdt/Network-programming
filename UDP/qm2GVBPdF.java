package UDP;

import java.io.*;
import java.net.*;

public class qm2GVBPdF {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        
        String msg = ";B22DCCN222;m2GVBPdF";
        socket.send(new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket pk = new DatagramPacket(buf, buf.length);
        socket.receive(pk);
        byte[] data = pk.getData();
        
        String requestId = new String(data, 0, 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(data, 8, pk.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee e = (Employee) ois.readObject();
        ois.close();
        
        e.name = viethoa(e.name);
        e.salary = tangluong(e.salary, e.hireDate);
        e.hireDate = doingay(e.hireDate);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(requestId.getBytes());
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(e);
        oos.flush();
        
        byte[] res = baos.toByteArray();
        socket.send(new DatagramPacket(res, res.length, addr, port));
        socket.close();
    }
    
    private static String viethoa(String name) {
        String[] parts = name.trim().toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : parts) {
            sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
    
    private static double tangluong(double salary, String date) {
        int sum = 0;
        String year = date.substring(0, 4);
        char[] nums = year.toCharArray();
        for (char s : nums) {
            sum += (s - '0');
        }
        return salary * (1 + sum / 100.0);
    }
    
    private static String doingay(String date) {
        String[] parts = date.split("-", 3);
        return parts[2] + "/" + parts[1] + "/" + parts[0];
    }
}

class Employee implements Serializable {
    private static final long serialVersionUID = 20261107L;
    String id, name, hireDate;
    double salary;

    public Employee(String id, String name, double salary, String hireDate) {
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
        this.salary = salary;
    }
}