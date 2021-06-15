package realproject.hrms.core.utilities.adapter;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import realproject.hrms.cloudinary.CloudinaryManager;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.core.utilities.results.SuccessResult;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadWithCloudinary implements ImageUploadService{

    @Override
    public String uploadImage(String imageUrl) throws IOException {
        Map uploadResult = CloudinaryManager.cloudinary().uploader().upload(imageUrl,ObjectUtils.emptyMap());
        return uploadResult.get("url").toString();
    }

    @Override
    public void show() {
        System.out.println(CloudinaryManager.cloudinary().url().imageTag("161w.png"));

    }
}
