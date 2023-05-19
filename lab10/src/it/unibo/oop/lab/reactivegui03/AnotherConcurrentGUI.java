package it.unibo.oop.lab.reactivegui03;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AnotherConcurrentGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.1;
    private static final long WAITING_TIME = TimeUnit.SECONDS.toMillis(10);
    private final JLabel display = new JLabel();
    private final JButton up = new JButton("up");
    private final JButton down = new JButton("down");
    private final JButton stop = new JButton("stop");

    private final Agent agent = new Agent();

    /**
     * Builds a new CGUI.
     */
    public AnotherConcurrentGUI() {
        super();
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        panel.add(display);
        panel.add(up);
        panel.add(down);
        panel.add(stop);
        this.getContentPane().add(panel);
        this.setVisible(true);
        /*
         * Create the counter agent and start it. This is actually not so good:
         * thread management should be left to
         * java.util.concurrent.ExecutorService
         */

        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                agent.countUp();
            }
        });

        down.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                agent.countDown();
            }
        });

        stop.addActionListener(new ActionListener() {
            /**
             * event handler associated to action event on button stop.
             * 
             * @param e
             *            the action event that will be handled by this listener
             */
            @Override
            public void actionPerformed(final ActionEvent e) {
                // Agent should be final
                agent.stopCounting();
                stop.setEnabled(false);
                down.setEnabled(false);
                up.setEnabled(false);
            }
        });

        new Thread(agent).start();
        new Thread(() -> {
            try {
                Thread.sleep(WAITING_TIME);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.stopCounting();
        }).start();
    }

    private void stopCounting() {
        agent.stopCounting();
        SwingUtilities.invokeLater(() -> {
            stop.setEnabled(false);
            up.setEnabled(false);
            down.setEnabled(false);
        });
    }

    private class Agent implements Runnable {
        /*
         * Stop is volatile to ensure visibility. Look at:
         * 
         * http://archive.is/9PU5N - Sections 17.3 and 17.4
         * 
         * For more details on how to use volatile:
         * 
         * http://archive.is/4lsKW
         * 
         */
        private volatile boolean stop;
        private volatile int counter;
        private volatile boolean up = true;

        @Override
        public void run() {
            while (!this.stop) {
                try {
                    counter += up ? 1 : -1;
                    /*
                     * All the operations on the GUI must be performed by the
                     * Event-Dispatch Thread (EDT)!
                     */
                    final var todisplay = Integer.toString(counter);
                    SwingUtilities.invokeLater(() -> display.setText(todisplay));
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    /*
                     * This is just a stack trace print, in a real program there
                     * should be some logging and decent error reporting
                     */
                    ex.printStackTrace();
                }
            }
        }

        public void countUp() {
            up = true;
        }

        public void countDown() {
            up = false;
        }
        /**
         * External command to stop counting.
         */
        public void stopCounting() {
            this.stop = true;
        }
    }
}
