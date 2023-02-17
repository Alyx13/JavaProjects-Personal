import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Notepad extends JFrame {

  // Text area
  private JTextArea textArea = new JTextArea();

  // File menu
  private JMenu fileMenu = new JMenu("File");
  private JMenuItem newMenuItem = new JMenuItem("New");
  private JMenuItem openMenuItem = new JMenuItem("Open");
  private JMenuItem saveMenuItem = new JMenuItem("Save");
  private JMenuItem exitMenuItem = new JMenuItem("Exit");

  // Edit menu
  private JMenu editMenu = new JMenu("Edit");
  private JMenuItem cutMenuItem = new JMenuItem("Cut");
  private JMenuItem copyMenuItem = new JMenuItem("Copy");
  private JMenuItem pasteMenuItem = new JMenuItem("Paste");

  // Search menu
  private JMenu searchMenu = new JMenu("Search");
  private JMenuItem findMenuItem = new JMenuItem("Find");
  private JMenuItem replaceMenuItem = new JMenuItem("Replace");

  // Constructor
  public Notepad() {
    // Set the title
    setTitle("Java Notepad");

    // Set the size
    setSize(800, 600);

    // Center the frame
    setLocationRelativeTo(null);

    // Add the text area to the frame
    add(textArea, BorderLayout.CENTER);

    // Create the menu bar
    JMenuBar menuBar = new JMenuBar();

    // Add the file menu to the menu bar
    menuBar.add(fileMenu);

    // Add the edit menu to the menu bar
    menuBar.add(editMenu);

    // Add the search menu to the menu bar
    menuBar.add(searchMenu);

    // Add the menu items to the file menu
    fileMenu.add(newMenuItem);
    fileMenu.add(openMenuItem);
    fileMenu.add(saveMenuItem);
    fileMenu.addSeparator();
    fileMenu.add(exitMenuItem);

    // Add the menu items to the edit menu
    editMenu.add(cutMenuItem);
    editMenu.add(copyMenuItem);
    editMenu.add(pasteMenuItem);

    // Add the menu items to the search menu
    searchMenu.add(findMenuItem);
    searchMenu.add(replaceMenuItem);

    // Add the menu bar to the frame
    setJMenuBar(menuBar);

    // Add a window listener to the frame
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        exitMenuItem.doClick();
      }
    });

    // Add an action listener to the new menu item
    newMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        textArea.setText("");
      }
    });

 // Add an action listener to the open menu item
    openMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();

        // Show the file chooser and wait for the user's response
        int result = fileChooser.showOpenDialog(Notepad.this);

        // If the user clicked the "Open" button
        if (result == JFileChooser.APPROVE_OPTION) {
          // Get the selected file
          java.io.File file = fileChooser.getSelectedFile();

          // Read the contents of the file into the text area
          try {
            textArea.setText(new String(java.nio.file.Files.readAllBytes(file.toPath())));
          } catch (java.io.IOException ex) {
            ex.printStackTrace();
          }
        }
      }
    });
  }
}
