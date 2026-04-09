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
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("destino"),
                        EstadoMision.valueOf(rs.getString("estadoMision")),
                        rs.getInt("naveId")
                ), id);
    }

    @Override
    public void save(Mision mision) {
        String sql = "INSERT INTO misiones (id,codigo,destino,estadoMision,naveId) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, mision.getId(), mision.getCodigo(), mision.getDestino(), mision.getEstadoMision(), mision.getNaveId()) ;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void updateById(Mision mision) {

    }

    @Override
    public List<Mision> findByPilot(Integer idPiloto) {
        return List.of();
    }
}
