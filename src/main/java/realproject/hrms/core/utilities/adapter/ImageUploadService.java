package realproject.hrms.core.utilities.adapter;

import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;

import java.io.IOException;

public interface ImageUploadService {
    String uploadImage(String imageUrl) throws IOException;
    void show();
}
