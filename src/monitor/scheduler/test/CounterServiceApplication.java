package monitor.scheduler.test;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import monitor.scheduler.handlers.ButtonUpdater;
import javafx.scene.layout.TilePane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
public class CounterServiceApplication extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		//Initiate TilePane
		TilePane tp = new TilePane();
		
		//Initiate CounterService
		CounterService counterServc = new CounterService();
		CounterService counterServc_2 = new CounterService();
		
		//Initiate counter
		Counter oc = new Counter(100);
		Counter op = new Counter(2000);
		
		//Initiate Button and styling
		Button button = new Button();
		button.setMinSize(100, 100);
		
		Button button_2 = new Button();
		button_2.setMinSize(100, 100);
		
		//add buttons to TilePane
		tp.getChildren().add(button);
		tp.getChildren().add(button_2);
		
		//set counterservice object.
		counterServc.setObject(oc);
		counterServc_2.setObject(op);
		
		//set counterService periods
		counterServc.setPeriod(Duration.seconds(1));
		counterServc_2.setPeriod(Duration.seconds(1));
		
		//set counterservice onsucceded
		counterServc.setOnSucceeded(new ButtonUpdater(button, oc));
		counterServc_2.setOnSucceeded(new ButtonUpdater(button_2, op));
		
		//start service
		counterServc.start();
		counterServc_2.start();
		
		stage.setTitle("test");
		Scene scene = new Scene(tp);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
