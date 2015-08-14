package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entidades.ExceptionTanteador;
import entidades.Rutas;
import entidades.Tanteador;

public class Tablero extends JFrame {

    private JLabel lblGame, lblPuntoGameJugador1, lblPuntoGameJugador2, lblBlank, lblSet1, 
            lblSet2, lblSet3, lblSet4, lblSet5, lblJug1SetGame,
            lblJug2SetGame, lblJug1PuntosSet1, lblJug2PuntosSet1,
            lblJug1PuntosSet2, lblJug2PuntosSet2, lblJug1PuntosSet3,
            lblJug2PuntosSet3, lblJug1PuntosSet4, lblJug2PuntosSet4, 
            lblJug1PuntosSet5, lblJug2PuntosSet5, lblFotoJugador1, lblFotoJugador2, lblBanderaJugador1,
            lblBanderaJugador2,lblSaqueJugador1, lblSaqueJugador2;
    
    String rutaBanderas = Rutas.rutaBanderas;
    String imagenBall = Rutas.imagenBall;
    
    private Tanteador tanteador;
    

    public Tablero(Tanteador tanteador) throws ExceptionTanteador  {
        this.tanteador=tanteador;
        setSize(800, 600);
        setTitle("Tenis");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btnPlayer1 = new JButton("Punto Jugador1");
        JButton btnPlayer2 = new JButton("Punto Jugador 2");

        // Botones de los jugadores
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnPlayer1);
        panelBotones.add(btnPlayer2);
        
        btnPlayer1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anotarPuntoJug1();
            }
        });

        btnPlayer2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anotarPuntoJug2();
            }
        });
        
        add(BorderLayout.NORTH, panelBotones);

        // Panel de Puntuacion
        JPanel panelPuntuacion = new JPanel();
        panelPuntuacion.setBackground(Color.cyan);

        // GridLayout para el Panel
        if (tanteador.getPartido().isA3Sets()) {
            panelPuntuacion.setLayout(new GridLayout(3, 7));
        } else {
            panelPuntuacion.setLayout(new GridLayout(3, 8));
        }
        panelPuntuacion.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        add(panelPuntuacion);

        
        Font fontHeader = new Font("SansSerif", Font.BOLD, 20);
        Font fontBody = new Font("SansSerif", Font.PLAIN, 15);
        
        // Puntos Games
        lblBlank = new JLabel("");
        panelPuntuacion.add(lblBlank);
        lblBlank = new JLabel("");
        panelPuntuacion.add(lblBlank);
        lblBlank = new JLabel("");
        panelPuntuacion.add(lblBlank);
        lblBlank = new JLabel("");
        panelPuntuacion.add(lblBlank);
        
        lblGame = new JLabel("Game");
        
        lblGame.setBorder(BorderFactory.createLineBorder(Color.black));
        lblGame.setHorizontalAlignment(SwingConstants.CENTER);
        lblGame.setFont(fontHeader);
        panelPuntuacion.add(lblGame);

        lblPuntoGameJugador1= new JLabel("");
        lblPuntoGameJugador1.setBorder(BorderFactory.createLineBorder(Color.black));
        lblPuntoGameJugador1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPuntoGameJugador1.setFont(fontBody);
        
        lblPuntoGameJugador2= new JLabel("");
        lblPuntoGameJugador2.setBorder(BorderFactory.createLineBorder(Color.black));
        lblPuntoGameJugador2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPuntoGameJugador2.setFont(fontBody);
        
        
        
        // Jugador 1
        lblJug1SetGame = new JLabel(tanteador.getPartido().getJugador1().getNombre());
//      lblJug1SetGame .setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug1SetGame.setFont(fontBody);
        
        // Foto Jugador 1
        ImageIcon fotoJugador1 = new ImageIcon(tanteador.getPartido().getJugador1().getRutaFoto());
        lblFotoJugador1 = new JLabel(scale(fotoJugador1.getImage(), 60, 60));
        
        
        // Bandera Jugador1
        ImageIcon banderaJugador1 = new ImageIcon(rutaBanderas+tanteador.getPartido().getJugador1().getPais()+".png");
        lblBanderaJugador1=new JLabel(scale(banderaJugador1.getImage(), 30, 30));
        
        // Jugador 2
        lblJug2SetGame = new JLabel(tanteador.getPartido().getJugador2().getNombre());
//      lblJug2SetGame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug2SetGame.setFont(fontBody);
        
        // Foto Jugador 2
        ImageIcon fotoJugador2 = new ImageIcon(tanteador.getPartido().getJugador2().getRutaFoto());
        lblFotoJugador2 = new JLabel(scale(fotoJugador2.getImage(), 60, 60));
        
        // Bandera Jugador2
        ImageIcon banderaJugador2 = new ImageIcon(rutaBanderas+tanteador.getPartido().getJugador2().getPais()+".png");
        lblBanderaJugador2=new JLabel(scale(banderaJugador2.getImage(), 30, 30));
        
        lblSaqueJugador1=new JLabel("");
        lblSaqueJugador2=new JLabel("");
        
        
        // Headers
        lblSet1 = new JLabel(" 1 ");
        lblSet1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblSet1.setHorizontalAlignment(SwingConstants.CENTER);
        lblSet1.setFont(fontHeader);
        
        lblSet2 = new JLabel(" 2 ");
        lblSet2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblSet2.setHorizontalAlignment(SwingConstants.CENTER);
        lblSet2.setFont(fontHeader);
        
        lblSet3 = new JLabel(" 3 ");
        lblSet3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblSet3.setHorizontalAlignment(SwingConstants.CENTER);
        lblSet3.setFont(fontHeader);
        
        lblSet4 = new JLabel(" 4 ");
        lblSet4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblSet4.setHorizontalAlignment(SwingConstants.CENTER);
        lblSet4.setFont(fontHeader);
        
        lblSet5 = new JLabel(" 5 ");
        lblSet5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblSet5.setHorizontalAlignment(SwingConstants.CENTER);
        lblSet5.setFont(fontHeader);
        
        // Puntos
        lblJug1PuntosSet1 = new JLabel("");
        lblJug1PuntosSet1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug1PuntosSet1.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug1PuntosSet1.setFont(fontBody);
        
        lblJug1PuntosSet2 = new JLabel("");
        lblJug1PuntosSet2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug1PuntosSet2.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug1PuntosSet2.setFont(fontBody);
        
        lblJug1PuntosSet3 = new JLabel("");
        lblJug1PuntosSet3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug1PuntosSet3.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug1PuntosSet3.setFont(fontBody);
        
        lblJug1PuntosSet4 = new JLabel("");
        lblJug1PuntosSet4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug1PuntosSet4.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug1PuntosSet4.setFont(fontBody);
        
        lblJug1PuntosSet5 = new JLabel("");
        lblJug1PuntosSet5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug1PuntosSet5.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug1PuntosSet5.setFont(fontBody);
        
        lblJug2PuntosSet1 = new JLabel("");
        lblJug2PuntosSet1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug2PuntosSet1.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug2PuntosSet1.setFont(fontBody);
        
        lblJug2PuntosSet2 = new JLabel("");
        lblJug2PuntosSet2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug2PuntosSet2.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug2PuntosSet2.setFont(fontBody);
        
        lblJug2PuntosSet3 = new JLabel("");
        lblJug2PuntosSet3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug2PuntosSet3.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug2PuntosSet3.setFont(fontBody);
        
        lblJug2PuntosSet4 = new JLabel("");
        lblJug2PuntosSet4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug2PuntosSet4.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug2PuntosSet4.setFont(fontBody);
        
        lblJug2PuntosSet5 = new JLabel("");
        lblJug2PuntosSet5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblJug2PuntosSet5.setHorizontalAlignment(SwingConstants.CENTER);
        lblJug2PuntosSet5.setFont(fontBody);
        
        if (tanteador.getPartido().isA3Sets()) {
        
            panelPuntuacion.add(lblSet1);
            panelPuntuacion.add(lblSet2);
            panelPuntuacion.add(lblSet3);

            // Agrego Jugador 1
            panelPuntuacion.add(lblFotoJugador1);
            panelPuntuacion.add(lblJug1SetGame);
            panelPuntuacion.add(lblBanderaJugador1);
            panelPuntuacion.add(lblSaqueJugador1);
        	
            
            // Puntaje Game Jugador1
            panelPuntuacion.add(lblPuntoGameJugador1);

            // Puntaje Sets Jugador 1
            panelPuntuacion.add(lblJug1PuntosSet1);
            panelPuntuacion.add(lblJug1PuntosSet2);
            panelPuntuacion.add(lblJug1PuntosSet3);

            // Agrego Jugador 2
            panelPuntuacion.add(lblFotoJugador2);
            panelPuntuacion.add(lblJug2SetGame);
            panelPuntuacion.add(lblBanderaJugador2);
            panelPuntuacion.add(lblSaqueJugador2);
            
            // Puntaje Game Jugador2
            panelPuntuacion.add(lblPuntoGameJugador2);
            
            // Puntaje Sets Jugador 2
            
            panelPuntuacion.add(lblJug2PuntosSet1);
            panelPuntuacion.add(lblJug2PuntosSet2);
            panelPuntuacion.add(lblJug2PuntosSet3);
        } else {
            // Sets
                        
            panelPuntuacion.add(lblSet1);
            panelPuntuacion.add(lblSet2);
            panelPuntuacion.add(lblSet3);
            panelPuntuacion.add(lblSet4);
            panelPuntuacion.add(lblSet5);

            // Agrego Jugador 1
            panelPuntuacion.add(lblFotoJugador1);
            panelPuntuacion.add(lblJug1SetGame);
            panelPuntuacion.add(lblBanderaJugador1);
            panelPuntuacion.add(lblSaqueJugador1);
            
            // Puntaje Game Jugador1
            panelPuntuacion.add(lblPuntoGameJugador1);
            

            panelPuntuacion.add(lblJug1PuntosSet1);
            panelPuntuacion.add(lblJug1PuntosSet2);
            panelPuntuacion.add(lblJug1PuntosSet3);
            panelPuntuacion.add(lblJug1PuntosSet4);
            panelPuntuacion.add(lblJug1PuntosSet5);

            // Agrego Jugador 2
            panelPuntuacion.add(lblFotoJugador2);
            panelPuntuacion.add(lblJug2SetGame);
            panelPuntuacion.add(lblBanderaJugador2);
            panelPuntuacion.add(lblSaqueJugador2);
            
            // Puntaje Game Jugador2
            panelPuntuacion.add(lblPuntoGameJugador2);
            
            
            panelPuntuacion.add(lblJug2PuntosSet1);
            panelPuntuacion.add(lblJug2PuntosSet2);
            panelPuntuacion.add(lblJug2PuntosSet3);
            panelPuntuacion.add(lblJug2PuntosSet4);
            panelPuntuacion.add(lblJug2PuntosSet5);
        }
            
        actualizarPuntaje();
    }

    private void anotarPuntoJug1() {
        tanteador.puntoJugador(tanteador.getPartido().getJugador1());
        actualizarPuntaje();
    }
    
    private void anotarPuntoJug2() {
        tanteador.puntoJugador(tanteador.getPartido().getJugador2());
        actualizarPuntaje();
    }
    
    private void actualizarPuntaje() {
        String[] puntaje = tanteador.getTanteadorGameEnJuego();
        
        lblPuntoGameJugador1.setText(puntaje[0]);
        lblPuntoGameJugador2.setText(puntaje[1]);

        ArrayList<Integer> tanteadorSets = tanteador.getTanteadorSETS();
        int tamanio = tanteadorSets.size() ;
        
        
        if (tamanio >0) {lblJug1PuntosSet1.setText(" " + tanteadorSets.get(0)); } 
        if (tamanio >1) {lblJug2PuntosSet1.setText(" " + tanteadorSets.get(1));}
        if (tamanio >2) {lblJug1PuntosSet2.setText(" " + tanteadorSets.get(2));}
        if (tamanio >3) {lblJug2PuntosSet2.setText(" " + tanteadorSets.get(3));}
        if (tamanio >4) {lblJug1PuntosSet3.setText(" " + tanteadorSets.get(4));}
        if (tamanio >5) {lblJug2PuntosSet3.setText(" " + tanteadorSets.get(5));}
        if (tamanio >6) {lblJug1PuntosSet4.setText(" " + tanteadorSets.get(6));}
        if (tamanio >7) {lblJug2PuntosSet4.setText(" " + tanteadorSets.get(7));}
        if (tamanio >8) {lblJug1PuntosSet5.setText(" " + tanteadorSets.get(8));}
        if (tamanio >9) {lblJug2PuntosSet5.setText(" " + tanteadorSets.get(9));}

        
        ImageIcon fotoBall = new ImageIcon(imagenBall);
        if (tanteador.getPartido().getSetEnJuego().getGameEnJuego().isSacaJugador1()) {
        	lblSaqueJugador1.setIcon(scale(fotoBall.getImage(), 30, 30));
        	lblSaqueJugador2.setIcon(null);
        } else {
        	lblSaqueJugador2.setIcon(scale(fotoBall.getImage(), 30, 30));
        	lblSaqueJugador1.setIcon(null);
        }
    }

    private ImageIcon scale(Image src, int width, int height) {
        int w = width;
        int h = height;
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(w, h, type);
        Graphics2D g2 = dst.createGraphics();
        g2.drawImage(src, 0, 0, w, h, this);
        g2.dispose();
        return new ImageIcon(dst);
    }
}

