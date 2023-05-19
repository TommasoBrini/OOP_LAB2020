package it.unibo.oop.lab.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller;
    /*
     * Once the Controller is done, implement this class in such a way that:
     * 
     * 1) I has a main method that starts the graphical application
     * 
     * 2) In its constructor, sets up the whole view
     * 
     * 3) The graphical interface consists of a JTextField in the upper part of the frame, 
     * a JTextArea in the center and two buttons below it: "Print", and "Show history". 
     * SUGGESTION: Use a JPanel with BorderLayout
     * 
     * 4) By default, if the graphical interface is closed the program must exit
     * (call setDefaultCloseOperation)
     * 
     * 5) The behavior of the program is that, if "Print" is pressed, the
     * controller is asked to show the string contained in the text field on standard output. 
     * If "show history" is pressed instead, the GUI must show all the prints that
     * have been done to this moment in the text area.
     * 
     */

    /**
     * builds a new {@link SimpleGUI}.
     * @param controller
     */
    public SimpleGUI(final Controller controller) {
        this.controller = controller;
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        final JButton print = new JButton("Print");
        buttonPanel.add(print);
        final JButton show = new JButton("Show history");
        buttonPanel.add(show);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                SimpleGUI.this.controller.setNextStringToPrint(textField.getText());
                SimpleGUI.this.controller.printCurrentString();
            }
        });

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                textArea.setText("");
                final List<String> history = SimpleGUI.this.controller.getHistoryOfPrintedStrings();
                for (final String s : history) {
                    textArea.setText(textArea.getText() + "\n" + s);
                }
            }
        });

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         *  Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);

        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(final String... args) {
        final Controller controller = new ControllerImpl();
        new SimpleGUI(controller).display();
     }
}