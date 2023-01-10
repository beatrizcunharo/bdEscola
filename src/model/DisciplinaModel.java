package model;

/**
 *
 * @author Beatr
 */
public class DisciplinaModel {
    private int cod_disciplina;
    private String nome_disciplina;
    private String ementa_disciplina;
    private String obs_disciplina;

    /**
     * @return the cod_disciplina
     */
    public int getCod_disciplina() {
        return cod_disciplina;
    }

    /**
     * @param cod_disciplina the cod_disciplina to set
     */
    public void setCod_disciplina(int cod_disciplina) {
        this.cod_disciplina = cod_disciplina;
    }

    /**
     * @return the nome_disciplina
     */
    public String getNome_disciplina() {
        return nome_disciplina;
    }

    /**
     * @param nome_disciplina the nome_disciplina to set
     */
    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    /**
     * @return the ementa_disciplina
     */
    public String getEmenta_disciplina() {
        return ementa_disciplina;
    }

    /**
     * @param ementa_disciplina the ementa_disciplina to set
     */
    public void setEmenta_disciplina(String ementa_disciplina) {
        this.ementa_disciplina = ementa_disciplina;
    }

    /**
     * @return the obs_disciplina
     */
    public String getObs_disciplina() {
        return obs_disciplina;
    }

    /**
     * @param obs_disciplina the obs_disciplina to set
     */
    public void setObs_disciplina(String obs_disciplina) {
        this.obs_disciplina = obs_disciplina;
    }
}