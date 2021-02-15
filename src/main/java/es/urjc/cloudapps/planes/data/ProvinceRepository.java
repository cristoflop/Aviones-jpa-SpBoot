package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.provinces.Data;
import es.urjc.cloudapps.planes.domain.provinces.Province;
import es.urjc.cloudapps.planes.dto.ProvinceTotalsDto;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends MongoRepository<Province, String> {

    @Aggregation(pipeline = {"{$unwind:\"$Datos\"}","{$replaceRoot: {newRoot: \"$Datos\"}}",})
    List<Data> findAllProvincesData();

    @Aggregation(pipeline = {"{$group:{_id: { $ifNull: [ \"$CA\", \"Sin comunidad\" ] }, provinces: {$sum:1}}}"})
    List<ProvinceTotalsDto> findAllProvincesTotals();
}
