package com.mysillydreams.eventmanagement.service;

import com.mysillydreams.eventmanagement.configuration.TwilioOtpConfiguration;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Service
public class OtpService {

    @Autowired
    private TwilioOtpConfiguration twilioOtpConfiguration;

    Map<String,String> otpMap = new HashMap<String,String>();
    public String generateOtp() {
        // Generate a random 6-digit OTP
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }


    public void sendOtp(String to, String otp) {


            Twilio.init(twilioOtpConfiguration.getAccountSid(), twilioOtpConfiguration.getAuthToken());
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(to),
                        new com.twilio.type.PhoneNumber(twilioOtpConfiguration.getPhoneNumber()),
                        "Your OTP is: " + otp)
                .create();

        //System.out.println(message.getSid());
        System.out.println(message.getBody());

    }
}
