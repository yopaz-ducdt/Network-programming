package RMI;

import java.rmi.*;
import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.Map;

public class qutAoFqsX {
    public static void main(String[] args) throws Exception {
        CharacterService service = (CharacterService) Naming.lookup(
            "rmi://203.162.10.109/RMICharacterService"
        );

        String input = service.requestCharacter("B22DCCN222", "utAoFqsX");
        input = input.replace("\"", "").trim();

        // Đếm tần số theo thứ tự xuất hiện
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue());
        }

        service.submitCharacter("B22DCCN222", "utAoFqsX", result.toString());
        System.out.println("Done: " + result);
    }
}

interface CharacterService extends Remote {
    String requestCharacter(String studentCode, String qCode) throws RemoteException;
    void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
