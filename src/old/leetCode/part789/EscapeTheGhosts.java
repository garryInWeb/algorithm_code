package old.leetCode.part789;

/**
 * Created by zhengtengfei on 2019/2/1.
 */
public class EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int x = target[0];
        int y = target[1];
        int length = Math.abs(x) + Math.abs(y);
        int minLength;
        for (int i = 0 ;i < ghosts.length;i++){
            int xLength = ghosts[i][0] - x;
            int yLength = ghosts[i][1] - y;
            minLength = Math.abs(xLength) + Math.abs(yLength);
            if (minLength <= length) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] ghosts = new int[][]{{1,0}};
        int[] target = new int[]{2,0};
        EscapeTheGhosts escapeTheGhosts = new EscapeTheGhosts();
        System.out.println(escapeTheGhosts.escapeGhosts(ghosts,target));
    }
}
