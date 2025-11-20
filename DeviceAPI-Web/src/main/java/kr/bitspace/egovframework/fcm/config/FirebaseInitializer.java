package kr.bitspace.egovframework.fcm.config;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;

public class FirebaseInitializer {

    private String serviceAccountPath;   // XML에서 주입
    private ResourceLoader resourceLoader;

    public void setServiceAccountPath(String serviceAccountPath) {
        this.serviceAccountPath = serviceAccountPath;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void init() throws Exception {
        Resource resource = resourceLoader.getResource(serviceAccountPath);
        InputStream serviceAccount = resource.getInputStream();

        @SuppressWarnings("deprecation")
		FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }
}
