/**  
* River Deters - mddeters  
* CIS171 22149
* Jul 16, 2023
* Windows 10 Operating System Eclipse Version - 2023-03 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SmileyFaceDeters extends JPanel {
    private Color faceColor = Color.YELLOW; // Default face color is yellow

    public SmileyFaceDeters() {
        setPreferredSize(new Dimension(200, 200));
        setBackground(faceColor); // Set the background color to the face color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the face
        g.setColor(faceColor);
        g.fillOval(50, 50, 100, 100);

        // Draw the eyes
        g.setColor(Color.BLACK);
        g.fillOval(70, 75, 15, 15);
        g.fillOval(115, 75, 15, 15);

        // Draw the nose
        g.fillOval(95, 95, 10, 10);

        // Draw the mouth (a smile)
        g.drawArc(75, 100, 50, 30, 0, -180);
    }

    public void changeFaceColor() {
        // Generate random values to create a random color
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        faceColor = new Color(r, g, b);
        setBackground(faceColor); // Set the new background color
        repaint(); // Repaint the JPanel with the new color
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smiley Face");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SmileyFaceDeters smileyFace = new SmileyFaceDeters();

        JButton colorButton = new JButton("Change Color");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smileyFace.changeFaceColor();
            }
        });

        frame.add(smileyFace, BorderLayout.CENTER);
        frame.add(colorButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}
