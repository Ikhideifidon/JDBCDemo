module com.github.ikhideifidon.jdbcdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires mysql.connector.java;
    requires java.sql;

    opens com.github.ikhideifidon.jdbcdemo to javafx.fxml;
    exports com.github.ikhideifidon.jdbcdemo;
}