package velodromo;

import javax.swing.JOptionPane;

/**
 *
 * @author JUAN PABLO GALEANO SALGUERO
 *          JESÚS ALBERTO RIVERA MINA
 *          CHRISTIAN CAMILO FERNÁNDEZ LEGUIZAMO
 */
public class Main {

    public static void main(String[] args) {

        Velodromo vm = new Velodromo();
        vm.generarSillas();
        System.out.println(vm.verSillas());
//        String continuar = "Si";

        int st = Integer.parseInt(JOptionPane.showInputDialog("Cuántas solicitudes desea?"));
        String solicitudes[] = new String[st];
        String Li = "", Ri = "";
        String intervalo = "";
        int cantidadP[] = new int[st];

        for (int i = 0; i < st; i++) {
            Li = JOptionPane.showInputDialog("Ingrese la silla inicial");
            Ri = JOptionPane.showInputDialog("Ingrese la silla final");
            intervalo = Li + "," + Ri;
            solicitudes[i] = intervalo;
            int cantidadSillas = vm.calcularSillas(Li, Ri);
            cantidadP[i] = cantidadSillas;
            //vm.vender(intervalo);
            
        }

        int i = 0;
        while (i < st) {
            System.out.println("" + solicitudes[i] + " cantidad de sillas: " + cantidadP[i]);
            i++;
        }
        vm.ordenar(cantidadP, solicitudes, intervalo);
        
        for (int j = 0; j < st; j++) {
            vm.vender(solicitudes[j]);
        }
        
        System.out.println(vm.verSillas());

//        do {
//            String Li = JOptionPane.showInputDialog("Ingrese la silla inicial");
//            String Ri = JOptionPane.showInputDialog("Ingrese la silla final");
//            String intervalo = Li + "," + Ri;
//            vm.vender(intervalo); //Ingresar Li y Ri
//            System.out.println(vm.verSillas());
//
//            continuar = JOptionPane.showInputDialog("Desea realizar otra solicitud?");
//        } while (continuar.equalsIgnoreCase("Si"));
//        String Li = JOptionPane.showInputDialog("Ingrese la silla inicial");
//        String Ri = JOptionPane.showInputDialog("Ingrese la silla final");
//        String intervalo = Li + "," + Ri;
//        vm.vender(intervalo); //Ingresar Li y Ri
//        System.out.println(vm.verSillas());
//        vm.vender("B1,B5,B4");
//        System.out.println(vm.verSillas());
//        vm.vender("A1,A3,A4");
//        System.out.println(vm.verSillas());
//        vm.vender("C1,C3,C4");
//        System.out.println(vm.verSillas());
    }
}
