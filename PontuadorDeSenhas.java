 /** Date: 05.11.2018
 * @authors (Marina Moreira && Victor Botelho) 
 * @version (número de versão ou data)
 */
import java.util.Scanner;
public class Senhas
{
    /**
     * Método para calcular a quantidade de digitos de uma senha e pontuá-la de acordo com os digitos
     * encotrados;
     * @param - String = Senha digitada pelo usuário;
     * @return - int = pontuação da senha.
     */
    
    public static int SenhaComDigitos (String senhaUser)
    {
        int pontuacao = 0;//variavel do tipo inteiro que irá armazenar a pontuação da senha
        int tamanhoSenha = tamanhoSenha = Senhas.TamanhoSenha(senhaUser);
        //variavel que chama o metodo para calcular o tamanho da senha e guarda esse valor 
        
        
        if(tamanhoSenha >= 6)//Caso o tamanho da String seja maior que 6, calcula-se a pontução por digitos 
        {
                for(int posicao = 0;posicao < tamanhoSenha;posicao++)//laço para analisar cada caracter da String
                {
                    char letra = senhaUser.charAt(posicao);//variavel do tipo caracter que chama uma função
                    //para senhaUser que analisa e retorna o char do indice.
                    
                        switch(letra)//Analisa o que está contido em letra de acordo com os casos abaixos
                        {
                            case '0'://caso o char seja '0'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;
                               
                            case '1'://caso o char seja '1'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;
                               
                            case '2'://caso o char seja '2'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;
                               
                            case '3'://caso o char seja '3'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;
                               
                            case '4'://caso o char seja '4'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;
                               
                            case '5'://caso o char seja '5'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;
                               
                            case '6'://caso o char seja '6'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;
                               
                            case '7'://caso o char seja '7'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;
                               
                            case '8'://caso o char seja '8'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;
                               
                            case '9'://caso o char seja '9'
                               pontuacao = pontuacao + 3;//recebe + 3 de pontuação
                               break;   
                               
                            default:
                               break;
                        }
                        
                    pontuacao++;//adiciona 1 ponto a pontuação por cada caracter adicional    
                }
        }
        else//Caso a senha seja menor que 6 cai no else.
        {
            pontuacao = 0;//recebe 0
        }
    
        return pontuacao;//retorna o valor da pontuação.
    }
    
    /**
     * Método para calcular a quantidade de caracteres com caixa alta de uma senha e pontuá-la de acordo 
     * com os caracteres encotrados;
     * @param - String = senhaUser;
     * @return - int = pontuacao;
     */
    
    public static int SenhasComMaiusculas(String senhaUser)
    {
        int pontuacao = 0;//Cria a variável pontuação nesse método
        pontuacao = Senhas.SenhaComDigitos(senhaUser);//pontuação acumula o valor que recebeu no metodo anterior
        int tamanhoSenha = Senhas.TamanhoSenha(senhaUser);//recebe o tamanho da senha por meio do método criado
        boolean jaTemCaixaAlta = false;//variavel do tipo boolean para saber se a senha ja possui caixa alta
        int qtdMaiusc = 0;//variavel do tipo inteiro para armazenar a qtd de maiusculas
        
        for(int posicao = 0;posicao < tamanhoSenha;posicao++)
        {
            char letra = senhaUser.charAt(posicao);//mesmo laço do método anterior, com diferença que esse 
            //analise o indice e confere se possui caixa alta por meio da tabela ASCII. 
            if(jaTemCaixaAlta == false)//Função condicional para não entrar em loop infinito
            {
                while(qtdMaiusc < 1)//Laço para pontuar apenas o aparecimento de uma letra maiuscula
                {
                    if((letra >= 65) && (letra <= 90))//Caso a letra seja de caixa alta recebe a pontuação
                    //de acordo com a tabela ASCII
                    {
                        pontuacao+=15;
                        jaTemCaixaAlta = true;//recebe true para não entrar mais no primeiro IF.
                    }
                    
                    qtdMaiusc++;//Recebe incremento para sair do laço
                }
                qtdMaiusc = 0;//recebe zero para entrar no laço novamente para o próximo indice da senha.
            }
        }
        //função condicional para analisar o caso especifico de uma senha ser inteiramente em caixa alta
        //e receber o mesmo valor caso fosse em caixa baixa.
        if(senhaUser.equals(senhaUser.toUpperCase()))
        {
            pontuacao = pontuacao - 15;
        }
        
        return pontuacao;//retorna o novo valor da pontuação
    }
    
    /**
     * Método para calcular a quantidade de caracteres especiais de uma senha e pontuá-la de acordo 
     * com os caracteres encotrados;
     * @param - String = senhaUser;
     * @return - int = pontuacao;
     */
    
    public static int SenhasComCaracteresEspeciais(String senhaUser)
    {
        int pontuacao = Senhas.SenhasComMaiusculas(senhaUser);//cria novamente a variavel para acumular 
        //as pontuações dos outros métodos
        int tamanhoSenha = tamanhoSenha = Senhas.TamanhoSenha(senhaUser);//recebe o tamanho da senha por meio do método criado
        int qtdCaracEspeciais = 0;//variavel para quantificar os caracteres especiais
        
        for(int posicao = 0;posicao < tamanhoSenha;posicao++)
        {
            char letra = senhaUser.charAt(posicao);//mesmo laço do método anterior, com diferença 
            //que esse analise o indice e confere se possui caracteres especiais.
            
            if(qtdCaracEspeciais == 0)//Função condicional para pontuar apenas a existencia de 1 caracter
            //especial
            {
                switch(letra)//analisa cada indice da senha para caracteres especiais
                {
                    case '@'://caso a senha possua '@'
                        pontuacao+= 10;//recebe mais 10 pontos
                        qtdCaracEspeciais++;//recebe 1 para sair do IF e pontuar apenas a existência de 
                        //1 caracter especial
                        break;
            
                    case '#'://caso a senha possua '#'
                        pontuacao+= 10;//recebe mais 10 pontos
                        qtdCaracEspeciais++;//recebe 1 para sair do IF e pontuar apenas a existência de
                        //1 caracter especial
                        break;
                        
                    case '$'://caso a senha possua '$'
                        pontuacao+= 10;//recebe mais 10 pontos
                        qtdCaracEspeciais++;//recebe 1 para sair do IF e pontuar apenas a existência de
                        //1 caracter especial
                        break;
                        
                    case '_'://caso a senha possua '_'
                        pontuacao+= 10;//recebe mais 10 pontos
                        qtdCaracEspeciais++;//recebe 1 para sair do IF e pontuar apenas a existência de
                        //1 caracter especial
                        break;
            
                    default:
                        break;
                }
            }
        }
        
        
        return pontuacao;//retorna a pontuação atual da senha
    }
    
    /**
     * Método para calcula o tamanho da senha.
     * @param - String = senhaUser;
     * @return - int = tamanhoSenha;
     */
    
    public static int TamanhoSenha(String senhaUser)//método para calcular o tamanho da String
    {
         int tamanhoSenha = 0;//variável do tipo inteiro para armazenar o tamanho
         tamanhoSenha = senhaUser.length();//calcula o tamanho da String
         
         return tamanhoSenha;//retorna o valor do tamanho da String
    }        
    
    /**
     * Método principal que irá chamar os outros, os quais irão executar 80% do programa
     * @param - String = senhaUser;
     * @return - int = pontuacao e tamanhoSenha;
     */
   
    public static void main (String [] args)
    {
        Scanner in = new Scanner (System.in);//chama o scanner para ler o input do usuário
        
        String senhaUser;//variável do tipo String para guardar a senha inserida do usuário
        int tamanhoSenha = 0;//variável do tipo inteiro para guardar o tamanho da senha
        int pontuacao = 0;//variável do tipo inteiro para guardar a pontuacao da senha do usuário
        
        System.out.print("Digite uma senha: ");//imprime na tela do usuário: Digite uma senha: 
        senhaUser = in.nextLine();//pede a senha para o usuário
        
        tamanhoSenha = Senhas.TamanhoSenha(senhaUser);//chama o método para calcular o tamanho da senha.
        System.out.printf("O tamanho da sua senha é: %d\n", tamanhoSenha);//mostra o tamanho da senha.
        
        pontuacao+= Senhas.SenhasComCaracteresEspeciais(senhaUser);//chama o método para calcular a pontuação
        System.out.printf("A pontuação da sua senha é: %d.\n", pontuacao);//exibe a pontuação na tela.
    }
    /*
     * Escrever um programa que solicita uma senha para o usuário e avalia a qualidade dessa 
     * senha, com uma pontuação conforme os critérios a seguir. O programa necessariamente deverá
     * envolver pelo menos dois métodos (subprogramas) além do "main". Sugere-se utilizar o máximo
     * de métodos reutilizáveis que for possível.

        Senhas com menos de 6 caracteres: 0 pontos no total
        
        Senhas com 6 ou mais caracteres:
        
        - 1 ponto adicional por cada caractere. Ex: abcdefg = 7 pontos
        
        - 3 pontos adicionais por cada dígito
        
        - 10 pontos adicionais se a senha contiver pelo menos um caractere especial: @, #, $ ou _ (não importando a quantidade deles)
        
        - 15 pontos adicionais se a senha misturar letras maiúsculas e minúsculas
        
        Exemplos:                               Testes com sucesso(autoavalição):
        
        *Senha 'jha4' Pontuação = 0             1.0
        *Senha 'abcdefg' Pontuação = 7          1.0
        *Senha 'abcdefg@' Pontuação = 18        1.0
        *Senha 'abcdefg@#$' Pontuação = 20      1.0
        *Senha 'Abcdefg@#$' Pontuação = 35      1.0
        *Senha 'Abcdefg@#$1' Pontuação = 39     1.0
        *Senha 'ABCDEFG' Pontuação = 7          1.0
        *Senha 'ABCDEFG1' Pontuação = 11        1.0
        *Senha 'ABCDEFG1_' Pontuação = 22       1.0
        *Senha 'aBcDeFg' Pontuação = 22         1.0
     */
}