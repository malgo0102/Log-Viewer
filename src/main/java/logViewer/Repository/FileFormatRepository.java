package logViewer.Repository;

import logViewer.Model.FileFormat;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FileFormatRepository extends CrudRepository<FileFormat, Integer> {

    Optional<FileFormat> findById(int id);
    Iterable<FileFormat> findAll();

}
