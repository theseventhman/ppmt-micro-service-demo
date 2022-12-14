package com.tj.exercise.ppmt.configure.center.demo.common.util;

import cn.hutool.core.bean.BeanUtil;
import com.tj.exercise.ppmt.configure.center.demo.common.Config;
import com.tj.exercise.ppmt.configure.center.demo.common.ConfigLoader;
import com.tj.exercise.ppmt.configure.center.demo.common.facade.ConfigInfoFacade;
import com.tj.exercise.ppmt.configure.center.demo.common.vo.ConfigInfoVO;
import com.tj.exercise.ppmt.core.project.api.demo.dto.ConfigDto;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/12/12 20:28
 */
public class RequestUtil implements  Runnable {
    public void run() {
        while (true) {
            System.out.println("模拟调用http请求");

            SendRequestGetConfigInfo();
            try {
                Thread.sleep(2 *
                        60 *
                        1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("定时模拟调用http请求出错");
            }
        }
    }


    public void SendRequestGetConfigInfo() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8763/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        ConfigInfoFacade service = retrofit.create(ConfigInfoFacade.class);
        Call<List<ConfigDto>> callSync = service.getConfigInfos();
        try {
            Response<List<ConfigDto>> response = callSync.execute();
            List<ConfigDto> configInfoVOS = response.body();
           List<Config> configs =  BeanUtil.copyToList(configInfoVOS,Config.class);
            for (Config config : configs) {
                ConfigLoader.getInstance().loadConfig(config);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
