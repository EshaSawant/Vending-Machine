package HW4;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine machine1 = new VendingMachine(100);
        VendingMachine machine2 = new VendingMachine(200, "Library");
        System.out.println("===== Welcome to the CSUMB Vending Machine =====");
        System.out.println(machine1);
        machine1.displayMenu();
        System.out.println("");
        System.out.println(machine2);
        machine2.displayMenu();
        System.out.println("\n=== Compare Two Machines ===");
        System.out.println(machine1.equals(machine2));
        machine1.setLocation("BIT104");
        machine1.setName(50);
        machine1.setName(100);
        System.out.println("\n=== Machine Reset ===");

        /*
        for machine1() we assume that a machine administrator
        resets the contents of a machine
        */
        machine1.reset(4, 5, 0, 6);

        // A system admin can add items to the machine
        machine1.addItems(1, 2, 3, 4);
        System.out.println(machine1);
        //System.out.println("");
        machine1.displayMenu();

        /*
        System.out.println("\n===Vending Machine Menu===");
        System.out.println("1. Water........$1.50");
        System.out.println("2. Coffee.......$2.00");
        System.out.println("3. Chips........$1.00");
        System.out.println("4. Chocolate....$2.50");
         */

        System.out.println("\n=== Buy an Item ===");
        machine1.buyItem();
        System.out.println("\n=== Buy another Item ===");
        if (machine1.buyItem(1, 4) == false) {
            System.exit(1);
        }
        System.out.println("\n=== Return Two Items ===");
        machine1.returned(1, 2);
        machine1.returned(2, 3);
        System.out.println("\n=== Buy another Item ===");
        machine1.buyItem(3, 5);
        System.out.println("\n=== Pay for items selected. ===");
        if (machine1.payment()) {
            System.out.println("\n=== Valid payment. ===");
            machine1.displayReceipt();
        } else {
            System.out.println("=== Invalid payment. Try one more time. ===\n");
            if (machine1.payment()) {
                System.out.println("\n=== Print Receipt ===");
                machine1.displayReceipt();
            } else {
                System.exit(1);
            }
        }
        machine1.addItems(5, 5, 5, 5);
        System.out.println("\n=== Machine Status ===");
        machine1.status();
        System.out.println("\n===== Thank you! =====");
    }
}