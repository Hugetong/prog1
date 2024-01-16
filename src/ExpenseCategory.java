import java.util.ArrayList;
import java.util.List;

class ExpenseCategory {
    private String name;
    private List<Expense> expenses;
    private List<ExpenseCategory> unterCategories;

    public ExpenseCategory(String name) {
        this.name = name;
        expenses = new ArrayList<>();
        unterCategories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<ExpenseCategory> getUnterCategories() {
        return unterCategories;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void addUnterCategory(ExpenseCategory unterCategory) {
        unterCategories.add(unterCategory);
    }

    public ExpenseCategory getUnterCategory(String name) {
        for (ExpenseCategory unterCategory : unterCategories) {
            if (unterCategory.getName().equals(name)) {
                return unterCategory;
            }
        }

        return null;
    }

    public int getSum() {
        int sum = 0;

        for (Expense expense : expenses) {
            sum += expense.getValue();
        }

        for (ExpenseCategory unterCategory : unterCategories) {
            sum += unterCategory.getSum();
        }

        return sum;
    }

}