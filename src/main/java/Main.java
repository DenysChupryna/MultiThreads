/**
 * Created by Анна on 25.04.2017.
 */
public class Main {


    public static void main(String[] args) {
        Weapon weapon = new Weapon(13, 15);
        Bot bot1;
        Bot bot2;
        bot1 = new Bot("Silver", weapon);
        bot2 = new Bot("Global", weapon);
        bot1.setEnemy(bot2);
        bot2.setEnemy(bot1);
        Thread thread1 = new Thread(bot1);
        Thread thread2 = new Thread(bot2);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();

        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(bot1  + "    " + bot2);
            if(!thread1.isAlive()){
                System.out.println("Bot " + bot1.getName() + " R.I.P");
                break;
            }
            if(!thread2.isAlive()){
                System.out.println("Bot " + bot2.getName() + " R.I.P");
                break;
            }
        }

    }
}
