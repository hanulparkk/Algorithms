import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<Character> result = new ArrayList<Character>();
        int value = 0;

        // 문자를 하나씩 확인하며
        for (int i = 0; i < str.length(); i++) {
            // 알파벳인 경우 결과 리스트에 삽입
            if (Character.isLetter(str.charAt(i)))
                result.add(str.charAt(i));
            // 숫자는 따로 더하기
            else
                value += str.charAt(i) - '0';
        }

        // 알파벳을 오름차순으로 정렬
        Collections.sort(result);

        // 알파벳을 차례대로 출력
        for (int i = 0; i < result.size(); i++)
            System.out.print(result.get(i));

        // 숫자가 하나라도 존재하는 경우 가장 뒤에 출력
        if (value != 0)
            System.out.print(value);
        
        System.out.println();
    }
}