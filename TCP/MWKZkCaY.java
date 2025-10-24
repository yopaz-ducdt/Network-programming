import java.net.*;
import java.util.*;

public class MWKZkCaY {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109/");
        int port = 2208;

        // a. Gửi chuỗi
        String studentCode = "B22DCCN222";
        String qCode = "MWKZkCaY";
        String msg = ";" + studentCode + ";" + qCode;
        byte[] sendData = msg.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
        socket.send(sendPacket);

        // b. Nhận chuỗi từ server
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received: " + received);

        // Tách requestId và data
        String[] parts = received.split(";", 2);
        String requestId = parts[0];
        String data = parts[1];

        // c. Chuẩn hóa chuỗi
        String[] words = data.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1).toLowerCase())
                    .append(" ");
        }
        String processedData = sb.toString().trim();

        // d. Gửi lại server
        String finalMsg = requestId + ";" + processedData;
        byte[] sendBack = finalMsg.getBytes();
        DatagramPacket sendPacket2 = new DatagramPacket(sendBack, sendBack.length, serverAddress, port);
        socket.send(sendPacket2);

        socket.close();
    }
}
