import java.util.*;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] meeting = new int[n][2];

        for (int i = 0; i < n; i++) {
            meeting[i][0] = sc.nextInt();
            meeting[i][1] = sc.nextInt();
        }

        //logic
        //회의 종료 시간이 작은 순으로 정렬 (종료 시간이 같다면, 시작 시간이 작은 순으로 정렬)
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                
                return o1[1] - o2[1];
            }
        };

        Arrays.sort(meeting, comparator);

        int end = 0; //현재 회의 종료 시간
        int count = 0;

        for (int[] m : meeting) {
            //현재 회의 종료 시간 이후에 시작할 수 있는 회의가 있다면
            if (end <= m[0]) {
                count++; //회의 배정
                end = m[1]; //현재 회의 종료 시간 업데이트
            }
        }

        //output
        System.out.println(count);
    }
}