package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication extends Application {

    private ConfigurableApplicationContext springContext;


    @Override
    public void init() {
        springContext = SpringApplication.run(DemoApplication.class);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"), null, null, springContext::getBean);
        //或者
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("xxx");
        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.show();
    }


    @Override
    public void stop(){
        springContext.close();
    }

    public static void main(String[] args) {
        //为了能正常使用Desktop.getDesktop()相关方法
        System.setProperty("java.awt.headless", Boolean.toString(false));
        launch();
    }

}