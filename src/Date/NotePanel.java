package Date;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class NotePanel extends JPanel {

    private Frame frame;

    private JButton ok, cancel;

    private JTextField text;

    private JLabel l;

    private JLabel c;

    private GregorianCalendar calendar;

    private TreeMap<String, ArrayList<String>> myMap;

    public  NotePanel(Frame frame, TreeMap<String, ArrayList<String>> myMap){

        setLayout(new BorderLayout());

        this.frame = frame;

        this.myMap = myMap;

        calendar = new GregorianCalendar();

        l = new JLabel("Today");

        l.setFont(new Font("Arial",Font.PLAIN,24));

        add(l,BorderLayout.NORTH);

         c = new JLabel("No Event");

        c.setFont(new Font("Arial",Font.PLAIN,18));

        add(c,BorderLayout.CENTER);

        currentEvent();

        Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {

               currentEvent();
            }
        });

        timer.start();
    }

    public void currentEvent(){

        StringBuilder key = new StringBuilder();

        ArrayList<String> notes = null;

        Set<String> keys = myMap.keySet();

        Iterator<String> iterator = keys.iterator();

        LocalTime localTime = LocalTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("a");

        if(keys.size() == 0){

            c.setText("No Events");
        }

        while (iterator.hasNext()) {

            key.append(iterator.next());

            notes = myMap.get(key.toString());

            if(key.toString().equals(calendar.get(Calendar.YEAR) + " 0" + (calendar.get(Calendar.MONTH) + 1) + " 0" + calendar.get(Calendar.DAY_OF_MONTH)) || key.toString().equals(calendar.get(Calendar.YEAR) + " 0" + (calendar.get(Calendar.MONTH) + 1) + " " + calendar.get(Calendar.DAY_OF_MONTH)) || key.toString().equals(calendar.get(Calendar.YEAR) + " " + (calendar.get(Calendar.MONTH) + 1) + " 0" + calendar.get(Calendar.DAY_OF_MONTH)) || key.toString().equals(calendar.get(Calendar.YEAR) + " " + (calendar.get(Calendar.MONTH) + 1) + " " + calendar.get(Calendar.DAY_OF_MONTH))){

                if ((calendar.get(Calendar.MONTH) + 1 < 10)) {

                    if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {

                        for (String i : notes) {

                            if ((localTime.format(dateTimeFormatter).equals("AM")) && i.substring(9, 11).equals("Pm") || i.substring(0, 11).compareTo((calendar.get(Calendar.HOUR) + 1) + " : " + calendar.get(Calendar.MINUTE) + " Am") <= 0 || i.substring(0, 11).compareTo((calendar.get(Calendar.HOUR) + 1) + " : " + calendar.get(Calendar.MINUTE) + " Pm") <= 0) {

                                c.setText(i.substring(0, 11) + " - " + i.substring(11) + "\n");

                                break;
                            }
                        }

                    } else {

                        for (String i : notes) {

                            if ((localTime.format(dateTimeFormatter).equals("AM")) && i.substring(9, 11).equals("Pm") || i.substring(0, 11).compareTo((calendar.get(Calendar.HOUR) + 1) + " : " + calendar.get(Calendar.MINUTE) + " Am") <= 0 || i.substring(0, 11).compareTo((calendar.get(Calendar.HOUR) + 1) + " : " + calendar.get(Calendar.MINUTE) + " Pm") <= 0) {

                                c.setText(i.substring(0, 11) + " - " + i.substring(11) + "\n");

                                break;
                            }
                        }

                    }

                } else {

                    if ((calendar.get(Calendar.YEAR) + " " + (calendar.get(Calendar.MONTH) + 1) + " 0" + calendar.get(Calendar.DAY_OF_MONTH)).equals(key.toString())) {

                        for (String i : notes) {

                            if ((localTime.format(dateTimeFormatter).equals("AM")) && i.substring(9, 11).equals("Pm") || i.substring(0, 11).compareTo((calendar.get(Calendar.HOUR) + 1) + " : " + calendar.get(Calendar.MINUTE) + " Am") <= 0 || i.substring(0, 11).compareTo((calendar.get(Calendar.HOUR) + 1) + " : " + calendar.get(Calendar.MINUTE) + " Pm") <= 0) {

                                c.setText(i.substring(0, 11) + " - " + i.substring(11) + "\n");

                                break;
                            }
                        }
                    } else {

                        for (String i : notes) {

                            if ((localTime.format(dateTimeFormatter).equals("AM")) && i.substring(9, 11).equals("Pm") || i.substring(0, 11).compareTo((calendar.get(Calendar.HOUR) + 1) + " : " + calendar.get(Calendar.MINUTE) + " Am") <= 0 || i.substring(0, 11).compareTo((calendar.get(Calendar.HOUR) + 1) + " : " + calendar.get(Calendar.MINUTE) + " Pm") <= 0) {

                                c.setText(i.substring(0, 11) + " - " + i.substring(11) + "\n");

                                break;
                            }
                        }

                    }
                }
            }
            key.setLength(0);
        }
    }
}
