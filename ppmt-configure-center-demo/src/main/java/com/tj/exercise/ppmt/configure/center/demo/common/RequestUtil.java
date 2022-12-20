package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.common.facade.ConfigInfoFacade;
import com.tj.exercise.ppmt.configure.center.demo.common.vo.ConfigInfoVO;
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
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://localhost:8763/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            ConfigInfoFacade service = retrofit.create(ConfigInfoFacade.class);
            Call<List<ConfigInfoVO>> callSync = service.getConfigInfos();
            try {
                Response<List<ConfigInfoVO>> response = callSync.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5 *
                        60 *
                        1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("定时模拟调用http请求出错");
            }
        }
    }
}
