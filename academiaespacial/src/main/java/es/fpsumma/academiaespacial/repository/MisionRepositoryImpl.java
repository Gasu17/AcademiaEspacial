package es.fpsumma.academiaespacial.repository;

import es.fpsumma.academiaespacial.model.EstadoMision;
import es.fpsumma.academiaespacial.model.Mision;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class MisionRepositoryImpl implements MisionRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Mision> listAll() {
        String sql = "SELECT * FROM misiones ";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Mision(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("destino"),
                        EstadoMision.valueOf(rs.getString("estadoMision")),
                        rs.getInt("naveId")


                )
        );


    }

    @Override
    public Mision findById(Integer id) {
        String sql = "SELECT * FROM misiones WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Mision(
                        rs.getString("codigo"),
                        rs.getString("destino"),
                        EstadoMision.valueOf(rs.getString("estadoMision")),
                        rs.getInt("naveId")
                ), id);
    }

    @Override
    public void save(Mision mision) {
        String sql = "INSERT INTO misiones (id,codigo,destino,estadoMision,naveId) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, mision.getCodigo(), mision.getDestino(), mision.getEstadoMision(), mision.getNaveId());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM misiones WHERE id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override

    public void updateStateById(Integer id, EstadoMision estadoMision) {
        String sql = "UPDATE misiones SET ? WHERE id = ? ";
        jdbcTemplate.update(sql, id, estadoMision);

    }


}

