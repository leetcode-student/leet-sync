/*
Create a comparator that makes use of the order
*/
class Solution {
    public String customSortString(String order, String s) {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }

        Collections.sort(chars, new CustomSortComparator(order));

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }

    private static class CustomSortComparator implements Comparator<Character> {
        String order;

        CustomSortComparator(String order) {
            this.order = order;
        }

        public int compare(Character first, Character second) {
            int firstIdx = order.indexOf(first);
            int secondIdx = order.indexOf(second);

            return firstIdx - secondIdx;
        }
    }
}