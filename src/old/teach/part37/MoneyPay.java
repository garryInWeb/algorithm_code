package old.teach.part37;

/**
 * Created by zhengtengfei on 2019/3/13.
 *
 * 支付不找零
 */
public class MoneyPay {
    public int moneyPay(int[][] cash,int payMoney,int count){
        if (payMoney <= 0) return count;
        for (int i = 0; i < cash.length; i++){
            if (cash[i][1] <= 0 || cash[i][0]>payMoney) continue;
            if (cash[i][0] <= payMoney && cash[i][1] > 0){
                payMoney -= cash[i][0];
                cash[i][1] --;
                return moneyPay(cash,payMoney,count+1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MoneyPay moneyPay = new MoneyPay();
        System.out.println(moneyPay.moneyPay(new int[][]{{100,1},{50,3},{20,1},{10,1},{5,3},{2,10},{1,100}},152,0));
    }
}
