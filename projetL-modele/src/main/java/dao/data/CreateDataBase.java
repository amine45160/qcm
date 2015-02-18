package dao.data;

import org.h2.jdbcx.JdbcDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase implements ICreateDataBase{

    private PreparedStatement preparedStatement = null;
    private JdbcDataSource ds;
    private Connection conn;
    private String userName = "admin";
    private String userPassword = "admin";
    private String dbPath = "src/dbb/ProjectL";
    private String classForName = "org.h2.Driver";
    private static CreateDataBase monInstance;

    public CreateDataBase(){
        try {
            Class.forName(classForName);
            ds = new JdbcDataSource();
            ds.setURL("jdbc:h2:"+ dbPath);
            ds.setUser(userName);
            ds.setPassword(userPassword);



        } catch (ClassNotFoundException e) {
            System.err.println("cannot create datasource");
            e.printStackTrace();
        }
    }

    public static ICreateDataBase getInstance() throws SQLException {
        if (monInstance == null) {
            System.err.println("IL EXISTE PAS UNE INSTANCE");
            monInstance = new CreateDataBase();
            monInstance.open();
            monInstance.createSchema();
            monInstance.close();
        }

        return monInstance;
    }

    public static void createBD(Connection connection , PreparedStatement preparedStatement ) throws SQLException {

        System.err.println("je suis entrain de fabriquer");
        preparedStatement = connection.prepareStatement("CREATE SCHEMA IF NOT EXISTS Questionnaires;"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Formation (idFormation INT NOT NULL AUTO_INCREMENT, intituleFormation VARCHAR2(60), PRIMARY KEY(idFormation));"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Utilisateur (idUtilisateur INT NOT NULL AUTO_INCREMENT, nomUtilisateur VARCHAR(50),prenomUtilisateur VARCHAR(50),motDePasse VARCHAR(90),idFormation INT NOT NULL , PRIMARY KEY(idUtilisateur), FOREIGN KEY(idFormation) REFERENCES Questionnaires.Formation(idFormation) ON DELETE CASCADE);"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Thematique (idThematique INT NOT NULL AUTO_INCREMENT,idFormation INT NOT NULL , NomThematique VARCHAR(50),PRIMARY KEY(idThematique), FOREIGN KEY(idFormation) REFERENCES Questionnaires.Formation(idFormation) ON DELETE CASCADE);"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Etudiant (idUtilisateurEt INT NOT NULL ,identifiantEtudiant VARCHAR(70),PRIMARY KEY(idUtilisateurEt),FOREIGN KEY(idUtilisateurEt) REFERENCES Questionnaires.Utilisateur(idUtilisateur) ON DELETE CASCADE);"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Enseignant (idUtilisateurEn INT NOT NULL ,IdentifiantEnseignant VARCHAR(70),PRIMARY KEY(idUtilisateurEn),FOREIGN KEY(idUtilisateurEn) REFERENCES Questionnaires.Utilisateur(idUtilisateur) ON DELETE CASCADE);"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Enseignement (idUtilisateurEns INT NOT NULL ,  idThematique INT NOT NULL, PRIMARY KEY(idUtilisateurEns, idThematique), FOREIGN KEY(idUtilisateurEns) REFERENCES Questionnaires.Enseignant(idUtilisateurEn) ON DELETE CASCADE, FOREIGN KEY(idThematique) REFERENCES Questionnaires.Thematique(idThematique) ON DELETE CASCADE);"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Qcm(idQcm INT NOT NULL AUTO_INCREMENT,idThematique INT NOT NULL,idUtilisateurEn INT NOT NULL,PRIMARY KEY(idQcm),FOREIGN KEY(idThematique) REFERENCES Questionnaires.Thematique(idThematique),FOREIGN KEY(idUtilisateurEn) REFERENCES Questionnaires.Enseignant(idUtilisateurEn));"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Question (idQuestion INT NOT NULL AUTO_INCREMENT ,idQcm INT NOT NULL,contenu VARCHAR(300),timer int, PRIMARY KEY(idQuestion),FOREIGN KEY(idQcm) REFERENCES Questionnaires.Qcm(idQcm));"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.SessionQCM (idSessionQCM INT NOT NULL AUTO_INCREMENT,idQcm INT NOT NULL,dateSession DATE, PRIMARY KEY(idSessionQCM),opened tinyint(1),activated tinyint(1), FOREIGN KEY(idQcm) REFERENCES Questionnaires.Qcm(idQcm) ON DELETE CASCADE);"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.ResultatSessionQCM (idResultatSessionQCM INT NOT NULL AUTO_INCREMENT,  idSessionQCM INT NOT NULL,idUtilisateurEt int not null,resultat double , PRIMARY KEY(idResultatSessionQCM,idSessionQCM,idUtilisateurEt), FOREIGN KEY(idSessionQCM) REFERENCES Questionnaires.SessionQCM(idSessionQCM) ON DELETE CASCADE,FOREIGN  KEY(idUtilisateurEt) REFERENCES Questionnaires.Etudiant(idUtilisateurEt)ON DELETE CASCADE );"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Choix(idChoix INT NOT NULL AUTO_INCREMENT,  idQuestion INT NOT NULL,choix VARCHAR(300),isGood tinyint(1), PRIMARY KEY(idChoix), FOREIGN KEY(idQuestion) REFERENCES Questionnaires.Question(idQuestion) ON DELETE CASCADE);"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.TauxReussiteQuestion (idTauxReussiteQuestion INT NOT NULL AUTO_INCREMENT,  idQuestion INT NOT NULL,idSessionQCM INT NOT NULL,PRIMARY KEY(idTauxReussiteQuestion), FOREIGN KEY(idQuestion) REFERENCES Questionnaires.Question(idQuestion) ON DELETE CASCADE,FOREIGN KEY(idSessionQCM) REFERENCES Questionnaires.SessionQCM(idSessionQCM));"
                +"CREATE TABLE IF NOT EXISTS Questionnaires.Score (idUtilisateurEt int not null , idQcm int not null , idQuestion int not null , goodAnswer tinyint(1) , PRIMARY KEY (idUtilisateurEt , idQcm , idQuestion));"
        );

        preparedStatement.execute();
        DAOUtilitaire.fermetureSilencieuse(preparedStatement);
    }

    private void createSchema() {

        try {
            createBD(conn,preparedStatement);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        DAOUtilitaire.fermetureSilencieuse(preparedStatement);
    }

    @Override
    public void close() {
            DAOUtilitaire.fermetureSilencieuse(conn);
            DAOUtilitaire.fermetureSilencieuse(preparedStatement);
    }

    /* (non-Javadoc)
       * @see dao.db.CreateDataBase#open()
       */
    @Override
    public void open() {
        try {
            this.conn = this.ds.getConnection();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /* (non-Javadoc)
           * @see dao.db.ICreateDataBase#getDbPath()
           */
    public String getDbPath() {
        return dbPath;
    }

    /* (non-Javadoc)
     * @see dao.db.ICreateDataBase#setDbPath(java.lang.String)
     */
    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }

    public void truncate(){
        System.out.println("TRUNCATE IT ");
        open();
        Statement statement;
        String query1 = "DELETE FROM Questionnaires.Score ";
        String query2 = "DELETE FROM Questionnaires.Choix ";
        String query3 = "DELETE FROM Questionnaires.ResultatSessionQCM ";
        String query4 = "DELETE FROM Questionnaires.SessionQCM ";
        String query5 = "DELETE FROM Questionnaires.Question ";
        String query6 = "DELETE FROM Questionnaires.Qcm ";
        String query7 = "DELETE FROM Questionnaires.Qcm ";
        String query8 = "DELETE FROM Questionnaires.Enseignement ";
        String query9 = "DELETE FROM Questionnaires.Enseignant ";
        String query10= " DELETE FROM Questionnaires.Etudiant ";
        String query11 = " DELETE FROM Questionnaires.Thematique ";
        String query12 = "DELETE FROM Questionnaires.Utilisateur ";
        String query13 = "DELETE FROM Questionnaires.Formation " ;

        try {
          statement = conn.createStatement();
           statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            statement.executeUpdate(query4);
            statement.executeUpdate(query5);
            statement.executeUpdate(query6);
            statement.executeUpdate(query7);
            statement.executeUpdate(query8);
            statement.executeUpdate(query9);
            statement.executeUpdate(query10);
            statement.executeUpdate(query11);
            statement.executeUpdate(query12);
            statement.executeUpdate(query13);
          DAOUtilitaire.fermetureSilencieuse(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
