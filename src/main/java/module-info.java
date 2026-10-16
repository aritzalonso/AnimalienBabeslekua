module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports org.example;
    exports org.example.controller;
    exports org.example.view;
    exports org.example.dao;
}