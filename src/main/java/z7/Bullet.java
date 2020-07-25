package z7;

import java.util.*;

public class Bullet {
    private int bulletSize;
    private Deque<String> bullets = new ArrayDeque<>();
    public Bullet(int bulletSize) {
        this.bulletSize = bulletSize;
    }
    private void loadBullet(String bullet){
        if(bullets.size() < bulletSize) {
            bullets.addLast(bullet);
        }
        System.out.println(bullets);
    }
    private boolean isLoaded(){
        return !bullets.isEmpty();
    }
    private void shot(){
        if(isLoaded()) {
            System.out.println("SHOT: " + bullets.removeLast());
        } else {
            System.out.println("Bullet is empty");
        }
    }
    public static void main(String[] args) {
        Bullet bullet = new Bullet(3);
        bullet.loadBullet("-> 1");
        bullet.loadBullet("-> 2");
        bullet.loadBullet("-> 3");
        bullet.loadBullet("-> 4");
        bullet.shot();
        bullet.shot();
        bullet.shot();
        bullet.shot();
        bullet.shot();
    }
}
