import java.io.*;
import java.net.*;

public class sfmWQko8 {
    public static void main(String[] args) {
        String host = "203.162.10.109";
        int port = 2206;
        String studentCode = "B22DCCN222";
        String qCode = "sfmWQko8";

        try (Socket socket = new Socket(host, port)) {
            socket.setSoTimeout(5000);

            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();

            os.write((studentCode + ";" + qCode + "\n").getBytes());
            os.flush();

            byte[] buffer = new byte[1024];
            int bytesRead = is.read(buffer);
            String line = new String(buffer, 0, bytesRead).trim();

            String[] parts = line.split(",");
            int n = parts.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(parts[i].trim());

            int bestIndex = 0;
            int minDiff = Integer.MAX_VALUE;
            int leftSum = 0, rightSum = 0;

            for (int i = 0; i < n; i++) {
                int sumLeft = 0, sumRight = 0;
                for (int j = 0; j < i; j++)
                    sumLeft += arr[j];
                for (int j = i + 1; j < n; j++)
                    sumRight += arr[j];
                int diff = Math.abs(sumLeft - sumRight);
                if (diff < minDiff) {
                    minDiff = diff;
                    bestIndex = i;
                    leftSum = sumLeft;
                    rightSum = sumRight;
                }
            }

            String result = bestIndex + "," + leftSum + "," + rightSum + "," + minDiff;
            os.write((result + "\n").getBytes());
            os.flush();

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
