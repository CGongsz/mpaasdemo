package com.nov.mpaasdemo.repository;

import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.nov.mpaasdemo.bean.User;
import com.nov.mpaasdemo.vo.MpaasUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private MpaasQueryFactory mpaasQueryFactory;

    public List<User> findUserByName(String name) {
        List<User> users = mpaasQueryFactory.buildQuery()
                .eq("name", name)
                .doQuery(User.class);
        return users;
    }

    public List<User> startWith(String field, String value){
        List<User> users = mpaasQueryFactory.buildQuery()
                .startWith(field, value)
                .doQuery(User.class);
        return users;
    }

    public List<User> findComplexCondition(){
        List<User> userViews = mpaasQueryFactory.buildQuery()
                .and()
                .like("name", "剑")
                .lteq("age", "25")
                .conjuctionOr()
                .and()
                .eq("code", "005")
                .gt("age", "26")
                .doQuery(User.class);
        return userViews;
    }

    public List<MpaasUserView> findView(){
        List<MpaasUserView> userViews = mpaasQueryFactory.buildViewQuery("v1")
                .like("name", "剑")
                .doQuery(MpaasUserView.class);
        return userViews;
    }

    public PageQueryResult<User> findByPage(){
        PageQueryResult<User> userPageQueryResult = mpaasQueryFactory.buildQuery()
                .like("email", "ng")
                .doPageQuery(2, 2, User.class);
        return userPageQueryResult;
    }

    public Response deleteByUserName(String name){
        mpaasQueryFactory.buildQuery()
                .eq("name", name)
                .table("mpaas_user")
                .doDelete();
        return Response.ok();
    }
}
