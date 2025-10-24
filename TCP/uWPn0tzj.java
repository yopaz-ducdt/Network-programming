import java.io.*;
import java.net.*;

public class uWPn0tzj {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        socket.setSoTimeout(5000);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        os.write(("B22DCCN222;uWPn0tzj").getBytes());
        os.flush();

        byte[] buffer = new byte[1024];
        int readInt = is.read(buffer);
        String line = new String(buffer, 0, readInt);

        String[] parts = line.split(",");
        int n = parts.length;
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
            sum += arr[i];
        }

        double target = sum * 2.0 / n;

        int num1 = arr[0];
        int num2 = arr[1];
        double minDiff = Math.abs((arr[0] + arr[1]) - target);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double diff = Math.abs((arr[i] + arr[j]) - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    num1 = Math.min(arr[i], arr[j]);
                    num2 = Math.max(arr[i], arr[j]);
                }
            }
        }

        os.write((num1 + "," + num2 + "\n").getBytes());
        os.flush();

        os.close();
        is.close();
        socket.close();

    }
}
