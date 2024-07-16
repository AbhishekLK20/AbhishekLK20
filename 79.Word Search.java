class Solution {
public boolean exist(char[][] board, String word) {
int m = board.length;
int n = board[0].length;
// Try to find the word starting from each cell in the board
for (int i = 0; i < m; i++) {
for (int j = 0; j < n; j++) {
if (search(board, word, i, j, 0)) {
return true;
}
}
}
return false;
}
private boolean search(char[][] board, String word, int i, int j, int index) {
// Base case: word found
if (index >= word.length()) {
return true;
}
// Base case: out of bounds or character doesn't match
if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
board[i][j] != word.charAt(index)) {
return false;
}
// Mark current cell as visited
char temp = board[i][j];
board[i][j] = '#'; // '#': visited marker
// Recursively search in all four directions
boolean found = search(board, word, i + 1, j, index + 1) ||
search(board, word, i - 1, j, index + 1) ||
search(board, word, i, j + 1, index + 1) ||
search(board, word, i, j - 1, index + 1);
// Restore the original character
board[i][j] = temp;
return found;
}
}
