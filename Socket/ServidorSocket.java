package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta classe representa o cliente socket para enviar mensagens para o servidor.
 */

public class ServidorSocket {
    static Map<Socket, String> socketToUserMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        List<Socket> conexoes = new ArrayList<>();
        try (ServerSocket servidor = new ServerSocket(7000)) {

            Thread consoleThread = new Thread(() -> {
                try {
                    BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
                    while (true) {
                        String serverMessage = consoleInput.readLine();
                        for (Socket cliente : conexoes) {
                            try {
                                PrintWriter writer = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()));
                                writer.println("Servidor: " + serverMessage);
                                writer.flush();
                            } catch (IOException e) {
//                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e) {
//                    e.printStackTrace();
                }
            });
            consoleThread.start();

            while (true) {
                System.out.println("Aguardando conexões...");
                Socket conexao = servidor.accept();
                conexoes.add(conexao);

                BufferedReader nomeUsuarioInput = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                String nomeUsuario = nomeUsuarioInput.readLine();
                socketToUserMap.put(conexao, nomeUsuario);

                System.out.println("Cliente conectado: " + conexao.getInetAddress() + " (" + nomeUsuario + ")");

                Thread thread = new Thread(new ClienteHandler(conexao, conexoes));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Algo errado aconteceu");
        }
    }
}

class ClienteHandler implements Runnable {
    private final Socket conexao;
    private final List<Socket> conexoes;

    public ClienteHandler(Socket conexao, List<Socket> conexoes) {
        this.conexao = conexao;
        this.conexoes = conexoes;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            do {
                String texto = entrada.readLine();
                if (texto == null || "sair".equals(texto)) {
                    break;
                }

                String nomeUsuario = ServidorSocket.socketToUserMap.get(conexao);
                System.out.println("Mensagem recebida de " + nomeUsuario + ": " + texto);

                for (Socket cliente : conexoes) {
                    if (cliente != conexao) {
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()));
                        writer.println(nomeUsuario + ": " + texto);
                        writer.flush();
                    }
                }
            } while (true);
        } catch (IOException e) {
            System.out.println("Erro ao processar mensagem do cliente: " + e.getMessage());
        } finally {
            try {
                conexao.close();
                conexoes.remove(conexao);
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }
    }
}
