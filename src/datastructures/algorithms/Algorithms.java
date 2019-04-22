package datastructures.algorithms;

import java.util.*;

public class Algorithms {

    //time complex O(n), space complex O(n)
    public List<List<Integer>> permutations(List<Integer> nums) {
        Map<Integer, Integer> keys = new HashMap<>();
        for (int i : nums) {
            keys.put(i, keys.getOrDefault(i, 0) + 1);
        }


        int[] content = new int[keys.size()];
        int[] counter = new int[keys.size()];
        int[] result = new int[nums.size()];
        List<List<Integer>> t = new ArrayList<List<Integer>>();

        int i = 0;


        for (Map.Entry<Integer, Integer> entry : keys.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            content[i] = k;
            counter[i] = v;
            i++;
        }

        t = permutation(result, content, counter, 0, t);

        return t;
    }

    //time complex (n^2 * k!)
    public List<List<Integer>> permutation(int[] result, int[] content, int[] counter, int level, List<List<Integer>> t) {
        if (level == result.length) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < result.length; i++)
                arr.add(result[i]);
            t.add(arr);
            return null;
        }

        for (int i = 0; i < content.length; i++) {
            if (counter[i] == 0) continue;

            result[level] = content[i];
            counter[i]--;
            permutation(result, content, counter, level+1, t);
            counter[i]++;
        }

        return t;
    }





    public List<List<Integer>> permutations2(List<Integer> nums) {
        List<List<Integer>> t = new ArrayList<List<Integer>>();

        t = permutationUtil(nums,0, t);

        return t;
    }

    public List<List<Integer>> permutationUtil(List<Integer> nums, int index, List<List<Integer>> t) {
        if (index == nums.size()) {
            t.add(nums);
            return null;
        }

        for (int i = index; i < nums.size(); i++) {
            swap(nums, index, i);
            permutationUtil(nums, index+1, t);
            swap(nums, index, i);
        }

        return t;
    }

    void swap(List<Integer> nums, int x, int y) {
        int tmp = nums.get(x);
        nums.set(x, nums.get(y));
        nums.set(y, tmp);
    }

}
