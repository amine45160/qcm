package dao;

import dao.data.ConnectivityData;
import dao.data.CreateDataBase;
import modele.Thematique;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amineboufatah on 24/12/14.
 */
public class ThematiqueDAO extends ConnectivityData implements IThematiqueDAO{

    private static ThematiqueDAO thematiqueDaoInstance ;
    private Connection connection ;
    private PreparedStatement preparedStatement ;
    private static ArrayList<Thematique> thematiques = testing();

    private static ArrayList<Thematique> testing() {
        Thematique a = new Thematique("ANGLAIS 1",1,1);
        Thematique b = new Thematique("ALGORITHMIQUE 1",1,2);
        Thematique c = new Thematique("BASE DE DONNEES",1,3);
        Thematique d = new Thematique("OCAML",2,4);
        ArrayList<Thematique> thematiqueList = new ArrayList<Thematique>();
        thematiqueList.add(a);
        thematiqueList.add(b);
        thematiqueList.add(c);
        thematiqueList.add(d);
        return thematiqueList;
    }

    public List<Thematique> getMyThemes(int level){
        ArrayList<Thematique> thems = new ArrayList<Thematique>();
        for(int i=0 ; i<thematiques.size();i++){
            if(thematiques.get(i).getLevel()==level)
                thems.add(thematiques.get(i));
        }
        return thems;
    }


    /**
     * Constructor ThematiqueDAO
     */
    private ThematiqueDAO(){
     connection = super.getConnection();
    }

    /**
     * returns an instance of the object
     * @return ThematiqueDAO
     */
    public static ThematiqueDAO getInstance(){
        if(thematiqueDaoInstance==null)
        {
            thematiqueDaoInstance = new ThematiqueDAO();
        }
        return thematiqueDaoInstance;
    }

    /**
     * This method checks whether the Thematique already exists or not
     * @param content
     * @return boolean
     */
    public boolean thematiqueExists(String content){
        String query = "SELECT * FROM Questionnaires.Thematique where NomThematique = ? ";
        ResultSet resultSet ;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1 , content);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this function adds a thematique to the DataBase
     * @param level
     * @param nomThematique
     */
    public void addThematique(int level , String nomThematique){

        String query = "INSERT INTO Questionnaires.Thematique (idFormation , NomThematique) VALUES ( ? , ? ) ;";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,level);
            preparedStatement.setString(2 , nomThematique);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the thematiques by the Level
     * @param level
     * @return
     */
    public List<Thematique> getThematiquesByLevel(int level){
        try {
           CreateDataBase.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Thematique> thematiqueList = new ArrayList<Thematique>();
        String query = "SELECT * FROM Questionnaires.Thematique where idFormation = ? ";

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,level);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Thematique theme = new Thematique();
                theme.setId(resultSet.getInt(1));
                theme.setLevel(resultSet.getInt(2));
                theme.setNom(resultSet.getString(3));
                thematiqueList.add(theme);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thematiqueList;
    }

    /**
     * This method will return the list of thematiques that are actually activated for users
     * @param level
     * @return List
     */
    public List<Thematique> getLaunchedThematiques(int level){
     String query = "SELECT MAX(Questionnaires.SessionQCM.idQcm) as id , Questionnaires.SessionQCM.idQcm , idSessionQcm ,Questionnaires.Thematique.idThematique , nomThematique FROM " +
        "Questionnaires.SessionQCM natural join Questionnaires.Qcm natural join Questionnaires.Thematique WHERE idFormation = ? and activated =1 group by " +
        "Questionnaires.Thematique.idThematique, Questionnaires.SessionQCM.idQcm;";

        ResultSet resultSet ;

        List<Thematique> thematiqueList = new ArrayList<Thematique>();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,level);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                int id = resultSet.getInt("idThematique");
                String nomThematique = resultSet.getString("nomThematique");
                Thematique thematique = new Thematique(nomThematique , level , id);
                System.out.println("LAUCHED "+thematique.getNom());
                thematiqueList.add(thematique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thematiqueList;
    }

    public List<Thematique> getNotLaunchedThematiques(List<Thematique> listAll , List<Thematique>listLaunched){
        System.out.println("JE SUIS ICI");
        for(int i=0 ; i<listAll.size();i++){
            for(int j=0 ; j<listLaunched.size() ;j++){
//                System.out.println(listAll.get(i).getNom() +" VS "+listLaunched.get(j).getNom());
                if(listAll.get(i).getNom().equals(listLaunched.get(j).getNom())){
                    System.out.println("Not Launched " + listAll.get(i).getNom());
                    listAll.remove(i);
                }
            }
        }
    return listAll;
    }

    public List<Thematique> getAll(int level){
        String query = " SELECT * FROM Questionnaires.Qcm join Questionnaires.Thematique on " +
                "Questionnaires.Qcm.idThematique = Questionnaires.Thematique.idThematique where idFormation = ?";

        ResultSet resultSet;
        List<Thematique> thematiqueList = new ArrayList<Thematique>();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1 , level);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("idThematique");
                String nom = resultSet.getString("nomThematique");
                Thematique thematique = new Thematique(nom,level,id);
                System.out.println("ALL "+nom);
                thematiqueList.add(thematique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thematiqueList;

    }


    /**
     * This method will return the Id Thematique by its content
     * @param content
     * @return int
     */
    public int getIdThematiqueByContent(String content){
        String query = "SELECT idThematique FROM Questionnaires.Thematique where NomThematique ='"+content+"'" ;
        ResultSet resultSet ;
        Statement statement ;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                System.out.println("ID DE LA THEMATIQUE "+resultSet.getInt(1));
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1 ;
        /*for(int i = 0 ; i<thematiques.size() ; i++){
            if(thematiques.get(i).getNom().equals(content))
                return thematiques.get(i).getId();
        }
        return -1;*/
    }

}
