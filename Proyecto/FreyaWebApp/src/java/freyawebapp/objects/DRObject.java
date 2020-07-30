
package freyawebapp.objects;

public class DRObject {
    private int idDireccion;
    private String localizacion;
    private int codigoPostal;
    private int numeroTelefono;
    
    public DRObject(int pIdDireccion, String pLocalizacion, int pCodigoPostal, 
            int pNumeroTelefono) {
        setIdDireccion(pIdDireccion);
        setLocalizacion(pLocalizacion);
        setCodigoPostal(pCodigoPostal);
        setNumeroTelefono(pNumeroTelefono);
    }
    
    public int getIdDireccion() {
        return idDireccion;
    }

    private void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    private void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    private void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    private void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

       
    
}

