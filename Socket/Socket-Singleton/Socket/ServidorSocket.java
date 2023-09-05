package Socket;

import java.io.*;
import java.net.*;
import java.util.*;


public class ServidorSocket {
    private static ServidorSocket instance;  // Instância única do servidor
    public static Map<Socket, String> socketToUserMap;

    // Construtor privado para evitar criação de instâncias fora da classe
    private ServidorSocket() {
        socketToUserMap = new HashMap<>();
    }

    // Método estático para obter a instância única
    public static synchronized ServidorSocket getInstance() {
        if (instance == null) {
            instance = new ServidorSocket();
        }
        return instance;
    }

    public void start() {
        ServerSocket servidor = null;
        List<Socket> conexoes = new ArrayList<>();

        try {
            servidor = new ServerSocket(7000);

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
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
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
        } finally {
            if (servidor != null) {
                try {
                    servidor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Outros métodos relacionados ao servidor aqui...

    public static void main(String[] args) {
        ServidorSocket servidor = ServidorSocket.getInstance();
        servidor.start();
    }
}

// Resto do código permanece inalterado
