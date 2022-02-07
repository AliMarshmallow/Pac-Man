module Packman {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.google.gson;


    opens sample.view to javafx.fxml;
    exports sample.view;
    exports sample.model;
    exports sample.cotroller;
}