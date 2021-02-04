package flames_gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTextField;
public class Flames implements ActionListener{
    JFrame ff = new JFrame();
    JTextField firstNameField = new JTextField();
    JTextField secondNameField = new JTextField();
    JButton exitButton = new JButton("x");
    JLabel closeLabel = new JLabel("CLOSE");
    JLabel flamesLabel = new JLabel("F  L  A  M  E  S");
    JLabel yourNameLabel = new JLabel("YOUR NAME:");
    JLabel patNameLabel = new JLabel("PARTNER'S NAME:");
    JButton resultButton = new JButton("SHOW RELATION >_<");
    JLabel resultLabel = new JLabel();
    JSeparator js = new JSeparator();
    Flames(){
    ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ff.setUndecorated(true);
    ff.setVisible(true);
    ff.setSize(500,250);
    ff.setLayout(null);
    ff.setLocationRelativeTo(null);
    ff.setTitle("FLAMES");
    ff.setResizable(false);
    ff.getContentPane().setBackground(new Color(0xffe8e8));

    flamesLabel.setBounds(108,10,400,50);
    flamesLabel.setFont(new Font("Calibri",Font.PLAIN,50));
    flamesLabel.setForeground(new Color(0xad6c80));

    closeLabel.setBounds(449,25,50,27);
    closeLabel.setFont(new Font("Calibri",Font.PLAIN,13));
    closeLabel.setForeground(new Color(0xad6c80));

    yourNameLabel.setBounds(107,85,250,27);
    yourNameLabel.setFont(new Font("Calibri",Font.PLAIN,24));
    yourNameLabel.setForeground(new Color(0xad6c80));

    patNameLabel.setBounds(54,125,250,27);
    patNameLabel.setFont(new Font("Calibri",Font.PLAIN,24));
    patNameLabel.setForeground(new Color(0xad6c80));

    resultLabel.setBounds(120,220,300,27);
    resultLabel.setFont(new Font("Calibri",Font.PLAIN,24));
    resultLabel.setForeground(new Color(0xff9292));

    firstNameField.setBounds(248,81,200,27);
    firstNameField.setBorder(null);
    firstNameField.setFont(new Font("Calibri",Font.PLAIN,24));
    firstNameField.setBackground(new Color(0xffdcdc));
    firstNameField.setForeground(new Color(0xad6c80));

    secondNameField.setBounds(248,121,200,27);
    secondNameField.setBorder(null);
    secondNameField.setFont(new Font("Calibri",Font.PLAIN,24));
    secondNameField.setBackground(new Color(0xffdcdc));
    secondNameField.setForeground(new Color(0xad6c80));
    
    exitButton.setFocusable(false);
    exitButton.setBounds(440,15,50,27);
    exitButton.setFont(new Font("Calibri",Font.PLAIN,24));
    exitButton.setForeground(new Color(0xad6c80));
    exitButton.setBackground(new Color(0xffe8e8));
    exitButton.setOpaque(false);
    exitButton.setBorderPainted(false);
    exitButton.addActionListener(this);

    resultButton.setFocusable(false);
    resultButton.setBounds(53,167,395,37);
    resultButton.setFont(new Font("Calibri",Font.PLAIN,22));
    resultButton.setForeground(new Color(0xad6c80));
    resultButton.setBackground(new Color(0xffdcdc));
    resultButton.setBorder(BorderFactory.createEmptyBorder(9,0,0,0));
    resultButton.addActionListener(this);
    
    js.setOrientation(SwingConstants.HORIZONTAL);
    js.setBounds(50,55,400,100);
    js.setBorder(null);
    js.setForeground(new Color(0xffdcdc));
    ff.add(firstNameField);
    ff.add(secondNameField);
    ff.add(closeLabel);
    ff.add(exitButton);
    ff.add(resultButton);
    ff.add(flamesLabel);
    ff.add(yourNameLabel);
    ff.add(patNameLabel);
    ff.add(resultLabel);
    ff.add(js);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exitButton){
            System.exit(0);
        }
        if(e.getSource()==resultButton){
            if(firstNameField.getText().length()==0 || secondNameField.getText().length()==0 ){
                JOptionPane.showMessageDialog(null, "Names cannot be empty!");
            }
            else{
                //Yahan se shuru main logic.
                String gname = firstNameField.getText().toUpperCase();
                String bname = secondNameField.getText().toUpperCase();
                StringBuilder name1 = new StringBuilder(gname);
                StringBuilder name2 = new StringBuilder(bname);
                for(int i =0;i<gname.length();i++) {
                    for(int j=0;j<bname.length();j++) {
                        if(name1.charAt(i)==(name2.charAt(j))) {
                            name1.replace(i,i+1,"#");
                            name2.replace(j,j+1,"#");
                        }
                    }
                }

                //Random string BS
                String tempG = name1.toString();
		        String tempB = name2.toString();
		        String firstName = tempG.replace("#","");
		        String secondName = tempB.replace("#","");
                String fname = firstName+secondName;
                
                int fcount = fname.length();
		        StringBuilder flames = new StringBuilder("FLAMES");
                String result = "";
                

                //Ye wala flames non gui ke time likha tha, magar ab nai pata kya chal rha hai. IT JUST WORKS!
                while(flames.length()!=1) {
                    int index = fcount%flames.length();
                    if(index!=0) {
                        result = flames.substring(index)+flames.substring(0,index-1);
                    }
                    else
                        result = flames.substring(0,flames.length()-1);
                    flames = new StringBuilder(result);
                }

                //Fir toh GG ekdum!
                switch(result.charAt(0)){
                case 'F':
                    resultLabel.setBounds(120,220,300,27);
                    resultLabel.setText("Friends! with? bene...XD");
	                break;
                case 'L':
                    resultLabel.setBounds(175,220,300,27);
                    resultLabel.setText("Love! Moh Maya.");

	                break;
                case 'A':
                    resultLabel.setBounds(120,220,300,27);
                    resultLabel.setText("Affection! Hmmm..acha..thik!");
	                break;
                case 'M':
                    resultLabel.setBounds(120,220,300,27);
                    resultLabel.setText("Marriage! Ayye! Congrats.");
	                break;
                case 'E':
                    resultLabel.setBounds(145,220,300,27);
                    resultLabel.setText("Enemy! KHATAM BC!");
	                break;
                case 'S':
                    resultLabel.setBounds(155,220,300,27);
                    resultLabel.setText("Siblings! Sed LYFE -_-");
	                break;        
	            }
            }
        }
    }
}