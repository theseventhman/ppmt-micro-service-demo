package com.tj.exercise.ppmt.configure.center.demo.common.facade;

import com.tj.exercise.ppmt.configure.center.demo.common.vo.ConfigInfoVO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/12/20 23:23
 */
public interface ConfigInfoFacade {
    @GET("/config/getConfigInfos")
    public Call<List<ConfigInfoVO>> getConfigInfos();
}
