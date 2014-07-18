/** Spaceship Annihilator 
 * Mr. Paterson
 * Pallavi Hukerikar & Patrick Bevilacqua
 * June 13, 2014
 **/
package Game;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
  protected int x;
  protected int y;
  protected Sprite sprite;
  protected int velX;
  protected int velY;
  private Rectangle thisEntity = new Rectangle();
  private Rectangle otherEntity = new Rectangle();
  public Entity(String refImage,int x,int y) {
    sprite = SpriteManager.get().getSprite(refImage);
    this.x = x;
    this.y = y;
  }
  public void move() {
  }
/*
* Changes the horizontal velocity of the sprite
* pre: None
* post: velX is set to a new value
*/
  public void setHorizontalVelocity(int velX) {
    this.velX = velX;
  }
/*
* Changes the vertical velocity of the sprite
* pre: None
* post: velY is set to a new value
*/
  public void setVerticalVelocity(int velY) {
    this.velY = velY;
  }
/*
* returns the current horizontal velocity
* pre: None
* post: velX is returned
*/
  public int getHorizontalVelocity() {
    return velX;
  }
/*
* returns the current vertical velocity
* pre: None 
* post: velY is returned
*/
  public int getVerticalVelocity() {
    return velY;
  }
/*
* draws this objects image to the graphics context
* pre: None
* post: the image is drawn at the given x y location to the buffer
*/
  public void draw(Graphics graphics) {
    sprite.draw(graphics,x,y);
  }
/*
* returns the current x position
* pre: None
* post: x is returned
*/
  public int getX() {
    return x;
  }
/*
* returns the current y position
* pre: None
* post: y is returned
*/
  public int getY() {
    return y;
  }
/*
* checks if the two entities hit each other 
* pre: None
* post: returns true if they collided with each other, else returns false
*/
  public boolean collisionDetection(Entity checkEntity) {
    thisEntity.setBounds(x,y,sprite.getWidth(),sprite.getHeight());
    otherEntity.setBounds(checkEntity.x,checkEntity.y,checkEntity.sprite.getWidth(),checkEntity.sprite.getHeight());
    return thisEntity.intersects(otherEntity);
  }
  public abstract void collisionWith(Entity collidedEntity);
}