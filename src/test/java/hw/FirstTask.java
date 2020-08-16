package hw;

import org.junit.jupiter.api.Test;

import java.util.*;

/*
Создать массив с набором из 10–20 слов, должны встречаться повторяющиеся.
Найти и вывести список уникальных слов, из которых состоит массив.
Посчитать, сколько раз встречается каждое слово.
 */
public class FirstTask {

    @Test
    public void firstTask() {
        String text = "Ведьмаку заплатите чеканной монетой чеканной монетой Ведьмаку заплатите зачтется все это вам";
        String[] array = text.split(" ");
        List<String> list = Arrays.asList(array);
        Set<String> set = new HashSet<>(list);

        for (String word : set) {
            System.out.println("Слово '" + word + "' встречается " + Collections.frequency(list, word) + " раз(а).");
        }
    }
}
