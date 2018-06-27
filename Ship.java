public class Ship {
    private String name;
    private int size;
    private boolean onBoard;
    private int x;
    private int y;

    public Ship(String name, int size){
        this.size = size;
        this.name = name;
        this.onBoard = false;
    }

    public int getSize() {
        return this.size;
    }
    public String getName() {
        return this.name;
    }
    public void setXofShip(int x){
        this.x = x;
    }
    public void setYofShip(int y){
        this.y = y;
    }
    public int getXofShip(){
        return x;
    }
    public int getYofShip(){
        return y;
    }
}

