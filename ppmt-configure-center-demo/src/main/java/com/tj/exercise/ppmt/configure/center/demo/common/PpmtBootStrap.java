package com.tj.exercise.ppmt.configure.center.demo.common;

import com.tj.exercise.ppmt.configure.center.demo.common.util.RequestUtil;

import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/12/22 15:51
 */
public class PpmtBootStrap {

        private PpmtBootStrap(){
            System.out.println("调用私有构造函数");
             PpmtConfig.loadConfigForDownload();
        }

        public void init(){
            Thread thread = new Thread(new RequestUtil());
            thread.setName("requestUtil");
            thread.setDaemon(true);
            thread.start();
        }

         static class PpmtBootStrapHelper {
            public final static PpmtBootStrap INSTANCE = new PpmtBootStrap();
        }

        public static PpmtBootStrap getInstance(){
            return PpmtBootStrapHelper.INSTANCE;
        }

}
