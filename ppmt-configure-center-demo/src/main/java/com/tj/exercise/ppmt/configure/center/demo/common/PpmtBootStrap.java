package com.tj.exercise.ppmt.configure.center.demo.common;

import java.util.List;

/**
 * @Author: tj
 * @Date: 2022/12/22 15:51
 */
public class PpmtBootStrap {

        private PpmtBootStrap(){
            System.out.println("调用私有构造函数");
            List<Config> configs = PpmtConfig.loadConfigForDownload();
            for (Config config : configs) {
               ConfigLoader.getInstance().loadConfig(config);
            }


        }

        private static class PpmtBootStrapHelper {
            private static PpmtBootStrap INSTANCE = new PpmtBootStrap();
        }

        public static PpmtBootStrap getInstance(){
            return PpmtBootStrapHelper.INSTANCE;
        }

}
