import java.io.*;
import java.net.*;

public class ihHDEaFn {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        os.write(("B22DCCN222;ihHDEaFn").getBytes());
        os.flush();

        byte[] buffer = new byte[1024];
        int bufferRead = is.read(buffer);
        String line = new String(buffer, 0, bufferRead);

        int sum = 0;
        String[] numbers = line.split(",");
        for (String num : numbers) {
            int m = Integer.parseInt(num);
            if (snt(m)) {
                sum += m;
            }
        }
        os.write((String.valueOf(sum)).getBytes());
        os.flush();

        os.close();
        is.close();
        socket.close();
    }

    private static boolean snt(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
