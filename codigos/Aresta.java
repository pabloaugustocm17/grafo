package codigos;

class Aresta{

    private int destino;
    private boolean visitada;
    private int peso;

    private void init(int destino, boolean visitada, int peso){

        this.destino = destino;
        this.visitada = visitada;
        this.peso = peso;
    
    }

    Aresta(){
        init(-1, false, 0);
    }

    Aresta(int destino){
        init(destino, false, peso);
    }

    public int getDestino(){
        return this.destino;
    }

    public int getPeso(){
        return this.peso;
    }

    public boolean getVisitada(){
        return this.visitada;
    }

    public void limparVisita(){

        if(this.visitada){
            this.visitada = false;
        }else{
            Util.ImprimiMensagem("Essa aresta não foi visitada ainda");
        }

    }

    public void visitarAresta(){

        if(!this.visitada){
            this.visitada = true;
        }else{
            Util.ImprimiMensagem("Essa aresta já foi visitada");
        }

    }

    


}