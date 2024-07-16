class Solution {
public List<List<Integer>> combinationSum(int[] candidates, int target) {
List<List<Integer>> result = new ArrayList<>();
Arrays.sort(candidates); // Sort candidates to handle duplicates and
ensure ascending order
backtrack(result, new ArrayList<>(), candidates, target, 0);
return result;
}
private void backtrack(List<List<Integer>> result, List<Integer> current,
int[] candidates, int remaining, int start) {
if (remaining == 0) {
result.add(new ArrayList<>(current)); // Found a valid combination
return;
}
for (int i = start; i < candidates.length; i++) {
if (candidates[i] > remaining) {
break; // No need to check further if candidate is larger than
remaining sum
}
current.add(candidates[i]);
backtrack(result, current, candidates, remaining - candidates[i], i);
// Include current candidate
current.remove(current.size() - 1); // Backtrack
}
}
}
