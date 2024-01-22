class Solution {
    public boolean isNumber(String s) {
        s = s.replace('E', 'e');

        int eIndex = s.indexOf('e');

        if (eIndex == -1) {
            return isDecimal(s) || isInteger(s);
        } else {
            String firstPart = s.substring(0, eIndex);
            String secondPart = s.substring(eIndex + 1);

            return (isDecimal(firstPart) || isInteger(firstPart)) && isInteger(secondPart);
        }
    }

    private boolean isDecimal(String s) {
        System.out.println("isDecimal " + s);
        if (s.length() == 0) {
            return false;
        }

        boolean hasSign = hasSign(s);
        if (hasSign) {
            s = s.substring(1);
        }

        if (s.length() == 0) {
            return false;
        }

        int dotIndex = s.indexOf('.');
        boolean containsDot = dotIndex != -1;
        boolean integerBeforeDot = dotIndex > 0;
        boolean integerAfterDot = dotIndex + 1 < s.length();

        if (!containsDot) {
            return false;
        } else if (!integerBeforeDot && !integerAfterDot) {
            return false;
        }

        if (integerBeforeDot && integerAfterDot) {
            System.out.println("option 1");
            return isDigits(s.substring(0, dotIndex)) && isDigits(s.substring(dotIndex + 1));
        } else if (integerBeforeDot) {
            System.out.println("option 1");
            return isDigits(s.substring(0, dotIndex));
        } else {
            System.out.println("option 1");
            return isDigits(s.substring(dotIndex + 1));
        }
    }

    private boolean isInteger(String s) {
        System.out.println("isInteger " + s);
        if (s.length() == 0) {
            return false;
        }

        boolean hasSign = hasSign(s);
        if (hasSign) {
            return isDigits(s.substring(1));
        } else {
            return isDigits(s);
        }
    }

    private boolean isDigits(String s) {
        if (s.length() == 0) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean hasSign(String s) {
        return s.charAt(0) == '+' || s.charAt(0) == '-';
    }
}