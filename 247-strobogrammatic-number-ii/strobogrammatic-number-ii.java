/*

609
6099

*/
class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> firstStrobos = new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> secondStrobos = new ArrayList<>(Arrays.asList("11", "69", "88", "96"));

        if (n == 1) {
            return firstStrobos;
        } else if (n == 2) {
            return secondStrobos;
        }

        if (n % 2 == 0) {
            return findStrobos(4, n, secondStrobos);
        } else {
            return findStrobos(3, n, firstStrobos);
        }
    }

    private List<String> findStrobos(int i, int n, List<String> lastStrobos) {
        if (i > n) {
            return lastStrobos;
        }

        Set<String> currStrobos = buildStrobos(i, lastStrobos);
        List<String> currStrobosList = new ArrayList<>(currStrobos);
        Collections.sort(currStrobosList);

        //System.out.println("i=" + i);
        //System.out.println("currStrobosList=" + currStrobosList);
        //System.out.println();

        return findStrobos(i + 2, n, currStrobosList);
    }

    private Set<String> buildStrobos(int i, List<String> lastStrobos) {
        Set<String> strobos = new HashSet<>();

        for (String lastStrobo : lastStrobos) {
            List<String> lastStroboVersions = new ArrayList<>();
            lastStroboVersions.add(lastStrobo);

            if (i >= 4) {
                lastStroboVersions.add('0' + lastStrobo.substring(1, lastStrobo.length() - 1) + '0');
            }
            
            for (String lastStroboVersion : lastStroboVersions) {
                strobos.add('1' + lastStroboVersion + '1');
                strobos.add('6' + lastStroboVersion + '9');
                strobos.add('9' + lastStroboVersion + '6');
                strobos.add('8' + lastStroboVersion + '8');
            }
        }

        return strobos;
    }
}