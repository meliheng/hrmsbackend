package realproject.hrms.cloudinary;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class CloudinaryManager {

    public static Cloudinary cloudinary(){
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "type here",
                "api_key", "type here",
                "api_secret", "type here"));

        return cloudinary;
    }

}
