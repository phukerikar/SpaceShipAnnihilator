package Game;
public class Bullet extends Entity {
  private Game game;
  private boolean bulletHit=false;
  
  public Bullet(Game gameCreate,String spriteString,int x,int y) {
    super(spriteString,x,y);
    game=gameCreate;
  }
/*
* Adds velocity to x coord, removes bullet if it leaves the screen 
* pre: None 
* post: x coord has increased or decreased 
*/
  public void move(){
    if (x>1024||x<0) {
      game.removeEntity(this);
    }
    x += velX;
  }
/*
* If a collision has happened this is called to determine the correct course of action
* pre: method collisionDetection must be true
* post: bulletHit becomes true so double kills do not happen, bullet is removed from game
*       and the enemy life is decreased by one
*/
   public void collisionWith(Entity collidedEntity) {
     if (!bulletHit) {
     if (collidedEntity instanceof Spaceship1) {
       --game.p1Lives;
       bulletHit = true;
       game.removeEntity(this);
     } else if (collidedEntity instanceof Spaceship2) {
       --game.p2Lives;
       bulletHit = true;
       game.removeEntity(this);
     }
    }
     if (game.p1Lives == 0 || game.p2Lives == 0) {
       game.playGame = 2;
     }
}
}
