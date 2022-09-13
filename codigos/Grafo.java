package codigos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Grafo {
    
    public final String nome = Util.getNomeGrafo();

    private List<Vertice> vertices;

    /* Construtores */

    private void init(List<Vertice> vertices){
        this.vertices = vertices;
    }

    Grafo(){
        List<Vertice> vertices = new ArrayList<>();
        init(vertices);
    }

    Grafo(List<Vertice> vertices){
        init(vertices);
    }

    /* Métodos */

    public void carregarGrafo(String path){

        File arquivo = new File(path);

        try(FileReader fileReader = new FileReader(arquivo)){

            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                


                bufferedReader.close();

            } catch (Exception e) {
                
            }

            
            fileReader.close();

        }catch(Exception e){

        }

    } 

}
