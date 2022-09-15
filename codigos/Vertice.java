package codigos;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

    private final int id = Util.retornaID();
    private List<Aresta> arestas;
    private boolean visitado;

    /* Construtor */

    private void init(boolean visitado){

        this.arestas = new ArrayList<>();
        this.visitado = visitado;

    }

    Vertice(){

        init(false);

    }

    /* Métodos */


    /**
     * @param destino -> recebe o destino para adiconar uma nova aresta 
     * @return -> caso seja possível adiconar a aresta, é retornado verdadeiro, caso não, falso
     */
    public boolean addAresta(int destino){

        Aresta arestaAdd = new Aresta(destino);

        if(!Util.IsListaArestasVazia(this.arestas)){

            if(existeAresta(destino) == null){
                
                addAresta(arestaAdd);
                return true;

            }else{

                Util.ImprimiErro("Já existe uma aresta nesse destino");
                return false;

            }

        }else{
            
            addAresta(arestaAdd);
            return true;
        
        }
        
    }


    /**
     * @param destino -> recebe o destino e verifica se existe alguma aresta que realiza esse destino, verificando sua existência
     * @return -> caso exista uma aresta ela é retornada, caso não é voltado uma aresta nula
     */
    public Aresta existeAresta(int destino){

        if(!Util.IsListaArestasVazia(this.arestas)){

            for(Aresta aresta : this.arestas){

                if(aresta.getDestino() == destino){
                    return aresta;
                }

            }

            return null;
        
        }else{

            return null;

        }

    }

    public void visitarVertice(){

        if(!this.visitado){
            this.visitado = true;
        }else{
            Util.ImprimiErro("Vértice já visitado");
        }


    }

    public void limparVisita(){

        if(this.visitado){
            this.visitado = false;
        }else{
            Util.ImprimiErro("Vértice não foi visitado ainda");
        }

    }

    /* Getters and Setters */

    public int getGrau(){
        return this.arestas.size();
    }

    public boolean getVisitado(){
        return this.visitado;
    }

    public int getID(){
        return this.id;
    }

    /* Util */

    
    /**
     * @param aresta -> recebe a aresta á ser adicionada
     */
    private void addAresta(Aresta aresta){
        this.arestas.add(aresta);
    }

    public void imprimiVertice(){

        if(!Util.IsListaArestasVazia(this.arestas)){

            Util.ImprimiMensagemSemQuebraLinha("Vertice (" + this.id + "): ");

            for(int i = 0; i < this.getGrau(); i++){

                if(i == this.getGrau()-1){
                    Util.ImprimiMensagem("{" + this.arestas.get(i).getDestino() + "}");
                }else{
                    Util.ImprimiMensagemSemQuebraLinha("{" + this.arestas.get(i).getDestino() + "}, ");
                }

            }

        }else{

            Util.ImprimiErro("Vértice (" + this.id + "): Vazio");

        }

        

    }

}
