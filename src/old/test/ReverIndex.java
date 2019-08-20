package old.test;

import java.util.*;

/*
已知一些学生对于班级的正排索引Map<Integer, Integer> studentToClass,求班级对于学生的倒排索引Map<Integer, List<Integer>> classToStudents
 */
public class ReverIndex {
    public static Map<Integer, List<Integer>> reverse(Map<Integer, Integer> studentToClass) {

        // 正排索引转换为矩阵
        int maxStu = 0,maxCla = 0;
        for (Map.Entry entry : studentToClass.entrySet()){
            if ((int)entry.getKey() > maxStu) maxStu = (int) entry.getKey();
            if ((int)entry.getValue() > maxCla) maxCla = (int) entry.getValue();
        }
        maxCla ++;
        maxStu ++;
        int[][] studentToClassArr = new int[maxCla][maxStu];

        for (Map.Entry entry : studentToClass.entrySet()){
            studentToClassArr[(int) entry.getValue()][(int) entry.getKey()] = 1;
        }

        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < maxCla; i++){
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < maxStu; j++){
                if (studentToClassArr[i][j] == 1){
                    temp.add(j);
                }
            }
            if (temp.size() > 0){
                result.put(i,temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> studentToClass = new HashMap<>();
        studentToClass.put(1,6);
        studentToClass.put(2,6);
        studentToClass.put(3,7);
        studentToClass.put(4,7);
        studentToClass.put(6,8);

        System.out.println(ReverIndex.reverse(studentToClass));
    }
}
