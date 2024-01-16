public class ExpenseManager {
    private ExpenseCategory root;

    public ExpenseManager(){
        root = new ExpenseCategory("root");
    }

    public void createCategory(String name) {
        String[] categories = name.split("\\.");
        ExpenseCategory currentCategory = root;

        for (String categoryName : categories) {
            ExpenseCategory unterCategory = currentCategory.getUnterCategory(categoryName);

            if (unterCategory == null) {
                unterCategory = new ExpenseCategory(categoryName);
                currentCategory.addUnterCategory(unterCategory);
            }

            currentCategory = unterCategory;
        }
    }

    public void addExpense(Expense expense, String category) {
        ExpenseCategory thisCategory = findCategory(category);

        if (thisCategory != null) {
            thisCategory.addExpense(expense);
        }
    }

    public int getSum(String category) {
        ExpenseCategory thisCategory = findCategory(category);

        if (thisCategory != null) {
            return thisCategory.getSum();
        }

        return 0;
    }

    public void print() {
        printCategory(root, 0);
    }

    private ExpenseCategory findCategory(String category) {
        String[] categories = category.split("\\.");
        ExpenseCategory currentCategory = root;

        for (String categoryName : categories) {
            currentCategory = currentCategory.getUnterCategory(categoryName);

            if (currentCategory == null) {
                return null;
            }
        }

        return currentCategory;
    }

    private void printCategory(ExpenseCategory category, int categoryNumber) {
        StringBuilder space = new StringBuilder();

        for (int i = 0; i < categoryNumber; i++) {
            space.append("  ");
        }

        System.out.println(space + "->" + category.getName() + " (" + (category.getSum() / 100.0) + " EUR)");

        for (Expense expense : category.getExpenses()) {
            System.out.println(space + "  -" + expense.toString());
        }

        for (ExpenseCategory unterCategory : category.getUnterCategories()) {
            printCategory(unterCategory, categoryNumber + 1);
        }
    }
}