import greenfoot.*;

public class Cerebro{
    private int qtdCartasViradas = 0;
    private static int QTD_PARES = 14;
    private int qtdCartasDescobertas = 0;
    private int pontuacao = 0;
    private Carta carta1, carta2;
    private GreenfootImage nomeDaCartaVirada1;
    private GreenfootImage nomeDaCartaVirada2;
    private Mundo refMundo;
    private Pontuacao qPontos;
    
    public Cerebro(Mundo d){
        refMundo = d;
        qPontos = new Pontuacao(refMundo);
    }
    
    public void VerificaCartaVirada(GreenfootImage i, Carta c){
        if(++qtdCartasViradas == 1){
            nomeDaCartaVirada1 = i;
            carta1 = c;
        }else{
            if(qtdCartasViradas == 2){
                nomeDaCartaVirada2 = i;
                carta2 = c;
                
                qtdCartasViradas = 0;
                pontuacao++;
                if(nomeDaCartaVirada1 == nomeDaCartaVirada2){
                    qtdCartasDescobertas++;
                    Greenfoot.delay(10);
                    carta1.removerCarta();
                    carta2.removerCarta();
                    verificaFimDeJogo();
                }else{
                    Greenfoot.delay(10);
                    carta1.desvirarCarta();
                    carta2.desvirarCarta();
                    carta1 = null;
                    carta2 = null;
                    nomeDaCartaVirada1 = null;
                    nomeDaCartaVirada2 = null;
                }
            }    
        }
    }
    
    /**
     * Verifica o fim do jogo
     */
    public void verificaFimDeJogo(){
        if(qtdCartasDescobertas == QTD_PARES){
            qtdCartasDescobertas = 0;
            qPontos.setPontuacao(pontuacao);
            refMundo.addObject(qPontos, 287, 220);
            pontuacao = 0; 
        }
    }
    
    /**
     * Verifica se é possível desvirar uma carta, quando não há duas cartas desviradas.
     */
    public boolean podeDesvirarCarta(){
        if(qtdCartasViradas <= 1)
            return true;
        else
            return false;
    }
}
