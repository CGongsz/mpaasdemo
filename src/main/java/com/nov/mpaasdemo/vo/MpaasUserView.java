package com.nov.mpaasdemo.vo;

import com.definesys.mpaas.query.annotation.SQL;
import com.definesys.mpaas.query.annotation.SQLQuery;
import lombok.Data;

@Data
@SQLQuery(value = {
        @SQL(view = "v1", sql = "select id, code, name, age from mpaas_user"),
        @SQL(view = "v2", sql = "select name from mpaas_user")
})
public class MpaasUserView {
    private Integer id;
    private String code;
    private String name;
    private Integer age;
}
