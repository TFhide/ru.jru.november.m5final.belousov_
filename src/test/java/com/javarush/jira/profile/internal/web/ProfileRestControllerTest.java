package com.javarush.jira.profile.internal.web;

import com.javarush.jira.AbstractControllerTest;
import com.javarush.jira.common.BaseHandler;
import com.javarush.jira.profile.ContactTo;
import com.javarush.jira.profile.internal.ProfileRepository;
import com.javarush.jira.profile.internal.model.Contact;
import com.javarush.jira.profile.internal.model.Profile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static com.javarush.jira.common.util.JsonUtil.writeValue;
import static com.javarush.jira.login.internal.web.UserTestData.*;
import static com.javarush.jira.profile.internal.web.ProfileTestData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ProfileRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL_PROFILE = BaseHandler.REST_URL + "/profile";

    @DisplayName("auth should be status is Ok")
    @Test
    @WithUserDetails(value = USER_MAIL)
    void authShouldBeOk() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL_PROFILE))
                .andExpect(status().isOk())
    ;}

    @DisplayName("user isn't authorized")
    @Test
    void getUnAuth() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL_PROFILE))
                .andExpect(status().isUnauthorized());
    }

    @DisplayName("should updated user")
    @Test
    @WithUserDetails(value = USER_MAIL)
    void update() throws Exception {
        USER_PROFILE_TO.setMailNotifications(Set.of("assigned", "three_days_before_deadline", "two_days_before_deadline",
                "one_day_before_deadline", "deadline", "overdue"));
        USER_PROFILE_TO.setContacts(Set.of(
                new ContactTo("skype", "newSkype"),
                new ContactTo("mobile", "+380987654321"),
                new ContactTo("website", "new.com"),
                new ContactTo("github", "newGitHub"),
                new ContactTo("tg", "newTg"),
                new ContactTo("vk", "newVk"),
                new ContactTo("linkedin", "newLinkedin"))
        );
        perform(MockMvcRequestBuilders.put(REST_URL_PROFILE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(USER_PROFILE_TO)))
                .andDo(print())
                .andExpect(status().isNoContent());
        PROFILE_TO_MATCHER.assertMatch(USER_PROFILE_TO, ProfileTestData.getUpdatedTo());
    }


}