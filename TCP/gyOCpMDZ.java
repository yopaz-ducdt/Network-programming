import java.io.*;
import java.net.*;

public class gyOCpMDZ {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        dos.writeUTF("B22DCCN222;gyOCpMDZ");
        dos.flush();

        int k = dis.readInt();

        String line = dis.readUTF();
        String[] parts = line.split(",");
        int n = parts.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(parts[i].trim());

        for (int i = 0; i < n; i += k) {
            int left = i, right = Math.min(i + k - 1, n - 1);
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        for (int i = 0; i < n; i += k) {
            int left = i, right = Math.min(i + k - 1, n - 1);
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        dos.close();
        dis.close();
        socket.close();
    }
}
