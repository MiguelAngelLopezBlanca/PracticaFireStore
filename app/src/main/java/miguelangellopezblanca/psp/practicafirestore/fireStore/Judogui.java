package miguelangellopezblanca.psp.practicafirestore.fireStore;

public class Judogui {

    private String idCompetidor;
    private String marca, modelo, imgJudogui, color;
    private int talla;
    private String created_at;
    private String updated_at;
    private String identificador;

    public Judogui(String idCompetidor, String marca, String modelo, String imgJudogui, String color, int talla, String identificador) {
        this.idCompetidor = idCompetidor;
        this.marca = marca;
        this.modelo = modelo;
        this.imgJudogui = imgJudogui;
        this.color = color;
        this.talla = talla;
        this.identificador = identificador;
    }

    public Judogui() {
    }

    public String getIdCompetidor() {
        return idCompetidor;
    }

    public void setIdCompetidor(String idCompetidor) {
        this.idCompetidor = idCompetidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImgJudogui() {
        return imgJudogui;
    }

    public void setImgJudogui(String imgJudogui) {
        this.imgJudogui = imgJudogui;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Judogui{" +
                "idCompetidor='" + idCompetidor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", imgJudogui='" + imgJudogui + '\'' +
                ", color='" + color + '\'' +
                ", talla=" + talla +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", identificador='" + identificador + '\'' +
                '}';
    }
}
