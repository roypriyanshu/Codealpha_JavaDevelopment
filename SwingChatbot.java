import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SwingChatbot extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private HashMap<String, String> responses;

    public SwingChatbot() {
        setTitle("AI Chatbot - Java Swing");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        initializeResponses();

        // Send message on button click or ENTER key
        sendButton.addActionListener(e -> processInput());
        inputField.addActionListener(e -> processInput());

        setVisible(true);
    }

    private void initializeResponses() {
        responses = new HashMap<>();
        responses.put("hi", "Hello! How can I help you today?");
        responses.put("hello", "Hi there! What would you like to know?");
        responses.put("how are you", "I'm doing great, thank you!");
        responses.put("your name", "I'm your AI assistant built with Java.");
        responses.put("bye", "Goodbye! See you soon.");
        responses.put("help", "You can ask about weather, time, or general questions.");
        responses.put("thanks", "You're welcome!");
        responses.put("thank you", "My pleasure!");
        responses.put("what's the weather today", "Assuming a sunny day with a pleasant breeze!");
        responses.put("is it raining", "Looks clear for now! You might want to check your local forecast.");
        responses.put("hot outside", "It depends on your location, but remember to stay hydrated!");
        responses.put("cold", "Bundle up! Cold weather calls for cozy clothes.");
        responses.put("stock market", "The stock market is where buyers and sellers trade company shares.");
        responses.put("what is a stock", "A stock is a share in the ownership of a company.");
        responses.put("buy stocks", "To buy stocks, you need a brokerage account. Research before investing!");
        responses.put("stock tips", "Diversify your portfolio, and don't follow trends blindly.");
        responses.put("share price", "I can't check live prices now. Please use a financial website or app.");
        responses.put("how is the market today","Market status varies throughout the day. Check with an official source.");
        responses.put("best stocks", "It depends on your goals. Consider tech, energy, or healthcare sectors.");

    }

    private void processInput() {
        String userInput = inputField.getText().toLowerCase().trim();
        appendChat("You: " + userInput);
        inputField.setText("");

        String response = getResponse(userInput);
        appendChat("Bot: " + response);
    }

    private void appendChat(String message) {
        chatArea.append(message + "\n");
    }

    // Basic NLP: normalize and match
    private String getResponse(String input) {
        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                return responses.get(key);
            }
        }

        // Unknown input
        return "Sorry, I didn't understand that. Try asking something else!";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingChatbot::new);
    }
}