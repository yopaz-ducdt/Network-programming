package UDP;

import java.io.*;
import java.net.*;


public class qMWLp1xPo {
    public static void main(String[] args) throws Exception {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        
        String mess = ";B22DCCN222;MWLp1xPo";
        socket.send(new DatagramPacket(mess.getBytes(), mess.getBytes().length, addr, port));
        
        byte[] buf = new byte[1024];
        DatagramPacket recpk = new DatagramPacket(buf, buf.length);
        socket.receive(recpk);
        byte[] data = recpk.getData();
        
        String requestId = new String(data, 0, 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(data, 8, recpk.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student s = (Student) ois.readObject();
        ois.close();
        
        s.name = nomalizename(s.name);
        s.email = generateemail(s.name);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(requestId.getBytes());
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(s);
        oos.flush();
        oos.close();
        
        byte[] sendData = baos.toByteArray();
        socket.send(new DatagramPacket(sendData, sendData.length, addr, port));
        
        socket.close();
        
    }
    
    private static String nomalizename(String name) {
    String[] words = name.trim().toLowerCase().split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (String w : words) {
        sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
        
    }
    return sb.toString().trim();
}

    private static String generateemail(String name) {
        String[] parts = name.trim().toLowerCase().split("\\s+");
        if (parts.length < 2) return parts[0] + "@ptit.edu.vn";
        String lastname = parts[parts.length - 1];
        StringBuilder sb = new StringBuilder(lastname);
        for (int i = 0; i < parts.length - 1; i++) {
            sb.append(parts[i].charAt(0));
        }
        return sb.toString() + "@ptit.edu.vn";
    }
}



class Student implements Serializable {
    private static final long serialVersionUID = 20171107L;
    
    String id, code, name, email;

    public Student(String code) {
        this.code = code;
    }

    public Student(String id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }
    
    
}