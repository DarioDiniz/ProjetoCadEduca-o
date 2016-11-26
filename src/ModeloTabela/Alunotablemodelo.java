package ModeloTabela;

import Entidade.Aluno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lab-01
 */
public class Alunotablemodelo extends AbstractTableModel {

    String NomedasColunas[] = {"id", "nome", "curso", "matricula", "cpf", "e-mail", "celular"};
    private List<Aluno> Alunos;

    public Alunotablemodelo(List<Aluno> Alunos) {
        this.Alunos = Alunos;
    }

    @Override
    public int getRowCount() {
        return Alunos.size();
    }

    @Override
    public int getColumnCount() {
        return NomedasColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = Alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aluno.getId();
            case 1:
                return aluno.getNome();
            case 2:
                return aluno.getNomeCurso();
            case 3:
                return aluno.getMatricula();
            case 4:
                return aluno.getCpf();
            case 5:
                return aluno.getEmail();
            case 6:
                return aluno.getCelular();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return NomedasColunas[0];
            case 1:
                return NomedasColunas[1];
            case 2:
                return NomedasColunas[2];
            case 3:
                return NomedasColunas[3];
             case 4:
                return NomedasColunas[4];
               case 5:
                return NomedasColunas[5];     
                case 6:
                return NomedasColunas[6];    
        }
        return "";
    }

}
