package WS;

import java.net.*;
import java.util.*;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

public class qDbpdF299 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://203.162.10.109:8080/JNPWS/CharacterService?wsdl");
        QName qname = new QName("http://RMI/", "CharacterServiceImplService");
        Service service = Service.create(url, qname);
        CharacterService cs = service.getPort(CharacterService.class);

        String input = cs.requestString("B22DCCN222", "DbpdF299");
        String[] words = input.toLowerCase().replace("_", " ").split("\\s+");
        StringBuilder pascal = new StringBuilder(), camel = new StringBuilder(), snake = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            pascal.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1));
            if (i == 0) camel.append(w); else camel.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1));
            if (i > 0) snake.append("_"); snake.append(w);
        }
        List<String> list = Arrays.asList(pascal.toString(), camel.toString(), snake.toString());
        cs.submitCharacterStringArray("B22DCCN222", "DbpdF299", list);
        System.out.println("Done");
    }
}

interface CharacterService {
    String requestString(String studentCode, String qCode);
    void submitCharacterStringArray(String studentCode, String qCode, List<String> data);
}
