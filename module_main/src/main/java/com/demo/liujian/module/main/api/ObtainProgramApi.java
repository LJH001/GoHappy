package com.demo.liujian.module.main.api;

import com.demo.liujian.module.main.entity.ProgramEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * <p>Class: com.demo.liujian.module.main.api.ObtainProgramApi</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author liujianhui
 * @date 2021/2/25/18:20
 */

public interface ObtainProgramApi {
    @GET("/article/list/0/json")
    Observable<ProgramEntity> getProgramList();
}

