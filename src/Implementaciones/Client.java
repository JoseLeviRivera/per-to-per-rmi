package Implementaciones;

import Interfaces.CentralServer;
import Modelos.Servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            // Conectar al servidor central
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            CentralServer centralServer = (CentralServer) registry.lookup("CentralServer");

            // Obtener la información del archivo del servidor central
            Servidor servidorCentral = centralServer.obtenerMetadata();
            List<Servidor> servidores = centralServer.obtenerInformacionServidores();
            System.out.println("Información del archivo obtenida del servidor central:");
            System.out.println("IP: " + servidorCentral.getIp());
            System.out.println("Puerto: " + servidorCentral.getPuerto());
            System.out.println("Ruta: " + servidorCentral.getRuta());
            System.out.println("Nombre de archivo: " + servidorCentral.getNombreArchivo());

            System.out.println("Informacion de los servidores conectados: ");
            System.out.println(servidores);

            // Descargar el archivo de los servidores P2P
            // Aquí puedes implementar la lógica para descargar el archivo utilizando la información obtenida.
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}

