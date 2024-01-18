/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int bufPtr = 0;
        char[] buf4 = new char[4];
        while (bufPtr < n) {
            int numRead = read4(buf4);
            
            if (numRead == 0) {
                return bufPtr;
            }

            for (int i = 0; i < numRead && bufPtr < n; i++) {
                buf[bufPtr] = buf4[i];
                bufPtr++;
            }
        }
        
        return bufPtr;
    }
}