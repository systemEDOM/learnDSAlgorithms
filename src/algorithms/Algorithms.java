package algorithms;

import sortingalgorithms.SortArray;

import java.lang.reflect.Array;
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





    //o(nlonk)
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        List<Integer> arr = new LinkedList();

        for (int i : nums) {
            hash.put(i, hash.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> hash.get(n1) - hash.get(n2));

        for (int n: hash.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        while (!heap.isEmpty()) {
            arr.add(heap.poll());
        }
        Collections.reverse(arr);
        return arr;
    }


    //o(n)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i : nums) {
            hash.put(i, hash.getOrDefault(i, 0)+1);
        }

        int max = 0;
        for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
            max = Math.max(max, entry.getValue());
        }

        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
        for(int i = 1; i <= max; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
            int count = entry.getValue();
            int number = entry.getKey();
            arr[count].add(number);
        }

        List<Integer> result = new ArrayList<>();
        for(int j = max; j >= 1; j--){
            if(arr[j].size() > 0) {
                for(int a : arr[j]){
                    result.add(a);
                }
            }
            if(result.size() == k)
                break;
        }

        return result;
    }





    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i <= nums.length; i++)
            generate(nums,new ArrayList<Integer>(),i,0,res);
        return res;
    }

    private void generate(int[] nums, List<Integer> path, int k, int s, List<List<Integer>> res) {
        if (k==0) {
            res.add(new ArrayList<Integer>(path));
        } else {
            for(int i = s; i <= nums.length-k; i++) {
                path.add(nums[i]);
                generate(nums,path,k-1,i+1,res);
                path.remove(path.size()-1);
            }
        }
    }

    public void deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i) {
            index.add(i);
        }

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty()) {
                index.add(index.pollFirst());
            }
        }

        System.out.println(Arrays.toString(ans));
    }

    public void pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        for (int next = A.length; next > 0; next--) {
            int index = getIndex(A, next);
            if (index != next - 1) {
                if (index != 0) {
                    result.add(index + 1);
                }
                result.add(next);
                reverseFirstKIndexes(A, index);
                reverseFirstKIndexes(A, next - 1);
            }
        }
        System.out.println(result);
    }

    private static void reverseFirstKIndexes(int[] A, int index) {
        for (int start = 0, end = index; start < end; start++, end--) {
            SortArray.swap(A, end, start);
        }
    }
    private static int getIndex(int[] A, int value) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i : nums) {
            int index = Math.abs(i) - 1;
            System.out.println("ind: "+index);
            if (nums[index] < 0)
                ans.add(Math.abs(i));
            else
                nums[index] *= -1;
        }

        System.out.println(ans);
    }
}
