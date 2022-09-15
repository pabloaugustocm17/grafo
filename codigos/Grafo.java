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
                
                String linha;
                int linha_referencia = 0;

                linha = bufferedReader.readLine();

                String divisao_matriz[] = linha.split("-");

                for(int i = 0; i < divisao_matriz.length; i++){
                    
                    this.addVertice(new Vertice());

                }


                while(linha != null){

                    divisao_matriz = linha.split("-");

                    for(int i = 0; i < divisao_matriz.length; i++){

                        if(divisao_matriz[i].equals("1")){

                            this.addAresta(i, linha_referencia);

                        }
    
                    }
                    
                    linha_referencia++;
                    linha = bufferedReader.readLine();

                }


                bufferedReader.close();

            } catch (Exception e) {
                
            }

            fileReader.close();

        }catch(Exception e){

        }

    } 

    public boolean addVertice(Vertice novo){

        for(Vertice vertice_analisar : this.vertices){

            if(vertice_analisar.equals(novo)){
                Util.ImprimiErro("Vértice já existe em grafo");
                return false;
            }

        }

        this.vertices.add(novo);
        return true;

    } 

    public boolean addAresta(int origem, int destino){

        if(this.vertices.size() < 2){
            Util.ImprimiErro("Grafo não possui vértices suficientes");
            return false;
        }

        for(int i = 0; i < this.vertices.size(); i++){
            
            if(this.vertices.get(i).getID() == origem){
                this.vertices.get(i).addAresta(destino);
            }

        }

        return false;

    }

    public void imprimiGrafo(){

        for (Vertice vertice : this.vertices) {
            
            vertice.imprimiVertice();

        }

        if(this.vertices.size() == 0){
            System.out.println("NULL");
        }

    }

}
