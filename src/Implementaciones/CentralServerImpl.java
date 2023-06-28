package Implementaciones;

import Interfaces.CentralServer;
import Modelos.Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CentralServerImpl extends UnicastRemoteObject implements CentralServer {
    private Servidor servidor;
    private List<Servidor> servidores = new ArrayList<>();

    public CentralServerImpl(Servidor servidor, List<Servidor> servidores) throws RemoteException {
        this.servidor = servidor;
        this.servidores = servidores;
    }

    public CentralServerImpl(String ipAddress, int port, String filePath, String fileName) throws RemoteException {
        servidor = new Servidor(ipAddress, port, filePath, fileName);
    }

    @Override
    public Servidor obtenerMetadata() throws RemoteException {
        return servidor;
    }

    @Override
    public List<Servidor> obtenerInformacionServidores() throws RemoteException {
        return servidores;
    }


    public static void main(String[] args) {
        try {

            String path = "C:\\Users\\Jose Levi\\Desktop";
            String nombreArchivo = "file.c";

            path = path.replace("\\", "\\\\");

            List<Servidor> servidores = List.of(
                    new Servidor("127.0.0.1", 6000, path,nombreArchivo),
                    new Servidor("127.0.0.1", 7000, path,nombreArchivo),
                    new Servidor("127.0.0.1", 8000, path,nombreArchivo)
            );



            int puerto = 1099;
            //CentralServer centralServer = new CentralServerImpl("127.0.0.1", 5000, path,nombreArchivo);
            CentralServer centralServer = new CentralServerImpl( new Servidor("127.0.0.1", puerto, path,nombreArchivo), servidores);
            // Registrar el servidor central en el registro RMI

            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(puerto);
            registry.rebind("CentralServer", centralServer);
            System.out.println("Servidor central listo.");
        } catch (Exception e) {
            System.err.println("Error en el servidor central: " + e.toString());
            e.printStackTrace();
        }
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }
}
