package go.java;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class RadioMenuItem extends JFrame {

    private JLabel statusbar;

    public RadioMenuItem() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

      /*  statusbar = new JLabel("Easy");
        statusbar.setBorder(BorderFactory.createEtchedBorder());
        add(statusbar, BorderLayout.NORTH);
*/
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(20,20));
 /*  JLabel background=new JLabel(new ImageIcon("ressources/RedCell.png"));
        
        add(background);
        

        background.setLayout(new FlowLayout());*/
        setLayout(new BorderLayout());
       ImageIcon grassIcon = new ImageIcon("ressources/RedCell.png");
       ImageIcon grassIcon2 = new ImageIcon("ressources/Green cell.png");
       JLabel background=new JLabel(new ImageIcon("ressources/Green cell.png"));
       
       // JLabel background=new JLabel(new ImageIcon("ressources/RedCell.png"));
        
      /*  add(background);
        

        background.setLayout(new FlowLayout());*/
        JLabel labels[][] = new JLabel[20][20];
        for(int i=0;i<20;i++){
      	  for(int j=0;j<10;j++){
      	  
      		labels[i][j] = new JLabel(grassIcon );
            centerPanel.add(labels[i][j]);
            //labels[i][j].setLayout(new FlowLayout());
      	  }
        }
       // labels[1][2] = background;
        centerPanel.remove(5);
        //= labels[1][2];
        //labels[1][10] = background;
        //centerPanel.add(labels[1][10]);
        add(centerPanel);
        
        
        pack();
        setVisible(true);
        
        setTitle("JRadioButtonMenuItem");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
        JMenu heatMenu = new JMenu("Heat");
        heatMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenu nutMenu = new JMenu("Nut");
        nutMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenu salinityMenu = new JMenu("Salinity");
        salinityMenu.setMnemonic(KeyEvent.VK_F);
      
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem newMi = new JMenuItem("New");
        JMenuItem openMi = new JMenuItem("Open");
        JMenuItem saveMi = new JMenuItem("Save");

        JMenuItem exitMi = new JMenuItem("Exit");
        exitMi.setToolTipText("Exit application");

        exitMi.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });   
            
            
            
        ButtonGroup difGroup = new ButtonGroup();

        JRadioButtonMenuItem eaRMi = new JRadioButtonMenuItem("Easy");
        eaRMi.setSelected(true);
        heatMenu.add(eaRMi);
       /* nutMenu.add(eaRMi);
        salinityMenu.add(eaRMi);*/
        
        
        eaRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setText("Easy");
            }
        });
        JRadioButtonMenuItem eanutRMi = new JRadioButtonMenuItem("Easy");
        eanutRMi.setSelected(true);
        nutMenu.add(eanutRMi);
        eanutRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setText("Easy");
            }
        });

        JRadioButtonMenuItem meRMi = new JRadioButtonMenuItem("Medium");
        heatMenu.add(meRMi);
        

        meRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setText("Medium");
            }
        });

        JRadioButtonMenuItem menutRMi = new JRadioButtonMenuItem("Medium");
        nutMenu.add(menutRMi);
        menutRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setText("Medium");
            }
        });
        
        
        JRadioButtonMenuItem haRMi = new JRadioButtonMenuItem("Hard");
        heatMenu.add(haRMi);
        //nutMenu.add(haRMi);

        haRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setText("Hard");
            }
        });
        JRadioButtonMenuItem hanutRMi = new JRadioButtonMenuItem("Hard");
         nutMenu.add(hanutRMi);
        //nutMenu.add(haRMi);

        hanutRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setText("Hard");
            }
        });
        

        difGroup.add(eaRMi);
        difGroup.add(meRMi);
        difGroup.add(haRMi);
        
        fileMenu.add(newMi);
        fileMenu.add(openMi);
        fileMenu.add(saveMi);
        fileMenu.addSeparator();
        fileMenu.addSeparator();
        fileMenu.add(exitMi);

        menubar.add(fileMenu);

        menubar.add(heatMenu);
        menubar.add(nutMenu);
        menubar.add(salinityMenu);
        setJMenuBar(menubar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            RadioMenuItem ex = new RadioMenuItem();
            ex.setVisible(true);
        });
    }
}