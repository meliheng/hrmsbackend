package realproject.hrms.core.utilities.adapter;

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
    public Result uploadImage(String imageUrl){
        try {
            Map uploadResult = CloudinaryManager.cloudinary().uploader().upload(imageUrl,ObjectUtils.asMap("resource_type","image","public_id","161w"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SuccessResult("profil resmi kaydedildi");
    }

    @Override
    public void show() {
        System.out.println(CloudinaryManager.cloudinary().url().imageTag("161w.png"));

    }
}
