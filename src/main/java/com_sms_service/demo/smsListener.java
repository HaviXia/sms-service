package com_sms_service.demo;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jms.annotation.JmsListener;


import java.util.Map;


@Component
public class smsListener {

    @Autowired
    private smsUtil smsutil;

    //从 rabbitMQ 中接收短信发送给用户
    @JmsListener(destination = "sms")
    public void sendSms(Map<String, String> map) {
        try {

            SendSmsResponse sendSmsResponse = smsutil.sendSms(map.get("phoneNumber"), map.get("templateCode"), map.get("signName"), map.get("param"));
            System.out.println("code:" + sendSmsResponse.getCode());
            System.out.println("message" + sendSmsResponse.getMessage());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
