import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Bidder thread1 = new Bidder(5,100);
        Bidder thread2 = new Bidder(5,50);
        Bidder thread3 = new Bidder(5,1000);

        ArrayList<Lot> lotList = new ArrayList<Lot>();
        Lot lot1 = new Lot();
        lot1.cost=10;
        lot1.name="Lot 1";
        lotList.add(lot1);

        Lot lot2 = new Lot();
        lot2.cost=100;
        lot2.name="Lot 2";
        lotList.add(lot2);

        Lot lot3 = new Lot();
        lot3.cost=1000;
        lot2.name="Lot 3";
        lotList.add(lot3);



        for (int j=0;j<3;j++) {

            System.out.println("next lot "+lotList.get(j).name);

            thread1.run();
            thread2.run();
            thread3.run();

            long t = System.currentTimeMillis();
            long endT = t+5000;
            int currentBid=lotList.get(j).cost;
            HashMap<Integer,String> bids = new HashMap<>();

            String winner="";


            while (System.currentTimeMillis() < endT) {
                //create three threads
                currentBid=thread1.setBid(currentBid);
                winner = thread1.getName();
                Thread.sleep(100);
                currentBid=thread2.setBid(currentBid);
                Thread.sleep(100);
                currentBid=thread3.setBid(currentBid);
                Thread.sleep(100);


            }
            switch (winner)
            {
                case "Thread-0":if (thread1.wallet>=currentBid){System.out.println("Auction ended. The Winner is  "+winner+" with bid "+currentBid);} else
                    System.out.println(winner+"has no enough of mony for this bid");
                case "Thread-1":if (thread2.wallet>=currentBid){System.out.println("Auction ended. The Winner is  "+winner+" with bid "+currentBid);} else
                    System.out.println(winner+" has no enough of mony for this bid");
                case "Thread-2":if (thread3.wallet>=currentBid){System.out.println("Auction ended. The Winner is  "+winner+" with bid "+currentBid);} else
                    System.out.println(winner+" has no enough of mony for this bid");
                //comment for commit


            }


            System.out.println();

        }
    }
}
