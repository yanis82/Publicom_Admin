/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Column;
import utils.QueryBuilder;

/**
 *
 * @author 08luc
 */
public abstract class SuperDao<T extends Model> {

    protected T model;
    private Connection connection;

    protected SuperDao(T model) throws SQLException {
        this.connection = MysqlConnector.getConnexion();
        this.model = model;

    }

    public Connection getConnection() {
        return connection;
    }

    public List<T> getAll() throws SQLException {
        QueryBuilder queryBuilder = new QueryBuilder();
        var rawColumns = this.model.getColumns();
        Column[] columnsArray = new Column[rawColumns.size()];
        int j = 0;
        for (int i = 0; i < rawColumns.size(); i++) {
            if (rawColumns.get(i) instanceof Column) {
                columnsArray[j++] = rawColumns.get(i);
            }
        }
        String getAllQuery = queryBuilder
                .select(columnsArray)
                .from(this.model.getTable())
                .getQuery();
        PreparedStatement stat = this.getConnection().prepareStatement(getAllQuery);
        ResultSet rs = stat.executeQuery();
        ArrayList<T> listModels = new ArrayList<>();
        while (rs.next()) {
            T rowModel = this.createModelInstance();
            for (Column column : this.model.getColumns()) {
                if (column.getType() == String.class) {
                    rowModel.set(column.getName(), rs.getString(column.getName()));
                } else if (column.getType() == int.class) {
                    rowModel.set(column.getName(), rs.getInt(column.getName()));
                } else if (column.getType() == boolean.class) {
                    rowModel.set(column.getName(), rs.getBoolean(column.getName()));
                } else {
                    throw new IllegalArgumentException("SuuperDao : getall -> ne prend en compte que les types int, string et boolean");
                }
            }
            listModels.add(rowModel);
        }
        return listModels;
    }

    public void insert(T model) {
        System.out.println("insert");
    }

    public void delete(T model) throws SQLException {
        System.out.println("delete");
    }

    public void update(T model) throws SQLException {
        System.out.println("update");
    }

    public T get() {
        System.out.println("get");
        return null;
    }

    protected abstract T createModelInstance();
}
