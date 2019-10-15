package velodromo;

/**
 *
 * @author JUAN PABLO GALEANO SALGUERO
 *          JESÚS ALBERTO RIVERA MINA
 *          CHRISTIAN CAMILO FERNÁNDEZ LEGUIZAMO
 */
public class Silla {

    private char letra;
    private int numero;
    private boolean estado;

    public Silla() {
    }

    public Silla(char letra, int numero) {
        this.letra = letra;
        this.numero = numero;
        this.estado = true; // Por defecto la silla está disponibile
    }

    /*
     * Obtiene el nombre completo que se le asigna al asiento
     @return String letra + numero
     */
    public String getNombre() {
        return String.valueOf(letra) + numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
