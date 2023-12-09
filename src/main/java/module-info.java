module com.stickheroap.stickheroap {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.stickheroap.stickheroap to javafx.fxml;
    exports com.stickheroap.stickheroap;
}