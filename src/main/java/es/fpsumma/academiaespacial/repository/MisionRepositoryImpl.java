package es.fpsumma.academiaespacial.repository;

import es.fpsumma.academiaespacial.dto.CreateMisionDto;
import es.fpsumma.academiaespacial.dto.MisionDetalleDto;
import es.fpsumma.academiaespacial.dto.ResponseMisionDto;
import es.fpsumma.academiaespacial.model.EstadoMision;
import es.fpsumma.academiaespacial.model.Mision;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Data
@Repository
@Slf4j
public class MisionRepositoryImpl implements MisionRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Mision> listAll() {
        String sql = "SELECT * FROM misiones";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Mision(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("destino"),
                        EstadoMision.valueOf(rs.getString("estado")),
                        rs.getInt("nave_id")


                )
        );


    }

    @Override
    public Mision findById(Integer id) {
        String sql = "SELECT * FROM misiones WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Mision(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("destino"),
                        EstadoMision.valueOf(rs.getString("estado")),
                        rs.getInt("nave_id")
                ), id);
    }

    @Override
    public void save(CreateMisionDto mision) {
        String sql = "INSERT INTO misiones (codigo,destino,estado,nave_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, mision.getCodigo(), mision.getDestino(), mision.getEstadoMision().name(), mision.getNaveId());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM misiones WHERE id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override

    public void updateStateById(Integer id, EstadoMision estadoMision) {
        try {
            String sql = "UPDATE misiones SET estado = ? WHERE id = ? ";
            jdbcTemplate.update(sql, String.valueOf(estadoMision), id);
        } catch (Exception e){
            System.out.println("FALLO SQL UPDATE STATE");
        }

    }

    @Override
    public List<Mision> filterMisionByPilotId(Integer idPiloto) {
        String sql = """
                SELECT
                    m.id,
                    m.codigo,
                    m.destino,
                    m.estado,
                    m.nave_id
                FROM misiones m
                JOIN naves n ON m.nave_id = n.id
                JOIN pilotos p ON n.piloto_id = p.id
                WHERE p.id = ?
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Mision(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("destino"),
                        EstadoMision.valueOf(rs.getString("estado")),
                        rs.getInt("nave_id")
                ), idPiloto);

    }

    @Override
    public MisionDetalleDto viewFullDetailsMision(Integer id) {

        String sql = """
                SELECT
                    m.id,
                    m.codigo,
                    m.destino,
                    m.estado,
                    n.id AS nave_id,
                    n.nombre AS nave_nombre,
                    n.modelo,
                    p.id AS piloto_id,
                    p.nombre AS piloto_nombre,
                    p.rango
                FROM misiones m
                JOIN naves n ON m.nave_id = n.id
                JOIN pilotos p ON n.piloto_id = p.id
                WHERE m.id = ?;
                """;

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new MisionDetalleDto(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("destino"),
                        EstadoMision.valueOf(rs.getString("estado")),
                        rs.getInt("nave_id"),
                        rs.getString("nave_nombre"),
                        rs.getString("modelo"),
                        rs.getInt("piloto_id"),
                        rs.getString("piloto_nombre"),
                        rs.getString("rango")
                ), id);

    }


}

