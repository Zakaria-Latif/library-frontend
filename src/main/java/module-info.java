module com.example.premierprojetfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens com.example.premierprojetfx to javafx.fxml, javafx.graphics, javafx.base;
    exports com.example.premierprojetfx to javafx.fxml, javafx.graphics;
    exports com.example.premierprojetfx.models to com.google.gson;


    opens com.example.premierprojetfx.controllers to javafx.fxml;
    exports  com.example.premierprojetfx.controllers to javafx.fxml;


}