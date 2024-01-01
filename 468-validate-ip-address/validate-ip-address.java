class Solution {
    public String validIPAddress(String queryIP) {
        if (isValidIPv4(queryIP)) {
            return "IPv4";
        } else if (isValidIPv6(queryIP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isValidIPv4(String queryIP) {
        String[] components = queryIP.split("\\.");
        if (components.length != 4) {
            return false;
        }
        if (queryIP.charAt(queryIP.length() - 1) == '.') {
            return false;
        }
        for (String component : components) {
            if (component.length() < 1 || component.length() > 3) {
                return false;
            }
            if (component.charAt(0) == '0' && component.length() > 1) {
                return false;
            }
            for (int i = 0; i < component.length(); i++) {
                if (!Character.isDigit(component.charAt(i))) {
                    return false;
                }
            }
            int value = Integer.parseInt(component);
            if (value > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String queryIP) {
        String[] components = queryIP.split(":");
        if (components.length != 8) {
            return false;
        }
        if (queryIP.charAt(queryIP.length() - 1) == ':') {
            return false;
        }
        for (String component : components) {
            if (component.length() < 1 || component.length() > 4) {
                return false;
            }
            for (int i = 0; i < component.length(); i++) {
                char c = component.charAt(i);
                if (!((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9'))) {
                    return false;
                }
            }
        }
        return true;
    }
}