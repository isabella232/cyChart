package org.cytoscape.cyChart.internal.charts;


import javafx.application.Application;
import javafx.stage.Stage;
public class ReportVersion extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(Stage stage) {
	    System.out.println("java.version: " + System.getProperties().get("javafx.runtime.version"));
	    System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version"));
    System.exit(0);
  }
}