package jogovelha;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class JogoSingle extends javax.swing.JFrame 
{
    boolean Jogador1Ativo = true;
    boolean Jogador2Ativo = false;
    int Vitoria1 = 0;
    int Vitoria2 = 0;
    int Empate   = 0;
      
    public JogoSingle() 
    {
        initComponents();
        setIcon();
    }

    public void InteligenciaArtificial()
    {       
        if(B1.getText().equals(""))
        {
            B1.setText("O");
            B1.setEnabled(false);
        }
        else if(B2.getText().equals(""))
        {
            B2.setText("O");
            B2.setEnabled(false);
        }
        else if(B3.getText().equals(""))
        {
            B3.setText("O");
            B3.setEnabled(false);
        }
        else if(B4.getText().equals(""))
        {
            B4.setText("O");
            B4.setEnabled(false);
        }
        else if(B5.getText().equals(""))
        {
            B5.setText("O");
            B5.setEnabled(false);
        }
        else if(B6.getText().equals(""))
        {
            B6.setText("O");
            B6.setEnabled(false);
        }
        else if(B7.getText().equals(""))
        {
            B7.setText("O");
            B7.setEnabled(false);
        }
        else if(B8.getText().equals(""))
        {
            B8.setText("O");
            B8.setEnabled(false);
        }
        else if(B9.getText().equals(""))
        {
            B9.setText("O");
            B9.setEnabled(false);
        }
        JogadorVencedor("X");
        JogadorVencedor("O");
    }
    
    public void JogadorVencedor(String Jogador)
    {
        //VERIFICANDO 1ª LINHA
        if(B1.getText().equals(Jogador) && B2.getText().equals(Jogador) && B3.getText().equals(Jogador))
        {
            B1.setBackground(Color.green);
            B2.setBackground(Color.green);
            B3.setBackground(Color.green);
            if(B1.getText().equals("X"))
            {
                Vencedor("Jogador 1");
            }
            else
            {
                Vencedor("CPU");
            }
        }
        //VERIFICANDO 2ª LINHA
        if(B4.getText().equals(Jogador) && B5.getText().equals(Jogador) && B6.getText().equals(Jogador))
        {
            B4.setBackground(Color.green);
            B5.setBackground(Color.green);
            B6.setBackground(Color.green);
            if(B4.getText().equals("X"))
            {
                Vencedor("Jogador 1");
            }
            else
            {
                Vencedor("CPU");
            }
        }
        //VERIFICANDO 3ª LINHA
        if(B7.getText().equals(Jogador) && B8.getText().equals(Jogador) && B9.getText().equals(Jogador))
        {
            B7.setBackground(Color.green);
            B8.setBackground(Color.green);
            B9.setBackground(Color.green);
            if(B7.getText().equals("X"))
            {
                Vencedor("Jogador 1");
            }
            else
            {
                Vencedor("CPU");
            }
        }
        //VERIFICANDO 1ª COLUNA
        if(B1.getText().equals(Jogador) && B4.getText().equals(Jogador) && B7.getText().equals(Jogador))
        {
            B1.setBackground(Color.green);
            B4.setBackground(Color.green);
            B7.setBackground(Color.green);
            if(B1.getText().equals("X"))
            {
                Vencedor("Jogador 1");
            }
            else
            {
                Vencedor("CPU");
            }
        }
        //VERIFICANDO 2ª COLUNA
        if(B2.getText().equals(Jogador) && B5.getText().equals(Jogador) && B8.getText().equals(Jogador))
        {
            B2.setBackground(Color.green);
            B5.setBackground(Color.green);
            B8.setBackground(Color.green);
            if(B2.getText().equals("X"))
            {
                Vencedor("Jogador 1");
            }
            else
            {
                Vencedor("CPU");
            }
        }
        //VERIFICANDO 3ª COLUNA
        if(B3.getText().equals(Jogador) && B6.getText().equals(Jogador) && B9.getText().equals(Jogador))
        {
            B3.setBackground(Color.green);
            B6.setBackground(Color.green);
            B9.setBackground(Color.green);
            if(B3.getText().equals("X"))
            {
                Vencedor("Jogador 1");
            }
            else
            {
                Vencedor("CPU");
            }
        }
        //VERIFICANDO 1ª DIAGONAL
        if(B1.getText().equals(Jogador) && B5.getText().equals(Jogador) && B9.getText().equals(Jogador))
        {
            B1.setBackground(Color.green);
            B5.setBackground(Color.green);
            B9.setBackground(Color.green);
            if(B1.getText().equals("X"))
            {
                Vencedor("Jogador 1");
            }
            else
            {
                Vencedor("CPU");
            }
        }
        //VERIFICANDO 2ª DIAGONAL
        if(B3.getText().equals(Jogador) && B5.getText().equals(Jogador) && B7.getText().equals(Jogador))
        {
            B3.setBackground(Color.green);
            B5.setBackground(Color.green);
            B7.setBackground(Color.green);
            if(B3.getText().equals("X"))
            {
                Vencedor("Jogador 1");
            }
            else
            {
                Vencedor("CPU");
            }
        }
        //VERIFICANDO EMPATE
        if(!B1.getText().equals("") &&
           !B2.getText().equals("") &&
           !B3.getText().equals("") && 
           !B4.getText().equals("") && 
           !B5.getText().equals("") && 
           !B6.getText().equals("") && 
           !B7.getText().equals("") && 
           !B8.getText().equals("") && 
           !B9.getText().equals(""))
        {
            B1.setBackground(Color.red);
            B2.setBackground(Color.red);
            B3.setBackground(Color.red);
            B4.setBackground(Color.red);
            B5.setBackground(Color.red);
            B6.setBackground(Color.red);
            B7.setBackground(Color.red);
            B8.setBackground(Color.red);
            B9.setBackground(Color.red);
            Vencedor("Empate");
        }
    }
    
    public void Vencedor(String JogadorVencedor)
    {
        if(JogadorVencedor.equals("Jogador 1"))
        {
            JOptionPane.showMessageDialog(JogoSingle.this, "Parabéns Jogador 1, você venceu");
            Vitoria1 ++;
            NumeroDeVitoriasDoJogador1.setText("Número de Vitórias: " +Vitoria1);
            LimparCampos();
            
        }
        if(JogadorVencedor.equals("CPU"))
        {
            JOptionPane.showMessageDialog(JogoSingle.this, " Você Perdeu");
            Vitoria2 ++;
            NumeroDeVitoriasDoJogador2.setText("Número de Vitórias: " +Vitoria2);
            LimparCampos();
        }
        if(JogadorVencedor.equals("Empate"))
        {
            JOptionPane.showMessageDialog(JogoSingle.this, "Empate!");
            Empate ++;
            NumeroDeEmpate.setText("Número de Empates: " +Empate);
            LimparCampos();
        }
    }
    
    public void LimparCampos()
    {
        //LIMPA OS X E O DOS BOTÕES
        B1.setText("");
        B2.setText("");
        B3.setText("");
        B4.setText("");
        B5.setText("");
        B6.setText("");
        B7.setText("");
        B8.setText("");
        B9.setText("");  
        //HABILITA NOVAMENTE OS BOTÕES
        B1.setEnabled(true);
        B2.setEnabled(true);
        B3.setEnabled(true);
        B4.setEnabled(true);
        B5.setEnabled(true);
        B6.setEnabled(true);
        B7.setEnabled(true);
        B8.setEnabled(true);
        B9.setEnabled(true);
        //VOLTA A COR PADRÃO DOS BOTÕES
        B1.setBackground(null);  
        B2.setBackground(null); 
        B3.setBackground(null); 
        B4.setBackground(null); 
        B5.setBackground(null); 
        B6.setBackground(null); 
        B7.setBackground(null); 
        B8.setBackground(null); 
        B9.setBackground(null); 

        Jogador1Ativo = true;
        Jogador2Ativo = false;        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        B1 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        B6 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        B9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NumeroDeVitoriasDoJogador1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NumeroDeVitoriasDoJogador2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        NumeroDeEmpate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        NovoJogo = new javax.swing.JButton();
        SairDoJogo = new javax.swing.JButton();
        VoltarMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Play vs PC");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        B1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B1.setForeground(new java.awt.Color(0, 102, 153));
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        B2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B2.setForeground(new java.awt.Color(0, 102, 153));
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });

        B3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B3.setForeground(new java.awt.Color(0, 102, 153));
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });

        B4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B4.setForeground(new java.awt.Color(0, 102, 153));
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });

        B5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B5.setForeground(new java.awt.Color(0, 102, 153));
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });

        B6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B6.setForeground(new java.awt.Color(0, 102, 153));
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });

        B7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B7.setForeground(new java.awt.Color(0, 102, 153));
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });

        B8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B8.setForeground(new java.awt.Color(0, 102, 153));
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });

        B9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B9.setForeground(new java.awt.Color(0, 102, 153));
        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(B2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(B1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do Jogo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel1.setText("Jogador 1");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel2.setText("Símbolo: X");

        NumeroDeVitoriasDoJogador1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        NumeroDeVitoriasDoJogador1.setText("Número de Vitórias: 0");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel4.setText("Jogador 2");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel5.setText("Símbolo: O");

        NumeroDeVitoriasDoJogador2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        NumeroDeVitoriasDoJogador2.setText("Número de Vitórias: 0");

        NumeroDeEmpate.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        NumeroDeEmpate.setText("Número de Empates: 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumeroDeVitoriasDoJogador1)
                            .addComponent(NumeroDeVitoriasDoJogador2)
                            .addComponent(NumeroDeEmpate))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumeroDeVitoriasDoJogador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumeroDeVitoriasDoJogador2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumeroDeEmpate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle do Jogo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 12))); // NOI18N

        NovoJogo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        NovoJogo.setText("Novo Jogo");
        NovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoJogoActionPerformed(evt);
            }
        });

        SairDoJogo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        SairDoJogo.setText("Sair do Jogo");
        SairDoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairDoJogoActionPerformed(evt);
            }
        });

        VoltarMenu.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        VoltarMenu.setText("Voltar ao Menu");
        VoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NovoJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VoltarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SairDoJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NovoJogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VoltarMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SairDoJogo))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        if(B1.getText().equals(""))
        { 
            B1.setText("X");
            B1.setEnabled(false);
        } 
        InteligenciaArtificial();     
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        if(B2.getText().equals(""))
        { 
            B2.setText("X");
            B2.setEnabled(false);
        } 
        InteligenciaArtificial();   
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        if(B3.getText().equals(""))
        { 
            B3.setText("X");
            B3.setEnabled(false);
        } 
        InteligenciaArtificial();       
    }//GEN-LAST:event_B3ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        if(B4.getText().equals(""))
        { 
            B4.setText("X");
            B4.setEnabled(false);
        } 
        InteligenciaArtificial();      
    }//GEN-LAST:event_B4ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        if(B5.getText().equals(""))
        { 
            B5.setText("X");
            B5.setEnabled(false);
        } 
        InteligenciaArtificial();        
    }//GEN-LAST:event_B5ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
        if(B6.getText().equals(""))
        { 
            B6.setText("X");
            B6.setEnabled(false);  
        } 
        InteligenciaArtificial();      
    }//GEN-LAST:event_B6ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        if(B7.getText().equals(""))
        { 
            B7.setText("X");
            B7.setEnabled(false);    
        } 
        InteligenciaArtificial();    
    }//GEN-LAST:event_B7ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        if(B8.getText().equals(""))
        { 
            B8.setText("X");
            B8.setEnabled(false);
        } 
        InteligenciaArtificial();
    }//GEN-LAST:event_B8ActionPerformed

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        if(B9.getText().equals(""))
        { 
            B9.setText("X");
            B9.setEnabled(false);   
        } 
        InteligenciaArtificial();     
    }//GEN-LAST:event_B9ActionPerformed

    private void NovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoJogoActionPerformed
        LimparCampos();
    }//GEN-LAST:event_NovoJogoActionPerformed

    private void SairDoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairDoJogoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SairDoJogoActionPerformed

    private void VoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarMenuActionPerformed
        this.dispose(); 
        new MenuInicial().setVisible(true);  
    }//GEN-LAST:event_VoltarMenuActionPerformed
    //CRIAÇÃO DE UM ICONE
    private void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("x.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton B6;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton B9;
    private javax.swing.JButton NovoJogo;
    private javax.swing.JLabel NumeroDeEmpate;
    private javax.swing.JLabel NumeroDeVitoriasDoJogador1;
    private javax.swing.JLabel NumeroDeVitoriasDoJogador2;
    private javax.swing.JButton SairDoJogo;
    private javax.swing.JButton VoltarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}