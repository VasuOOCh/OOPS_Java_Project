import javax.swing.*;
import java.awt.*;

public class ArrayPanel extends JPanel {

    private int currentIndex = -1;
    int[] arr;

    public ArrayPanel(int[] arr) {
        this.arr = arr;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        int ELEMENT_WIDTH=2;
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int x = i*ELEMENT_WIDTH + 30;
            int y = (getHeight() - height*2) - 50;

            if(i == currentIndex) {
                g.setColor(Color.blue);
                g.fillRect(x, y-height, ELEMENT_WIDTH, height*3);

            }else {
                g.setColor(Color.GREEN);
                g.fillRect(x, y-height, ELEMENT_WIDTH, height*3);

            }
        }

    }

    public void paintCurrentElement(int i) {
        currentIndex = i;
        this.repaint();
    }

}
