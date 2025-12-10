package model;

import java.util.Scanner;

public class CashAcceptor extends PaymentAcceptor{

    public CashAcceptor(int amount) {
        super(amount);
    }

    @Override
    public void showMenu() {
        System.out.println("а - Внести купюру");
    }

    @Override
    public void handleInput() {
        Scanner sc = new Scanner(System.in);

        String cmd = sc.nextLine();
        if (cmd.equalsIgnoreCase("a")) {
            System.out.print("Введите номинал купюры: ");
            int cash = Integer.parseInt(sc.nextLine());
            amount += cash;
            System.out.println("Баланс: " + amount);
        }
    }
}
