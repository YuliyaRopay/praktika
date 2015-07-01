package day6.Frame13Shapes;

import javax.swing.*;
import java.awt.*;

public class ShapesTemplate extends JPanel {
	
	private Drawable[] shapes;
	
	public ShapesTemplate(Drawable[] shapes) {
		this.shapes = shapes;
		if (shapes == null || shapes.length < 1) {
			this.shapes = new Drawable[0];
		}
		
		JFrame frame = new JFrame("DAY 6, 2D Graphics");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(600, 400));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		for (Drawable s : shapes) {
			if(s!=null){
                s.draw(g);
            }
		}
	}
}
