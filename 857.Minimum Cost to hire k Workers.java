class Worker {
int quality;
double ratio;
public Worker(int quality, int wage) {
this.quality = quality;
ratio = (double)wage / quality;
}
}
class Solution {
public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
int n = quality.length;
Worker[] workers = new Worker[n];
for(int i=0; i<n; i++)
workers[i] = new Worker(quality[i], wage[i]);
Arrays.sort(workers, (a,b)->(int)Math.signum(a.ratio-b.ratio));
double best = Double.MAX_VALUE;
PriorityQueue<Integer> qualityHeap = new PriorityQueue<Integer>(k);
int totalQuality = 0;
for(Worker w : workers) {
int q = w.quality;
totalQuality += q;
if (qualityHeap.size() == k)
totalQuality += qualityHeap.poll();
qualityHeap.add(-q);
if (qualityHeap.size() == k)
best = Math.min(best, totalQuality * w.ratio);
}
return best;
}
}
