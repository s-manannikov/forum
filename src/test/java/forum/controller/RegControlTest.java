package forum.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

import forum.model.User;
import forum.service.UserService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import forum.Main;

import org.hamcrest.MatcherAssert;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class RegControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService users;

    @Test
    @WithMockUser
    public void whenRequestRegistration() throws Exception {
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }

    @Test
    @WithMockUser
    public void whenRegister() throws Exception {
        this.mockMvc.perform(post("/reg")
                .param("username","user1")
                .param("email", "mail")
                .param("password", "pass"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(users).saveUser(argument.capture());
        MatcherAssert.assertThat(argument.getValue().getUsername(), is("user1"));
    }
}