package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UI extends JFrame {

    private JTextArea outputArea;
    private JButton speakButton;

    public UI() {
        setTitle("Speech Recognition Tool");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // Text Area for displaying output
        outputArea = new JTextArea();
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Serif", Font.PLAIN, 16));
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Speak Button
        speakButton = new JButton("🎤 Speak");
        speakButton.setFont(new Font("Arial", Font.BOLD, 18));
        speakButton.setBackground(new Color(30, 144, 255));
        speakButton.setForeground(Color.WHITE);
        speakButton.setFocusPainted(false);

        speakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speakButton.setEnabled(false);
                outputArea.setText("Listening...");

                new Thread(() -> {
                    SpeechListener listener = new SpeechListener();
                    String query = listener.listen();

                    if (query == null || query.trim().isEmpty()) {
                        outputArea.setText("Could not understand. Please try again.");
                        Speaker.speak("Could not understand. Please try again.");
                    } else {
                        outputArea.setText("You said: " + query + "\nSearching...");
                        String result = WebSearcher.search(query);
                        outputArea.append("\n\nResult:\n" + result);
                        Speaker.speak(result);
                        DatabaseLogger.logQuery(query, result);
                    }

                    speakButton.setEnabled(true);
                }).start();
            }
        });

        // Add components to layout
        add(scrollPane, BorderLayout.CENTER);
        add(speakButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UI ui = new UI();
            ui.setVisible(true);
        });
    }
}
