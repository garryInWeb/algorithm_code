package old.bl1;

/**
 * Created by zhengtengfei on 2018/10/30.
 */
public class SurvivorTest {
    private static final int K = 1024;
    private static final int M = K * K;
    private static final int G = K * M;

    private static final int ALIVE_OBJECT_SIZE = 31 * M;

    public static void main(String[] args) {
        int length = ALIVE_OBJECT_SIZE / 64;
        ObjectOf64Bytes[] array = new ObjectOf64Bytes[length];
        for (long i = 0; i < G; i++){
            array[(int)(i % length)] = new ObjectOf64Bytes();
        }
    }
}
