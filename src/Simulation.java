public class Simulation {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.createCategory("Nahrung.Supermarkt");
        expenseManager.createCategory("Nahrung.Supermarkt.Obst");
        expenseManager.createCategory("Nahrung.Imbiss");
        expenseManager.createCategory("Wohnung.Miete");
        expenseManager.createCategory("Wohnung.Nebenkosten.Strom");
        expenseManager.createCategory("Wohnung.Nebenkosten.WLAN");
        expenseManager.createCategory("Freizeit.Reise");
        expenseManager.createCategory("Freizeit.Fitness");
        expenseManager.createCategory("Freizeit.ComputerGame");


        System.out.println("Baum vor Ausgaben:");
        expenseManager.print();
        System.out.println();

        expenseManager.addExpense(new Expense("Pommes", 300), "Nahrung.Imbiss");
        expenseManager.addExpense(new Expense("Einkaufen", 492), "Nahrung.Supermarkt");
        expenseManager.addExpense(new Expense("Einkaufen II", 1337), "Nahrung.Supermarkt");
        expenseManager.addExpense(new Expense("Orange", 299), "Nahrung.Supermarkt.Obst");
        expenseManager.addExpense(new Expense("Weihnachtsmarkt", 350), "Nahrung");
        expenseManager.addExpense(new Expense("Mallorca", 60000), "Freizeit.Reise");
        expenseManager.addExpense(new Expense("Jogginghose", 3500), "Freizeit.Fitness");
        expenseManager.addExpense(new Expense("FitX", 2400), "Freizeit.Fitness");
        expenseManager.addExpense(new Expense("Miete Januar", 80000), "Wohnung.Miete");
        expenseManager.addExpense(new Expense("Vattenfall Januar", 2500), "Wohnung.Nebenkosten.Strom");
        expenseManager.addExpense(new Expense("WLAN Januar", 5400), "Wohnung.Nebenkosten.WLAN");


        System.out.println("Baum nach Ausgaben:");
        expenseManager.print();
    }
}
