public class App {
    enum direcoes{
        NORTE,
        LESTE,
        SUL,
        OESTE
    };    

/* 
    0       5     
    1       4  
    2 - 5 = -3 (*-1) = 3
    3 - 5 = -2 (*-1) = 2
    4 - 5 = -1 (*-1) = 1
    5 - 5 = 0
    */
    //iremos fazer a função que mostra o robozin andando
    public static void mostra(Rover robo, Plato plato){       
        for(int i = 0; i <= plato.limiteX; i++){ //linhas
            for(int j = 0; j <= plato.limiteY; j++){ //colunas
                if(-1*(i - plato.limiteX) == robo.y && j == robo.x){
                    System.out.print("R\t");
                }
                else{
                    System.out.print(".\t");
                }
            }
            System.out.println();
        }
        System.out.println("O robo esta em " + robo.x + " e em " + robo.y + ", olhando para o " + robo.direcao);
    }
    public static void main(String[] args) throws Exception {
        InputReader input = new InputReader();
        Plato plato = input.retornaPlato();
        while(input.temLinha()){
            Rover rover = input.RetornaRover();
            System.out.println("POSICAO INICIAL: " + rover.x + " , " + rover.y + " , " + rover.direcao);
            char[] comandos = input.retornaComandos();
            for (int i = 0; i < comandos.length; i++){
                rover.decifraComando(comandos[i], plato.limiteX, plato.limiteY);
                mostra(rover, plato);
            }
            System.out.println("POSICAO FINAL: " + rover.x + " , " + rover.y + " , " + rover.direcao);
        }
    }
}
