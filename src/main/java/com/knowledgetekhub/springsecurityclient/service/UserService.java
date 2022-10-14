package com.knowledgetekhub.springsecurityclient.service;

import com.knowledgetekhub.springsecurityclient.entity.User;
import com.knowledgetekhub.springsecurityclient.entity.VerificationToken;
import com.knowledgetekhub.springsecurityclient.model.UserModel;

import java.util.Optional;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationToken(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);
}
