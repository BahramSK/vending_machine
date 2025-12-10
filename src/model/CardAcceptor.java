package model;

import java.util.Scanner;

public class CardAcceptor extends PaymentAcceptor {
    public CardAcceptor(int amount) {
        super(amount);
    }

    @Override
    public void showMenu() {
        System.out.println("a - Оплатить картой");
    }

    @Override
    public void handleInput() {
        Scanner sc = new Scanner(System.in);

        String cmd = sc.nextLine();
        if (cmd.equalsIgnoreCase("a")) {
            System.out.print("Введите номер карты: ");
            sc.nextLine();
            System.out.print("Введите одноразовый пароль: ");
            sc.nextLine();

            System.out.print("Введите сумму пополнения: ");
            int money = Integer.parseInt(sc.nextLine());

            amount += money;
            System.out.println("Баланс пополнен. Новый баланс: " + amount);
        }
    }

}
