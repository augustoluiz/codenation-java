import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticUtil {

    public static int average(int[] elements) {
        return Arrays.stream(elements).reduce(0, (anterior, atual) -> atual + anterior) / elements.length;
    }

    public static int mode(int[] elements) {
        Map<Integer, Integer> mapElements = Arrays.stream(elements)
                                                  .distinct()
                                                  .collect(HashMap<Integer, Integer>::new,
                                                          (m, e) -> m.put(e, 0),
                                                          (m, u) -> {});
        Arrays.stream(elements).forEach( e -> mapElements.replace(e, mapElements.get(e)+1));
        return mapElements.entrySet()
                          .stream()
                          .reduce((anterior, atual) -> atual = anterior.getValue() > atual.getValue() ? anterior : atual)
                          .map(e -> e.getKey())
                          .get();
    }

    public static int median(int[] elements) {
        Arrays.sort(elements);
        if (elements.length % 2 == 0){
            return (elements[elements.length / 2] + elements[(elements.length / 2) - 1]) / 2;
        }
        return elements[elements.length / 2];
    }

}
