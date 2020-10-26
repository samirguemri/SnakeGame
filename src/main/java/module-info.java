module org.samir.projects {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.samir.projects to javafx.fxml;
    exports org.samir.projects;
}