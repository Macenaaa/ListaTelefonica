
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class ContatoDAO {

    public void inserir(Contato contato) {
        String sql = "INSERT INTO contato (nome, telefone) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.executeUpdate();
            System.out.println("Contato inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> listarTodos() {
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contato ORDER BY nome ASC";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Contato(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizar(Contato contato) {
        String sql = "UPDATE contato SET nome = ?, telefone = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setInt(3, contato.getId());
            stmt.executeUpdate();
            System.out.println("Contato atualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM contato WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Contato deletado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contato> buscarPorNome(String nome) {
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contato WHERE nome LIKE ? ORDER BY nome ASC";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Contato(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
