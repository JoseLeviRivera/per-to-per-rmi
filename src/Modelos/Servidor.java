package Modelos;

import java.io.Serializable;

public class Servidor implements Serializable {
    private String ip;
    private int puerto;
    private String ruta;
    private String nombreArchivo;

    public Servidor(){}

    public Servidor(String ip, int puerto, String ruta, String nombreArchivo) {
        this.ip = ip;
        this.puerto = puerto;
        this.ruta = ruta;
        this.nombreArchivo = nombreArchivo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String toString() {
        return "Servidor[" +
                "ip='" + ip + '\'' +
                ", puerto=" + puerto +
                ", ruta='" + ruta + '\'' +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                ']'+ '\n';
    }
}
