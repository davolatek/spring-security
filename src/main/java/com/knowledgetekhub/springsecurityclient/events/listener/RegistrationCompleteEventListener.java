package com.knowledgetekhub.springsecurityclient.events.listener;

import com.knowledgetekhub.springsecurityclient.entity.User;
import com.knowledgetekhub.springsecurityclient.events.RegistrationCompleteEvent;
import com.knowledgetekhub.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create verification Token for the user to click
        User user = event.getUser();
        String token = UUID.randomUUID().toString();

        userService.saveVerificationToken(token, user);

        // Send email to new User

        String url = event.getApplicationUrl()+"/verifyRegistration?token="+token;

        log.info("Click the link to verify your account: {}",url);
    }
}
