//this app is a Java applet for a stopwatch
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Stopwatch extends JApplet{

  private int numSecs;
  private Timer timer; //to reference a timer obj
  private final int DELAY = 1000;

  private JPanel buttonPanel;
  private JPanel timePanel;

  private JButton startButton;
  private JButton stopButton;
  private JButton clearButton;

  private JTextField time;
  private JLabel message;

  private Container contentPane; //to reference the content panel

  //init method
  public void init(){
    //set background
    getContentPane();
    //build button panel
    buildButtonPanel();
    //build textfield
    buildTimePanel();
    //add buttons text to content panel
    add(buttonPanel, BorderLayout.SOUTH);
    add(timePanel, BorderLayout.CENTER);
    //crate a new timer obj;
    timer = new Timer(DELAY, new TimerListener());
  }

  private void buildButtonPanel(){
    //create the panel
    buttonPanel = new JPanel();
    //create the buttons
    startButton = new JButton("Start");
    stopButton = new JButton("Stop");
    clearButton = new JButton("Clear");
    //add action listeners
    startButton.addActionListener(new StartButtonListener());
    stopButton.addActionListener(new StopButtonListener());
    clearButton.addActionListener(new ClearButtonListener());
    //set layout
    buttonPanel.setLayout(new GridLayout(1, 3));
    //add buttons
    buttonPanel.add(startButton);
    buttonPanel.add(stopButton);
    buttonPanel.add(clearButton);
  }

  private void buildTimePanel(){
    //create the panel
    timePanel = new JPanel();
      //create a lable to display message
    message = new JLabel("Time");
    //create a text field for time
    time = new JTextField(10);
    time.setEditable(false);
    time.setText("0");
    //create the layout
    timePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    //add label
    timePanel.add(message);
    timePanel.add(time);
  }

  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      numSecs++;
      time.setText(String.valueOf(numSecs));
    }
  }

  private class StartButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      timer.start();

    }
  }
  private class StopButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      timer.stop();
    }
  }

  private class ClearButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      timer.stop();
      numSecs = 0;
      time.setText("0");

    }
  }

  public static void main(String[] args){

  }
}
