import java.util.ArrayList;

public class Bidder extends Thread {

    int stepOfBid;
    int wallet;

    public Bidder(int stepOfBid, int wallet)
    {
        this.stepOfBid=stepOfBid;
        this.wallet=wallet;
    }



    public int setBid(int currentBid)
    {
        int newBid=stepOfBid+currentBid ;
        System.out.println("Bidder "+getName()+" take a bid "+newBid);
        return newBid;
    }

@Override
    public void run()
{System.out.println();
    System.out.println("run is run");


//    try {
//        Thread.sleep(10);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }

}


}

