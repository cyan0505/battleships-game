import javax.lang.model.util.ElementScanner6;

public class Square {
    public int x;
    private int y;
    private boolean isShip;
    private boolean checked;
    private boolean isAvailable;

    public Square(int i, int j) {
        this.x = i;
        this.y = j;
        this.isShip = false;
        this.checked = false;
        this.isAvailable = true;
    }

    public void markAsShip(){
        this.isShip = true;
    }

    public boolean getChecked() {
        return this.checked;
    }

    public boolean getIsAvailable(){
        return this.isAvailable;
    }
    public boolean getIsShip(){
        return this.isShip;
    }
    public void setIsShip(){
        this.isShip = true;
    }

    public void setChecked(){
        this.checked = true;
    }

    public void setIsAvailable(){
        this.isAvailable = false;
    }

    public String getGamerSquare() {
        String marker;
        if (this.isShip) {
            marker =(char)27 + "[31m" + " \u20DE " + (char)27 + "[39m"; // red 
        } else {
            marker =(char)27 + "[39m" + " \u20DE ";  // default          
        }
        return marker;
    }

    public String getOpponentSquare() {
        String marker;
        if (this.checked) {
            if (this.isShip){
                marker = (char)27 + "[31m" + " \u20DE " + (char)27 + "[39m"; // red
            } else {
                marker = (char)27 + "[34m" + " \u20DE " + (char)27 + "[39m"; // blue
            }        
        } else {
            marker = (char)27 + "[39m" + " \u20DE "; // default
        }
        return marker;
    }
    
    
    // "[32m" + " \u20DE "; // green
}


