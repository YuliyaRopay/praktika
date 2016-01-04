package tanks6.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Water extends SimpleBFObject{

    public Water(int x, int y) {
        super(x, y);
        color = new Color(100,50, 255);
        setImage(BFImages.IMG_WATER);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2D=(Graphics2D) g;
        Composite origin=g2D.getComposite();
        Composite transparent=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f);
        g2D.setComposite(transparent);
        g.setColor(this.color);
        g.fillRect(this.getX(), this.getY(), 64, 64);
        //g.drawImage(image, getX(), getY(), null);
        g2D.setComposite(origin);
    }
}
