/*

n=1
0,1,8
n=2
11,69,88,96
n=3
101,609,906,808,111,619,916,818,181,689,986,888
n=4
1111,...

*/
class Solution {
    public List<String> findStrobogrammatic(int n) {
        Set<String> first = new HashSet<>(Arrays.asList("0", "1", "8"));
        Set<String> second = new HashSet<>(Arrays.asList("11", "69", "88", "96"));

        Set<String> stroboSet;
        if (n % 2 == 1) {
            stroboSet = findStrobogrammatic(first, 1, n);
        } else {
            stroboSet = findStrobogrammatic(second, 2, n);
        }

        return new ArrayList<>(stroboSet);
    }

    private Set<String> findStrobogrammatic(Set<String> previousStrobos, int nPrevious, int nTarget) {
        if (nPrevious == nTarget) {
            return previousStrobos;
        }

        Set<String> currentStrobos = new HashSet<>();
        for (String previousStrobo : previousStrobos) {
            currentStrobos.add("1" + previousStrobo + "1");
            currentStrobos.add("6" + previousStrobo + "9");
            currentStrobos.add("9" + previousStrobo + "6");
            currentStrobos.add("8" + previousStrobo + "8");

            if (nPrevious >= 2) {
                currentStrobos.add("10" + previousStrobo.substring(1, previousStrobo.length() - 1) + "01");
                currentStrobos.add("60" + previousStrobo.substring(1, previousStrobo.length() - 1) + "09");
                currentStrobos.add("90" + previousStrobo.substring(1, previousStrobo.length() - 1) + "06");
                currentStrobos.add("80" + previousStrobo.substring(1, previousStrobo.length() - 1) + "08");
            }
        }

        return findStrobogrammatic(currentStrobos, nPrevious + 2, nTarget);
    }
}