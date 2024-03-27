package MainFrame;

import Model.UtilisateurModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public void addUtilisateur(UtilisateurModel user) {
        this.utilisateurs.add(user);
        fireTableDataChanged(); // Notifies JTable of utilisateurs change
    }

    public List<UtilisateurModel> getData() {
        return Collections.unmodifiableList(this.utilisateurs); // Return unmodifiable list to prevent external modification
    }
}
