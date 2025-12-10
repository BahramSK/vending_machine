package model;

import java.util.Scanner;

public class CoinAcceptor extends PaymentAcceptor {

    public CoinAcceptor(int amount) {
        super(amount);
    }

    @Override
    public void showMenu() {
        System.out.println("Введите номинал монеты");
    }

    @Override
    public void handleInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int coin = Integer.parseInt(sc.nextLine());
                if (coin <= 0) {
                    System.out.println("Сумма должна быть положительной! Попробуйте снова:");
                    continue;
                }
                amount += coin;
                System.out.println("Баланс пополнен. Новый баланс: " + amount);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод! Введите число:");
            }
        }
    }
}