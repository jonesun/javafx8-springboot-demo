package com.example.demo.controller;

import com.example.demo.service.TestService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * 首页
 *
 * @author jone.sun
 * @date 2021/2/24 15:06
 */
@Controller
public class MainController extends BaseController {

    @FXML
    private AnchorPane rootPane;

    @Autowired
    TestService testService;


    @Value("${demo.name}")
    private String demoName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("{}-主页初始化: {}", demoName, testService.sayHello());
    }

    public void doOnCreate(ActionEvent actionEvent) throws IOException {
        logger.info("创建");
    }

    public void doOnOpen(ActionEvent actionEvent) throws IOException {
        logger.info("打开");
    }

}
