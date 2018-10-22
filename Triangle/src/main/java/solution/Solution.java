package solution;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size()-2; i >=0 ; i--) {
            List<Integer> s = triangle.get(i);
            List<Integer> p = triangle.get(i+1);
            for (int j = 0; j < s.size(); j++) {
                int v = s.get(j);
                s.set(j, v + Math.min(p.get(j), p.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}