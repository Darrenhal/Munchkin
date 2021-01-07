package de.munchkin.utilities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class JPictureBox extends JPanel{
	
    private static final long serialVersionUID = 6196514831308649310L;



    private Image mImage;

    public JPictureBox(final Image pImage) {
        mImage = pImage;
    }
    
    public JPictureBox() {}


    public Image getImage() {
        return mImage;
    }
    public void setImage(final Image pImage) {
        mImage = pImage;
        repaint();
    }



    @Override protected void paintComponent(final Graphics pG) {
        if (mImage == null) return;

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);// can add more
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(mImage, 0, 0, getWidth(), getHeight(), this);
    }
	
}
