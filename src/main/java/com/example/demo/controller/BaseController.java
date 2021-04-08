package com.example.demo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

/**
 * @author jone.sun
 * 2021/4/8 11:15
 */
public abstract class BaseController implements Initializable {

    protected final Logger logger = LoggerFactory.getLogger(getClass());


    protected ApplicationContext springContext;

    /**
     * 获取Scene
     * @param actionEvent
     * @return
     */
    public Scene getScene(ActionEvent actionEvent) {
        return ((Node) actionEvent.getSource()).getScene();
    }

    /**
     * 获取Stage
     * @param actionEvent
     * @return
     */
    public Stage getStage(ActionEvent actionEvent) {
        Scene scene = getScene(actionEvent);
        return (Stage) scene.getWindow();
    }

    /**
     * 获取Stage
     * 注意如果是在initialize中获取的话需使用 Platform.runLater(() -> Stage stage = getStage(node);});
     * @param node
     * @return
     */
    public Stage getStage(Node node) {
        return (Stage) node.getScene().getWindow();
    }

    /**
     * 打开页面
     * @param actionEvent
     * @param fxmlName
     * @throws IOException
     */
    public void openController(ActionEvent actionEvent, String fxmlName) throws IOException {
        Scene scene = getScene(actionEvent);
        Parent root = FXMLLoader.load(getClass().getResource(fxmlName), null, null, springContext::getBean);
        scene.setRoot(root);
    }
}