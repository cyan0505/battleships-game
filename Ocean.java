import java.util.*;
import java.text.DecimalFormat;

public class Ocean {
    private Square[][] ocean;

    public Ocean() {
        this.ocean = new Square[10][10];
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                this.ocean[i][j] = new Square(i, j);
            }
        }
    }

    public Square getSquare(int x, int y){
        return ocean[x][y];
    } 
    
    
    public String getGamerBoard() {
        String display = "     A B C D E F G H I J \n";
        for (int i=0; i<10; i++){
            DecimalFormat formatter = new DecimalFormat("###");
            display += String.format(" %2s ", formatter.format(i+1));
            for (int j=0; j<10; j++){
                display += this.ocean[i][j].getGamerSquare();
            }
            display += "\n";
        }
        return display;
    }

    public String getOpponentBoard() {
        String display = "     A B C D E F G H I J \n";
        for (int i=0; i<10; i++){
            DecimalFormat formatter = new DecimalFormat("###");
            display += String.format(" %2s ", formatter.format(i+1));
            for (int j=0; j<10; j++){
                display += this.ocean[i][j].getOpponentSquare();
            }
            display += "\n";
        }
        return display;
    }

    public void placeShipHorizontally(Ship ship){
        int X = ship.getXofShip();
        for (int i = 0; i < ship.getSize(); i++){
            this.getSquare((ship.getYofShip()), (X)).markAsShip();
            this.getSquare((ship.getYofShip()), (X)).setIsAvailable();
            X++; 
               
        }

    }

    public void placeShipVertically(Ship ship){
        int Y = ship.getYofShip();
        for (int i = 0; i < ship.getSize(); i++){
            this.getSquare((Y), (ship.getXofShip())).markAsShip();
            this.getSquare((Y), (ship.getXofShip())).setIsAvailable();
            Y++;
        }
    }
    public boolean checkPlaceOnBoardHorizontally(Ship ship){ 
        int A = ship.getXofShip() - 1;
        int B = ship.getYofShip() - 1;
        if (ship.getSize() + A + 2 <= 10 && B + 3 <= 10) {
            for (int i = 0; i <= ship.getSize() + 1; i++){
                for (int j = 0; j < 3; j++){
                    if (this.getSquare(B + j, A + i).getIsAvailable()){
                        continue;
                    } else {
                        return true;
                    }
                }
            } 
            return false;  
        } else {
            return true;
        }
            
    }
    public boolean checkPlaceOnBoardVertically(Ship ship){ 
        int A = ship.getXofShip() - 1;
        int B = ship.getYofShip() - 1;
        if (ship.getSize() + B + 2 <= 10 && A + 3 <= 10) {
            for (int i = 0; i <= ship.getSize() + 1; i++){
                for (int j = 0; j < 3; j++){
                    if (this.getSquare(B + i, A + j).getIsAvailable()){
                        continue;
                    } else {
                        return true;
                    }
                }
            } 
            return false;   
        } else {
            return true;
        } 

    }
}