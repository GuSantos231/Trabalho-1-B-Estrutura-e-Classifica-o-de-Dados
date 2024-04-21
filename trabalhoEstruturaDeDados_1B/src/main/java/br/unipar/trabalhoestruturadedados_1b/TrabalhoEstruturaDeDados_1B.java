package br.unipar.trabalhoestruturadedados_1b;

import javax.swing.JOptionPane;
/**
 *
 * @author gusan
 */
public class TrabalhoEstruturaDeDados_1B {

    public static void main(String[] args) {
        
        // Solicitar o tamanho do vetor e os numeros dele:
        int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor:"));
        int[] vetorOriginal = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetorOriginal[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento " + (i + 1) + ":"));
        }
        
        // Clonar o vetor original para que não seja modificado pela ordenação
        int[] vetorOrdenar = vetorOriginal.clone();
          
        // Exibir menu de opções
        String[] opcoes = {"Ordenação por Inserção", "Ordenação por Seleção", "Ordenação Bolha"};
        int escolha = JOptionPane.showOptionDialog(null, 
                "Escolha o método de ordenação:", "Menu de Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0 -> ordenarPorInsercao(vetorOrdenar, vetorOriginal);
            case 1 -> ordenarPorSelecao(vetorOrdenar, vetorOriginal);
            case 2 -> ordenarBolha(vetorOrdenar, vetorOriginal);
            default -> System.exit(0);
        }        
    }    
    public static void ordenarPorInsercao(int[] vetor, int[] vetorOriginal) {
        //ORDENAÇÃO POR INSERÇÃO
        
        int chave;  
        int j;
        //Identifica a ordem correta:
        for(int i = 1; i < vetor.length; i++){
            chave = vetor[i];
            
            for( j = i-1; (j >=0 && vetor[j] > chave); j-- ){
                vetor[j+1] = vetor[j];
            }
            vetor[j+1] = chave;
        }   
        //Exibe o resultado:
        String msgOrdenado = "";
        for (int i = 0; i < vetor.length; i++) {
            msgOrdenado += vetor[i];
            if(i < vetor.length-1){
                msgOrdenado += " - ";
            }
        }
        String msgOriginal = "";
        for (int i = 0; i < vetorOriginal.length; i++) {
            msgOriginal += vetorOriginal[i];
            if(i < vetorOriginal.length-1){
                msgOriginal += " - ";
            }
        }
        JOptionPane.showMessageDialog(null, "Vetor informado: \n" + msgOriginal +
                "\nVetor ordenado: \n" + msgOrdenado);       
    }   
    public static void ordenarPorSelecao(int[] vetor, int[] vetorOriginal) {
        //ORDENAÇÃO POR SELEÇÃO
        
        //Identificar a ordem correta:
        for(int i=0; i<vetor.length; i++){
            int posicaoMenor = i;
            
            for(int j = i+1; j < vetor.length; j++){
                if(vetor[j] < vetor[posicaoMenor]){
                    posicaoMenor = j;
                }                
            }
            if(posicaoMenor != i){ 
                int auxiliar = vetor[i];
                vetor[i]= vetor[posicaoMenor];
                vetor[posicaoMenor] = auxiliar;
            }
        }
        //Exibir resultado:
        String msgOrdenada = "";
        for(int i = 0; i < vetor.length; i++){
            msgOrdenada += vetor[i];
            if(i < vetor.length-1){
                msgOrdenada += " - ";
            }
        }
        String msgOriginal = "";
        for (int i = 0; i < vetorOriginal.length; i++) {
            msgOriginal += vetorOriginal[i];
            if(i < vetorOriginal.length-1){
                msgOriginal += " - ";
            }
        }
        JOptionPane.showMessageDialog(null, "Vetor informado: \n" + msgOriginal +
                "\nVetor ordenado: \n" + msgOrdenada); 
    }
    public static void ordenarBolha(int[] vetor, int[] vetorOriginal) {
        //ORDENAÇÃO BOLHA
        
        //Identificar ordem correta:
        boolean houveTroca = true;
        
        while(houveTroca){
            houveTroca = false;
            
            for (int i = 0; i < vetor.length -1; i++) {
                
                if(vetor[i] > vetor[i+1]){
                 int aux = vetor[i];
                 vetor[i] = vetor[i+1];
                 vetor[i+1] = aux;
                 houveTroca = true;
                }                      
            }            
        }
        //Exibir resultado:
        String msgOrdenada = "";
        for(int i = 0; i < vetor.length; i++){
            msgOrdenada += vetor[i];
            if(i < vetor.length-1){
                msgOrdenada += " - ";
            }
        }
        String msgOriginal = "";
        for (int i = 0; i < vetorOriginal.length; i++) {
            msgOriginal += vetorOriginal[i];
            if(i < vetorOriginal.length-1){
                msgOriginal += " - ";
            }
        }
        JOptionPane.showMessageDialog(null, "Vetor informado: \n" + msgOriginal +
                "\nVetor ordenado: \n" + msgOrdenada); 
    }
}