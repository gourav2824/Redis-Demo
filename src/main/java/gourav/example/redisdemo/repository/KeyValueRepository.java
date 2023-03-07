package gourav.example.redisdemo.repository;

import gourav.example.redisdemo.entity.KeyValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyValueRepository extends CrudRepository<KeyValue, String> {
}
