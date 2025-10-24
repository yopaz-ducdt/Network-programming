package TCP;

import java.net.*;
import java.io.*;

public class qSy7fOer0 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        out.writeObject("B22DCCN222;Sy7fOer0");

        Laptop lap = (Laptop) in.readObject();

        String[] w = lap.name.trim().split("\\s+");
        if (w.length >= 2) {
            String t = w[0]; w[0] = w[w.length - 1]; w[w.length - 1] = t;
            lap.name = String.join(" ", w);
        }

        lap.quantity = Integer.parseInt(new StringBuilder(String.valueOf(lap.quantity)).reverse().toString());

        out.writeObject(lap);
        socket.close();
    }
}

class Laptop implements Serializable {
    private static final long serialVersionUID = 20150711;
    
    public int id;
    public String code;
    public String name;
    public int quantity;

    public Laptop(int id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    
    
}



