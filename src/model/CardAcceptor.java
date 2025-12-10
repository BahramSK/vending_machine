package model;

import java.util.Scanner;

public class CardAcceptor extends PaymentAcceptor {
    public CardAcceptor(int amount) {
        super(amount);
    }

    @Override
    public void showMenu() {
        System.out.println("Пополнение картой");
    }

    @Override
    public void handleInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите номер карты: ");
        sc.nextLine();

        System.out.print("Введите одноразовый пароль: ");
        sc.nextLine();

        while (true) {
            System.out.print("Введите сумму пополнения: ");
            String input = sc.nextLine();
            try {
                int money = Integer.parseInt(input);
                if (money <= 0) {
                    System.out.println("Сумма должна быть положительной! Попробуйте снова:");
                    continue;
                }
                amount += money;
                System.out.println("Баланс пополнен. Новый баланс: " + amount);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод! Введите число:");
            }
        }
    }
}