package Game;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
public class SpriteManager {
  private static SpriteManager singleSpriteManager = new SpriteManager();
  public static SpriteManager get() {
    return singleSpriteManager;
  }
  private HashMap<String,Sprite> sprites = new HashMap<String,Sprite>();
  public Sprite getSprite(String reference) {
    if (sprites.get(reference) != null) {
      return (Sprite) sprites.get(reference);
    }
    BufferedImage source = null;
    try {
      URL url = getClass().getClassLoader().getResource(reference);
      if (url == null) {
        fail("Reference not found: " + reference);
      }
      source = ImageIO.read(url);
    } catch (IOException e) {
      fail("Couldn't load image: " + reference);
    }
    GraphicsConfiguration graphicsconfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    Image image = graphicsconfig.createCompatibleImage(source.getWidth(),source.getHeight(),Transparency.BITMASK);
    image.getGraphics().drawImage(source,0,0,null);
    Sprite sprite = new Sprite(image);
    sprites.put(reference,sprite);
    return sprite;
  }
  private void fail(String errorMessage) {
    System.err.println(errorMessage);
    System.exit(0);
  }
}
      