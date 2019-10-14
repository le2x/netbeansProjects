/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eatingcirclesbynetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author slazur
 */
public class Server {
    public ArrayList<gamer> inGameList = new ArrayList<>();
    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    static final int PORT = 3443;
    ServerSocket s;
    Socket clientSocket;
    
    Server(){
        
    }
    
    public void startServer() throws IOException {
        try {
            s = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");
            clientSocket = s.accept();
            ClientHandler client = new ClientHandler(clientSocket, this);
            clients.add(client);
            new Thread(client).start();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        } finally {
//            try {
//                // закрываем подключение
//                clientSocket.close();
//                System.out.println("Сервер остановлен");
//                s.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
    }
    
    public void addGamerToBase(gamer newGamer){
        inGameList.add(newGamer);
    }
    // отправляем сообщение всем клиентам
    public void sendMessageToAllClients(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }

    }

    // удаляем клиента из коллекции при выходе из чата
    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}

