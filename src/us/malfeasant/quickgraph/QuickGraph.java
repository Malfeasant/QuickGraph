package us.malfeasant.quickgraph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class QuickGraph extends Application {
	private static final double TAU = Math.PI * 2.0;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Canvas can = new Canvas(1849, 625);
		
		draw(can.getGraphicsContext2D().getPixelWriter());
		
		primaryStage.setScene(new Scene(new StackPane(can)));
		primaryStage.show();
	}

	private void draw(PixelWriter pw) {
		for (int turn = 200; turn < 600; turn++) {
			int res = 7200;
			if (turn > 300) res = 9720;
			if (turn > 400) res = 12240;
			if (turn > 500) res = 14400;
			
			for (int deg = 0; deg < res; deg++) {
				double rot = deg / (double) res;
				double scale = turn + rot;
				double rad = rot * TAU;
				
				double s = Math.sin(rad) * (scale / 625);
				double c = Math.cos(rad) * (scale / 625);
				
				int x = (int) (c * 2500) - 650;
				int y = (int) (s * 2500) + 312;
				
				pw.setColor(x, y, Color.BLACK);
			}
		}
	}
}
