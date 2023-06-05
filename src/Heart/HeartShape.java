package Heart;

// Java code to draw a dynamic heart shape
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import javax.swing.*;

public class HeartShape {
    public static void main(String[] args) {
        String message = "祝爸爸生日快乐";
        int size = 10; // 心形的尺寸，可以根据需要进行调整

        // 打印上半部分
        for (int i = size / 2; i <= size; i += 2) {
            for (int j = 1; j < size - i; j += 2) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // 打印下半部分
        for (int i = size; i >= 1; i--) {
            for (int j = i; j < size; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (i * 2) - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // 打印信息
        int spaces = (size * 2 - message.length()) / 2;
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.println(message);
    }
}