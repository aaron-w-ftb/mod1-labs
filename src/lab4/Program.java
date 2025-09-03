package lab4;

public class Program {
    public static void main(String[] args) {
        System.out.println("Lab 4: Loops and Arrays\n");
        
        // Array operations
        System.out.println("Array Operations");
        int[] numbers = {1, 3, -5, 7, 0, 4, 6, 8};
        
        System.out.println("Array: {1, 3, -5, 7, 0, 4, 6, 8}");
        System.out.println("Sum: " + findSum(numbers));
        System.out.println("Average: " + findAverage(numbers));
        System.out.println("Minimum: " + findMinimum(numbers));
        System.out.println("Maximum: " + findMaximum(numbers));
        System.out.println("Index of zero: " + findIndexOfZero(numbers));
        
        // Student grades
        System.out.println("\nStudent Grades");
        processStudentGrades();
        
        // Investment calculator
        System.out.println("\nInvestment Calculator");
        calculateInvestmentGrowth();
        
        // Multiplication table
        System.out.println("\nMultiplication Table");
        multiplicationTable();
    }
    
    // Array Operations
    public static int findSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    
    public static double findAverage(int[] array) {
        return (double) findSum(array) / array.length;
    }
    
    public static int findMinimum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    
    public static int findMaximum(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    public static int findIndexOfZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    
    // Student Grades Processing
    public static String getGrade(int mark) {
        if (mark < 1 || mark > 100) {
            return "Error: marks must be between 1-100";
        }
        else if (mark < 50) {
            return "Fail";
        }
        else if (mark >= 50 && mark <= 60) {
            return "Pass";
        }
        else if (mark >= 61 && mark <= 70) {
            return "Merit";
        }
        else {
            return "Distinction";
        }
    }
    
    public static void processStudentGrades() {
        String[] students = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        int[] marks = {85, 42, 67, 91, 58};
        
        System.out.println("Student Grades:");
        for (int i = 0; i < students.length; i++) {
            String grade = getGrade(marks[i]);
            System.out.println(students[i] + ": " + marks[i] + " - " + grade);
        }
    }
    
    // Investment growth Calculator
    public static void calculateInvestmentGrowth() {
        double initialMoney = 100.0;
        double currentMoney = initialMoney;
        double interestRate = 0.05;
        double targetAmount = 200.0;
        int years = 0;
        
        System.out.println("Initial investment: £" + initialMoney);
        System.out.println("Interest rate: " + (interestRate * 100) + "%");
        System.out.println("Target amount: £" + targetAmount);
        System.out.println();
        
        while (currentMoney < targetAmount) {
            years++;
            currentMoney = currentMoney * (1 + interestRate);
            System.out.println("Year " + years + ": £" + String.format("%.2f", currentMoney));
        }
        
        System.out.println("\nIt takes " + years + " years to double your money from £" + 
                          initialMoney + " to £" + String.format("%.2f", currentMoney));
    }
    
    // Multiplication Table (nested loops)
    public static void multiplicationTable() {
        System.out.println("Multiplication Table (1-10):");
        System.out.println();
        
        // Header row
        System.out.print("   ");
        for (int col = 1; col <= 10; col++) {
            System.out.printf("%4d", col);
        }
        System.out.println();
        
        // Multiplication table rows
        for (int row = 1; row <= 10; row++) {
            System.out.printf("%2d ", row);
            for (int col = 1; col <= 10; col++) {
                System.out.printf("%4d", row * col);
            }
            System.out.println();
        }
        
        System.out.println("\nTip: This uses nested for loops (outer loop for rows, inner loop for columns)");
        System.out.println("The printf(\"%4d\", col * row) formats each number in 4 spaces for alignment");
    }
}