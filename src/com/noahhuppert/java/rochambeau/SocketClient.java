package com.noahhuppert.java.rochambeau;

import com.noahhuppert.java.rochambeau.log.Log;
import com.noahhuppert.java.rochambeau.log.LogTag;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Noah Huppert on 9/22/2014.
 * UDP Packet Tutorial: http://michieldemey.be/blog/network-discovery-using-udp-broadcast/
 */
public class SocketClient {

    public SocketClient(){
        discoverSocketServers();
    }

    private void discoverSocketServers(){
        List<Game> discoveredServers = new ArrayList<Game>();

        try{
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.setBroadcast(true);

            byte[] udpDiscoverRequest = SocketServer.UDP_DISCOVER_REQUEST.getBytes();

            //Try 255.255.255.255
            try{
                DatagramPacket datagramPacket = new DatagramPacket(udpDiscoverRequest, udpDiscoverRequest.length, InetAddress.getByName("255.255.255.255"), SocketServerDiscoveryThread.datagramSocketPort);

                datagramSocket.send(datagramPacket);

                Log.log("Sent UDP Discovery packet to: 255.255.255.255 (DEFAULT)", Log.TAG_SOCKET_CLIENT);
            } catch (Exception e){

            }

            //All other network interfaces
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while(networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = (NetworkInterface)networkInterfaces.nextElement();

                if(networkInterface.isLoopback() || !networkInterface.isUp()){
                    continue;
                }

                for(InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()){
                    InetAddress broadcast = interfaceAddress.getBroadcast();

                    if(broadcast == null){
                        continue;
                    }

                    try{
                        DatagramPacket datagramPacket = new DatagramPacket(udpDiscoverRequest, udpDiscoverRequest.length, InetAddress.getByName("255.255.255.255"), SocketServerDiscoveryThread.datagramSocketPort);

                        datagramSocket.send(datagramPacket);

                        Log.log("Sent UDP Discovery packet to: " + broadcast.getHostAddress() + " " + networkInterface.getDisplayName(), Log.TAG_SOCKET_CLIENT);
                    } catch (Exception e){

                    }
                }
            }

            Log.log("Done sending out UDP Discovery packets, awaiting responses", Log.TAG_SOCKET_CLIENT);

            byte[] recvBuf = new byte[15000];
            DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
            datagramSocket.receive(receivePacket);

            Log.log("Broadcast response from server: " + receivePacket.getAddress().getHostAddress(), Log.TAG_SOCKET_CLIENT);

            String receivePacketMessage = new String(receivePacket.getData()).trim();
            if(receivePacketMessage.contains(SocketServer.UDP_DISCOVER_RESPONSE)){
                Game discoveredGame = new Game(receivePacketMessage.replace(SocketServer.UDP_DISCOVER_RESPONSE, ""), receivePacket.getAddress());
                discoveredServers.add(discoveredGame);

                Log.log("Correct UDP Discovery response received from " + receivePacket.getAddress(), Log.TAG_SOCKET_CLIENT);
            }


        } catch (IOException e){
            Log.log("Socket Client Discovery error: " + e.getMessage(), Log.TAG_ERROR);
        }

        onDiscoverComplete(discoveredServers);
    }

    private void onDiscoverComplete(List<Game> discoveredServers){
        int toChooseGameNumber = 1;

        Log.divider("Existing Games");

        for(Game game : discoveredServers){
            Log.log(toChooseGameNumber + ") " + game.getTitle() + "(" + game.getInetAddress().getHostAddress() + ")", Log.TAG_GAME);
            toChooseGameNumber++;
        }

        int gameIndex = Integer.parseInt(Rochambeau.readLine("Please enter the number of the game you wish to join\n    EX: If you wish to join \n      \"1) Rochambeau Game(192.168.1.1)\" \n    simply enter \"1\"\nGame number: ")) - 1;

        Log.divider("Joining Game " + discoveredServers.get(gameIndex).getTitle());
    }
}
