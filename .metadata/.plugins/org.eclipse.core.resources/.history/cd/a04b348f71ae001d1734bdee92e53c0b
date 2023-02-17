import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToDoListGUI {
    private JFrame frame;
    private JTextField textField;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private ArrayList<String> tasks;

    public ToDoListGUI() {
        tasks = new ArrayList<String>();
        listModel = new DefaultListModel<String>();
        taskList = new JList<String>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(taskList);
        textField = new JTextField(20);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editTask();
            }
        });

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(textField);
        inputPanel.add(addButton);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.PAGE_START);
        frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);
    }

    private void addTask() {
        String task = textField.getText();
        if (!task.isEmpty()) {
            tasks.add(task);
            listModel.addElement(task);
            textField.setText("");
        }
    }

    private void removeTask() {
        int index = taskList.getSelectedIndex();
        if (index >= 0) {
            String task = tasks.get(index);
            tasks.remove(index);
            listModel.remove(index);
            JOptionPane.showMessageDialog(frame, "Task removed: " + task);
        }
    }

    private void editTask() {
        int index = taskList.getSelectedIndex();
        if (index >= 0) {
            String task = tasks.get(index);
            String newTask = JOptionPane.showInputDialog(frame, "Edit task:", task);
            if (newTask != null && !newTask.isEmpty()) {
                tasks.set(index, newTask);
                listModel.set(index, newTask);
                JOptionPane.showMessageDialog(frame, "Task edited: " + task + " -> " + newTask);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToDoListGUI();
            }
        });
    }
}
