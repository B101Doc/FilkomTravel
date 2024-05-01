package com.example;

class History {
    private static String[] orderHistory = new String[100];
    private static int historyCount = 0;

    public static void addOrderHistory(String orderDetails) {
        orderHistory[historyCount++] = orderDetails;
    }

    public static void displayOrderHistory() {
        System.out.println("\nHistori Pemesanan:");
        System.out.println("===========================");
        if (historyCount == 0) {
            System.out.println("Belum ada histori pemesanan.");
        } else {
            for (int i = 0; i < historyCount; i++) {
                System.out.println(orderHistory[i]);
            }
        }
        System.out.println("===========================");
    }
}