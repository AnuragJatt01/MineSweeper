/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author anuragsingh
 */
public class MineSweeper extends javax.swing.JFrame {
    
    private final int DIMENSIONS = 8;
    private int BOMB;
    private double WIN_PERCENT;
    private int[][] field;
    private int second;
    private int minute;
    private JButton[][] buttons = new JButton[DIMENSIONS][DIMENSIONS];
    private Timer timer;
    private String player="Player";
    private int score = 0;
    private int counter = 0;
    
    /**
     * Creates new form CampoFiorito
     */
    public MineSweeper() {
        player = jOptionPane1.showInputDialog(this, "Insert name:", "Player Name", jOptionPane1.INFORMATION_MESSAGE);
        String difficultyString = jOptionPane1.showInputDialog(this, "Insert difficulty (1:Easy, 2:Medium, 3:Difficulty):", "Difficulty",jOptionPane1.INFORMATION_MESSAGE);
        if (player != null && difficultyString != null && !difficultyString.isEmpty()) {
            int difficulty = Integer.parseInt(difficultyString);
            initComponents();
            startGame(difficulty);
        } else {
            player = "Player"; 
            int difficulty = 1;
            initComponents();
            startGame(difficulty);
        }
    }
    
    private void startGame(int difficulty){
        buttons_array();
        switch (difficulty) {
            case 1:
                BOMB = 10;
                WIN_PERCENT = 0.5;
                break;
            case 2:
                BOMB = 15;
                WIN_PERCENT = 0.6;
                break;
            case 3:
                BOMB = 20;
                WIN_PERCENT = 0.8;
                break;
            default:
                BOMB = 10;
                WIN_PERCENT = 0.5;
                break;
        }
        field = casualField();
    }
    
    private void buttons_array(){
        int buttonsIndex = 1;
        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                String buttonsName = "button" + buttonsIndex;
                buttons[i][j] = findButton(buttonsName);
                buttonsIndex++;
            }
        }
    }
    
    private JButton findButton(String nome) {
        switch (nome) {
            case "button1":
                return button1;
            case "button2":
                return button2;
            case "button3":
                return button3;
            case "button4":
                return button4;
            case "button5":
                return button5;
            case "button6":
                return button6;
            case "button7":
                return button7;
            case "button8":
                return button8;
            case "button9":
                return button9;
            case "button10":
                return button10;
            case "button11":
                return button11;
            case "button12":
                return button12;
            case "button13":
                return button13;
            case "button14":
                return button14;
            case "button15":
                return button15;
            case "button16":
                return button16;
            case "button17":
                return button17;
            case "button18":
                return button18;
            case "button19":
                return button19;
            case "button20":
                return button20;
            case "button21":
                return button21;
            case "button22":
                return button22;
            case "button23":
                return button23;
            case "button24":
                return button24;
            case "button25":
                return button25;
            case "button26":
                return button26;
            case "button27":
                return button27;
            case "button28":
                return button28;
            case "button29":
                return button29;
            case "button30":
                return button30;
            case "button31":
                return button31;
            case "button32":
                return button32;
            case "button33":
                return button33;
            case "button34":
                return button34;
            case "button35":
                return button35;
            case "button36":
                return button36;
            case "button37":
                return button37;
            case "button38":
                return button38;
            case "button39":
                return button39;
            case "button40":
                return button40;
            case "button41":
                return button41;
            case "button42":
                return button42;
            case "button43":
                return button43;
            case "button44":
                return button44;
            case "button45":
                return button45;
            case "button46":
                return button46;
            case "button47":
                return button47;
            case "button48":
                return button48;
            case "button49":
                return button49;
            case "button50":
                return button50;
            case "button51":
                return button51;
            case "button52":
                return button52;
            case "button53":
                return button53;
            case "button54":
                return button54;
            case "button55":
                return button55;
            case "button56":
                return button56;
            case "button57":
                return button57;
            case "button58":
                return button58;
            case "button59":
                return button59;
            case "button60":
                return button60;
            case "button61":
                return button61;
            case "button62":
                return button62;
            case "button63":
                return button63;
            case "button64":
                return button64;
            default:
                break;
        }
        return null; 
    }
    
    private int[][] casualField() {
        int[][] field = new int[DIMENSIONS][DIMENSIONS];

        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                field[i][j] = 0;
            }
        }

        Random random = new Random();
        int cont = 0;
        while (cont < BOMB) {
            int x = random.nextInt(DIMENSIONS);
            int y = random.nextInt(DIMENSIONS);
            if (field[x][y] != -1) {
                field[x][y] = -1;
                cont++;
            }
        }
        
        System.out.println("Field:");
        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                System.out.print(field[i][j]+"\t");
            }
            System.out.print("\n");
        }
        
        return field;
    }
    
    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                if (second == 60) {
                    second = 0;
                    minute++;
                }
                jLabel3.setText(String.format("%02d:%02d", minute, second));
            }
        });
        timer.start();
    }
    
    private void click(){
        if (second == 0 && minute == 0) { 
            startTimer();
        }
        revealButtons(); 
    }
    
    private void revealButtons() {
        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                JButton button = buttons[i][j];
                if (!button.isSelected() && button.getText().isEmpty()) {
                    if (field[i][j] == -1) {
                        //button.setText("B");
                        button.setForeground(Color.black);
                    } else {
                        int bombNearby = 0;
                        for (int k = i - 1; k <= i + 1; k++) {
                            for (int l = j - 1; l <= j + 1; l++) {
                                if (k >= 0 && k < DIMENSIONS && l >= 0 && l < DIMENSIONS) {
                                    if (field[k][l] == -1) {
                                        bombNearby++;
                                    }
                                }
                            }
                        }
                        if (bombNearby > 0) {
                            switch (bombNearby) {
                                case 1:
                                    button.setForeground(Color.CYAN);
                                    break;
                                case 2:
                                    button.setForeground(Color.yellow);
                                    break;
                                case 3: 
                                    button.setForeground(Color.RED);
                                    break;
                                case 4:
                                    button.setForeground(Color.ORANGE);
                                    break;
                                default:
                                    break;
                            }
                            button.setText(String.valueOf(bombNearby));
                        }
                    }
                }
            }
        }
    }
    
    private void controller(int row, int column) {
        if (field[row][column] == -1) {
            jOptionPane1.showMessageDialog(this,player + " You lost!", "End", jOptionPane1.ERROR_MESSAGE);
            reset();
        } else{
            counter++;
            score += 10;
            jLabel6.setText(String.format("%04d", score));
            if (counter >= ((DIMENSIONS * DIMENSIONS) - BOMB) * WIN_PERCENT) {
                jOptionPane1.showMessageDialog(this,player + " You won!", "End", jOptionPane1.INFORMATION_MESSAGE);
                reset();
            }
        }
    }

    private void reset() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        second = 0;
        minute = 0;
        score = 0;
        jLabel6.setText("0000");
        jLabel3.setText("00:00");
        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        field = casualField(); 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        help = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        button1 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        button17 = new javax.swing.JButton();
        button25 = new javax.swing.JButton();
        button33 = new javax.swing.JButton();
        button41 = new javax.swing.JButton();
        button49 = new javax.swing.JButton();
        button57 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button10 = new javax.swing.JButton();
        button18 = new javax.swing.JButton();
        button26 = new javax.swing.JButton();
        button34 = new javax.swing.JButton();
        button42 = new javax.swing.JButton();
        button50 = new javax.swing.JButton();
        button58 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button11 = new javax.swing.JButton();
        button19 = new javax.swing.JButton();
        button27 = new javax.swing.JButton();
        button35 = new javax.swing.JButton();
        button43 = new javax.swing.JButton();
        button51 = new javax.swing.JButton();
        button59 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button12 = new javax.swing.JButton();
        button20 = new javax.swing.JButton();
        button28 = new javax.swing.JButton();
        button36 = new javax.swing.JButton();
        button44 = new javax.swing.JButton();
        button52 = new javax.swing.JButton();
        button60 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button13 = new javax.swing.JButton();
        button21 = new javax.swing.JButton();
        button29 = new javax.swing.JButton();
        button37 = new javax.swing.JButton();
        button45 = new javax.swing.JButton();
        button53 = new javax.swing.JButton();
        button61 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button14 = new javax.swing.JButton();
        button22 = new javax.swing.JButton();
        button30 = new javax.swing.JButton();
        button38 = new javax.swing.JButton();
        button46 = new javax.swing.JButton();
        button54 = new javax.swing.JButton();
        button62 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button15 = new javax.swing.JButton();
        button23 = new javax.swing.JButton();
        button31 = new javax.swing.JButton();
        button39 = new javax.swing.JButton();
        button47 = new javax.swing.JButton();
        button55 = new javax.swing.JButton();
        button63 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button16 = new javax.swing.JButton();
        button24 = new javax.swing.JButton();
        button32 = new javax.swing.JButton();
        button40 = new javax.swing.JButton();
        button48 = new javax.swing.JButton();
        button56 = new javax.swing.JButton();
        button64 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        reset_pulsante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 154, 255));
        jLabel1.setText("MineSweeper");

        help.setForeground(new java.awt.Color(222, 9, 222));
        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        exit.setForeground(new java.awt.Color(0, 0, 255));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        button1.setBackground(new java.awt.Color(102, 102, 102));
        button1.setBorder(new javax.swing.border.MatteBorder(null));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button9.setBackground(new java.awt.Color(102, 102, 102));
        button9.setBorder(new javax.swing.border.MatteBorder(null));
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        button17.setBackground(new java.awt.Color(102, 102, 102));
        button17.setBorder(new javax.swing.border.MatteBorder(null));
        button17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button17ActionPerformed(evt);
            }
        });

        button25.setBackground(new java.awt.Color(102, 102, 102));
        button25.setBorder(new javax.swing.border.MatteBorder(null));
        button25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button25ActionPerformed(evt);
            }
        });

        button33.setBackground(new java.awt.Color(102, 102, 102));
        button33.setBorder(new javax.swing.border.MatteBorder(null));
        button33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button33ActionPerformed(evt);
            }
        });

        button41.setBackground(new java.awt.Color(102, 102, 102));
        button41.setBorder(new javax.swing.border.MatteBorder(null));
        button41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button41ActionPerformed(evt);
            }
        });

        button49.setBackground(new java.awt.Color(102, 102, 102));
        button49.setBorder(new javax.swing.border.MatteBorder(null));
        button49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button49ActionPerformed(evt);
            }
        });

        button57.setBackground(new java.awt.Color(102, 102, 102));
        button57.setBorder(new javax.swing.border.MatteBorder(null));
        button57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button57ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(102, 102, 102));
        button2.setBorder(new javax.swing.border.MatteBorder(null));
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button10.setBackground(new java.awt.Color(102, 102, 102));
        button10.setBorder(new javax.swing.border.MatteBorder(null));
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });

        button18.setBackground(new java.awt.Color(102, 102, 102));
        button18.setBorder(new javax.swing.border.MatteBorder(null));
        button18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button18ActionPerformed(evt);
            }
        });

        button26.setBackground(new java.awt.Color(102, 102, 102));
        button26.setBorder(new javax.swing.border.MatteBorder(null));
        button26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button26ActionPerformed(evt);
            }
        });

        button34.setBackground(new java.awt.Color(102, 102, 102));
        button34.setBorder(new javax.swing.border.MatteBorder(null));
        button34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button34ActionPerformed(evt);
            }
        });

        button42.setBackground(new java.awt.Color(102, 102, 102));
        button42.setBorder(new javax.swing.border.MatteBorder(null));
        button42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button42ActionPerformed(evt);
            }
        });

        button50.setBackground(new java.awt.Color(102, 102, 102));
        button50.setBorder(new javax.swing.border.MatteBorder(null));
        button50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button50ActionPerformed(evt);
            }
        });

        button58.setBackground(new java.awt.Color(102, 102, 102));
        button58.setBorder(new javax.swing.border.MatteBorder(null));
        button58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button58ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(102, 102, 102));
        button3.setBorder(new javax.swing.border.MatteBorder(null));
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button11.setBackground(new java.awt.Color(102, 102, 102));
        button11.setBorder(new javax.swing.border.MatteBorder(null));
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        button19.setBackground(new java.awt.Color(102, 102, 102));
        button19.setBorder(new javax.swing.border.MatteBorder(null));
        button19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button19ActionPerformed(evt);
            }
        });

        button27.setBackground(new java.awt.Color(102, 102, 102));
        button27.setBorder(new javax.swing.border.MatteBorder(null));
        button27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button27ActionPerformed(evt);
            }
        });

        button35.setBackground(new java.awt.Color(102, 102, 102));
        button35.setBorder(new javax.swing.border.MatteBorder(null));
        button35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button35ActionPerformed(evt);
            }
        });

        button43.setBackground(new java.awt.Color(102, 102, 102));
        button43.setBorder(new javax.swing.border.MatteBorder(null));
        button43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button43ActionPerformed(evt);
            }
        });

        button51.setBackground(new java.awt.Color(102, 102, 102));
        button51.setBorder(new javax.swing.border.MatteBorder(null));
        button51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button51ActionPerformed(evt);
            }
        });

        button59.setBackground(new java.awt.Color(102, 102, 102));
        button59.setBorder(new javax.swing.border.MatteBorder(null));
        button59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button59ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(102, 102, 102));
        button4.setBorder(new javax.swing.border.MatteBorder(null));
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button12.setBackground(new java.awt.Color(102, 102, 102));
        button12.setBorder(new javax.swing.border.MatteBorder(null));
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });

        button20.setBackground(new java.awt.Color(102, 102, 102));
        button20.setBorder(new javax.swing.border.MatteBorder(null));
        button20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button20ActionPerformed(evt);
            }
        });

        button28.setBackground(new java.awt.Color(102, 102, 102));
        button28.setBorder(new javax.swing.border.MatteBorder(null));
        button28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button28ActionPerformed(evt);
            }
        });

        button36.setBackground(new java.awt.Color(102, 102, 102));
        button36.setBorder(new javax.swing.border.MatteBorder(null));
        button36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button36ActionPerformed(evt);
            }
        });

        button44.setBackground(new java.awt.Color(102, 102, 102));
        button44.setToolTipText("");
        button44.setBorder(new javax.swing.border.MatteBorder(null));
        button44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button44ActionPerformed(evt);
            }
        });

        button52.setBackground(new java.awt.Color(102, 102, 102));
        button52.setBorder(new javax.swing.border.MatteBorder(null));
        button52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button52ActionPerformed(evt);
            }
        });

        button60.setBackground(new java.awt.Color(102, 102, 102));
        button60.setBorder(new javax.swing.border.MatteBorder(null));
        button60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button60ActionPerformed(evt);
            }
        });

        button5.setBackground(new java.awt.Color(102, 102, 102));
        button5.setBorder(new javax.swing.border.MatteBorder(null));
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button13.setBackground(new java.awt.Color(102, 102, 102));
        button13.setBorder(new javax.swing.border.MatteBorder(null));
        button13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button13ActionPerformed(evt);
            }
        });

        button21.setBackground(new java.awt.Color(102, 102, 102));
        button21.setBorder(new javax.swing.border.MatteBorder(null));
        button21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button21ActionPerformed(evt);
            }
        });

        button29.setBackground(new java.awt.Color(102, 102, 102));
        button29.setToolTipText("");
        button29.setBorder(new javax.swing.border.MatteBorder(null));
        button29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button29ActionPerformed(evt);
            }
        });

        button37.setBackground(new java.awt.Color(102, 102, 102));
        button37.setBorder(new javax.swing.border.MatteBorder(null));
        button37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button37ActionPerformed(evt);
            }
        });

        button45.setBackground(new java.awt.Color(102, 102, 102));
        button45.setBorder(new javax.swing.border.MatteBorder(null));
        button45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button45ActionPerformed(evt);
            }
        });

        button53.setBackground(new java.awt.Color(102, 102, 102));
        button53.setBorder(new javax.swing.border.MatteBorder(null));
        button53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button53ActionPerformed(evt);
            }
        });

        button61.setBackground(new java.awt.Color(102, 102, 102));
        button61.setBorder(new javax.swing.border.MatteBorder(null));
        button61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button61ActionPerformed(evt);
            }
        });

        button6.setBackground(new java.awt.Color(102, 102, 102));
        button6.setBorder(new javax.swing.border.MatteBorder(null));
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button14.setBackground(new java.awt.Color(102, 102, 102));
        button14.setBorder(new javax.swing.border.MatteBorder(null));
        button14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button14ActionPerformed(evt);
            }
        });

        button22.setBackground(new java.awt.Color(102, 102, 102));
        button22.setBorder(new javax.swing.border.MatteBorder(null));
        button22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button22ActionPerformed(evt);
            }
        });

        button30.setBackground(new java.awt.Color(102, 102, 102));
        button30.setBorder(new javax.swing.border.MatteBorder(null));
        button30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button30ActionPerformed(evt);
            }
        });

        button38.setBackground(new java.awt.Color(102, 102, 102));
        button38.setBorder(new javax.swing.border.MatteBorder(null));
        button38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button38ActionPerformed(evt);
            }
        });

        button46.setBackground(new java.awt.Color(102, 102, 102));
        button46.setBorder(new javax.swing.border.MatteBorder(null));
        button46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button46ActionPerformed(evt);
            }
        });

        button54.setBackground(new java.awt.Color(102, 102, 102));
        button54.setBorder(new javax.swing.border.MatteBorder(null));
        button54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button54ActionPerformed(evt);
            }
        });

        button62.setBackground(new java.awt.Color(102, 102, 102));
        button62.setBorder(new javax.swing.border.MatteBorder(null));
        button62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button62ActionPerformed(evt);
            }
        });

        button7.setBackground(new java.awt.Color(102, 102, 102));
        button7.setBorder(new javax.swing.border.MatteBorder(null));
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button15.setBackground(new java.awt.Color(102, 102, 102));
        button15.setBorder(new javax.swing.border.MatteBorder(null));
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });

        button23.setBackground(new java.awt.Color(102, 102, 102));
        button23.setBorder(new javax.swing.border.MatteBorder(null));
        button23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button23ActionPerformed(evt);
            }
        });

        button31.setBackground(new java.awt.Color(102, 102, 102));
        button31.setBorder(new javax.swing.border.MatteBorder(null));
        button31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button31ActionPerformed(evt);
            }
        });

        button39.setBackground(new java.awt.Color(102, 102, 102));
        button39.setBorder(new javax.swing.border.MatteBorder(null));
        button39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button39ActionPerformed(evt);
            }
        });

        button47.setBackground(new java.awt.Color(102, 102, 102));
        button47.setBorder(new javax.swing.border.MatteBorder(null));
        button47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button47ActionPerformed(evt);
            }
        });

        button55.setBackground(new java.awt.Color(102, 102, 102));
        button55.setBorder(new javax.swing.border.MatteBorder(null));
        button55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button55ActionPerformed(evt);
            }
        });

        button63.setBackground(new java.awt.Color(102, 102, 102));
        button63.setBorder(new javax.swing.border.MatteBorder(null));
        button63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button63ActionPerformed(evt);
            }
        });

        button8.setBackground(new java.awt.Color(102, 102, 102));
        button8.setBorder(new javax.swing.border.MatteBorder(null));
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button16.setBackground(new java.awt.Color(102, 102, 102));
        button16.setBorder(new javax.swing.border.MatteBorder(null));
        button16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button16ActionPerformed(evt);
            }
        });

        button24.setBackground(new java.awt.Color(102, 102, 102));
        button24.setBorder(new javax.swing.border.MatteBorder(null));
        button24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button24ActionPerformed(evt);
            }
        });

        button32.setBackground(new java.awt.Color(102, 102, 102));
        button32.setBorder(new javax.swing.border.MatteBorder(null));
        button32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button32ActionPerformed(evt);
            }
        });

        button40.setBackground(new java.awt.Color(102, 102, 102));
        button40.setBorder(new javax.swing.border.MatteBorder(null));
        button40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button40ActionPerformed(evt);
            }
        });

        button48.setBackground(new java.awt.Color(102, 102, 102));
        button48.setBorder(new javax.swing.border.MatteBorder(null));
        button48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button48ActionPerformed(evt);
            }
        });

        button56.setBackground(new java.awt.Color(102, 102, 102));
        button56.setBorder(new javax.swing.border.MatteBorder(null));
        button56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button56ActionPerformed(evt);
            }
        });

        button64.setBackground(new java.awt.Color(102, 102, 102));
        button64.setBorder(new javax.swing.border.MatteBorder(null));
        button64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button64ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Timer:");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("00:00");

        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Score:");

        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("0000");

        reset_pulsante.setForeground(new java.awt.Color(0, 153, 153));
        reset_pulsante.setText("Reset");
        reset_pulsante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_pulsanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button33, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button49, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button57, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button50, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button58, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(help))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button59, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(button20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button60, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(button21, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button29, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button37, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button53, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button61, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button45, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(button14, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button30, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button38, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button46, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button54, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button62, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                            .addComponent(button22, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
                                    .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(reset_pulsante)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button39, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button47, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button48, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button63, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button64, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addContainerGap(59, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(button51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button59, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(button52, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button60, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(button50, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button58, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(button49, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button57, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(button53, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button54, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(button56, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button62, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button61, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button63, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button64, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(button27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(button17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(button25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(button18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(button26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(button34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button35, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(108, 108, 108)
                                        .addComponent(button43, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(button20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button28, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button44, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(button16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(button22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(button24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(button23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(button29, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button30, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(button32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(button31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(button37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button38, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(button39, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(button45, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button46, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(button47, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button48, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(reset_pulsante)
                    .addComponent(help))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        button1.setEnabled(false);
        click();
        controller(0,0); 
    }//GEN-LAST:event_button1ActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
         String help = "How to play:\n" +
                   "1. Press any button on the field to start the game.\n" +
                   "2. The timer starts when you press the first button.\n" +
                   "3. If you click on a mine, the game ends.\n" +
                   "4. If you click on an empty cell it will reveal the number of mines nearby.\n" +
                   "5. Try to uncover all safe cells.\n\n";
         
        jOptionPane1.showMessageDialog(rootPane, help, "Information",jOptionPane1.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        button2.setEnabled(false);
        click();
        controller(0,1); 
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        button3.setEnabled(false);
        click();
        controller(0,2); 
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        button4.setEnabled(false);
        click();
        controller(0,3); 
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        button5.setEnabled(false);
        click();
        controller(0,4); 
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        button6.setEnabled(false);
        click();
        controller(0,5); 
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        button7.setEnabled(false);
        click();
        controller(0,6); 
    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        button8.setEnabled(false);
        click();
        controller(0,7); 
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        button9.setEnabled(false);
        click();
        controller(1,0); 
    }//GEN-LAST:event_button9ActionPerformed

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
        button10.setEnabled(false);
        click();
        controller(1,1); 
    }//GEN-LAST:event_button10ActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        button11.setEnabled(false);
        click();
        controller(1,2); 
    }//GEN-LAST:event_button11ActionPerformed

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        button12.setEnabled(false);
        click();
        controller(1,3); 
    }//GEN-LAST:event_button12ActionPerformed

    private void button17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button17ActionPerformed
        button17.setEnabled(false);
        click();
        controller(2,0); 
    }//GEN-LAST:event_button17ActionPerformed

    private void button18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button18ActionPerformed
        button18.setEnabled(false);
        click();
        controller(2,1); 
    }//GEN-LAST:event_button18ActionPerformed

    private void button19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button19ActionPerformed
        button19.setEnabled(false);
        click();
        controller(2,2); 
    }//GEN-LAST:event_button19ActionPerformed

    private void button14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button14ActionPerformed
        button14.setEnabled(false);
        click();
        controller(1,5); 
    }//GEN-LAST:event_button14ActionPerformed

    private void button13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button13ActionPerformed
        button13.setEnabled(false);
        click();
        controller(1,4); 
    }//GEN-LAST:event_button13ActionPerformed

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        button15.setEnabled(false);
        click();
        controller(1,6); 
    }//GEN-LAST:event_button15ActionPerformed

    private void button16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button16ActionPerformed
        button16.setEnabled(false);
        click();
        controller(1,7); 
    }//GEN-LAST:event_button16ActionPerformed

    private void button21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button21ActionPerformed
        button21.setEnabled(false);
        click();
        controller(2,4); 
    }//GEN-LAST:event_button21ActionPerformed

    private void button20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button20ActionPerformed
        button20.setEnabled(false);
        click();
        controller(2,3); 
    }//GEN-LAST:event_button20ActionPerformed

    private void button22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button22ActionPerformed
        button22.setEnabled(false);
        click();
        controller(2,5); 
    }//GEN-LAST:event_button22ActionPerformed

    private void button23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button23ActionPerformed
        button23.setEnabled(false);
        click();
        controller(2,6); 
    }//GEN-LAST:event_button23ActionPerformed

    private void button24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button24ActionPerformed
        button24.setEnabled(false);
        click();
        controller(2,7); 
    }//GEN-LAST:event_button24ActionPerformed

    private void button25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button25ActionPerformed
        button25.setEnabled(false);
        click();
        controller(3,0); 
    }//GEN-LAST:event_button25ActionPerformed

    private void button26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button26ActionPerformed
        button26.setEnabled(false);
        click();
        controller(3,1); 
    }//GEN-LAST:event_button26ActionPerformed

    private void button27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button27ActionPerformed
        button27.setEnabled(false);
        click();
        controller(3,2); 
    }//GEN-LAST:event_button27ActionPerformed

    private void button28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button28ActionPerformed
        button28.setEnabled(false);
        click();
        controller(3,3); 
    }//GEN-LAST:event_button28ActionPerformed

    private void button29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button29ActionPerformed
        button29.setEnabled(false);
        click();
        controller(3,4); 
    }//GEN-LAST:event_button29ActionPerformed

    private void button30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button30ActionPerformed
        button30.setEnabled(false);
        click();
        controller(3,5); 
    }//GEN-LAST:event_button30ActionPerformed

    private void button31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button31ActionPerformed
        button31.setEnabled(false);
        click();
        controller(3,6); 
    }//GEN-LAST:event_button31ActionPerformed

    private void button32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button32ActionPerformed
        button32.setEnabled(false);
        click();
        controller(3,7); 
    }//GEN-LAST:event_button32ActionPerformed

    private void button33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button33ActionPerformed
        button33.setEnabled(false);
        click();
        controller(4,0); 
    }//GEN-LAST:event_button33ActionPerformed

    private void button34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button34ActionPerformed
        button34.setEnabled(false);
        click();
        controller(4,1); 
    }//GEN-LAST:event_button34ActionPerformed

    private void button35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button35ActionPerformed
        button35.setEnabled(false);
        click();
        controller(4,2); 
    }//GEN-LAST:event_button35ActionPerformed

    private void button36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button36ActionPerformed
        button36.setEnabled(false);
        click();
        controller(4,3); 
    }//GEN-LAST:event_button36ActionPerformed

    private void button37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button37ActionPerformed
        button37.setEnabled(false);
        click();
        controller(4,4); 
    }//GEN-LAST:event_button37ActionPerformed

    private void button38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button38ActionPerformed
        button38.setEnabled(false);
        click();
        controller(4,5); 
    }//GEN-LAST:event_button38ActionPerformed

    private void button39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button39ActionPerformed
        button39.setEnabled(false);
        click();
        controller(4,6); 
    }//GEN-LAST:event_button39ActionPerformed

    private void button40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button40ActionPerformed
        button40.setEnabled(false);
        click();
        controller(4,7); 
    }//GEN-LAST:event_button40ActionPerformed

    private void button41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button41ActionPerformed
        button41.setEnabled(false);
        click();
        controller(5,0); 
    }//GEN-LAST:event_button41ActionPerformed

    private void button42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button42ActionPerformed
        button42.setEnabled(false);
        click();
        controller(5,1); 
    }//GEN-LAST:event_button42ActionPerformed

    private void button43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button43ActionPerformed
        button43.setEnabled(false);
        click();
        controller(5,2); 
    }//GEN-LAST:event_button43ActionPerformed

    private void button44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button44ActionPerformed
        button44.setEnabled(false);
        click();
        controller(5,3); 
    }//GEN-LAST:event_button44ActionPerformed

    private void button45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button45ActionPerformed
        button45.setEnabled(false);
        click();
        controller(5,4); 
    }//GEN-LAST:event_button45ActionPerformed

    private void button46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button46ActionPerformed
        button46.setEnabled(false);
        click();
        controller(5,5); 
    }//GEN-LAST:event_button46ActionPerformed

    private void button47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button47ActionPerformed
        button47.setEnabled(false);
        click();
        controller(5,6); 
    }//GEN-LAST:event_button47ActionPerformed

    private void button48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button48ActionPerformed
        button48.setEnabled(false);
        click();
        controller(5,7); 
    }//GEN-LAST:event_button48ActionPerformed

    private void button49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button49ActionPerformed
        button49.setEnabled(false);
        click();
        controller(6,0); 
    }//GEN-LAST:event_button49ActionPerformed

    private void button50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button50ActionPerformed
        button50.setEnabled(false);
        click();
        controller(6,1); 
    }//GEN-LAST:event_button50ActionPerformed

    private void button51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button51ActionPerformed
        button51.setEnabled(false);
        click();
        controller(6,2); 
    }//GEN-LAST:event_button51ActionPerformed

    private void button52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button52ActionPerformed
        button52.setEnabled(false);
        click();
        controller(6,3); 
    }//GEN-LAST:event_button52ActionPerformed

    private void button53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button53ActionPerformed
        button53.setEnabled(false);
        click();
        controller(6,4); 
    }//GEN-LAST:event_button53ActionPerformed

    private void button54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button54ActionPerformed
        button54.setEnabled(false);
        click();
        controller(6,5); 
    }//GEN-LAST:event_button54ActionPerformed

    private void button55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button55ActionPerformed
        button55.setEnabled(false);
        click();
        controller(6,6); 
    }//GEN-LAST:event_button55ActionPerformed

    private void button56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button56ActionPerformed
        button56.setEnabled(false);
        click();
        controller(6,7); 
    }//GEN-LAST:event_button56ActionPerformed

    private void button57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button57ActionPerformed
        button57.setEnabled(false);
        click();
        controller(7,0); 
    }//GEN-LAST:event_button57ActionPerformed

    private void button58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button58ActionPerformed
        button58.setEnabled(false);
        click();
        controller(7,1); 
    }//GEN-LAST:event_button58ActionPerformed

    private void button59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button59ActionPerformed
        button59.setEnabled(false);
        click();
        controller(7,2); 
    }//GEN-LAST:event_button59ActionPerformed

    private void button60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button60ActionPerformed
        button60.setEnabled(false);
        click();
        controller(7,3); 
    }//GEN-LAST:event_button60ActionPerformed

    private void button61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button61ActionPerformed
        button61.setEnabled(false);
        click();
        controller(7,4); 
    }//GEN-LAST:event_button61ActionPerformed

    private void button62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button62ActionPerformed
        button62.setEnabled(false);
        click();
        controller(7,5); 
    }//GEN-LAST:event_button62ActionPerformed

    private void button63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button63ActionPerformed
        button63.setEnabled(false);
        click();
        controller(7,6); 
    }//GEN-LAST:event_button63ActionPerformed

    private void button64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button64ActionPerformed
        button64.setEnabled(false);
        click();
        controller(7,7); 
    }//GEN-LAST:event_button64ActionPerformed

    private void reset_pulsanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_pulsanteActionPerformed
        reset();
    }//GEN-LAST:event_reset_pulsanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MineSweeper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button1;
    private javax.swing.JButton button10;
    private javax.swing.JButton button11;
    private javax.swing.JButton button12;
    private javax.swing.JButton button13;
    private javax.swing.JButton button14;
    private javax.swing.JButton button15;
    private javax.swing.JButton button16;
    private javax.swing.JButton button17;
    private javax.swing.JButton button18;
    private javax.swing.JButton button19;
    private javax.swing.JButton button2;
    private javax.swing.JButton button20;
    private javax.swing.JButton button21;
    private javax.swing.JButton button22;
    private javax.swing.JButton button23;
    private javax.swing.JButton button24;
    private javax.swing.JButton button25;
    private javax.swing.JButton button26;
    private javax.swing.JButton button27;
    private javax.swing.JButton button28;
    private javax.swing.JButton button29;
    private javax.swing.JButton button3;
    private javax.swing.JButton button30;
    private javax.swing.JButton button31;
    private javax.swing.JButton button32;
    private javax.swing.JButton button33;
    private javax.swing.JButton button34;
    private javax.swing.JButton button35;
    private javax.swing.JButton button36;
    private javax.swing.JButton button37;
    private javax.swing.JButton button38;
    private javax.swing.JButton button39;
    private javax.swing.JButton button4;
    private javax.swing.JButton button40;
    private javax.swing.JButton button41;
    private javax.swing.JButton button42;
    private javax.swing.JButton button43;
    private javax.swing.JButton button44;
    private javax.swing.JButton button45;
    private javax.swing.JButton button46;
    private javax.swing.JButton button47;
    private javax.swing.JButton button48;
    private javax.swing.JButton button49;
    private javax.swing.JButton button5;
    private javax.swing.JButton button50;
    private javax.swing.JButton button51;
    private javax.swing.JButton button52;
    private javax.swing.JButton button53;
    private javax.swing.JButton button54;
    private javax.swing.JButton button55;
    private javax.swing.JButton button56;
    private javax.swing.JButton button57;
    private javax.swing.JButton button58;
    private javax.swing.JButton button59;
    private javax.swing.JButton button6;
    private javax.swing.JButton button60;
    private javax.swing.JButton button61;
    private javax.swing.JButton button62;
    private javax.swing.JButton button63;
    private javax.swing.JButton button64;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton exit;
    private javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JButton reset_pulsante;
    // End of variables declaration//GEN-END:variables
}
