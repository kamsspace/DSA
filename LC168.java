// problem: 168. Excel Sheet Column Title
// difficulty: easy
// runtime: 0ms, beats 100%
// memory: 41.20MB, beats 21.58%
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber-- > 0) {
            sb.insert(0,((char)((columnNumber % 26) + 'A')));
            columnNumber /= 26;
        }

        return sb.toString();
    }
}
