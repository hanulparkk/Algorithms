/**
* Input
* ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
* [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
* Output
* [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
*
* Explanation
* // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
* OrderedStream os = new OrderedStream(5);
* os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
* os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
* os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
* os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
* os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
* // Concatentating all the chunks returned:
* // [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
* // The resulting order is the same as the order above.
* 
* Your OrderedStream object will be instantiated and called as such:
* OrderedStream obj = new OrderedStream(n);
* List<String> param_1 = obj.insert(id,value);
*/

// First solution
class OrderedStream {
    private int pointer;
    private Map<Integer, String> map;

    public OrderedStream(int n) {
        pointer = 1;
        map = new HashMap<>();
    }
    
    public List<String> insert(int id, String value) {
        map.put(id, value);
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        List<String> valueSet = new ArrayList<>();
        while (map.containsKey(pointer)) {
            valueSet.add(map.get(pointer));
            pointer++;
        }
        return valueSet;
    }
}

// Second solution
class OrderedStream {
    private int pointer;
    private String[] streamList;

    public OrderedStream(int n) {
        pointer = 1;
        streamList = new String[n + 1];
    }

    public List<String> insert(int id, String value) {
        streamList[id] = value;

        ArrayList<String> orderedStreams = new ArrayList<String>();
        while (pointer < streamList.length) {
            if (streamList[pointer] == null) {
                break;
            }
            orderedStreams.add(streamList[pointer]);
            pointer++;
        }

        return orderedStreams;
    }
}