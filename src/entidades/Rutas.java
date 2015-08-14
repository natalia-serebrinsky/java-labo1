package entidades;

public class Rutas{

	//constructor privado hace Rutas static
	private Rutas(){}
	
	public final static String envRuben = "/home/ruben_baez/Dropbox/Document/Facultad/Laboratorio_I_201401/TP/";	
	//public final static String envNati = "/home/nati/workspace/";
	public final static String envNati = "/home/nati/Dropbox/TP_labo1/";
	
	public final static String env = envRuben;
	
	public final static String jugadores = env + "jugadores.txt";
	
	public final static String partido = env + "partido.txt";	

	public static String rutaBanderas = env + "Banderas/";
	
    public static String imagenBall = env + "img/ball.png";
    
    public static String juegoGuardado = env + "juegoGuardado.txt";
	
}