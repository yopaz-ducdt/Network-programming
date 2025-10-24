package RMI;

import java.rmi.*;
import java.util.*;

public class quucNOP2h {
    public static void main(String[] args) throws Exception {
        // Kết nối RMI Server
        DataService service = (DataService) Naming.lookup(
            "rmi://203.162.10.109/RMIDataService"
        );

        // Nhận dữ liệu từ server
        Object obj = service.requestData("B22DCCN222", "uucNOP2h");
        String dataStr = obj.toString().trim();
        System.out.println("Received: " + dataStr);

        // Tách và chuyển sang int[]
        String[] parts = dataStr.trim().split("\\s+|,");
        List<Integer> list = new ArrayList<>();
        for (String p : parts) {
            p = p.trim();
            if (!p.isEmpty()) list.add(Integer.parseInt(p));
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        // Sinh tổ hợp kế tiếp
        nextPermutation(arr);

        // Ghép lại thành chuỗi kết quả
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(",");
        }

        // Gửi lại kết quả
        service.submitData("B22DCCN222", "uucNOP2h", sb.toString());
        System.out.println("Done: " + sb);
    }

    public static void nextPermutation(int[] a) {
        int n = a.length, i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i >= 0) {
            int j = n - 1;
            while (a[j] <= a[i]) j--;
            swap(a, i, j);
        }
        reverse(a, i + 1, n - 1);
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void reverse(int[] a, int l, int r) {
        while (l < r) swap(a, l++, r--);
    }
}

interface DataService extends Remote {
    Object requestData(String studentCode, String qCode) throws RemoteException;
    void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
