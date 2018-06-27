import java.util.*;

public class AI extends Player{

    public AI(){
        super("Computer");
    }

    public void shipPlacer(Ship ship) {

        Random r = new Random();
        int direction = r.nextInt(2)+1;
        if (direction == 1) {
            do {
                addCoordinates(ship);
                } while (this.getBoard().checkPlaceOnBoardHorizontally(ship));
   
            this.getBoard().placeShipHorizontally(ship);
            System.out.println(this.getBoard().getGamerBoard());
        }
        if (direction == 2) {
            do {
                addCoordinates(ship);
                } while (this.getBoard().checkPlaceOnBoardVertically(ship));
        
            this.getBoard().placeShipVertically(ship);
            System.out.println(this.getBoard().getGamerBoard());
        }       
    }
    public void addCoordinates(Ship ship){
        
        int[] coordinates = randomCoordinates();
        ship.setXofShip(coordinates[0]);
        ship.setYofShip(coordinates[1]);
    }
    private int[] randomCoordinates(){
        Random r = new Random();
        int[] coordinates = new int[2];
        coordinates[0] = r.nextInt(9)+1;
        coordinates[1] = r.nextInt(9)+1;
        //System.out.println(coordinates[0] + " " + coordinates[1]);

        return coordinates;
    }
    
    public void shoot() {
        System.out.println("Shoot Computer !");
        int[] coordinates = randomCoordinates();
        addHitSquare(coordinates);
        
        getShootingBoard().getSquare(coordinates[1], coordinates[0]).setChecked();
    }

}