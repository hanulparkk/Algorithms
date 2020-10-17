//First Solution
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        //logic
        int result = 0;
        String[] strArr = s.split("[-]");

        for (String str : strArr[0].split("[+]"))
            result += Integer.parseInt(str);

        for (int i = 1; i < strArr.length; i++)
            for (String str : strArr[i].split("[+]"))
                result -= Integer.parseInt(str);

        //output
        System.out.println(result);
    }
}

//Second Solution
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        //input
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        //logic
        int result = 0;
        boolean flag = false;
        
        StringTokenizer st = new StringTokenizer(s, "-+", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.equals("-")) {
                flag = true;
                continue;
            }

            if (token.equals("+"))
                continue;

            if (flag)
                result -= Integer.parseInt(token);
            else
                result += Integer.parseInt(token);
        }

        //output
        System.out.println(result);
    }
}