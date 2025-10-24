import java.io.*;
import java.net.*;

public class MkPK2T4m {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        dos.writeUTF("B22DCCN222;MkPK2T4m");
        dos.flush();

        int a = dis.readInt();
        int b = dis.readInt();

        int sum = a + b;
        int product = a * b;

        dos.writeInt(sum);
        dos.flush();
        dos.writeInt(product);
        dos.flush();

        dos.close();
        dis.close();
        socket.close();
    }
}
