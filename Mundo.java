import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Mundo extends World{
    private static final int QTD_CARTAS = 28; // quantidade de cartas do jogo
    private static final int ESPACO_HORIZONTAL = 81; // tamanho da tela horizontal do jogo
    private static final int ESPACO_VERTICAL = 106; // tamanho da tela vertical do jogo
    private Carta [] carta = new Carta[QTD_CARTAS]; // vetor do tamanho da quantidade de cartas do 
    //O objeto lista é usado para conseguir obter uma imagem
    private ListaImagens lista = new ListaImagens();
    //Cerebro do jogo
    Cerebro cerebro = new Cerebro(this);
    private GreenfootImage background = new GreenfootImage("images/background.png");
    
    /**
     * Construtor da classe Mundo. Altera a imagem do plano de fundo do jogo e carrega as cartas para o inicio.
     */
    public Mundo(){    
        super(578, 438, 1);
        background.scale(578, 438);
        setBackground(background);
        carregaCartas();
    }
    
    /**
     * começar novo jogo
     */
    public void comecarNovoJogo(){
        lista.carregaIdentificacao();
        for(int i = 0; i < QTD_CARTAS; i++){
            carta[i].reiniciarCarta();
        }
    }
    
    /**
     * Cria os objetos Carta e os adiciona na tela, verificando os espaços contidos no mesmo.
     */
    public void carregaCartas(){
        int coluna = 45, 
            linha = 57, 
            qtd = 1;
            
        for(int i = 0; i < QTD_CARTAS; i++){
            carta[i] = new Carta(lista, cerebro);
            if(qtd <= 7){
                qtd++;
                addObject(carta[i], coluna, linha);
                coluna += ESPACO_HORIZONTAL;
            }else{
                qtd = 2;
                linha += ESPACO_VERTICAL;
                coluna = 45;
                addObject(carta[i], coluna, linha);
                coluna += ESPACO_HORIZONTAL;
            }
            
        }
    }
}
