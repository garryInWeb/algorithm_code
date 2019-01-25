package old.leetCode.part735;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zhengtengfei on 2019/1/25.
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int flag = 0;
        do{
            flag = 0;
            for (int i = 0; i < asteroids.length; i++){
                // 小于等于0的数不处理
                if (asteroids[i] <= 0) continue;
                // 一直往右边查找，直达查到不为0的数
                int rightIndex = getRightIndex(asteroids,i);
                // 看右边的值,大于0的不处理，只处理相邻两个数是正负数的情况
                if (rightIndex == 0 || asteroids[rightIndex] > 0) continue;

                int temp = asteroids[i];
                int rigthTemp = asteroids[rightIndex];
                if (temp + rigthTemp > 0) asteroids[rightIndex] = 0;
                else if (temp + rigthTemp == 0){ asteroids[rightIndex] = 0;asteroids[i] = 0;}
                else asteroids[i] = 0;
                flag = 1;
            }

        }while(flag == 1);
        int count = 0;
        for (int i = 0; i < asteroids.length; i++){
            if (asteroids[i] != 0) count++;
        }
        int j = 0;
        int[] result = new int[count];

        for (int i = 0; i < asteroids.length; i++){
            if (asteroids[i] != 0){
                result[j] = asteroids[i];
                j++;
            }
        }

        return result;
    }

    public int[] betterAsteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int asteroid : asteroids){
            // 大于 0 的数直接入栈
            if (asteroid > 0){
                stack.push(asteroid);
            }else {
                // 小于0 但是栈空或者栈顶 小于0 可以直接入栈
                if (stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroid);
                }else{
                    int temp = stack.peek();
                    if (temp + asteroid > 0) continue;
                    else if (temp + asteroid == 0) stack.pop();
                    else getRightIndexStack(stack,asteroid);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i --){
            result[i] = stack.pop();
        }
        return result;
    }

    private void getRightIndexStack(Stack<Integer> stack, int asteroid) {
        stack.pop();
        while (!stack.isEmpty()){
            int temp = stack.peek();
            if (temp < 0){
                stack.push(asteroid);
                return;
            }
            if (temp + asteroid > 0) return;
            else if (temp + asteroid == 0) {
                stack.pop();
                return;
            }else {
                stack.pop();
                continue;
            }
        }
        if (stack.isEmpty()){
            stack.push(asteroid);
        }
    }

    private int getRightIndex(int[] asteroids, int i) {
        for (int j = i+1; j < asteroids.length; j++){
            if (asteroids[j] != 0) return j;
        }
        return 0;
    }

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] array = new int[]{-20,8,8,10,-9,-10,-8,-10,11,-19};
        System.out.println(Arrays.toString(asteroidCollision.betterAsteroidCollision(array)));
    }
}
