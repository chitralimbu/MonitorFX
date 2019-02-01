package monitor.scheduler.handlers;

import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.concurrent.WorkerStateEvent;
import monitor.scheduler.test.Counter;
public class ButtonUpdater implements EventHandler<WorkerStateEvent>{
	
	Button button;
	Counter oc;
	
	public ButtonUpdater(Button button, Counter oc) {
		this.button = button;
		this.oc = oc;
	}
	
	@Override
	public void handle(WorkerStateEvent event) {
		System.out.println(event.getSource().getValue());
		oc.setCount((int) event.getSource().getValue());
		button.setText(Integer.toString((int) event.getSource().getValue()));
	}
	
}

