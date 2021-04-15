package forum.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import forum.model.Post;
import forum.model.Reply;
import forum.service.PostService;
import forum.service.ReplyService;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import forum.Main;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class PostControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService posts;

    @MockBean
    private ReplyService replies;

    @Test
    @WithMockUser
    public void whenRequestCreatingPost() throws Exception {
        this.mockMvc.perform(get("/add"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("add"));
    }

    @Test
    @WithMockUser
    public void whenRequestPost() throws Exception {
        this.mockMvc.perform(get("/post?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

    @Test
    @WithMockUser
    public void whenCreateNewPost() throws Exception {
        this.mockMvc.perform(post("/addpost")
                .param("name", "post title")
                .param("userid", "1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(posts).addPost(argument.capture());
        MatcherAssert.assertThat(argument.getValue().getName(), is("post title"));
    }

    @Test
    @WithMockUser
    public void whenCreateNewReply() throws Exception {
        when(posts.findPostById(1)).thenReturn(new Post());
        this.mockMvc.perform(post("/reply")
                .param("id","1")
                .param("reply","test reply")
                .param("userid","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
        ArgumentCaptor<Reply> argument = ArgumentCaptor.forClass(Reply.class);
        verify(replies).saveReply(argument.capture());
        MatcherAssert.assertThat(argument.getValue().getDescription(), is("test reply"));
    }
}