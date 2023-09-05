package Socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteSocket {
    private static ClienteSocket instance;  // Instância única do cliente
    private Socket cliente;
    private PrintStream saida;

    // Construtor privado para evitar criação de instâncias fora da classe
    private ClienteSocket() {
        cliente = null;
        saida = null;
    }

    // Método estático para obter a instância única
    public static synchronized ClienteSocket getInstance() {
        if (instance == null) {
            instance = new ClienteSocket();
        }
        return instance;
    }

    public void conectar(String endereco, int porta) throws IOException {
        if (cliente == null) {
            cliente = new Socket(endereco, porta);
            saida = new PrintStream(cliente.getOutputStream());

            // Thread para receber mensagens do servidor
            Thread threadReceber = new Thread(new ReceberMensagens(cliente));
            threadReceber.start();
        }
    }

    public void enviarMensagem(String mensagem) {
        if (saida != null) {
            saida.println(mensagem);
        }
    }

    public void encerrar() throws IOException {
        if (cliente != null) {
            cliente.close();
            cliente = null;
            saida = null;
        }
    }

    public static void main(String[] args) throws IOException {
        ClienteSocket cliente = ClienteSocket.getInstance();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o endereço do servidor:");
        String endereco = entrada.nextLine();
        System.out.println("Digite a porta do servidor:");
        int porta = entrada.nextInt();
        entrada.nextLine(); // Consumir a quebra de linha

        cliente.conectar(endereco, porta);

        System.out.println("Conectado ao servidor. Digite 'sair' para encerrar.");

        String mensagem;
        do {
            mensagem = entrada.nextLine();
            cliente.enviarMensagem(mensagem);
        } while (!"sair".equals(mensagem));

        cliente.encerrar();
    }
}

class ReceberMensagens implements Runnable {
    private Socket cliente;

    public ReceberMensagens(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String mensagem;

            while ((mensagem = entrada.readLine()) != null) {
                System.out.println(mensagem);
            }
        } catch (IOException e) {
            System.out.println("Erro ao receber mensagem do servidor: " + e.getMessage());
        }
    }
}
