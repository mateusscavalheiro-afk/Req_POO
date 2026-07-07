@SuppressWarnings("all")

public class motoreletrico {

    // ATRIBUTOS DA CLASSE MOTOR ELÉTRICO
    private String modelo;
    private double potenciacv;
    private double corr_nominal;
    private double velocidadeRPM;
    private String status;
    private String alarmes;
    private double temp;

    // MÉTODO CONSTRUTOR
    public motoreletrico(String modelo, double potenciacv, double corr_nominal, double temp) {
        this.modelo = modelo;
        this.potenciacv = potenciacv;
        this.setCorr_nominal(corr_nominal);
        this.temp = temp;
        this.velocidadeRPM = 1750;
        this.status = "Desligado";
        this.alarmes = "Nenhum";
    }

    // MÉTODOS GET & SET
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotenciacv() {
        return potenciacv;
    }

    public void setPotenciacv(double potenciacv) {
        this.potenciacv = potenciacv;
    }

    public double getCorr_nominal() {
        return corr_nominal;
    }

    public void setCorr_nominal(double corr_nominal) {
        if (corr_nominal <= 0) {
            System.out.println("xx-- Erro! O motor não deve operar em corrente inválida! --xx");
            System.out.println("##-- Insira uma corrente maior que 0 --##");
            return;
        } 
        this.corr_nominal = corr_nominal;
        }

    public double getVelocidadeRPM() {
        return velocidadeRPM;
    }

    public void setVelocidadeRPM(double velocidadeRPM) {
        this.velocidadeRPM = velocidadeRPM;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlarmes() {
        return alarmes;
    }

    public void setAlarmes(String alarmes) {
        this.alarmes = alarmes;
    }

    public double getTemp(){
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    // MÉTODOS PERSONALIZADOS
    public double calculo_consumo(){
        return potenciacv * 0.736; // CV -> kW
    }

    public void registrar_alarme(String alarme){
        if (this.alarmes.equals("Nenhum")) {
            this.alarmes = alarme;
        } else {
            this.alarmes += ", " + alarme;
        }
    }

    public void mudar_status(String novoStatus){
        this.status = novoStatus;
    }

    public String range_corr(){
        if (corr_nominal > 0 && corr_nominal < 15) {
            return "Segura";
        } else if (corr_nominal > 15 && corr_nominal < 32) {
            return "Instável";
        } else {
           return "Crítica!";
        }
    }

    public String range_temp(){
        if (temp > 0 && temp < 35) {
            return "Segura";
        } else if (temp > 35 && temp < 45) {
            return "Instável";
        } else {
            return "Crítica!";
        }
    }

    public void detalhes_motor(){
        if (corr_nominal <= 0) {} 
        else {
            System.out.println("-----------------------------------------------");
            System.out.println("--- x DETALHES DO MOTOR x ---");
            System.out.println(" + Modelo: " + modelo + ";");
            System.out.println(" + Potência: " + potenciacv + "CV;");
            System.out.println(" + Corrente: " + corr_nominal + "A -> " + range_corr() + ";");
            System.out.println(" + Temperatura: " + temp + "°C -> " + range_temp() + ";");
            System.out.println(" + Velocidade: " + velocidadeRPM + "RPM;");
            System.out.println(" + Status: " + status + ";");
            System.out.println(" + Alarmes: " + alarmes + ";");
            System.out.println(" + Consumo estimado: " + calculo_consumo() + "kW.");
            System.out.println("-----------------------------------------------");
        }
        }
        
    }
