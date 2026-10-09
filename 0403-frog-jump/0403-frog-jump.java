import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        map.get(0).add(0);

        for (int stone : stones) {
            for (int jump : map.get(stone)) {
                for (int k = jump - 1; k <= jump + 1; k++) {
                    if (k > 0 && map.containsKey(stone + k)) {
                        map.get(stone + k).add(k);
                    }
                }
            }
        }

        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}