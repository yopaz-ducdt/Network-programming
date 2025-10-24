package qx7KlSYHg;

import java.net.*;
import java.io.*;

public class qx7KlSYHg {
    public static void main(String[] args) throws Exception {
        Socket socket= new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF("B22DCCN222;x7KlSYHg");
        
        int n = in.readInt();
        
        String bin = Integer.toBinaryString(n);
        
        out.writeUTF(bin);
        
        socket.close();
    }
}
