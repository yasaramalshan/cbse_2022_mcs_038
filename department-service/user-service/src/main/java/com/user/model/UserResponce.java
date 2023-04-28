package com.iitcw.user.model;

import com.iitcw.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponce {

    private User user;
    private Department department;
}
