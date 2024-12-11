// problem: 412. FizzBuzz
// difficulty: easy
// time complexity: O(n)
// space complexity: O(n)

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            switch (i % 15) {
                case 3: 
                case 6: 
                case 9:
                case 12: answer.add("Fizz"); break;
                case 5: 
                case 10: answer.add("Buzz"); break;
                case 0: answer.add("FizzBuzz"); break;
                default: answer.add(String.valueOf(i));
            }
        }

        return answer;
    }
}
