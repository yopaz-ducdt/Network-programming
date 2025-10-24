package RMI;

import java.rmi.*;

public class qafXtvZ0Z {
    public static void main(String[] args) throws Exception {
       ByteService service = (ByteService) Naming.lookup("rmi://203.162.10.109/RMIByteService");
       
       byte[] data = service.requestData("B22DCCN222", "afXtvz0z");
       
       byte[] key = "PTIT".getBytes();
       
       byte[] mahoa = new byte[data.length];
       for (int i = 0; i < data.length; i++) {
           mahoa[i] = (byte) (data[i] ^ key[i % key.length]);
       }
       
       service.submitData("B22DCCN222", "afXtvz0z", mahoa);
    }
}

interface ByteService extends Remote {
    public byte[] requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}