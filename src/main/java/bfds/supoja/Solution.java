package bfds.supoja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<Integer>();

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5,};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Integer> score = new ArrayList<Integer>(Arrays.asList(0, 0, 0));

        for(int i = 0; i < answers.length; i++){
            if (a[i%a.length] == answers[i]) score.set(0, score.get(0) + 1);
            if (b[i%b.length] == answers[i]) score.set(1, score.get(1) + 1);
            if (c[i%c.length] == answers[i]) score.set(2, score.get(2) + 1);
        }        
        int max = 0;
        for(int i = 0; i < score.size(); i++){
            if(max < score.get(i)){
                max = score.get(i);
                answer.clear();
                answer.add(i+1);
            }else if(max == score.get(i)){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
}