package lastpencil;

import java.util.*;

/*
1. implement bot for the second of the two possible players
    - if john is first player
    - then jack is the bot but here jack is always the bot
2. use random from 1 to 3 to select the bot option follows the winning strategy [xs]


remarks
- implementation of robot is successful
- now need to determines if robot(Jack) starts first or not
- output winner
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // request number of pencil
        System.out.println("How many pencils would you like to use:");

        int numOfPencil = validateNumOfPencil(scanner);

        // initialize pencilCase
        PencilCase pencilCase = new PencilCase(numOfPencil);

        // ask who will be going first
        System.out.println("Who will be the first (John, Jack):");

        String name = validateName(scanner);

        // initialize who starts first as user
        User player1 = new User();
        User player2 = new User();

        if (name.equals("John")) {
            player1.setName("John");
            player2.setName("Jack");
        } else {
            player1.setName("Jack");
            player2.setName("John");
        }

        // print all pencil in pencilcase
        printPencil(pencilCase);

        String currentPlayer = "";
        
        while (pencilCase.getNumOfPencil() > 0) {
            // players get a turn if pencil in pencil case is still larger than 0

            if (player1.getName().equals("John")) {
                // player 1
                if (pencilCase.getNumOfPencil() > 0) {
                    currentPlayer = player1.getName();
                    playersTurn(player1, pencilCase, scanner);
                }

                // player 2 as bot for now
                // set logic for jack which is the bot, but we need to determine either bot start first or not
                if (pencilCase.getNumOfPencil() > 0) {
                    currentPlayer = player2.getName();
                    System.out.println(currentPlayer + "'s turn!");
                    int botsChoice = botsTurn(pencilCase);
                    System.out.println(botsChoice);
                    pencilCase.setNumOfPencil(pencilCase.getNumOfPencil() - botsChoice);
                    printPencil(pencilCase);
                }
            }

            if (player1.getName().equals("Jack")) {
                // set logic for jack which is the bot, but we need to determine either bot start first or not
                if (pencilCase.getNumOfPencil() > 0) {
                    currentPlayer = player1.getName();
                    System.out.println(currentPlayer + "'s turn!");
                    int botsChoice = botsTurn(pencilCase);
                    System.out.println(botsChoice);
                    pencilCase.setNumOfPencil(pencilCase.getNumOfPencil() - botsChoice);
                    printPencil(pencilCase);
                }

                // player 1
                if (pencilCase.getNumOfPencil() > 0) {
                    currentPlayer = player2.getName();
                    playersTurn(player2, pencilCase, scanner);
                }
            }

        }

        if (currentPlayer.equals(player1.getName())) {
            System.out.println(player2.getName() + " won!");
        } else {
            System.out.println(player1.getName() + " won!");
        }

        scanner.close();
    }

    public static void printPencil(PencilCase pencilCase) {
        for (int i = 0; i < pencilCase.getNumOfPencil(); i++) {
            System.out.print("|");
        }
        System.out.println();
    }

    public static int validateNumOfPencil(Scanner scanner) {
        int numOfPencil = 0;
        boolean isFalse = false;
        while (!isFalse) {
            try {
                String input = scanner.nextLine();
                numOfPencil = Integer.parseInt(input);

                if (numOfPencil == 0) {
                    System.out.println("The number of pencils should be positive");
                } else if (numOfPencil < 0){
                    System.out.println("The number of pencils should be numeric");
                } else {
                    isFalse = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

        return numOfPencil;
    }

    public static String validateName(Scanner scanner) {
        String name = "";

        boolean flag = false;
        while (!flag) {
            name = scanner.nextLine();
            if (name.equals("John") || name.equals("Jack")) {
                flag = true;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }

        return name;
    }

    public static void playersTurn(User user, PencilCase pencilCase, Scanner scanner) {
        System.out.println(user.getName() + "'s turn!");

        boolean flag = false;
        while (!flag) {
            try {
                String input = scanner.nextLine();
                int playerPencil = Integer.parseInt(input);

                if (playerPencil == 1 || playerPencil == 2 || playerPencil == 3) {
                    if (playerPencil <= pencilCase.getNumOfPencil()) {
                        user.setPencil(playerPencil);

                        pencilCase.setNumOfPencil(pencilCase.getNumOfPencil() - user.getPencil());
                        printPencil(pencilCase);
                        flag = true;
                    } else {
                        System.out.println("Too many pencils were taken");
                    }
                } else {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            } catch (NumberFormatException e) {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
    }

    public static int botsTurn(PencilCase pencilCase) {
        int numOfPencil = pencilCase.getNumOfPencil();

        // initializes random
        Random random = new Random();

        int botsChoice = 0;

        if (numOfPencil % 4 == 0) {
            botsChoice = 3;
        } else if (numOfPencil % 4 == 3) {
            botsChoice = 2;
        } else if ((numOfPencil + 1) % 2 == 1 || numOfPencil == 1){
            botsChoice = 1;
        } else {
            botsChoice = random.nextInt(3) + 1;
        }

        return botsChoice;
    }
}
