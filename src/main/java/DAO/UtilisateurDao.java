/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.UtilisateurModel;
import java.sql.SQLException;

/**
 *
 * @author L.sanchez
 */
public class UtilisateurDao extends SuperDao<UtilisateurModel> {

    public UtilisateurDao(UtilisateurModel model) throws SQLException {
        super(model);
    }

    @Override
    protected UtilisateurModel createModelInstance() {
        return new UtilisateurModel();
    }
    
}
