package org.xidian.lichen.backend.util;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class GPTUtil {
    private String API_KEY = "YOUR_API_KEY";
    private String URL_PATH = "https://api.openai.com/v1/chat/completions";
    private String MODEL_NAME = "gpt-3.5-turbo-0301";

    private requestbody body;
    private static class message {
        public String role;
        public String content;

        public message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }

    private static class requestbody {
        public String model;
        public message[] messages;

        public requestbody(String model, message[] messages) {
            this.model = model;
            this.messages = messages;
        }
    }

    private static class choice {
        public int index;
        public message message;
        public String finish_reason;
    }

    private static class response {
        public choice[] choices;
    }

    public GPTUtil() {
        body = new requestbody(MODEL_NAME, new message[]{new message("system", "你是一个优秀的高校招生数据分析专家。")});
    }

    public String getAnswer(String question) {
        message[] newmessage = new message[]{new message("user", question)};
        int len1 = body.messages.length;
        int len2 = newmessage.length;
        message[] nowmessage = Arrays.copyOf(body.messages, len1+len2);
        System.arraycopy(newmessage, 0, nowmessage, len1, len2);
        body.messages = nowmessage;

        try {
            Gson gson = new Gson();
            String jsonBody = gson.toJson(body);
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(URL_PATH))
                    .header("Authorization", "Bearer " + API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            response result = gson.fromJson(responseBody, GPTUtil.response.class);
            System.out.println(result.choices[0].message.content);
            return result.choices[0].message.content;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}
