
import Mundo.Mundo;


/**
 *
 * @author bruno
 */

public class Main {

    
    public static void main(String[] args) {
        Mundo mundo = new Mundo();
        
        
        while(true){
            
            mundo.desenhaMundoConsole();
            mundo.atualizaPosicaoPessoas();
            
            try{
                Thread.sleep(300);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
}
