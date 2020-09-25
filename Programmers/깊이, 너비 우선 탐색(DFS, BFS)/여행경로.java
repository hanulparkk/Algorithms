import java.util.*;

class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();

        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        String[] answer = solution.solution(tickets);

        System.out.println(Arrays.toString(answer));

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Total execution time in millis : " + elapsedTime);

    }
}

//First Solution: DFS
class Solution {
    List<String[]> answer;

    public String[] solution(String[][] tickets) {
        answer = new LinkedList<>();

        dfs(tickets, new boolean[tickets.length], new LinkedList<>(List.of("ICN")));

        Comparator<String[]> comparator = new Comparator<>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                for (int i = 0; i < o1.length; i++)
                    if (!o1[i].equals(o2[i]))
                        return o1[i].compareTo(o2[i]);

                return 0;
            }
        };

        Collections.sort(answer, comparator);

        return answer.get(0);
    }

    public void dfs(String[][] tickets, boolean[] visit, List<String> airport) {
        if (airport.size() == tickets.length + 1) {
            answer.add(airport.toArray(new String[airport.size()]));
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && tickets[i][0].equals(airport.get(airport.size() - 1))) {
                visit[i] = true;
                airport.add(tickets[i][1]);

                dfs(tickets, visit, airport);

                visit[i] = false;
                airport.remove(airport.size() - 1);
            }
        }
    }
}

//Second Solution: BFS
class Solution {
    public class Airport {
        List<String> list;
        boolean[] visit;

        public Airport(List<String> list, boolean[] visit) {
            this.list = list;
            this.visit = visit;
        }
    }

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, Comparator.comparing(o1 -> o1[1]));

        int n = tickets.length;
        String[] answer = null;

        Queue<Airport> queue = new LinkedList<>();
        queue.offer(new Airport(new LinkedList<>(Arrays.asList("ICN")), new boolean[n]));

        while (!queue.isEmpty()) {
            Airport airport = queue.poll();

            if (airport.list.size() == n + 1) {
                answer = airport.list.toArray(new String[airport.list.size()]);
                break;
            }

            String curAirport = airport.list.get(airport.list.size() - 1);

            for (int i = 0; i < n; i++) {
                if (!airport.visit[i] && tickets[i][0].equals(curAirport)) {
                    boolean[] visit = airport.visit.clone();
                    visit[i] = true;

                    List<String> list = new LinkedList<>(airport.list);
                    list.add(tickets[i][1]);

                    queue.offer(new Airport(list, visit));
                }
            }
        }

        return answer;
    }
}