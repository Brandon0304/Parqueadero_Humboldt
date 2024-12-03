
package modelo;

/**
 *
 * @author ortiz
 */
public class Vehiculo {
    
    private int idVehiculo;
    private String placa;
    private String propietario;
    private String tipoVehiculo;
    private String horaEntrada;
    private String horaSalida;
    private double valorPagado;
    private String estado;
    
    
    public Vehiculo(){
        this.idVehiculo = 0;
        this.placa = "";
        this.propietario = "";
        this.tipoVehiculo = "";
        this.horaEntrada = "";
        this.horaSalida = "";
        this.valorPagado = 0.00;
        this.estado = "";
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", placa=" + placa + ", propietario=" + propietario + ", tipoVehiculo=" + tipoVehiculo + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", valorPagado=" + valorPagado + ", estado=" + estado + '}';
    }
    
   
}
