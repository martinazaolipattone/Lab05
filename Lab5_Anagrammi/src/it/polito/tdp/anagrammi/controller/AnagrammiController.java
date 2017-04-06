package it.polito.tdp.anagrammi.controller;


import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInsert"
    private TextField txtInsert; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResCorrect"
    private TextArea txtResCorrect; // Value injected by FXMLLoader

    @FXML // fx:id="txtResError"
    private TextArea txtResError; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

	
	List<String> anagrammi = new LinkedList<String>();
	List<String> anagrammiSbagliati = new LinkedList<String>();
	List<String> anagrammiCorretti = new LinkedList<String>();
    @FXML
    void doCalcola(ActionEvent event) {
    if(txtInsert != null){
    	anagrammi= model.getAnagrammi(txtInsert.getText());
    	anagrammiCorretti = model.getAnagrammiCorretti(anagrammi);
    	anagrammiSbagliati = model.getAnagrammiSbagliati(anagrammi);
    	
    	for(String ac: anagrammiCorretti)
    		txtResCorrect.appendText(ac.toString()+"\n");
    	
    	for(String as: anagrammiSbagliati)
    		txtResError.appendText(as.toString()+"\n");
    }
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResCorrect.clear();
    	txtResError.clear();
    	txtInsert.clear();
    	anagrammiCorretti.clear();
    	anagrammiSbagliati.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResCorrect != null : "fx:id=\"txtResCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResError != null : "fx:id=\"txtResError\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model m) {
		this.model = m;
		
	}
}
