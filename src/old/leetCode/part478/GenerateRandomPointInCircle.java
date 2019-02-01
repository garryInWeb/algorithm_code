package old.leetCode.part478;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhengtengfei on 2019/2/1.
 */
public class GenerateRandomPointInCircle {
    private double radius;
    private double x_center;
    private double y_center;
    public GenerateRandomPointInCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random()) * radius;
        double deg = Math.random() * 2 * Math.PI;
        return new double[]{len * Math.cos(deg) + x_center, len * Math.sin(deg) + y_center};    }

    public static void main(String[] args) {
        GenerateRandomPointInCircle generateRandomPointInCircle = new GenerateRandomPointInCircle(1,0,0);
        System.out.printf(Arrays.toString(generateRandomPointInCircle.randPoint()));
        System.out.printf(Arrays.toString(generateRandomPointInCircle.randPoint()));
        System.out.printf(Arrays.toString(generateRandomPointInCircle.randPoint()));
        System.out.printf(Arrays.toString(generateRandomPointInCircle.randPoint()));
    }
}
