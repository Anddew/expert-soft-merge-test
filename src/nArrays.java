import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class nArrays {
    public static void main(String[] args) {
        List<Integer> a = createIntegerList();
        List<Integer> b = createIntegerList();
        merge(a, b);
        System.out.println("First array: " + a);
        System.out.println("Second array: " + b);

    }

    public static void merge(List<Integer> a, List<Integer> b) {
        List<Integer> newArray = new ArrayList<>(a.size());
        newArray.addAll(a);
        int resultSize = a.size() + b.size();
        a.clear();

        int indexA = 0;
        int indexB = 0;
        for(int i = 0; i < resultSize; i++) {
            if (indexA >= newArray.size()) {
                a.add(b.get(indexB++));
            } else if (indexB >= b.size()) {
                a.add(newArray.get(indexA++));
            } else if (newArray.get(indexA) <= b.get(indexB)) {
                a.add(newArray.get(indexA++));
            } else {
                a.add(b.get(indexB++));
            }
        }
    }

    private static List<Integer> createIntegerList() {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        int minSize = 3;
        int value = 0;
        for (int i = 0; i < Math.max(minSize, random.nextInt(10)); i++) {
            value += random.nextInt(10);
            result.add(value);
        }
        System.out.println("List created. Size = " + result.size() + ". List: " + result + '\n');
        return result;
    }

}