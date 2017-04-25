/**
 * Created by Анна on 25.04.2017.
 */
public class Weapon {

    private int damage;
    private int maxBullets;
    private int curBullets;

    public Weapon(int damage, int maxBullets){
        this.damage = damage;
        this.maxBullets = maxBullets;

        curBullets = this.maxBullets;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "damage=" + damage +
                ", maxBullets=" + maxBullets +
                '}';
    }

    public void reload(){
        curBullets = maxBullets;
        System.out.println("reloading...");
    }

    public boolean fire(Bot enemy, int accuracy){
        if(curBullets == 0){
            return false;
        }
        if(accuracy >= 0) {
            curBullets--;
            enemy.setCurXP(enemy.getCurXP() - damage);
            return true;
        } else {
            curBullets--;
            return true;
        }
    }

}
