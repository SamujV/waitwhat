package userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import model.MagikSquare;

public class magikGodController {


	@FXML
	private TextField txtOrder;

	@FXML
	private ComboBox<String> side;

	@FXML
	private String optionTop;

	@FXML
	private String optionBottom;

	@FXML
	private String optionleft;

	@FXML
	private String optionRight;

	@FXML
	private ComboBox<String> direction;

	@FXML
	private String optionNo;

	@FXML
	private String optionNe;

	@FXML
	private Button botton;

	@FXML
	private Label msm;
	
    @FXML
    private ScrollPane scroll;


	@FXML
	void sideAct(ActionEvent event) {

		if (!(direction.getItems().isEmpty())){
			
			direction.getItems().clear();
		}

		if(side.getValue().equals(optionTop)){

			direction.getItems().addAll(MagikSquare.NORTHWEST, MagikSquare.NORTHEAST);

		}else if(side.getValue().equals(optionBottom)){

			direction.getItems().addAll(MagikSquare.SOUTHWEST, MagikSquare.SOUTHEAST);

		}else if(side.getValue().equals(optionleft)){

			direction.getItems().addAll(MagikSquare.NORTHWEST, MagikSquare.SOUTHWEST);

		}else if(side.getValue().equals(optionRight)){

			direction.getItems().addAll(MagikSquare.NORTHEAST, MagikSquare.SOUTHEAST);

		}

	}


	@FXML
	void doMagik(ActionEvent event) {

		int size;
		size = Integer.parseInt(txtOrder.getText());

		if(size % 2 != 1) {

			msm.setText("Please select an odd number");

		}else {

			MagikSquare magic = new MagikSquare(size, side.getValue(), direction.getValue() );
			magic.mostrarM();
			showGrid(magic);
			
	
		}
	}
	
	public void showGrid(MagikSquare magic) {
		GridPane grid = new GridPane();
		grid.setHgap(4);
		grid.setVgap(4);
		grid.setAlignment(Pos.CENTER);
		magic.grid(grid);
		scroll.setContent(grid);
	}
}
