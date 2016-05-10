import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import models.FacilitatorId;
import models.Picture;
import models.LoginRequest;
import models.RegisterRequest;
import models.MyPropertyNamingStrategy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new MyPropertyNamingStrategy());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = "";

        try {
            // Register Request

            ArrayList<Picture> pictures = new ArrayList<>();
            for (int i = 1; i < 8; i++) {
                String image = String.format("res/obama%s.jpg", i);
                byte[] originalBytes = Files.readAllBytes(Paths.get(image));
                Base64.Encoder base64Encoder = Base64.getEncoder();
                String base64String = base64Encoder.encodeToString(originalBytes);
                Picture picture = new Picture(base64String, i);
                pictures.add(picture);
            }

            RegisterRequest registerRequest = new RegisterRequest(pictures);

            try {
                json = mapper.writeValueAsString(registerRequest);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            Path registerPath = Paths.get("res/register_request_json.txt");
            try (BufferedWriter writer = Files.newBufferedWriter(registerPath)) {
                writer.write(json);
            }


            // Login Request

            byte[] originalBytes = Files.readAllBytes(Paths.get("res/obama2.jpeg"));
            Base64.Encoder base64Encoder = Base64.getEncoder();
            String base64String = base64Encoder.encodeToString(originalBytes);
            ArrayList<FacilitatorId> facilitatorIds = new ArrayList<>();
            FacilitatorId facilitatorId = new FacilitatorId("fpp", "sdafjjasdklfjksdhgkalsdgklsa");
            facilitatorIds.add(facilitatorId);
            LoginRequest loginRequest = new LoginRequest(facilitatorIds, base64String);

            try {
                json = mapper.writeValueAsString(loginRequest);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            Path loginPath = Paths.get("res/login_request_json.txt");
            try (BufferedWriter writer = Files.newBufferedWriter(loginPath)) {
                writer.write(json);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
