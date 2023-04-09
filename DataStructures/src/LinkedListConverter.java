import java.util.HashMap;

public class LinkedListConverter {
    private static final HashMap<Integer, String> numToWordMap = new HashMap<>();
    static {
        numToWordMap.put(0, "zero");
        numToWordMap.put(1, "one");
        numToWordMap.put(2, "two");
        numToWordMap.put(3, "three");
        numToWordMap.put(4, "four");
        numToWordMap.put(5, "five");
        numToWordMap.put(6, "six");
        numToWordMap.put(7, "seven");
        numToWordMap.put(8, "eight");
        numToWordMap.put(9, "nine");
        numToWordMap.put(10, "ten");
        numToWordMap.put(11, "eleven");
        numToWordMap.put(12, "twelve");
        numToWordMap.put(13, "thirteen");
        numToWordMap.put(14, "fourteen");
        numToWordMap.put(15, "fifteen");
        numToWordMap.put(16, "sixteen");
        numToWordMap.put(17, "seventeen");
        numToWordMap.put(18, "eighteen");
        numToWordMap.put(19, "nineteen");
        numToWordMap.put(20, "twenty");
        numToWordMap.put(30, "thirty");
        numToWordMap.put(40, "forty");
        numToWordMap.put(50, "fifty");
        numToWordMap.put(60, "sixty");
        numToWordMap.put(70, "seventy");
        numToWordMap.put(80, "eighty");
        numToWordMap.put(90, "ninety");
    }

    public ListNode numberToWords(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current != null) {
            int num = Integer.parseInt(current.val);
            String word;
            if (num < 20) {
                word = numToWordMap.get(num);
            } else {
                int tens = num / 10 * 10;
                int ones = num % 10;
                if (ones == 0) {
                    word = numToWordMap.get(tens);
                } else {
                    word = numToWordMap.get(tens) + "-" + numToWordMap.get(ones);
                }
            }
            current.val = word;
            current = current.next;
        }

        return head;
    }
}