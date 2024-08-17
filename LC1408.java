// problem: 1408. String Matching in an Array
// difficulty: easy
// time: 30 minutes
// runtime: 6ms, beats 23.72%
// memory: 42.08MB, beats 70.43%

class Solution {
    public List<String> stringMatching(String[] words) {
        if (words.length == 1) return new ArrayList<String>();

        List<String> list = new ArrayList<>();

        for (String i : words) {
            for (String j : words) {
                    if (i.length() > j.length() && i.contains(j)) if (!(list.contains(j))) list.add(j); 
            }
        }

        return list;
    }
}
