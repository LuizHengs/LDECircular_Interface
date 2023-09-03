package Lista_Beecrowd_2;

class LSECircular <T> {

    private static String CODE = "Nao encontrado";

    class No {
        private T conteudo;
        private boolean ligado = true;
        private No proximo;
        private No anterior;

        public No() {
            proximo = null;
            anterior = null;
        }

        public T getConteudo() {
            return conteudo;
        }

        public No getProximo() {
            return proximo;
        }

        public No getAnterior() {
            return anterior;
        }

        public boolean isLigado() {
            return ligado;
        }

        public void setLigado(boolean ligado) {
            this.ligado = ligado;
        }

        public void setConteudo(T conteudo) {
            this.conteudo = conteudo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }

        public void setAnterior(No anterior) {
            this.anterior = anterior;
        }

    }

   private No cabeca;
   private No cauda;
   private int nElementos;

    public LSECircular() {
        cabeca = null;
        cauda = null;
        nElementos = 0;
    }

    public No getCabeca() {
        return cabeca;
    }

    public No getCauda() {
        return cauda;
    }

    public boolean vazia () {
        if (nElementos == 0)
            return true;
        else
            return false;
    }

    public int Tamanho() {
        return nElementos;
    }

    public No buscaPosicao (int posicao) throws outException {
        if (vazia())
            throw new outException(CODE, "Esta vazia!");
        if (posicao <= 0 || posicao > nElementos)
            throw new outException(CODE, "Este elemento nao existe aqui");

        No aux = new No();

        if (posicao <= nElementos/2) {
            aux = cabeca;
            for (int i = 1; i < posicao; i++)
                aux = aux.getProximo();
        }
        else{
            aux = cauda;
            for (int i = nElementos; i > posicao; i--)
                aux = aux.getAnterior();
        };
        return aux;

    }

    public T buscaPosicaoConteudo (int posicao) throws outException{
        return buscaPosicao(posicao).getConteudo();
    }

    public int buscaValor (T valor) throws outException {
        if (vazia())
            throw new outException(CODE, "Esta vazia!");

        No aux = new No();
        int posicao = 1;
        while (aux != null) {
            aux = aux.getProximo();
            posicao++;
            if (aux.getConteudo() == valor)
                return posicao;
        }

        if (aux == null)
            throw new outException(CODE, "Nao tem este valor aqui!");

        posicao = 0;
        return posicao;
    }

    private void inserirInicio(T conteudo) {
        No aux = new No();
        aux.conteudo = conteudo;

        if (!vazia()) {
            aux.setProximo(cabeca);
            aux.setAnterior(cauda);

            cabeca.setAnterior(aux);
            cauda.setProximo(aux);
        } else {
            cauda = aux;

        }

        cabeca = aux;

        nElementos++;

        aux = null;

    }

    private void inserirFinal(T conteudo) {
        No aux = new No();
        aux.conteudo = conteudo;

        aux.setAnterior(cauda);
        aux.setProximo(cabeca);

        cauda.setProximo(aux);
        cabeca.setAnterior(aux);
        cauda = aux;

        nElementos++;

        aux = null;

    }

    private void inserirMeio (T conteudo, int posicao) throws outException{

        No aux = new No();
        No trem;
        aux.conteudo = conteudo;
        //
        if (vazia())
            throw new outException(CODE, "Esta vazia!");
        if (posicao <= 0 || posicao > nElementos + 1)
            throw new outException(CODE, "Este elemento nao existe aqui");

        if (posicao <= nElementos/2 + 0.5) {
            trem = cabeca;
            for (int i = 1; i < posicao - 1; i++)
                trem = trem.getProximo();
        }
        else{
            trem = cauda;
            for (int i = nElementos; i > posicao - 1; i--)
                trem = trem.getAnterior();
        };
        //

        if (nElementos == 1) {
            trem.setProximo(aux);
            trem.setAnterior(aux);
        } else {
            aux.setProximo(trem.getProximo());
            aux.setAnterior(trem);
        }
        trem.getProximo().setAnterior(aux);
        trem.setProximo(aux);


        nElementos++;

        if (posicao == nElementos)
            cauda = aux;

        aux = null;

    }

    public void inserir (T conteudo, int posicao) throws outException {
        if (vazia() || posicao == 1)
            inserirInicio(conteudo);
        else if (posicao == nElementos + 1)
            inserirFinal(conteudo);
        else
            inserirMeio(conteudo, posicao);
    }

    public T remover (int posicao) throws outException {
        No aux;

        if (posicao <= nElementos/2) {
            aux = cabeca;
            for (int i = 1; i < posicao; i++)
                aux = aux.getProximo();
        }
        else{
            aux = cauda;
            for (int i = nElementos; i > posicao; i--)
                aux = aux.getAnterior();
        };

        T valorRemovido = aux.conteudo;



        if (nElementos > 1) {
            aux.getProximo().setAnterior(aux.getAnterior());
            aux.getAnterior().setProximo(aux.getProximo());
        }
        if (posicao == 1)
            cabeca = aux.getProximo();
        if (posicao == nElementos)
            cauda = aux.getAnterior();
        aux.setProximo(null);
        aux.setAnterior(null);
        aux = null;

        nElementos--;

        return valorRemovido;
    }

}
