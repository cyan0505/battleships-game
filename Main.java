import java.util.*;

public class Main {
    private Player player1;
    private Player player2;
    
    public Player getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public static void main(String[] args) {
        
        Main main = new Main();

        List<String> options = Arrays.asList("Player vs Player", "Player vs AI", "Simulation");
        List<String> difficulties = Arrays.asList("Easy", "Normal", "Hard");
        printMenu(options);

        Scanner scan = new Scanner(System.in);
        Integer option = scan.nextInt();
       
        switch(option){
            case 1:
            {
                System.out.println("Player vs Player");

                try{
                    System.out.println("Enter Player 1 name :");
                    main.setPlayer1(new Player(stringInput()));

                    System.out.println("Enter Player 2 name :");
                    main.setPlayer2(new Player(stringInput()));
                    main.PlayGame();
                    break;
                } catch (InterruptedException e){
                    System.out.println(e);
                }
                break;  
            }
            case 2:
            {
                System.out.println("Player vs AI");
                printMenu(difficulties);
                Integer diffculty = scan.nextInt();
                main.switchDiff(diffculty);
                break;
            
            }
            case 3:
            {
                System.out.println("AI vs AI");

                try{
                    main.setPlayer1(new AI());                  
                    main.setPlayer2(new AI());
                    main.PlayGame();
                    break;
                } catch (InterruptedException e){
                    System.out.println(e);
                }
                break;            
            }  
        }
        
    }

    public static void printMenu(List<String> menu){
        System.out.println();
        for (String option : menu) {
            System.out.println((menu.indexOf(option) + 1) + ". " + option);
        }
    }

    public void switchDiff(int diff){
        switch(diff){
            case 1:
            {
                try{
                    System.out.println("Enter Player 1 name :");
                    this.setPlayer1(new Player(stringInput()));

                    this.setPlayer2(new AI());

                    this.PlayGame();
                    break;
                } catch (InterruptedException e){
                    System.out.println(e);
                }
            }
            case 2:
            {
                System.out.print("diff - normal");
                break;
            }
            case 3:
            {
                System.out.print("diff - hard");
                break;
            }
        }
    }

    public static String stringInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }

    public static void cleanScreen() {
        int screenSize = 50;
        for (int i=0; i<screenSize; i++) {
            System.out.println("\n");
        }
    }

    public void PlayGame() throws InterruptedException {
        System.out.println(this.getPlayer1().getPlayerName());
        System.out.println(this.getPlayer1().getBoard().getGamerBoard());
        this.getPlayer1().placeShips();
        
        if (Thread.interrupted()) {
            throw new InterruptedException ("try again");
        }
        Thread.sleep(2000);

        cleanScreen();

        System.out.println(this.getPlayer2().getPlayerName());
        System.out.println(this.getPlayer2().getBoard().getGamerBoard());
        this.getPlayer2().placeShips();
        
        if (Thread.interrupted()) {
            throw new InterruptedException ("try again");
        }
        Thread.sleep(2000);

        cleanScreen();

        player1.setShootingBoard(player2.getBoard());
        player2.setShootingBoard(player1.getBoard()); 
        
        
        while (!player1.getWon() && !player2.getWon()) {
            cleanScreen();
            
            System.out.println(player1.getPlayerName() + "\n" + player1.getShootingBoard().getOpponentBoard());
            System.out.println(player2.getPlayerName() + "\n" + player2.getShootingBoard().getOpponentBoard());
    

            player1.shoot();
            System.out.println(player1.getPlayerName() + "\n" + player1.getShootingBoard().getOpponentBoard());
            System.out.println(player2.getPlayerName() + "\n" + player2.getShootingBoard().getOpponentBoard());
            
            
            player2.shoot();
            System.out.println(player1.getPlayerName() + "\n" + player1.getShootingBoard().getOpponentBoard());
            System.out.println(player2.getPlayerName() + "\n" + player2.getShootingBoard().getOpponentBoard());       
        }

        System.out.println(this.findWiner() + " You Won!");
    }  

    public String findWiner() {
        if (player1.getWon()) {
            return player1.getPlayerName();
        } 
        else {
            return player2.getPlayerName();
        }
        
    }
}
