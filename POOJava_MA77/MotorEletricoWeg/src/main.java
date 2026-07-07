@SuppressWarnings("all")

public class main {
    public static void main(String[] args) {
        motoreletrico m1 = new motoreletrico("W22", 680, 12, 27);
        motoreletrico m2 = new motoreletrico("W22", 750, 19, 55);
        
        // REGISTRAR ALARME
        m1.registrar_alarme("Subcarga Detectada!");
        m1.registrar_alarme("Aumento de Temperatura Crítica Detectada!");

        // MUDANDO STATUS
        m1.mudar_status("Em Operação");
        m2.mudar_status("Em Manutenção");

        m1.setCorr_nominal(0);

        // DEMONSTRAÇÃO DA FICHA DE UM MOTOR
        m1.detalhes_motor();
        System.out.println("\n");
        m2.detalhes_motor();
    }
}
