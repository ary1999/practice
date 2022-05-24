/*
 *Practice 10
 *Name: 楊承叡
 *Student Number: 110502545
 *Course 2022-CE1004-B
 */

//hihi this is a test

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class functions{
    Map<Integer, String> choiceToDrink = new HashMap<>(){{
        put(1, "Cola");
        put(2, "Green Tea");
        put(3, "Lemon Tea");
        put(4, "Mineral Water");
    }};

    Map<String,Integer> drinksPrice = new HashMap<>(){{
        put("Cola", 30);
        put("Green Tea", 25);
        put("Lemon Tea", 29);
        put("Mineral Water", 20);
    }};

    Map<Integer, Integer> drinkAmount = new HashMap<>(){{
        put(1, 0);
        put(2, 0);
        put(3, 0);
        put(4, 0);
    }};

    Map<String, Integer> list = new HashMap<>();

    int price = 0;
    boolean changeValue = true;
    boolean choiceValue = true;
    int drinkChoice;
    int amount;

    Scanner scanner = new Scanner(System.in);

    public void choose_drinks(){

        System.out.println("choose drinks (drinks / amount)\n(1)Cola (2)Green Tea (3)Lemon Tea (4)Mineral Water");
        drinkChoice = scanner.nextInt();
        amount = scanner.nextInt();
        if (drinkChoice != 1 && drinkChoice != 2 && drinkChoice != 3 && drinkChoice != 4){
            System.out.println("invalid input");
            choiceValue = false;
        }

    }

    public void processing(){
        drinkAmount.put(drinkChoice, drinkAmount.get(drinkChoice) + amount);
        price += drinksPrice.get(choiceToDrink.get(drinkChoice)) * amount;
        list.put(choiceToDrink.get(drinkChoice), drinkAmount.get(drinkChoice));
    }

    public void listOut(){
        if (list.isEmpty()){
            System.out.println("Empty");
        }
        else {
            for (Map.Entry<String, Integer> entry : list.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

    }

    public void pay(){
        System.out.println("total cost: " + price);
        System.out.println("plea pay: ");
        int payment = scanner.nextInt();
        int change = payment - price;
        if (change >= 0){
            System.out.println("money change: " + change + "\nthank you");
            changeValue = false;
        }
        else {
            System.out.println("money not enough");
        }
    }
}

public class P10_110502545 {
    public static void main(String[] args) {
        functions functions = new functions();
        while (true){
            System.out.println("(1)choose drinks (2)list (3)pay (4)exit");

            Scanner scanner = new Scanner(System.in);
            int actChoice = scanner.nextInt();


            if (actChoice == 1){
                functions.choose_drinks();
                if (!functions.choiceValue){
                    continue;
                }
                functions.processing();
            }
            else if (actChoice == 2){
                functions.listOut();
            }
            else if (actChoice == 3){
                functions.pay();
                if (!functions.changeValue){
                    break;
                }
            }
            else if (actChoice == 4) {
                System.out.println("exit");
                break;
            }
            else {
                System.out.println("invalid input");
            }
        }
    }
}
