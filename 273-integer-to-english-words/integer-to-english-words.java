/*

123
divisor=100, quotient=1

23
divisor=20, quotient=2
3
divisor=3, quotient=1

One Hundred Twenty Three

*/
class Solution {
    private List<WordMapping> wordMappings = new ArrayList<>(Arrays.asList(
        new WordMapping(1000000000, "Billion"),
        new WordMapping(1000000, "Million"),
        new WordMapping(1000, "Thousand"),
        new WordMapping(100, "Hundred"),
        new WordMapping(90, "Ninety"),
        new WordMapping(80, "Eighty"),
        new WordMapping(70, "Seventy"),
        new WordMapping(60, "Sixty"),
        new WordMapping(50, "Fifty"),
        new WordMapping(40, "Forty"),
        new WordMapping(30, "Thirty"),
        new WordMapping(20, "Twenty"),
        new WordMapping(19, "Nineteen"),
        new WordMapping(18, "Eighteen"),
        new WordMapping(17, "Seventeen"),
        new WordMapping(16, "Sixteen"),
        new WordMapping(15, "Fifteen"),
        new WordMapping(14, "Fourteen"),
        new WordMapping(13, "Thirteen"),
        new WordMapping(12, "Twelve"),
        new WordMapping(11, "Eleven"),
        new WordMapping(10, "Ten"),
        new WordMapping(9, "Nine"),
        new WordMapping(8, "Eight"),
        new WordMapping(7, "Seven"),
        new WordMapping(6, "Six"),
        new WordMapping(5, "Five"),
        new WordMapping(4, "Four"),
        new WordMapping(3, "Three"),
        new WordMapping(2, "Two"),
        new WordMapping(1, "One")));

    public String numberToWords(int num) {
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            //System.out.println("num=" + num + ", sb=" + sb);
            int quotient = num / wordMappings.get(i).number;
            if (quotient > 0) {
                if (quotient >= 1 && num >= 100) {
                    sb.append(numberToWords(quotient) + " ");
                }
                //System.out.println("adding " + wordMappings.get(i).word);
                sb.append(wordMappings.get(i).word);
                sb.append(" ");
                num -= quotient * wordMappings.get(i).number;
            }
            i++;
            //System.out.println("num=" + num + ", sb=" + sb);
        }

        if (sb.length() == 0) {
            return "Zero";
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static class WordMapping {
        int number;
        String word;

        WordMapping(int number, String word) {
            this.number = number;
            this.word = word;
        }
    }
}