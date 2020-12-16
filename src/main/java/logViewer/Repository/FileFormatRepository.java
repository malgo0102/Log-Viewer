package logViewer.Repository;

import logViewer.Model.FileFormat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileFormatRepository extends CrudRepository<FileFormat, Long> {

    @Override
    FileFormat save(FileFormat fileFormat);
}
