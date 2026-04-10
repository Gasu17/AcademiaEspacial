package es.fpsumma.academiaespacial.repository;

import es.fpsumma.academiaespacial.model.Nave;
import es.fpsumma.academiaespacial.model.Piloto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Repository
public class PilotoRepositoryImpl implements PilotoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Piloto> listAll() {
        String sql = "SELECT * FROM pilotos ";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Piloto(
                        rs.getString("nombre"),
                        rs.getString("rango")
                ));

    }

    @Override
    public Piloto  findById(Integer id) {
        String sql = "SELECT * FROM pilotos WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Piloto(
                        rs.getString("nombre"),
                        rs.getString("rango")
                ));

    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM pilotos WHERE id = ? ";
        jdbcTemplate.update(sql, id);


    }

    @Override
    public void save(Piloto piloto) {
        String sql = "INSERT INTO pilotos (nombre, rango) VALUES (?,?) ";
        jdbcTemplate.update(sql, piloto.getNombre(), piloto.getRango());

    }
}
