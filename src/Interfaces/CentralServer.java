package Interfaces;

import Modelos.Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CentralServer extends Remote {
    Servidor obtenerMetadata() throws RemoteException;
    List<Servidor> obtenerInformacionServidores() throws RemoteException;
}
