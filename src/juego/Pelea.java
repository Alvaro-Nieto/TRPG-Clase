/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 * Esta clase sirve para saber si una unidad ha ganado la pelea. Se incluyen los métodos comparador y ganarCombate.
 * 
 * @author Guillermo
 */
public class Pelea {
    /**
     * En este método se comparan la fuerza y la defensa de una unidad. 
     * A este método sólo se accede si una unidad ya ha ganado el combate, por lo que se compara la fuerza de la unidad vencedora
     * con la defensa de la unidad perdedora.
     */
    public static boolean Comparador (int fuerza, int defensa)
    {
        boolean victoria=false; //en este boolean se recoge si la unidad atacante ha conseguido herir a la unidad defensora.
        int dado=(int)(Math.random()*6)+1;//dado para hacer la primera tirada obligatoria
        int dado2;//dado que sólo se tira si es necesario. 
                  //Será necesario tan sólo si la defensa de la unidad defensora 
                  //supera a la fuerza de la atacante en un mínimo de 5 puntos
        if(fuerza>=1 && defensa<=fuerza+4)
        {
            switch(dado)
            {
                case 1: victoria=false; //En estos dos primeros casos es imposible matar. El mínimo que se ha de sacar en el dado es 3
                break;
                case 2: victoria=false;
                break;
                //a partir de aquí se ve reflejada la tabla para herir. Está probado y funciona, pero hacedle la traza si tenéis ganas sólo por asegurarnos
                case 3: if(fuerza>=defensa+2)
                        {
                            victoria=true;
                        }
                break;
                case 4: if(fuerza==defensa || fuerza>=defensa+1) 
                        {
                            victoria=true;
                        }
                break;
                case 5: if(fuerza<=defensa+1 || fuerza<=defensa+2) 
                        {
                            victoria=true;
                        }
                break;
                case 6: victoria=true;
                        
                break;
            }
        }
        else if(fuerza>=1 && defensa>=fuerza+5 && dado==6)
        {
            dado2=(int)(Math.random()*6)+1;
            switch(dado2)
            {
                case 4: if(defensa<=fuerza+5)
                        {
                            victoria=true;
                        }
                break;
                case 5: if(defensa<=fuerza+6)
                        {
                            victoria=true;
                        }
                break;
                case 6: if(defensa<=fuerza+7)
                        {
                            victoria=true;
                        }
                break;
                default: victoria=false;
                break;
            }
        }
        return victoria;
    }
    //Este método es simple de entender, se tiran dos dados (el primero para la unidad1 y el segundo para la segunda)
    //y se comparan. Luego se aplican las reglas que os expliqué. Luego se terminará de implementar cuando exista la clase unidad.
    public static Unidad ganarCombate (Unidad unidad1, Unidad unidad2)
    {
        int dado1 = (int)(Math.random()*6)+1;
        int dado2 = (int)(Math.random()*6)+1;
        
        if (dado1>dado2)
        {
            return unidad1;
        }
        else if(dado1<dado2)
        {
            return unidad2;
        }
        else if(dado1==dado2)
        {
            if(unidad1.getCombate()>unidad2.getCombate())
            {
                return unidad1;
            }
            else if(unidad1.getCombate()<unidad2.getCombate())
            {
                return unidad2;
            }
            else if(unidad1.getCombate()==unidad2.getCombate())
            {
                int dadoDesempate = (int)(Math.random()*6)+1;
                if (dadoDesempate<=3)
                {
                    return unidad1;
                }
                else
                    return unidad2;
            }
        }
        
    }
    
}
