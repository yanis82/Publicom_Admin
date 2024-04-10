package Vue;

import DAO.UtilisateurDao;
import Model.UtilisateurModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
 * template
 */
/**
 *
 * @author 08luc
 */
public class TableModelUtilisateur extends AbstractTableModel {

    private List<UtilisateurModel> utilisateurs;
    private final List<String> columnNames;

    public TableModelUtilisateur() {
        this.utilisateurs = new ArrayList<>();
        this.columnNames = new UtilisateurModel().getColumnsStr();
    }

    @Override
    public int getRowCount() {
        return this.utilisateurs.size();
    }
    
    public UtilisateurModel getRow(int row) throws IllegalArgumentException{
        if(row >= utilisateurs.size()) throw new IllegalArgumentException(String.format("ligne (%s) ne peut pas etre superieur au nombre d'utilisateurs (%s)", row, utilisateurs.size()));
        return utilisateurs.get(row);
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        UtilisateurModel utilsiateurModel = new UtilisateurModel();
        if((utilsiateurModel.getColumns().size() > columnIndex) && (columnIndex >=0)) {
            return utilsiateurModel.getColumns().get(columnIndex).getType();
        }else return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UtilisateurModel user = this.utilisateurs.get(rowIndex);
        return user.get(columnNames.get(columnIndex));
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    @Override
    public void fireTableCellUpdated(int row, int column) {
        super.fireTableCellUpdated(row, column);
        
        UtilisateurModel utilisateur = utilisateurs.get(row);
        try {
            UtilisateurDao utilisateurDao = new UtilisateurDao(utilisateur);
            utilisateurDao.update(utilisateur);
        } catch (SQLException ex) {
            Logger.getLogger(TableModelUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("MAKE OBSERVER FOR PRINT ERROR ON TOAST OR DIALOG");
            //TODO: MAKE OBSERVER
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        UtilisateurModel user = this.utilisateurs.get(rowIndex);
        String columnName = user.getColumns().get(columnIndex).getName();
        user.set(columnName, aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public void addUtilisateur(UtilisateurModel user) {
        this.utilisateurs.add(user);
        fireTableDataChanged(); // Notifies JTable of utilisateurs change
    }
    
    public void removeUtilisateur(UtilisateurModel user) {
        this.utilisateurs.remove(user);
        fireTableDataChanged(); // Notifies JTable of utilisateurs change
    }
    
    public List<UtilisateurModel> getData() {
        return Collections.unmodifiableList(this.utilisateurs); // Return unmodifiable list to prevent external modification
    }
}
