package velodromo;

import javax.swing.JOptionPane;

/**
 *
 * @author JUAN PABLO GALEANO SALGUERO
 *          JESÚS ALBERTO RIVERA MINA
 *          CHRISTIAN CAMILO FERNÁNDEZ LEGUIZAMO
 */
public class Velodromo {

    private final Silla[][] sillas;
    //Constantes de Colores según el estado, para java.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Velodromo() {

        //Pendiente definir el tamaño del arreglo por teclado, f y c.
        sillas = new Silla[1][15];

    }

    /**
     * Rellena la matriz de asientos poniendo una letra y un número en cada
     */
    public void generarSillas() {
        for (int f = 0; f < sillas.length; f++) {
            char letra = (char) (65 + f);
            for (int c = 0; c < sillas[f].length; c++) {
                // ? si sí cumple la condición, : si no la cumple. 65 = A en código ASCI
                sillas[f][c] = new Silla(letra, c + 1);
            }
        }
    }

    /**
     * Crea un string que es la representación de los asientos, cambia el color
     * dependiendo del estado de los mismos.
     *
     * @return String con los asientos concatenados.
     */
    public String verSillas() {
        String str = "";
        for (Silla[] silla : sillas) {
            for (Silla silla1 : silla) {
                str += silla1.isEstado() ? ANSI_GREEN : ANSI_RED;
                str += silla1.getNombre() + " ";
//                str += ANSI_RESET;
            }
            str += "\n";
        }
        return str;
    }
    
    public boolean vender(String seleccionados) {
        //A1,A2-----------------------RECIBIR SOLICITUD DE NÚMEROS
        String[] division = seleccionados.split(",");
        String num_i = division[0];
        String num_f = division[1];
//        JOptionPane.showMessageDialog(null, num_f + ", " + num_i);
        int nf = Integer.parseInt(num_f);
        int ni = Integer.parseInt(num_i);
        String cad = "";
        for (int x = ni; x <= nf; x++) { //llamar metodo de ordenamiento final para asignar fila.
            cad += "A" + x + ",";
        }
//        JOptionPane.showMessageDialog(null, cad);
        //A1,A2-----------------------
        String comprados = "";
        String[] espacios = cad.split(",");
        for (int i = 0; i < espacios.length; i++) {
            if (venderSilla(espacios[i])) {
                comprados += espacios[i] + ",";
            } else {
                liberar(comprados, seleccionados);
                return false;
            }

        }
        return true;

    }

    private boolean venderSilla(String espacio) {
        for (Silla[] silla : sillas) {
            for (Silla silla1 : silla) {
                if (silla1.getNombre().equals(espacio)) {
                    if (silla1.isEstado()) {
                        silla1.setEstado(false);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean vender2(String seleccionados) {
        //A1,A2-----------------------RECIBIR SOLICITUD DE NÚMEROS
        String[] division = seleccionados.split(",");
        String num_i = division[0];
        String num_f = division[1];
//        JOptionPane.showMessageDialog(null, num_f + ", " + num_i);
        int nf = Integer.parseInt(num_f);
        int ni = Integer.parseInt(num_i);
        String cad = "";
        for (int x = ni; x <= nf; x++) { //llamar metodo de ordenamiento final para asignar fila.
            cad += "A" + x + ",";
        }
//        JOptionPane.showMessageDialog(null, cad);
        //A1,A2-----------------------
        String comprados = "";
        String[] espacios = cad.split(",");
        for (int i = 0; i < espacios.length; i++) {
            if (venderSilla2(espacios[i])) {
                comprados += espacios[i] + ",";
            } else {
                liberar(comprados, seleccionados);
                return false;
            }

        }
        return true;

    }

    private boolean venderSilla2(String espacio) {
        for (int f = 0; f < sillas.length; f++) {
            for (int c = 0; c < sillas[f].length; c++) {
                if (sillas[f][c].getNombre().equals(espacio)) {
                    {
                        if (sillas[f][c].isEstado()) {
                            sillas[f][c].setEstado(false);
                            return true;
                        } else {
                            return false;
                        }
                    }

                }
            }

        }
        return false;
    }

    private void liberar(String comprados, String seleccionados) {
        String[] espacios = comprados.split(",");
        for (String espacio : espacios) {
            liberarSilla(espacio);
            JOptionPane.showMessageDialog(null, "Solicitud " + seleccionados + " rechazada");
        }
    }

    private void liberarSilla(String espacio) {
        for (Silla[] silla : sillas) {
            for (Silla silla1 : silla) {
                silla1.setEstado(true);
                return;
            }
        }
    }

    public int calcularSillas(String li, String ri) {
        int ni = Integer.parseInt(li);
        int nf = Integer.parseInt(ri);

        int total = 1;
        for (int i = ni; i < nf; i++) {

            total++;

        }
        int i = 0;
        while (i < 1) {

//        System.out.println(""+ total);
            i++;
        }

        return total;

    }
    
    
    public void ordenar(int cantidadP[], String solicitudes[], String seleccionados) {

        for (int k = 0; k < cantidadP.length; k++) {
            for (int f = 0; f < cantidadP.length - 1 - k; f++) {
                if (cantidadP[f] < cantidadP[f + 1]) {
                    int auxnota;
                    auxnota = cantidadP[f];
                    cantidadP[f] = cantidadP[f + 1];
                    cantidadP[f + 1] = auxnota;
                    String auxnombre;
                    auxnombre = solicitudes[f];
                    solicitudes[f] = solicitudes[f + 1];
                    solicitudes[f + 1] = auxnombre;

                }

            }
        }
        System.out.println("Solicitud y cantidad de sillas, en orden mayor a menor");
        for (int f = 0; f < cantidadP.length; f++) {
            System.out.println(solicitudes[f] + " - " + cantidadP[f]);
        }
    }

}
