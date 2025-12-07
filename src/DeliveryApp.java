import Parcel.*;
import box.ParcelBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcel = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardBox= new ParcelBox<StandardParcel>(50);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<FragileParcel>(50);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<PerishableParcel>(50);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    getAllParcels();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Трекинг доставки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Тип посылки:" + "\n" +
            "1 - Стандартная" + "\n" +
            "2 - Хрупкая" + "\n" +
            "3 - Скоропортящаяся");
        String input = scanner.nextLine();
        System.out.println("Уточните день отправки: ");
        int sendDay = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите адрес доставки: ");
        String deliveryAddress = scanner.nextLine().trim();
        System.out.println("Введите вес");
        int weight = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Что в посылке?");
        String description = scanner.nextLine();

        switch (input) {
            case "1":
                StandardParcel standardParcel = new StandardParcel(sendDay, deliveryAddress, weight, description);
                allParcels.add(standardParcel);
                standardBox.addParcel(standardParcel);
                break;
            case "2":
                FragileParcel fragileParcel = new FragileParcel(sendDay, deliveryAddress, weight, description);
                allParcels.add(fragileParcel);
                trackableParcel.add(fragileParcel);
                fragileBox.addParcel(fragileParcel);
                break;
            case "3":
                System.out.println("Введите скор годности:");
                int timeToLive = scanner.nextInt();
                PerishableParcel perishableParcel = new PerishableParcel(sendDay, deliveryAddress, weight, description, timeToLive);
                allParcels.add(perishableParcel);
                perishableBox.addParcel(perishableParcel);
                break;
            default:
                System.out.println("Введено неверное значение");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int allCost = 0;

        for (Parcel parcel : allParcels) {
            allCost += parcel.calculateDeliveryCost();
            }
        System.out.println("Стоимость всех посылок: " + allCost);
    }

    private static void reportStatus() {
        System.out.println("Введите новую локацию: ");
        String newLocations = scanner.nextLine();

        for (Trackable parce : trackableParcel) {
            parce.reportStatus(newLocations);
        }

    }

    private static void getAllParcels() {
        System.out.println("Какая коробка вас интересует: " + "\n" +
            "1 - Стандартная" + "\n" +
            "2 - Хрупкая" + "\n" +
            "3 - Скоропортящаяся");
        int input = scanner.nextInt();
        scanner.nextLine();
        switch (input) {
            case 1:
                standardBox.getAllParcels();
                break;
            case 2:
                fragileBox.getAllParcels();
                break;
            case 3:
                perishableBox.getAllParcels();
                break;
            default:
                System.out.println("Неверно введенные данные");
        }
    }

}
