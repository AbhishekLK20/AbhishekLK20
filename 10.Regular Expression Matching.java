class Solution {
public boolean isMatch(String s, String p) {
return isMatchRecursive(s, p, 0, 0);
}
private boolean isMatchRecursive(String s, String p, int sIndex, int pIndex) {
// Base case: if both strings are exhausted
if (pIndex >= p.length()) {
return sIndex >= s.length();
}
// Check if current characters match or pattern has '.'
boolean firstMatch = (sIndex < s.length() && (p.charAt(pIndex) ==
s.charAt(sIndex) || p.charAt(pIndex) == '.'));
// Check for '*'
if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
// Case 1: '*' matches 0 occurrences of preceding character
// Case 2: '*' matches 1 or more occurrences of preceding character
return isMatchRecursive(s, p, sIndex, pIndex + 2) ||
(firstMatch && isMatchRecursive(s, p, sIndex + 1, pIndex));
} else {
// No '*', just match current characters and move to next
return firstMatch && isMatchRecursive(s, p, sIndex + 1, pIndex + 1);
}
}
}
