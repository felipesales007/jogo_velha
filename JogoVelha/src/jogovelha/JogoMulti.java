package jogovelha;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.JOptionPane;

public class JogoMulti extends javax.swing.JFrame 
{
    Integer jogador;
    int matriz[][] = new int[3][3];
    int Jogador1;
    int Jogador2;
    
    int Vitoria1 = 0;
    int Vitoria2 = 0;
    int Empate   = 0;
    
    private String nome;
    private InetAddress enderecoMulticast;
    private int porta;
    private MulticastSocket socket;
      
    public JogoMulti() 
    {
        initComponents();
        setIcon();
    }

    public void JogoNovo() 
    {
        //ZERA A MATRIZ
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                matriz[i][j] = 0;
            }
        }
        //ANULA OS SETS DOS BOTÕES
        B1.setText("");
        B2.setText("");
        B3.setText("");
        B4.setText("");
        B5.setText("");
        B6.setText("");
        B7.setText("");
        B8.setText("");
        B9.setText("");
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
        //INICIA COM O JOGADOR 1 OU 2
        if(String.valueOf(OpcaoSimbolo.getSelectedItem()).equals("Jogador O"))
        {
            jogador = 1;
        }          
        if(String.valueOf(OpcaoSimbolo.getSelectedItem()).equals("Jogador X"))
        {
            jogador = 2; 
        }     
    }
    
    //MÉTODO DE BLOQUEIO DOS BOTÕES
    public void BlockButton(int block)
    {
        //DESBLOQUEAR BOTÕES DO GAME
        if(block == 1)
        {
            B1.setEnabled(true);
            B2.setEnabled(true);
            B3.setEnabled(true);
            B4.setEnabled(true);
            B5.setEnabled(true);
            B6.setEnabled(true);
            B7.setEnabled(true);
            B8.setEnabled(true);
            B9.setEnabled(true);
        }
        //BLOQUEAR BOTÕES DO GAME
        if(block == 2)
        {
            B1.setEnabled(false);
            B2.setEnabled(false);
            B3.setEnabled(false);
            B4.setEnabled(false);
            B5.setEnabled(false);
            B6.setEnabled(false);
            B7.setEnabled(false);
            B8.setEnabled(false);
            B9.setEnabled(false);
        }
    }
    
    //ATUALIZA OS BOTÕES EM OUTROS FRAMES
    public void AtualizaBt(String texto)
    {
        //BLOQUEIA BOTÕES GAME EM TODOS OS FRAMES POR QUEM GANHOU
        if(texto.equals("block2"))
        {
            BlockButton(2);
        }
        
        if(texto.equals("B1,J1")){B1.setText("O"); matriz[0][0] = 1;}
        if(texto.equals("B1,J2")){B1.setText("X"); matriz[0][0] = 2;}        
        
        if(texto.equals("B2,J1")){B2.setText("O"); matriz[0][1] = 1;}
        if(texto.equals("B2,J2")){B2.setText("X"); matriz[0][1] = 2;}
        
        if(texto.equals("B3,J1")){B3.setText("O"); matriz[0][2] = 1;}
        if(texto.equals("B3,J2")){B3.setText("X"); matriz[0][2] = 2;}
        
        if(texto.equals("B4,J1")){B4.setText("O"); matriz[1][0] = 1;}
        if(texto.equals("B4,J2")){B4.setText("X"); matriz[1][0] = 2;}
        
        if(texto.equals("B5,J1")){B5.setText("O"); matriz[1][1] = 1;}
        if(texto.equals("B5,J2")){B5.setText("X"); matriz[1][1] = 2;}
        
        if(texto.equals("B6,J1")){B6.setText("O"); matriz[1][2] = 1;}
        if(texto.equals("B6,J2")){B6.setText("X"); matriz[1][2] = 2;}
        
        if(texto.equals("B7,J1")){B7.setText("O"); matriz[2][0] = 1;}
        if(texto.equals("B7,J2")){B7.setText("X"); matriz[2][0] = 2;}
        
        if(texto.equals("B8,J1")){B8.setText("O"); matriz[2][1] = 1;}
        if(texto.equals("B8,J2")){B8.setText("X"); matriz[2][1] = 2;}
        
        if(texto.equals("B9,J1")){B9.setText("O"); matriz[2][2] = 1;}
        if(texto.equals("B9,J2")){B9.setText("X"); matriz[2][2] = 2;}
    }
    
    //VERIFICA SE ALGUÉM GANHOU
    public void Ganhou()
    {
        Jogador1 = 0;//JOGADOR '0'
        Jogador2 = 0;//JOGADOR 'X'

        //VERIFICANDO VALORES DAS MATRIZES ENTRE 1 JOGADOR 'O' E 2 JOGADOR 'X'
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++) 
            {
                if (matriz[i][j] == 1)
                {
                    //ABAIXO TODAS AS POSSIBILIDADES DE JOGO PARA AMBOS JOGADORES
                    //VERIFICANDO 1ª LINHA
                    if(B1.getText().equals("O") && B2.getText().equals("O") && B3.getText().equals("O"))
                    {
                        B1.setBackground(Color.green);
                        B2.setBackground(Color.green);
                        B3.setBackground(Color.green);
                        Jogador1++;
                    }
                    //VERIFICANDO 2ª LINHA
                    if(B4.getText().equals("O") && B5.getText().equals("O") && B6.getText().equals("O"))
                    {
                        B4.setBackground(Color.green);
                        B5.setBackground(Color.green);
                        B6.setBackground(Color.green);
                        Jogador1++;
                    }  
                    //VERIFICANDO 3ª LINHA
                    if(B7.getText().equals("O") && B8.getText().equals("O") && B9.getText().equals("O"))
                    {
                        B7.setBackground(Color.green);
                        B8.setBackground(Color.green);
                        B9.setBackground(Color.green);
                        Jogador1++;
                    }
                    //VERIFICANDO 1ª COLUNA
                    if(B1.getText().equals("O") && B4.getText().equals("O") && B7.getText().equals("O"))
                    {
                        B1.setBackground(Color.green);
                        B4.setBackground(Color.green);
                        B7.setBackground(Color.green);
                        Jogador1++;
                    }
                    //VERIFICANDO 2ª COLUNA
                    if(B2.getText().equals("O") && B5.getText().equals("O") && B8.getText().equals("O"))
                    {
                        B2.setBackground(Color.green);
                        B5.setBackground(Color.green);
                        B8.setBackground(Color.green);
                        Jogador1++;
                    }   
                    //VERIFICANDO 3ª COLUNA
                    if(B3.getText().equals("O") && B6.getText().equals("O") && B9.getText().equals("O"))
                    {
                        B3.setBackground(Color.green);
                        B6.setBackground(Color.green);
                        B9.setBackground(Color.green);
                        Jogador1++;
                    }
                    //VERIFICANDO 1ª DIAGONAL
                    if(B1.getText().equals("O") && B5.getText().equals("O") && B9.getText().equals("O"))
                    {
                        B1.setBackground(Color.green);
                        B5.setBackground(Color.green);
                        B9.setBackground(Color.green);
                        Jogador1++;
                    }
                    //VERIFICANDO 2ª DIAGONAL
                    if(B3.getText().equals("O") && B5.getText().equals("O") && B7.getText().equals("O"))
                    {
                        B3.setBackground(Color.green);
                        B5.setBackground(Color.green);
                        B7.setBackground(Color.green);
                        Jogador1++;
                    }     
                }
                else if (matriz[i][j] == 2)
                {
                    //VERIFICANDO 1ª LINHA
                    if(B1.getText().equals("X") && B2.getText().equals("X") && B3.getText().equals("X"))
                    {
                        B1.setBackground(Color.green);
                        B2.setBackground(Color.green);
                        B3.setBackground(Color.green);
                        Jogador2++;
                    }
                    //VERIFICANDO 2ª LINHA    
                    if(B4.getText().equals("X") && B5.getText().equals("X") && B6.getText().equals("X"))
                    {
                        B4.setBackground(Color.green);
                        B5.setBackground(Color.green);
                        B6.setBackground(Color.green);
                        Jogador2++;
                    }       
                    //VERIFICANDO 3ª LINHA
                    if(B7.getText().equals("X") && B8.getText().equals("X") && B9.getText().equals("X"))
                    {
                        B7.setBackground(Color.green);
                        B8.setBackground(Color.green);
                        B9.setBackground(Color.green);
                        Jogador2++;
                    }
                    //VERIFICANDO 1ª COLUNA
                    if(B1.getText().equals("X") && B4.getText().equals("X") && B7.getText().equals("X"))
                    {
                        B1.setBackground(Color.green);
                        B4.setBackground(Color.green);
                        B7.setBackground(Color.green);
                        Jogador2++;
                    }
                    //VERIFICANDO 2ª COLUNA    
                    if(B2.getText().equals("X") && B5.getText().equals("X") && B8.getText().equals("X"))
                    {
                        B2.setBackground(Color.green);
                        B5.setBackground(Color.green);
                        B8.setBackground(Color.green);
                        Jogador2++;
                    }
                    //VERIFICANDO 3ª COLUNA    
                    if(B3.getText().equals("X") && B6.getText().equals("X") && B9.getText().equals("X"))
                    {
                        B3.setBackground(Color.green);
                        B6.setBackground(Color.green);
                        B9.setBackground(Color.green);
                        Jogador2++;
                    }
                    //VERIFICANDO 1ª DIAGONAL
                    if(B1.getText().equals("X") && B5.getText().equals("X") && B9.getText().equals("X"))
                    {
                        B1.setBackground(Color.green);
                        B5.setBackground(Color.green);
                        B9.setBackground(Color.green);
                        Jogador2++;
                    }
                    //VERIFICANDO 2ª DIAGONAL
                    if(B3.getText().equals("X") && B5.getText().equals("X") && B7.getText().equals("X"))
                    {
                        B3.setBackground(Color.green);
                        B5.setBackground(Color.green);
                        B7.setBackground(Color.green);
                        Jogador2++;
                    }
                }
            }//FOR J
        }//FOR I
        
        if (Jogador1 == 3)
        {
            JOptionPane.showMessageDialog(null, "Parabéns Jogador 'O', você venceu!");
            Vitoria1 ++;
            NumeroDeVitoriasDoJogador1.setText("Número de Vitórias: " +Vitoria1);
            Jogador1 = 0;
            Jogador2 = 0;

            BlockButton(2);
            sendMsg("Jogador 'O' venceu!\n");
            sendMsg("block2");
        }        
        if (Jogador2 == 3)
        {
            JOptionPane.showMessageDialog(null, "Parabéns Jogador 'X', você venceu!");
            Vitoria2 ++;
            NumeroDeVitoriasDoJogador2.setText("Número de Vitórias: " +Vitoria2);
            Jogador2 = 0;
            Jogador1 = 0;

            BlockButton(2);
            sendMsg("Jogador 'X' venceu!\n");
            sendMsg("block2");
        }
    }

    public void Conexao()
    {
        nome = NomeDigitado.getText();
        //DESABILITANDO A OPÇÃO DE RENOMEAR DURANTE CONEXÃO
        NomeDigitado.setEnabled(false); 
        try
        {
            //PASSANDO VALORES DA PORTA ESTABELECIDO NA TBPORT
            porta = Integer.parseInt(PortaDigitada.getText());
            //Endereço multicast (244.0.0.0 à 239.255.255.255)
            enderecoMulticast = InetAddress.getByName(IPdigitado.getText());
            //CLIANDO O OBJETO EM CONEXÃO À PORTA DEFINIDA
            socket = new MulticastSocket(porta);            
            //CRIANDO O GRUPO BROADCAST MULTIPLEXADO
            socket.joinGroup(enderecoMulticast);            
            //CHAMANDO A THREAD DE LEITURA DE DATAPACKETS
            Thread();
            //HABILITANDO E DESABILITANDO BOTÕES
            BotaoConectado.setEnabled(false);
            BotaoDesconectado.setEnabled(true);
            NovoJogo.setEnabled(true);
            OpcaoSimbolo.setEnabled(true);
            EnviarMsg.setEnabled(true);
        }
        catch(NumberFormatException | IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Tente novamente! "+ex.toString()+"\n");
        }
    }
    
    public void Desconexão()
    {
        try
        {
            //MENSAGEM DE ALERTA SOBRE DESCONEXÃO
            sendMsg(nome+" se desconectado!");
            //FECHANDO MULTCASTSOCKET
            socket.close();           
        }
        catch(Exception ex)
        {
            System.err.println(ex.toString());
        }
    }
    
    //THREAD DE LEITURA DOS DATAPACKET
    public class Leitora implements Runnable
    {       
        @Override
        public void run()
        {            
            try
            {
                while(true)
                {
                    //BYTES DE RECEPÇÃO DE DADOS PARA O DATAGRAMA
                    byte dados[] = new byte[240];
                    //DATAGRAMA COM OS DADOS LANÇADOS DA SINCRONOIZAÇÃO
                    DatagramPacket datagrama = new DatagramPacket(dados,dados.length);
                    //MULTICASTSOCKET RECEBENDO DADOS DO DATAGRAMA
                    socket.receive(datagrama);
                    //STRING CONTENDO OS DADOS DO DATAGRAMA RECEBIDO E CONVERTIDOS PARA STRING
                    String texto = new String(datagrama.getData());
                    //CHAMADA AO MÉTODO DE ATUALIZAÇÃO DOS BOTÕES DO GAME EM AMBAS INTERFACE
                    AtualizaBt(texto.trim());
                    //EXIBIÇÃO EM TELA CHAT SOBRE OS EVENTOS DURANTE O PROCESSAMENTO
                    Chat.append("\n"+texto.trim());
                }
            }
            catch(Exception ex)
            {
                System.err.println(ex.toString());
            }
        }
    }
    
    //METODO DE INICIAÇÃO DA THREAD
    public void Thread()
    {
        //CRIANDO UM OBJETO THREAD DA CLASSE IMPLEMENTADA LEITORA()
        Thread Leitora = new Thread(new Leitora());
        //INICIANDO A THREAD
        Leitora.start();
    }
    
    //MÉTODO DE ENVIO DE MENSAGENS OU ENVIO DE DATAGRAMAS
    public void sendMsg(String msg)
    {
        try
        {
            //VARIAVEL BYTES DE SINCRONIZAÇÃO DE DATAGRAMAS DE RECEPTOR E EMISSOR
            byte dados[] = msg.getBytes();
            //NO ENVIO DE DATAGRAMAS UTILIZA-SE OS DADOS CONVERTIDOS EM BYTES, O TAMANHO DESTES DADOS,
            //O ENDEREÇO BROADCAST MULTIPLEXADO E A PORTA DE COMUNICAÇÃO
            DatagramPacket datagrama = new DatagramPacket(dados, dados.length, enderecoMulticast, porta);
            //MULTICASTSOCKET ENVIANDO O DATAGRAMA PROPARADO
            socket.send(datagrama);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chat = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        MsgDigitada = new javax.swing.JTextField();
        EnviarMsg = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        BotaoConectado = new javax.swing.JButton();
        BotaoDesconectado = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        IPdigitado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PortaDigitada = new javax.swing.JTextField();
        OpcaoSimbolo = new javax.swing.JComboBox<>();
        NomeDigitado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Play vs Play");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        B1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B1.setForeground(new java.awt.Color(0, 102, 153));
        B1.setEnabled(false);
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        B2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B2.setForeground(new java.awt.Color(0, 102, 153));
        B2.setEnabled(false);
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });

        B3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B3.setForeground(new java.awt.Color(0, 102, 153));
        B3.setEnabled(false);
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });

        B4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B4.setForeground(new java.awt.Color(0, 102, 153));
        B4.setEnabled(false);
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });

        B5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B5.setForeground(new java.awt.Color(0, 102, 153));
        B5.setEnabled(false);
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });

        B6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B6.setForeground(new java.awt.Color(0, 102, 153));
        B6.setEnabled(false);
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });

        B7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B7.setForeground(new java.awt.Color(0, 102, 153));
        B7.setEnabled(false);
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });

        B8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B8.setForeground(new java.awt.Color(0, 102, 153));
        B8.setEnabled(false);
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });

        B9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        B9.setForeground(new java.awt.Color(0, 102, 153));
        B9.setEnabled(false);
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
        NovoJogo.setEnabled(false);
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SairDoJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VoltarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(NovoJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensagens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 12))); // NOI18N
        jPanel4.setToolTipText("");

        Chat.setEditable(false);
        Chat.setColumns(20);
        Chat.setRows(5);
        jScrollPane1.setViewportView(Chat);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Enviar Mensagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 12))); // NOI18N

        MsgDigitada.setFont(new java.awt.Font("Yu Gothic UI Semilight", 2, 12)); // NOI18N
        MsgDigitada.setText("Digite aqui sua mensagem");
        MsgDigitada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MsgDigitadaMouseClicked(evt);
            }
        });
        MsgDigitada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsgDigitadaActionPerformed(evt);
            }
        });

        EnviarMsg.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        EnviarMsg.setText("Enviar");
        EnviarMsg.setEnabled(false);
        EnviarMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarMsgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(MsgDigitada, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EnviarMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(EnviarMsg)
                .addComponent(MsgDigitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle de Conexão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 12))); // NOI18N

        BotaoConectado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        BotaoConectado.setText("Conectar");
        BotaoConectado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConectadoActionPerformed(evt);
            }
        });

        BotaoDesconectado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        BotaoDesconectado.setText("Desconectar");
        BotaoDesconectado.setEnabled(false);
        BotaoDesconectado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDesconectadoActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        jLabel3.setText("IP: ");

        IPdigitado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        IPdigitado.setText("237.32.65.3");
        IPdigitado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IPdigitadoMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        jLabel6.setText("Porta: ");

        PortaDigitada.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        PortaDigitada.setText("9999");
        PortaDigitada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PortaDigitadaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PortaDigitada)
                    .addComponent(IPdigitado))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(IPdigitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(PortaDigitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        OpcaoSimbolo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        OpcaoSimbolo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jogador O", "Jogador X" }));
        OpcaoSimbolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcaoSimboloActionPerformed(evt);
            }
        });

        NomeDigitado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 2, 12)); // NOI18N
        NomeDigitado.setText("Digite seu nome aqui");
        NomeDigitado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NomeDigitadoMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        jLabel7.setText("Usuário:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotaoDesconectado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaoConectado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addComponent(OpcaoSimbolo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NomeDigitado)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(BotaoConectado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoDesconectado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addComponent(NomeDigitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(OpcaoSimbolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        if(matriz[0][0] == 0)
        {
            if (jogador == 1)
            {
                matriz[0][0] = 1;
                B1.setText("O");
                B1.setEnabled(false);
                //jogador = 2;
                sendMsg("B1,J1");
            }
            else
            {
                if(jogador == 2)
                {
                    matriz[0][0] = 2;
                    B1.setText("X");
                    B1.setEnabled(false);
                    //jogador = 1;
                    sendMsg("B1,J2");
                }
            }           
            Ganhou();
        }
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        if(matriz[0][1] == 0)
        {
            if(jogador == 1) 
            {
                matriz[0][1] = 1;
                B2.setText("O");
                B2.setEnabled(false);
                //jogador = 2;
                sendMsg("B2,J1");
            }
            else
            {
                if(jogador == 2)
                {
                    matriz[0][1] = 2;
                    B2.setText("X");
                    B2.setEnabled(false);
                    //jogador = 1;
                    sendMsg("B2,J2");
                }
            }
            Ganhou();
        }
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        if(matriz[0][2] == 0)
        {
            if(jogador == 1)
            {
                matriz[0][2] = 1;
                B3.setText("O");
                B3.setEnabled(false);
                //jogador = 2;
                sendMsg("B3,J1");
            }
            else
            {
                if(jogador == 2)
                {
                    matriz[0][2] = 2;
                    B3.setText("X");
                    B3.setEnabled(false);
                    //jogador = 1;
                    sendMsg("B3,J2");
                }
            }
            Ganhou();
        }
    }//GEN-LAST:event_B3ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        if(matriz[1][0] == 0)
        {
            if(jogador == 1)
            {
                matriz[1][0] = 1;
                B4.setText("O");
                B4.setEnabled(false);
                //jogador = 2;
                sendMsg("B4,J1");
            }
            else
            {
                if(jogador == 2)
                {
                    matriz[1][0] = 2;
                    B4.setText("X");
                    B4.setEnabled(false);
                    //jogador = 1;
                    sendMsg("B4,J2");
                }
            }
            Ganhou();
        }
    }//GEN-LAST:event_B4ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        if(matriz[1][1] == 0)
        {
            if(jogador == 1)
            {
                matriz[1][1] = 1;
                B5.setText("O");
                B5.setEnabled(false);
                //jogador = 2;
                sendMsg("B5,J1");
            }
            else
            {
                if(jogador == 2)
                {
                    matriz[1][1] = 2;
                    B5.setText("X");
                    B5.setEnabled(false);
                    //jogador = 1;
                    sendMsg("B5,J2");
                }
            }
            Ganhou();
        }
    }//GEN-LAST:event_B5ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
        if(matriz[1][2] == 0)
        {
            if(jogador == 1)
            {
                matriz[1][2] = 1;
                B6.setText("O");
                B6.setEnabled(false);
                //jogador = 2;
                sendMsg("B6,J1");
            }
            else
            {
                if(jogador == 2)
                {
                    matriz[1][2] = 2;
                    B6.setText("X");
                    B6.setEnabled(false);
                    //jogador = 1;
                    sendMsg("B6,J2");
                }
            }
            Ganhou();
        }
    }//GEN-LAST:event_B6ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        if(matriz[2][0] == 0)
        {
            if(jogador == 1)
            {
                matriz[2][0] = 1;
                B7.setText("O");
                B7.setEnabled(false);
                //jogador = 2;
                sendMsg("B7,J1");
            }
            else
            {
                if(jogador == 2)
                {
                    matriz[2][0] = 2;
                    B7.setText("X");
                    B7.setEnabled(false);
                    //jogador = 1;
                    sendMsg("B7,J2");
                }
            }
            Ganhou();
        }
    }//GEN-LAST:event_B7ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        if(matriz[2][1] == 0)
        {
            if(jogador == 1)
            {
                matriz[2][1] = 1;
                B8.setText("O");
                B8.setEnabled(false);
                //jogador = 2;
                sendMsg("B8,J1");
            }
            else
            {
                if(jogador == 2)
                {
                    matriz[2][1] = 2;
                    B8.setText("X");
                    B8.setEnabled(false);
                    //jogador = 1;
                    sendMsg("B8,J2");
                }
            }
            Ganhou();
        }
    }//GEN-LAST:event_B8ActionPerformed

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        if(matriz[2][2] == 0)
        {
            if(jogador == 1)
            {
                matriz[2][2] = 1;
                B9.setText("O");
                B9.setEnabled(false);
                //jogador = 2;
                sendMsg("B9,J1");
            }
            else
            {
                if(jogador == 2)
                {
                    matriz[2][2] = 2;
                    B9.setText("X");
                    B9.setEnabled(false);
                    //jogador = 1;
                    sendMsg("B9,J2");
                }
            }
            Ganhou();
        }
    }//GEN-LAST:event_B9ActionPerformed

    private void NovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoJogoActionPerformed
        JogoNovo();
        sendMsg(nome+" iniciou um jogo em rede! - "+OpcaoSimbolo.getSelectedItem().toString());
        BlockButton(1);
    }//GEN-LAST:event_NovoJogoActionPerformed

    private void SairDoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairDoJogoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SairDoJogoActionPerformed

    private void VoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarMenuActionPerformed
        this.dispose(); 
        new MenuInicial().setVisible(true);
    }//GEN-LAST:event_VoltarMenuActionPerformed

    private void EnviarMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarMsgActionPerformed
        if(MsgDigitada.getText().equals("") || MsgDigitada.getText().equals("Digite aqui sua mensagem"))
        {
            MsgDigitada.setText(null);
        }
        else
        {
            sendMsg(nome+": "+MsgDigitada.getText());
            MsgDigitada.setText("");
        }
        //FAZ O CHAT SEMPRE ROLAR PARA BAIXO
        Chat.setCaretPosition(Chat.getDocument().getLength() - 1);
    }//GEN-LAST:event_EnviarMsgActionPerformed

    private void OpcaoSimboloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcaoSimboloActionPerformed
        
    }//GEN-LAST:event_OpcaoSimboloActionPerformed

    private void BotaoConectadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConectadoActionPerformed
        if(NomeDigitado.getText().equals("") || NomeDigitado.getText().equals("Digite seu nome aqui") || IPdigitado.getText().equals("") || PortaDigitada.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Preencha os Campos!");
        }
        else
        {
            Conexao();
            sendMsg(nome+" se conectou!");
            IPdigitado.setEnabled(false);
            PortaDigitada.setEnabled(false);
            NomeDigitado.setEditable(false);
        }
    }//GEN-LAST:event_BotaoConectadoActionPerformed

    private void BotaoDesconectadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDesconectadoActionPerformed
        Desconexão();        
        BotaoDesconectado.setEnabled(false);
        NovoJogo.setEnabled(false);
        EnviarMsg.setEnabled(false);
        OpcaoSimbolo.setEnabled(false);
        BotaoConectado.setEnabled(true);
        IPdigitado.setEnabled(true);
        PortaDigitada.setEnabled(true);
        NomeDigitado.setEditable(true);
    }//GEN-LAST:event_BotaoDesconectadoActionPerformed

    private void MsgDigitadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MsgDigitadaMouseClicked
        MsgDigitada.setText("");
    }//GEN-LAST:event_MsgDigitadaMouseClicked

    private void NomeDigitadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NomeDigitadoMouseClicked
        NomeDigitado.setText("");
    }//GEN-LAST:event_NomeDigitadoMouseClicked

    private void IPdigitadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IPdigitadoMouseClicked
        IPdigitado.setText("");
    }//GEN-LAST:event_IPdigitadoMouseClicked

    private void PortaDigitadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PortaDigitadaMouseClicked
        PortaDigitada.setText("");
    }//GEN-LAST:event_PortaDigitadaMouseClicked

    private void MsgDigitadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsgDigitadaActionPerformed
        
    }//GEN-LAST:event_MsgDigitadaActionPerformed
    
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
    private javax.swing.JButton BotaoConectado;
    private javax.swing.JButton BotaoDesconectado;
    private javax.swing.JTextArea Chat;
    private javax.swing.JButton EnviarMsg;
    private javax.swing.JTextField IPdigitado;
    private javax.swing.JTextField MsgDigitada;
    private javax.swing.JTextField NomeDigitado;
    private javax.swing.JButton NovoJogo;
    private javax.swing.JLabel NumeroDeEmpate;
    private javax.swing.JLabel NumeroDeVitoriasDoJogador1;
    private javax.swing.JLabel NumeroDeVitoriasDoJogador2;
    private javax.swing.JComboBox<String> OpcaoSimbolo;
    private javax.swing.JTextField PortaDigitada;
    private javax.swing.JButton SairDoJogo;
    private javax.swing.JButton VoltarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}