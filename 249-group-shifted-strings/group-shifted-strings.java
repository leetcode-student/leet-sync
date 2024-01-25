/*

["abc","bcd","acef","xyz","az","ba","a","z"]

abc,bcd,xyz
acef
az,ba
a,z

Shifted strings have the same relative ordering between 0th, 1th, ... nth characters

Brute Force

For each string
    Compare to all shifted groups and add accordingly

Time: O(n^2)
Space: O(n)

Can "Compare to all shifted groups and add accordingly" be optimized?

Optimized

For each string
    Create "relative ordering" string
    Compare to all shifted groups (hash map)

Time: O(n)
Space: O(n)

["abc","bcd","acef","xyz","az","ba","a","z"]

abc -> 0-1-1
bcd -> 0-1-1
acef -> 0-2-2-1
xyz -> 0-1-1
az -> 0-25
ba -> 0-25
a -> 0
z -> 0

*/
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> encodingGroups = new HashMap<>();

        for (String string : strings) {
            String encoding = encode(string);
            if (!encodingGroups.containsKey(encoding)) {
                encodingGroups.put(encoding, new ArrayList<>());
            }
            encodingGroups.get(encoding).add(string);
        }

        List<List<String>> encodingGroupsList = new ArrayList<>();
        for (String encoding : encodingGroups.keySet()) {
            encodingGroupsList.add(encodingGroups.get(encoding));
        }

        return encodingGroupsList;
    }

    private String encode(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append("0-");

        char last = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            char curr = string.charAt(i);
            int distance = curr > last ? curr - last : curr - last + 26;
            sb.append(distance + "-");
            last = curr;
        }

        sb.deleteCharAt(sb.length() - 1);
        //System.out.println(string + " -> " + sb.toString());
        return sb.toString();
    }
}