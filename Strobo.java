import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Strobo {
    static boolean isStrobogrammatic(String st) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int l = 0, r = st.length() - 1;
        while (l <= r) {
            if (!map.containsKey(st.charAt(l)))
                return false;
            if (map.get(st.charAt(l)) != st.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give num :");
        String n = sc.next();
        System.out.println(isStrobogrammatic(n));
        sc.close();

    }
}