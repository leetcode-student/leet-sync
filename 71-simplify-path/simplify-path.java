class Solution {
    public String simplifyPath(String path) {
        List<String> pathComponents = new ArrayList<>();

        Integer startIdx = null;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (startIdx != null) {
                    pathComponents.add(path.substring(startIdx, i));
                    startIdx = null;
                }
                
            } else if (startIdx == null) {
                startIdx = i;
            }
        }
        if (startIdx != null) {
            pathComponents.add(path.substring(startIdx));
        }

        System.out.println("pathComponents=" + pathComponents);

        List<String> simplifiedPathComponents = new ArrayList<>();

        for (String pathComponent : pathComponents) {
            if (pathComponent.equals(".")) {
                continue;
            } else if (pathComponent.equals("..")) {
                if (simplifiedPathComponents.size() > 0) {
                    simplifiedPathComponents.remove(simplifiedPathComponents.size() - 1);
                }
            } else {
                simplifiedPathComponents.add(pathComponent);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String simplifiedPathComponent : simplifiedPathComponents) {
            sb.append(simplifiedPathComponent);
            sb.append("/");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return "/" + sb.toString();
    }
}