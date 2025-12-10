package model;

import java.util.Scanner;

public class CoinAcceptor extends PaymentAcceptor {

    public CoinAcceptor(int amount) {
        super(amount);
    }

    @Override
    public void showMenu() {
        System.out.println("а - Внести монету");
    }

    @Override
    public void handleInput() {
        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();

        if (cmd.equalsIgnoreCase("a")) {
            System.out.print("Введите номинал монеты: ");
            int coin = Integer.parseInt(sc.nextLine());
            amount += coin;
            System.out.println("Баланс: " + amount);
        }
    }
}
