import enums.ActionLetter;
import model.*;
import util.UniversalArray;
import util.UniversalArrayImpl;

import java.util.Scanner;

public class AppRunner {

    private final UniversalArray<Product> products = new UniversalArrayImpl<>();

    private PaymentAcceptor acceptor = new CoinAcceptor(0);

    private static boolean isExit = false;

    private AppRunner() {
        products.addAll(new Product[]{
                new Water(ActionLetter.B, 20),
                new CocaCola(ActionLetter.C, 50),
                new Soda(ActionLetter.D, 30),
                new Snickers(ActionLetter.E, 80),
                new Mars(ActionLetter.F, 80),
                new Pistachios(ActionLetter.G, 130)
        });
    }

    public static void run() {
        AppRunner app = new AppRunner();
        while (!isExit) {
            app.startSimulation();
        }
    }

    PaymentAcceptor choosePaymentMethod() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите способ оплаты:");
            System.out.println("1 - Монеты");
            System.out.println("2 - Наличные");
            System.out.println("3 - Карта");
            System.out.print("Введите номер: ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    return new CoinAcceptor(0);
                case "2":
                    return new CashAcceptor(0);
                case "3":
                    return new CardAcceptor(0);
                default:
                    System.out.println("Неверный ввод, попробуйте снова.\n");
            }
        }
    }

    private void startSimulation() {
        print("\nВ автомате доступны:");
        showProducts(products);

        print("Баланс: " + acceptor.getAmount());

        UniversalArray<Product> allowProducts = new UniversalArrayImpl<>();
        allowProducts.addAll(getAllowedProducts().toArray());
        chooseAction(allowProducts);
    }

    private UniversalArray<Product> getAllowedProducts() {
        UniversalArray<Product> allowProducts = new UniversalArrayImpl<>();
        for (int i = 0; i < products.size(); i++) {
            if (acceptor.getAmount() >= products.get(i).getPrice()) {
                allowProducts.add(products.get(i));
            }
        }
        return allowProducts;
    }

    private void chooseAction(UniversalArray<Product> products) {
        print(" a - Пополнить баланс");
        showActions(products);
        print(" h - Выйти");
        String action = fromConsole().substring(0, 1);

        if ("a".equalsIgnoreCase(action)) {
            PaymentAcceptor newAcceptor = choosePaymentMethod();
            newAcceptor.setAmount(acceptor.getAmount());
            acceptor = newAcceptor;

            acceptor.showMenu();
            acceptor.handleInput();
            return;
        }

        try {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getActionLetter().equals(ActionLetter.valueOf(action.toUpperCase()))) {
                    acceptor.setAmount(acceptor.getAmount() - products.get(i).getPrice());
                    print("Вы купили " + products.get(i).getName());
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            if ("h".equalsIgnoreCase(action)) {
                isExit = true;
            } else {
                print("Недопустимая буква. Попрбуйте еще раз.");
                chooseAction(products);
            }
        }
    }

    private void showActions(UniversalArray<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            print(String.format(" %s - %s", products.get(i).getActionLetter().getValue(), products.get(i).getName()));
        }
    }

    private String fromConsole() {
        return new Scanner(System.in).nextLine();
    }

    private void showProducts(UniversalArray<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            print(products.get(i).toString());
        }
    }

    private void print(String msg) {
        System.out.println(msg);
    }
}
