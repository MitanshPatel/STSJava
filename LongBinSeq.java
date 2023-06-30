import java.util.*;

public class LongBinSeq {
    public static int longestSequenceOfOnes(int binaryNumber) {
        String binaryString = Integer.toBinaryString(binaryNumber);
        int count = 0;
        int maxCount = 0;

        for (char digit : binaryString.toCharArray()) {
            if (digit == '1') {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int binaryNumber = sc.nextInt();
        int longestSequence = longestSequenceOfOnes(binaryNumber);
        System.out.println("The longest sequence of 1's in " + Integer.toBinaryString(binaryNumber) + " is: " + longestSequence);
        sc.close();
    }
}