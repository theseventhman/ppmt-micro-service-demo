package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.common.facade.ConfigInfoFacade;
import com.tj.exercise.ppmt.configure.center.demo.common.util.RequestUtil;
import com.tj.exercise.ppmt.configure.center.demo.common.vo.ConfigInfoVO;
import okhttp3.OkHttpClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/12/22 16:09
 */
public class PpmtConfig {
    public static void  loadConfigForDownload() {
        new RequestUtil().SendRequestGetConfigInfo();
    }
}
