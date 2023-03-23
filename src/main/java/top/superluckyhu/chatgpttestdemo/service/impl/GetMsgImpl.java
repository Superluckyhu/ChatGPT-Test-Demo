package top.superluckyhu.chatgpttestdemo.service.impl;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.superluckyhu.chatgpttestdemo.config.ParameterProperties;
import top.superluckyhu.chatgpttestdemo.service.GetMsg;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName GetMsgImpl
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/5 17:15
 * @Version 1.0
 **/
@Service
public class GetMsgImpl implements GetMsg {
    @Autowired
    private ParameterProperties parameterProperties;


    @Override
    public String getMsg(String promptMsg) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("0.0.0.0", 10809)))
                .build();
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String,String> messagesMap = new HashMap<>();
        messagesMap.put("role","user");
        messagesMap.put("content",promptMsg);
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        list.add(messagesMap);
        map.put("messages",list);
        map.put("max_tokens",parameterProperties.getMax_tokens());
        map.put("n",3);
        map.put("stop", "/n");
        map.put("stream",false);
        map.put("temperature", parameterProperties.getTemperature());
        map.put("model",parameterProperties.getModel_engine());
        // 将 formMap 转化为 json 然后 AES 加密
        Gson gson = new Gson();
        String jsonParams = gson.toJson(map);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonParams);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .method("POST", requestBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+parameterProperties.getApi_key())
                .build();
        System.out.println(request);
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        System.out.println(json);
        String content = JsonPath.parse(json).read("$.choices[0].message.content", String.class);
        return content;

    }
}
