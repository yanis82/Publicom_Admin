/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.UtilisateurModel;
import Model.UtilisateurModel.TABLESENUM;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.QueryBuilder;
import utils.enums.Operator;

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

    @Override
    public void update(UtilisateurModel model) throws SQLException {
        String idColumn = UtilisateurModel.getColumnByEnum(TABLESENUM.ID);
        Object idValue = super.model.get(idColumn);
        if (idValue.getClass() == int.class || idValue.getClass() == Integer.class) {
            QueryBuilder queryBuilder = new QueryBuilder();
            List<String> columnsStr = model.getColumnsStr();
            columnsStr.remove(0);

            String query = queryBuilder.where(idColumn, Operator.EQUAL, (int) idValue).update(this.model.getTable(), columnsStr.toArray(new String[0]));
            PreparedStatement statement = MysqlConnector.getConnexion().prepareStatement(query);
            for (int i = 0; i < columnsStr.size(); i++) {
                statement.setObject(i + 1, model.getValues().get(i));
            }
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(UtilisateurModel model) {
        try {
            QueryBuilder queryBuilder = new QueryBuilder();
            String columnStr = UtilisateurModel.getColumnByEnum(TABLESENUM.ID);
            String query = queryBuilder.where(columnStr, Operator.EQUAL, model.getId()).deleteFrom(super.model.getTable());
            PreparedStatement stmt = MysqlConnector.getConnexion().prepareStatement(query);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
