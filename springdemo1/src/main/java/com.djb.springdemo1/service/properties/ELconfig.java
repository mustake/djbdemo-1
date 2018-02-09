package com.djb.springdemo1.service.properties;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 *   注入配置文件  需要使用  @PropertySource  指定文件地址，   若使用@Value注入，需要配置一个 PropertySourcesPlaceholderConfigurer
 *   的Bean  注意，@Value（"${book.name}"）使用的是$，而不是 #
 *   注入Properties 还可以从 Environment得到
 */
@Configuration
@ComponentScan
@PropertySource("classpath:test.properties")
public class ELconfig {
    @Value("写入字符串")
    private String normal;
    @Value("#{systemProperties['os.name']}")//获取操作系统属性
    private String osName;

    @Value("#{T(java.lang.Math).random()*1000.0}")//注入表达式结果
    private double randomNumber;

    //注入其他bean属性   注意这不是类  是类name
    @Value("#{demoPropertiesService.author}")
    private String fromAnother;

    //注入文件资源
    @Value("classpath:test.txt")
    private Resource testFile;

    //注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;

    //注入配置文件
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return  new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
