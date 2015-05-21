package com.velvet.m.client;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by ake on 5/20/15.
 */
public class AkeView implements ActionListener, GameView {

    private JFrame frame;

    private JPanel topPanel;        //goes top    - no idea...
    private JLabel centerLabel;     //goes center - main board game?
    private JPanel leftPanel;       //goes left   - status of game?
    private JPanel rightPanel;      //goes right  - control?
    private JPanel bottomPanel;     //goes bottom - server txt + chat?
    private JButton joinButton;
    private JButton rollButton;
    private JButton startButton;
    private JPanel controlButtonsPanel;

    protected JTextField chatInputField;
    protected JTextArea chatArea;
    private final static String newline = "\n";

    private PlayerListener playerListener;

    public AkeView() {
        /**
         * Create the GUI and show it.  For thread safety,
         * this method should be invoked from the
         * event dispatch thread.
         */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndDisplayGUI();
            }
        });
    }

    private void createAndDisplayGUI() {
        //1. Create the frame.
        //frame = new JFrame("FrameDemo");
        frame = new JFrame();

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent event) {
            }

            public void keyReleased(KeyEvent event) {
                if (event.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
            public void keyTyped(KeyEvent event) {
            }
        });

        //2. Some frame setup
        Container container = frame.getContentPane();
        JFrame.setDefaultLookAndFeelDecorated(true);
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
        frame.setBackground(Color.black);
        // layout mgr
        container.setLayout(new BorderLayout());


        //3. Create components and put them in the frame.
        //frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        //Top area - no idea...
        //not used for now

        //Center - main game board?
        String path = "img/homer.jpg";
        BufferedImage centerPicture;
        try {
            centerPicture = ImageIO.read(new File(path));
            centerLabel = new JLabel(new ImageIcon(centerPicture));
            centerLabel.setOpaque(true);
            centerLabel.setBackground(Color.black);
            centerLabel.setPreferredSize(new Dimension(2 * (frame.getWidth() / 3), 2 * (frame.getHeight() / 6) - 100)); //w,h
            centerLabel.setFont(new Font("Arial", Font.BOLD, 24));
            centerLabel.setForeground(Color.white);
            } catch (IOException exp) {
            exp.printStackTrace();
            centerLabel = new JLabel();
        }
        container.add(centerLabel, BorderLayout.CENTER);

        /* Left panel - status of game? */
        Dimension leftDimension = new Dimension(frame.getWidth() / 6 + 50, 2 * (frame.getHeight() / 6) - 100); //w, h
        leftPanel = createPanel(leftDimension, Color.black, "Controller status", Color.gray);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        // add some funny things here to go into game status area....
        container.add(leftPanel, BorderLayout.LINE_START);

        /* Right panel - control? */
        Dimension rightDimension = new Dimension(frame.getWidth() / 6, 2 * (frame.getHeight() / 6) - 100);  //w, h
        rightPanel = createPanel(rightDimension, Color.black, "Controller Control and tbd...", Color.gray);
        //rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        //add some control components to the right panel
        Dimension controlButtonsDimension = new Dimension(frame.getWidth()/6 - 50, (frame.getHeight()/6)-50); //w,h
        controlButtonsPanel = createPanel(controlButtonsDimension, Color.black, "Control", Color.gray);
        controlButtonsPanel.setLayout(new GridLayout(3, 1, 10, 10)); //20
        rightPanel.add(controlButtonsPanel);
        joinButton  = addControlButton(controlButtonsPanel, "Join", null /* new ImageIcon("img/join.png")) */);
        startButton = addControlButton(controlButtonsPanel, "Start", null);
        rollButton  = addControlButton(controlButtonsPanel, "Roll", null);
        container.add(rightPanel, BorderLayout.LINE_END);


        //Bottom - server txt + chat?
        Dimension bottomDimension = new Dimension(frame.getWidth(), (frame.getHeight() / 6) + 50); //w, h
        bottomPanel = createPanel(bottomDimension, Color.black, "Chat with team ... somehow", Color.gray);
        //add some input and output components to the bottom panel
        chatInputField = new JTextField(">", 20);
        chatInputField.addActionListener(this);
        chatInputField.setBackground(Color.BLACK);
        chatInputField.setForeground(Color.YELLOW);
        chatArea = new JTextArea(5, 20);
        chatArea.setBackground(Color.BLACK);
        chatArea.setForeground(Color.YELLOW);
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setPreferredSize(new Dimension(frame.getWidth()/ 2, (frame.getHeight() / 6))); //w, h
        bottomPanel.setLayout(new GridLayout(2, 1, 20, 20)); //20
        bottomPanel.add(chatInputField);
        bottomPanel.add(scrollPane);
        container.add(bottomPanel, BorderLayout.PAGE_END);

        //needed?
        frame.validate();

        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);
    }

    private JPanel createPanel(Dimension dim, Color bgColor, String title, Color titleColor) {
        JPanel panel  = new JPanel();
        panel.setPreferredSize(dim); //w, h
        panel.setBackground(bgColor);
        // we don't paint all our bits
        panel.setOpaque(true);
        //Titled borders
        TitledBorder tb;
        tb = BorderFactory.createTitledBorder(title);
        panel.setBorder(tb);
        tb.setTitleColor(titleColor);
        tb.setTitleFont(new Font("Arial", Font.BOLD, 14));
        tb.setTitleJustification(TitledBorder.LEFT);
       return panel;
    }

    private JButton addControlButton(JPanel j, String txt, Icon icon){
        //JButton button = new JButton(icon);
        JButton button = new JButton(txt);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setOpaque(false);
        button.setBorderPainted(true);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setBackground(Color.black);
        button.setForeground(Color.yellow);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        j.add(button);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (playerListener == null) { return; }

        Object source = evt.getSource();
        if (source == chatInputField) {
            String text = chatInputField.getText();
            //clear input
            chatInputField.setText(">");
            playerListener.chatEvent(text);
        } else if (source == rollButton) {
            playerListener.rollEvent();
        } else if (source == joinButton) {
            playerListener.joinEvent();
        } else if (source == startButton) {
            playerListener.startEvent();
        } else {
            // Should never happen. Unknown component. Die.
            assert false;
        }
    }

    @Override
    public void appendChatText(String txt) {
        chatArea.append(txt + newline);
        chatArea.selectAll();
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    public void setPLayerListener(PlayerListener playerListener) {
        if(playerListener == null) throw new NullPointerException("Null PlayerListener");
        this.playerListener = playerListener;
    }
}
