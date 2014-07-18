/** Spaceship Annihilator 
 * Mr. Paterson
 * Pallavi Hukerikar
 * June 13, 2014
 **/
package Game;
public class Spaceship1 extends Entity {
  
  private Game game;
  
  public Spaceship1(Game gamePlayer,int x,int y) {
    super("Sprites/cargoship.png",x,y);
    game = gamePlayer;
  }
/*
 * moves the sprite up
 * pre: None
 * post: y coord is reduced by velY
 */  
  public void up() {
   
    if (y < 0) {
      return;
    }
    
    y -= velY;
  }
/*
 * moves the sprite down
 * pre: None
 * post: y coord is increased by velY
 */  
  public void down() {
    
     if (y > 709) {
      return;
    }
     
    y += velY;
  }
/*
 * moves the sprite right
 * pre: None
 * post: x coord is increased by velX
 */  
  public void right() {
   
    if (x > 904) {
      return;
    }
    
    x += velX;
  }
/*
 * moves the sprite left
 * pre: None
 * post: x coord is reduced by velX
 */    
  public void left() {
   
    if (x < 0) {
      return;
    }
    
    x -= velX;
  }
    
  public void collisionWith(Entity enemy) {
  }    
}