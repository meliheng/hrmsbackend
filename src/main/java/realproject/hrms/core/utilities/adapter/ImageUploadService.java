package realproject.hrms.core.utilities.adapter;

import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;

public interface ImageUploadService {
    Result uploadImage(String imageUrl);
    void show();
}
