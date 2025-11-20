package kr.bitspace.egovframework.fcm.controller;

import kr.bitspace.egovframework.fcm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
public class PushController {

    @Autowired
    private FirebaseCloudMessageService fcmService;

    @RequestMapping(value="/push-num-input", method=RequestMethod.POST)
    public ResponseEntity<?> pushNumberInput(@RequestBody Map<String, Object> req) {
        String targetToken = "device_fcm_token_here"; // 대상 디바이스 토큰 삽입
        String number = String.valueOf(req.get("number"));

        fcmService.sendMessage(targetToken, "숫자 입력 요청", "숫자 " + number + " 입력해주세요.");
        return ResponseEntity.ok().body(Map.of("result", "success"));
    }
    
    @GetMapping("/firebase-key")
    @ResponseBody
    public String getFirebaseKey() throws IOException {
        ClassPathResource resource =
            new ClassPathResource("egovframework/egovProps/kr-bitspace-egovframework-firebase-cloud-messaging-adminsdk.json");

        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

}
