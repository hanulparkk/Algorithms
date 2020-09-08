import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        String[] answer = solution.solution(record);

        System.out.println(Arrays.toString(answer));

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution
class Solution {
    public String[] solution(String[] record) {
        StringBuilder sb = new StringBuilder();

        Map<String, String> uidMap = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] context = record[i].split(" ");
            String code = context[0];
            String uid = context[1];

            if (code.equals("Enter")) {
                sb.append(uid + "님이 들어왔습니다.,");
                uidMap.put(uid, context[2]);

            } else if (code.equals("Change"))
                uidMap.put(uid, context[2]);

            else //if (code.equals("Leave"))
                sb.append(uid + "님이 나갔습니다.,");
        }

        String[] message = sb.toString().split(",");

        for (int i = 0; i < message.length; i++) {
            String uid = message[i].split("님")[0];
            message[i] = message[i].replaceAll(uid, uidMap.get(uid));
        }

        return message;
    }
}