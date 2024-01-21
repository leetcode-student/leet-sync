class Solution {
    public int maximumSwap(int num) {
        String numString = num + "";
        int[] largestNextDigit = new int[numString.length()];
        
        int largestDigit = Character.getNumericValue(numString.charAt(numString.length() - 1));
        for (int i = numString.length() - 1; i >= 0; i--) {
            int currDigit = Character.getNumericValue(numString.charAt(i));
            largestDigit = Math.max(currDigit, largestDigit);
            largestNextDigit[i] = largestDigit;
        }

        int swapFirstIdx = -1;
        for (int i = 0; i < numString.length(); i++) {
            int currDigit = Character.getNumericValue(numString.charAt(i));
            if (largestNextDigit[i] > currDigit) {
                swapFirstIdx = i;
                break;
            }
        }
        //System.out.println("swapFirstIdx=" + swapFirstIdx);
        //System.out.println("largestNextDigit[swapFirstIdx]=" + largestNextDigit[swapFirstIdx]);

        int swapSecondIdx = -1;
        if (swapFirstIdx != -1) {
            for (int i = numString.length() - 1; i >= 0; i--) {
                int currDigit = Character.getNumericValue(numString.charAt(i));
                if (currDigit == largestNextDigit[swapFirstIdx]) {
                    swapSecondIdx = i;
                    break;
                }
            }
        }
        //System.out.println("swapSecondIdx=" + swapSecondIdx);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numString.length(); i++) {
            if (swapFirstIdx != -1 && i == swapFirstIdx) {
                sb.append(numString.charAt(swapSecondIdx));
            } else if (swapSecondIdx != -1 && i == swapSecondIdx) {
                sb.append(numString.charAt(swapFirstIdx));
            } else {
                sb.append(numString.charAt(i));
            }
        }

        return Integer.parseInt(sb.toString());
    }
}