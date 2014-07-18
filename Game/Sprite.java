package Game;
import java.awt.Graphics;
import java.awt.Image;

public class Sprite {
  private Image image;
  public Sprite(Image image) {
    this.image = image;
  }
/*
 * get the width of the image for this sprite
 * pre: None
 * post: width of the image is returned
 */
  public int getWidth() {
    return image.getWidth(null);
  }
/*
 * get the height of the image for this sprite
 * pre: None
 * post: height of the image is returned
 */
  public int getHeight() {
    return image.getHeight(null);
  }
/*
 * draws image to graphics context at x y coord
 * pre: None
 * post: image is drawn to buffer
 */
  public void draw(Graphics graphics,int x,int y) {
    graphics.drawImage(image,x,y,null);
  }
}
  