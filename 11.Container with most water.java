class Solution {
public int maxArea(int[] height) {
int i = 0;
int j = height.length - 1;
int maxarea = 0;
while(i < j){
int left = height[i];
int right = height[j];
int max = Math.min(left , right) * (j - i);
maxarea = Math.max(max , maxarea);
if(left < right){
i++;
}else{
j--;
}
}
return maxarea;
}
}
