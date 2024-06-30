package org.example.service;

import org.example.common.CommentPageResult;
import org.example.entity.User;

public interface CommentService {
    CommentPageResult
    getAllComments(Integer phone_id, int pageNum, int pageSize, User user);

    CommentPageResult
    getGoodComments(Integer phone_id, int pageNum, int pageSize, User user);

    CommentPageResult
    getGeneralComments(Integer phone_id, int pageNum, int pageSize, User user);

    CommentPageResult
    getPoorComments(Integer phone_id, int pageNum, int pageSize, User user);
}
