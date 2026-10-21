class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Track seen numbers (1-9) for rows, columns, and 3x3 sub-boxes
        // Rows/cols/boxes indices: 0-8, Digits indices: 0-8 (representing '1'-'9')
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Skip empty cells
                if (board[r][c] == '.') {
                    continue;
                }

                // Convert char digit to a 0-based index (e.g., '5' becomes index 4)
                int val = board[r][c] - '1';
                
                // Calculate the 3x3 sub-box index (ranges from 0 to 8)
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If the number has already been seen in this row, col, or box, it's invalid
                if (rows[r][val] || cols[c][val] || boxes[boxIndex][val]) {
                    return false;
                }

                // Mark the number as seen
                rows[r][val] = true;
                cols[c][val] = true;
                boxes[boxIndex][val] = true;
            }
        }

        return true;
    }
}
