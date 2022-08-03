package com.example;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MBG {
    @Test
    void run() {
        try {
            Logger logger = LoggerFactory.getLogger(MBG.class.getName());
            List<String> warnings = new ArrayList<>();
            File configFile = new File("MybatisGenerator/MBG-config.xml");
            System.out.println(configFile.getAbsolutePath());
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            if (warnings.size() > 0) {
                logger.warn("读取配置的过程中发生警告：");
                for (String warn : warnings) {
                    logger.warn(warn);
                }
                warnings.clear();
            }
            DefaultShellCallback callback = new DefaultShellCallback(false);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            if (warnings.size() > 0) {
                logger.warn("生成文件的过程中发生警告：");
                for (String warn : warnings) {
                    logger.warn(warn);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
