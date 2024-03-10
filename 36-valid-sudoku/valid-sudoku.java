class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowCache = new HashMap<>();
        Map<Integer, Set<Character>> columnCache = new HashMap<>();
        Map<Integer, Set<Character>> boxCache = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                //System.out.println("i=" + i + ", j=" + j);

                if (!rowCache.containsKey(i)) {
                    rowCache.put(i, new HashSet<>());
                }

                if (rowCache.get(i).contains(board[i][j])) {
                    return false;
                } else {
                    rowCache.get(i).add(board[i][j]);
                }

                if (!columnCache.containsKey(j)) {
                    columnCache.put(j, new HashSet<>());
                }

                if (columnCache.get(j).contains(board[i][j])) {
                    return false;
                } else {
                    columnCache.get(j).add(board[i][j]);
                }

                int box = (i / 3) * 3 + (j / 3);
                //System.out.println("    box=" + box);
                if (!boxCache.containsKey(box)) {
                    boxCache.put(box, new HashSet<>());
                }

                if (boxCache.get(box).contains(board[i][j])) {
                    return false;
                } else {
                    boxCache.get(box).add(board[i][j]);
                }
            }
        }

        return true;
    }
}