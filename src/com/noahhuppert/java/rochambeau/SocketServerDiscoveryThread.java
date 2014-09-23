package com.noahhuppert.java.rochambeau;

import com.noahhuppert.java.rochambeau.log.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Noah Huppert on 9/22/2014.
 * UDP Packet Tutorial: http://michieldemey.be/blog/network-discovery-using-udp-broadcast/
 */
public class SocketServerDiscoveryThread implements Runnable {
    public static int datagramSocketPort = 3001;
    private DatagramSocket datagramSocket;
    private String gameTitle = "Default Game";
    private boolean promptUserForGameTitle;

    public SocketServerDiscoveryThread(String gameTitle){
        this.gameTitle = gameTitle;
        this.promptUserForGameTitle = false;
    }

    public SocketServerDiscoveryThread(boolean promptUserForGameTitle){
        this.promptUserForGameTitle = promptUserForGameTitle;
    }

    public SocketServerDiscoveryThread(){
        this.promptUserForGameTitle = false;
    };

    @Override
    public void run(){
        if(promptUserForGameTitle){
            Log.divider("Create New Game");
            this.gameTitle = Rochambeau.readLine("Please enter your game title(This will be used by other players to identify your game)");
        }

        try{
            datagramSocket = new DatagramSocket(datagramSocketPort, InetAddress.getByName("0.0.0.0"));
            datagramSocket.setBroadcast(true);

            Log.log("UDP Socket running on port " + datagramSocketPort, Log.TAG_SOCKET_SERVER);

            while(true){
                Log.log("UDP Socket ready to receive packets", Log.TAG_SOCKET_SERVER);

                byte[] recvBuf = new byte[15000];
                DatagramPacket datagramPacket = new DatagramPacket(recvBuf, recvBuf.length);
                datagramSocket.receive(datagramPacket);

                Log.log("Discovery packet received from " + datagramPacket.getAddress().getHostAddress(), Log.TAG_SOCKET_SERVER);
                Log.log("    Discovery packet data: " + datagramPacket.getData(), Log.TAG_SOCKET_SERVER);

                String datagramPackeMessage = new String(datagramPacket.getData()).trim();
                if(datagramPackeMessage.equals(SocketServer.UDP_DISCOVER_REQUEST)){
                    byte[] udpDiscoverResponse = (SocketServer.UDP_DISCOVER_RESPONSE + this.gameTitle).getBytes();

                    DatagramPacket datagramSendPacket = new DatagramPacket(udpDiscoverResponse, udpDiscoverResponse.length, datagramPacket.getAddress(), datagramPacket.getPort());
                    datagramSocket.send(datagramSendPacket);

                    Log.log("Sent discovery response to: " + datagramSendPacket.getAddress().getHostAddress(), Log.TAG_SOCKET_SERVER);
                }
            }
        } catch (IOException e){
            Log.log("UDP Socket error: " + e.getMessage(), Log.TAG_ERROR);
        }
    }
}
