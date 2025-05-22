import javax.swing.*;
import java.awt.*;

public class JListExample {
    public static void main(String[] args) {
        // Create a JFrame (main window)
        JFrame frame = new JFrame("Library Book List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Sample data for the JList
        DefaultListModel books = new DefaultListModel<>();
        books.addElement("Sherlock Holmes by Arthur Conan Doyle");
        books.addElement("Harry Potter by J.K. Rowling");
        books.addElement("Twilight by Stephenie Meyer");
        books.addElement("Batman by Christopher Nolan");
        
        // Create a JList to display the books
        JList<String> bookList = new JList<>(books);
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bookList.setVisibleRowCount(5); // Number of visible rows
        
        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        JButton edit = new JButton("Edit");
        add.addActionListener(e -> {
        	String book = JOptionPane.showInputDialog(null, "Enter the book name: ");
        	if (book != null)
        		books.addElement(book);
        });
        
        remove.addActionListener(e -> {
        	int index = bookList.getSelectedIndex();
        	if (index != -1)
        		books.remove(index);
        });
        
        edit.addActionListener(e -> {
        	int index = bookList.getSelectedIndex();
        	if (index != -1) {
        		String book = JOptionPane.showInputDialog(null, "What changes would you like to do with the book?");
        		books.remove(index);
        		books.insertElementAt(book, index);
        	}	
        });
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(add, BorderLayout.NORTH);
        panel.add(edit, BorderLayout.CENTER);
        panel.add(remove, BorderLayout.SOUTH);

        // Add the JList to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(bookList);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        // Display the frame
        frame.setVisible(true);
    }
}
