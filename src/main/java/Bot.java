import java.util.Random;

/**
 * Created by Анна on 25.04.2017.
 */
public class Bot implements Runnable{

    private Bot enemy;
    private String name;
    private final int maxXP = 100;
    private int curXP;
    private Weapon weapon;

    public Bot(String name, Weapon weapon){
        this.name = name;
        this.weapon = weapon;
        curXP = maxXP;
    }

    public void setEnemy(Bot enemy) {
        this.enemy = enemy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurXP() {
        return curXP;
    }

    public void setCurXP(int curXP) {
        this.curXP = curXP;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return  name +"{" +
                "curXP=" + curXP +
                '}';
    }

    private boolean isDead(){
        return (curXP <= 0);
    }

    private void shoot(Bot enemy){
        Random rand = new Random();
        int accuracy = rand.nextInt(7) - 3;
        if(!weapon.fire(enemy, accuracy)){
            weapon.reload();
        } else {
            weapon.fire(enemy, accuracy);
        }
    }


    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isDead()){
                break;
            } else {
                shoot(enemy);
            }
        }
    }
}
