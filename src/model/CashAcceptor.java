package model;

import java.util.Scanner;

public class CashAcceptor extends PaymentAcceptor{

    public CashAcceptor(int amount) {
        super(amount);
    }

    @Override
    public void showMenu() {
        System.out.println("Введите номинал купюры:");
    }

    @Override
    public void handleInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int cash = Integer.parseInt(sc.nextLine());
                if (cash <= 0) {
                    System.out.println("Сумма должна быть положительной! Попробуйте снова:");
                    continue;
                }
                amount += cash;
                System.out.println("Баланс пополнен. Новый баланс: " + amount);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод! Введите число:");
            }
        }
    }
}