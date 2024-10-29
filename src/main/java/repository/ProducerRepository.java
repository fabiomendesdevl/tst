package repository;

import dominio.Producer;
import resources.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//debugar shift+f9
//@Log4j2
//log.info("Dados adicionados linha afetada {}", rows);
public class ProducerRepository {

    //inserir dados salvar dados..
    public static void save(String nome) {
        String sql = "INSERT INTO anime_store.producer (name) VALUES('" + nome + "');";
        try (Connection connection = ConnectionFactory.getConnection();
             Statement smt = connection.createStatement()) {
            int rows = smt.executeUpdate(sql);
            System.out.println("Inserido com sucesso..." + rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //delete dados
    public static void delete(int id) {

        String sql = "DELETE FROM anime_store.producer WHERE id='" + id + "';";
        try (Connection connection = ConnectionFactory.getConnection();
             Statement smt = connection.createStatement()) {
            int rows = smt.executeUpdate(sql);
            System.out.println("%d Deletado com Sucesso..." + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //update dados
    public static void update(int id, String nome) {

        String sql = "UPDATE anime_store.producer SET name='" + nome + "' WHERE id=" + id + ";";
        try (Connection connection = ConnectionFactory.getConnection();
             Statement smt = connection.createStatement()) {
            int rows = smt.executeUpdate(sql);
            System.out.println("Atualizados com sucesso..." + rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Producer> findAll() {
        String sql = "SELECT id, name FROM anime_store.producer;";
        List<Producer> producers = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement smt = connection.createStatement()) {
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("name");
                Producer producer = new Producer();
                producer.setId(id);
                producer.setName(nome);
                producers.add(producer);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }
}
