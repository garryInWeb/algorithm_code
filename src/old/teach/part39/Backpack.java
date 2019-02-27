package old.teach.part39;

import java.util.Arrays;

/**
 * Created by zhengtengfei on 2019/2/26.
 * 0-1背包问题
 *
 */
public class Backpack {
    public int maxWeight;

    /**
     *
     * @param i 考察到第 i 个数
     * @param cw 背包现有重量
     * @param items 列表
     * @param n 数字总数
     * @param w 背包承重
     */
    public void f(int i,int cw,int[] items,int n,int w){
        if (cw == w || i == n){
            if (cw > maxWeight) maxWeight = cw;
            return;
        }
        // 不当前元素的情况
        f(i+1,cw,items,n,w);
        if (cw + items[i] <= w){
            // 放当前元素的情况
            f(1+1,cw + items[i],items,n,w);
        }
    }


    public static void main(String[] args) {
        int[] items = new int[]{8,3,6,9,11,5,1};
        Backpack backpack = new Backpack();
        backpack.f(0,0,items,items.length-1,10);
        System.out.println(backpack.maxWeight);
    }
}
