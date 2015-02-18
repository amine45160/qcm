package modele;

import java.io.Serializable;


public class Thematique implements Serializable,ThematiqueInterface {

    private static final long serialVersionUID = 6529685098267757690L;

    private static int idInc = 0 ;
    private  int id ;
    private String nom ;
    private int level ;

    public Thematique(){

    }

    public Thematique( String nom , int level){
        this.id = idInc ;
        this.nom = nom ;
        this.level = level ;
        idInc++ ;
    }

    public Thematique(String nomThematique, int level, int id) {
        this.nom = nomThematique ;
        this.level = level ;
        this.id = id;
    }

    /**
     * Getter Nom
     * @return String
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter Nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter Id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter Id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter Level
     * @return int
     */
    public int getLevel() {
        return level;
    }

    /**
     * Setter Level
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
