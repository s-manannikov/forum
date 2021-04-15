package forum.service;

import forum.model.Reply;
import forum.repository.ReplyRepository;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    private final ReplyRepository replies;

    public ReplyService(ReplyRepository replies) {
        this.replies = replies;
    }

    public void saveReply(Reply reply) {
        replies.save(reply);
    }
}
