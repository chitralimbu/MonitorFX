package monitor.scheduler.test;

import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import monitor.scheduler.handlers.ButtonUpdater;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
public class CounterServiceApplication extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		CounterService counterServc = new CounterService();
		Counter oc = new Counter();
		GridPane gp = new GridPane();
		Button button = new Button();
		button.setMinSize(100, 100);
		button.setText("1");
		gp.getChildren().add(button);
		
		counterServc.setObject(oc);
		counterServc.setPeriod(Duration.seconds(1));
		
		counterServc.setOnSucceeded(new ButtonUpdater(button, oc));
		
		/*
		 * counterServc.setOnSucceeded(new EventHandler<WorkerStateEvent>(){
		 * 
		 * @Override public void handle(WorkerStateEvent event) {
		 * System.out.println(event.getSource().getValue()); oc.setCount((int)
		 * event.getSource().getValue()); button.setText(Integer.toString((int)
		 * event.getSource().getValue())); }
		 * 
		 * });
		 */
	
		counterServc.start();
		
		stage.setTitle("test");
		Scene scene = new Scene(gp);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
