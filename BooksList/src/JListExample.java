import javax.swing.*;
import java.awt.*;

public class JListExample {
    public static void main(String[] args) {
        // Set a modern look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        // Create a JFrame (main window)
        JFrame frame = new JFrame("📚 Library Book List Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Title label
        JLabel title = new JLabel("Manage Your Book List", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Sample data for the JList
        DefaultListModel<String> books = new DefaultListModel<>();
        books.addElement("Sherlock Holmes by Arthur Conan Doyle");
        books.addElement("Harry Potter by J.K. Rowling");
        books.addElement("Twilight by Stephenie Meyer");
        books.addElement("Batman by Christopher Nolan");

        // Create a JList to display the books
        JList<String> bookList = new JList<>(books);
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bookList.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(bookList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Book List"));

        // Buttons
        JButton add = new JButton("➕ Add");
        JButton remove = new JButton("🗑️ Remove");
        JButton edit = new JButton("✏️ Edit");

        // Add button functionality
        add.addActionListener(e -> {
            String book = JOptionPane.showInputDialog(frame, "Enter the book name:", "Add Book", JOptionPane.PLAIN_MESSAGE);
            if (book != null && !book.trim().isEmpty()) {
                books.addElement(book.trim());
            } else {
                JOptionPane.showMessageDialog(frame, "Book name cannot be empty!", "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Remove button functionality
        remove.addActionListener(e -> {
            int index = bookList.getSelectedIndex();
            if (index != -1) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Remove selected book?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    books.remove(index);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a book to remove.", "No Selection", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Edit button functionality
        edit.addActionListener(e -> {
            int index = bookList.getSelectedIndex();
            if (index != -1) {
                String current = books.getElementAt(index);
                String updated = JOptionPane.showInputDialog(frame, "Edit the book name:", current);
                if (updated != null && !updated.trim().isEmpty()) {
                    books.set(index, updated.trim());
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a book to edit.", "No Selection", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(add);
        buttonPanel.add(edit);
        buttonPanel.add(remove);

        // Frame layout
        frame.add(title, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
