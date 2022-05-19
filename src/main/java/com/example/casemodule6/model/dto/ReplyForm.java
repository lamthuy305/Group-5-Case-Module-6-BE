package com.example.casemodule6.model.dto;

import com.example.casemodule6.model.entity.Comment;
import com.example.casemodule6.model.entity.Profile;
import com.example.casemodule6.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyForm {

    private Comment comment;

    private String text;

    private User user;

    private Profile profile;
}
