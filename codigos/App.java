package codigos;

public class App {
    
    public static void main(String[] args) {
        
        Grafo grafo = new Grafo();
        grafo.carregarGrafo("C:\\Users\\Pablo Magalhães\\Documents\\GitHub\\grafo\\resources\\grafo1.txt");
        grafo.imprimiGrafo();

    }
    
}
