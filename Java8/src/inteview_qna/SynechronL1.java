package inteview_qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class SynechronL1 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=1; i<=26; ++i) {
            map.put("" + (char)(96+i), i);
        }
        System.out.println(getCharactersAtEvenPlaces(map));
    }

    private static List<String> getCharactersAtEvenPlaces(HashMap<String, Integer> characterMap) {
        return characterMap.entrySet().stream()
                .filter(e -> e.getValue() % 2 == 0)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static
}
