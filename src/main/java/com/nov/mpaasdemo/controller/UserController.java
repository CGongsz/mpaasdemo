package com.nov.mpaasdemo.controller;

import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.nov.mpaasdemo.bean.User;
import com.nov.mpaasdemo.repository.UserRepository;
import com.nov.mpaasdemo.vo.MpaasUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public List<User> findUserByName(@PathVariable Integer id){
        List<User> users = userRepository.findUserByName("阿三");
        return users;
    }

    @GetMapping("/user")
    public List<User> startWith(){
        List<User> users = userRepository.startWith("email", "jia");
        return users;
    }

    @GetMapping("/user/condition")
    public List<User> findComplexCondition(){
        return userRepository.findComplexCondition();
    }

    @GetMapping("/user/view")
    public List<MpaasUserView> findView(){
        List<MpaasUserView> view = userRepository.findView();
        return view;
    }

    @GetMapping("/user/page")
    public PageQueryResult<User> findByPage(){
        PageQueryResult<User> byPage = userRepository.findByPage();
        return byPage;
    }

    @DeleteMapping("/user/delete")
    public Response deleteUserByRowId(@RequestParam(value = "name") String name){
        Response response = userRepository.deleteByUserName(name);
        return response;
    }
}
