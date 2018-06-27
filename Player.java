import java.util.*;

public class Player {
    private Ocean playerBoard;
    private String playerName;
    private Ocean shootingBoard;
    private final int SQUARE_TO_SHOOT = 3;
    private int hitSquare;
    private boolean won;

    public Player(String name) {
        this.playerBoard = new Ocean();
        this.playerName = name;
        this.hitSquare = 0;
        this.won = false;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getHitSquare() {
        return this.hitSquare;
    }

    public void setHitSquare(int number) {
        this.hitSquare = number;
    }

    public boolean getWon() {
        return this.won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public void setShootingBoard(Ocean opponentsBoard) {
        this.shootingBoard = opponentsBoard;
    }

    public Ocean getBoard() {
        return this.playerBoard;
    }

    public Ocean getShootingBoard() {
        return this.shootingBoard;
    }

    public void placeShips() {
        // this.shipPlacer(new Ship("X-Wing", 2));
        this.shipPlacer(new Ship("Millenium Falcon", 3));
        //this.shipPlacer(new Ship("Tie Fighter", 3));
        // this.shipPlacer(new Ship("Star Destroyer", 4));
        // this.shipPlacer(new Ship("Death Star", 5));
    }

    public void shipPlacer(Ship ship) {

        System.out.println("1. Place horizontally \n2. Place verically");
        Scanner scan = new Scanner(System.in);
        String direction = "";
        boolean choiceRight = false;
        while(choiceRight == false){
            direction = scan.next();
            if(direction.equals("1") || direction.equals("2")){
                choiceRight = true;
            }
            else{
                System.out.println("1 or 2 my friend... 1 or 2....");
            }
        }
        if (direction.equals("1")) {
            do {
                addCoordinates(ship);
                } while (this.getBoard().checkPlaceOnBoardHorizontally(ship));
   
            playerBoard.placeShipHorizontally(ship);
            System.out.println(this.getBoard().getGamerBoard());
        }
        if (direction.equals("2")) {
            do {
                addCoordinates(ship);
                } while (this.getBoard().checkPlaceOnBoardVertically(ship));
        
            playerBoard.placeShipVertically(ship);
            System.out.println(this.getBoard().getGamerBoard());
        }       
    }
    public void addCoordinates(Ship ship){
        System.out.println(
        playerName + " choose coordinates to place Your " + ship.getName() + " (length " + ship.getSize() + ")");
        int[] coordinates = convertInput();
        ship.setXofShip(coordinates[0]);
        ship.setYofShip(coordinates[1]);
    }
    public int[] convertInput() {
        boolean coordsRight = false;
        int[] coordinates = new int[2];
        while (coordsRight == false){
            Scanner scan = new Scanner(System.in);
            String position = scan.next().toUpperCase();
            char posASCIIX = position.charAt(0);
            char posASCIIY = position.charAt(1);
            int positionX = (int) posASCIIX - 64;
            int positionY;
            if (position.length() == 3) {
                positionY = 10;
            } else {
                positionY = (int) posASCIIY - 48;
            }
            
            coordinates[0] = positionX-1;
            coordinates[1] = positionY-1;
            if((position.length()==2) && coordinates[0] >= 0 && coordinates[0] < 10 && coordinates[1] >= 0 && coordinates[1] < 10) {
                coordsRight = true;
            } else if((position.length()==3) && coordinates[0] >= 0 && coordinates[0] < 10 && coordinates[1] >= 0 && coordinates[1] < 10) {
                coordsRight = true;
            } else {
                System.out.println("Wrong coordinates, stop this shenanigans at once! \n\nTry again:");
            }
        }
        return coordinates;
    }
    public void shoot() {
        System.out.println("Shoot " +  this.getPlayerName() + "!");
        int[] coordinates = convertInput();
        addHitSquare(coordinates);
        
        shootingBoard.getSquare(coordinates[1], coordinates[0]).setChecked();
    }

    public void addHitSquare(int[] coordinates) {
        if (shootingBoard.getSquare(coordinates[1], coordinates[0]).getIsShip()) {
            this.setHitSquare(this.getHitSquare()+1);
            if (this.getHitSquare() == SQUARE_TO_SHOOT) {
                this.setWon(true);
            }
        }
    } 
        
}
