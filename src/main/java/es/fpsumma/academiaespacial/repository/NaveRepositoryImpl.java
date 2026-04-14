package es.fpsumma.academiaespacial.repository;

import es.fpsumma.academiaespacial.model.Nave;
import es.fpsumma.academiaespacial.model.Piloto;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class NaveRepositoryImpl implements NaveRepository {
    private final JdbcTemplate jdbcTemplate;


    @Override
    public List<Nave> listAll() {
        String sql = "SELECT * FROM naves ";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Nave(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("modelo"),
                        rs.getInt("piloto_id")

                )
        );

    }

    @Override
    public Nave findById(Integer id) {
        String sql = "SELECT * FROM naves WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Nave(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("modelo"),
                        rs.getInt("piloto_id")
                ),id );
    }


    @Override
    public void deleteById(Integer id) {

        String sql = "DELETE FROM nave WHERE id = ? ";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public void save(Nave nave) {
        String sql = "INSERT INTO naves ( nombre,modelo,piloto_id ) VALUES (?,?,?)";
        jdbcTemplate.update(sql, nave.getNombre(), nave.getModelo(), nave.getPilotoId());
    }

    public Piloto viewAsignedPilot(Integer idNave) {
        String sql = """
                SELECT
                    p.nombre,
                    p.rango
                FROM pilotos p
                JOIN naves n ON p.id = n.piloto_id
                WHERE n.id = ?; 
                """;

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Piloto(
                        rs.getString("nombre"),
                        rs.getString("rango")
                ), idNave);
    }
    public void quitarPiloto (Integer id) {
        String sql = "Update naves set piloto_id = NULL where piloto_id = ?";
        jdbcTemplate.update(sql , id );
    }
}
