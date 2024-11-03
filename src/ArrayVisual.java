import javax.swing.*;
import java.awt.*;

public class ArrayVisual extends JFrame {
    int[] arr;
    private final int WIDTH = 1600;
    private final int HEIGHT = 600;
    private final int DELAY = 50; // in mili sec
    public ArrayPanel panel;

    public ArrayVisual(int[] arr){
        this.arr = arr;
        setTitle("Radix sort");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel = new ArrayPanel(arr);
        setBackground(Color.green);
        add(panel);


        setVisible(true);
    }
}
