import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private String title;
    public LibraryItem(String title) {
        this.title = title;
    }
}
public String getTitle() {
    return title;
}

public abstract int getBorrowingPeriod();

public LocalDate calculateDueDate(LocalDate currentDate) {
    return currentDate.plusDays(getBorrowingPeriod());
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }
    @Override
    public int getBorrowingPeriod() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }
    @Override
    public int getBorrowingPeriod() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }
    @Override
    public int getBorrowingPeriod() {
        return 3;
    }
}

public class LibraryDateCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-DD");
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            int firstSpace = line.indexOf(' ');
            if (firstSpace == -1) {
                continue;
            }

            String type = line.substring(0, firstSpace);
            int startQuote = line.indexOf('"');
            int endQuote = line.lastIndexOf('"');

            String title = (startQuote != -1 && endQuote > startQuote) ? line.substring(startQuote + 1, endQuote) : line.substring(firstSpace + 1).trim();

            switch (type) {
                case "BOOK":
                items.add(new Book(title));
                break;
                case "DVD":
                items.add(new DVD(title));
                break;
                case "MAGAZINE":
                items.add(new Magazine(title));
                break;
            }
        }

        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.println(item.getTitle() + ": " + dueDate);
        }

        scanner.close();
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            