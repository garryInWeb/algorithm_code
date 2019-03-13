package old.teach.part41;

/**
 * Created by zhengtengfei on 2019/3/6.
 */
public class CoinPay {
    public int coinPay(int[] coins,int pay){
        for (int i = 0; i < coins.length; i++){
            if (coins[i] > pay) {
                return 1;
            }
        }

        return coinPay(coins,pay-rent(pay,coins)) + 1;
    }

    private int rent(int pay,int[] coins) {
        int i = 0;
        for (; i < coins.length; i++){
            if (coins[i] > pay) {
                i--;
                break;
            }
        }
        if (i == coins.length) i--;
        return coins[i];
    }

    public static void main(String[] args) {
        CoinPay c = new CoinPay();
        System.out.println(c.coinPay(new int[]{1,3,5,8},19));
    }
}
