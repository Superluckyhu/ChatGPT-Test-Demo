package top.superluckyhu.chatgpttestdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.superluckyhu.chatgpttestdemo.service.impl.GetMsgImpl;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName ChatController
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/5 16:54
 * @Version 1.0
 **/
@RestController
public class ChatController {
    @Autowired
    GetMsgImpl getMsgImpl;

    @PostMapping(value = "/api/sendMsg")
    public HashMap<String,String> getMsg(@RequestBody HashMap<String,String> msgMap){
        HashMap<String, String> data = new HashMap<>();
        String msg = null;
        try {
            if ((msgMap.get("msg"))!=null){
                msg = getMsgImpl.getMsg(msgMap.get("msg"));
                data.put("data",msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


}
