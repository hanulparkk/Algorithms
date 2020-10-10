import java.util.*;

public class Main {

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public static int countByRange(List<Integer> list, int leftValue, int rightValue) {
        int rightIndex = list.lastIndexOf(rightValue);
        int leftIndex = list.indexOf(leftValue);
        return rightIndex - leftIndex + 1;
    }

    public static void main(String[] args) {
        // 데이터의 개수 N, 찾고자 하는 값 x 입력받기
        int n = 7;
        int x = 2;

        // 전체 데이터 입력 받기
        List<Integer> list = Arrays.asList(1, 1, 2, 2, 2, 2, 3);

        // 값이 [x, x] 범위에 있는 데이터의 개수 계산
        int cnt = countByRange(list, x, x);
        // 값이 x인 원소가 존재하지 않는다면
        if (cnt == 0)
            System.out.println(-1);
        //  값이 x인 원소가 존재한다면
        else
            System.out.println(cnt);
    }
}