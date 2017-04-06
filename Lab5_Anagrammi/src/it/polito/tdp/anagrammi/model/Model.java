package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;

import it.polito.tdp.anagrammi.DAO.ParoleDAO;

import java.util.*;

public class Model {

	private String parola;


	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	
	List<String> anagrammi = new LinkedList<String>();
	List<String> anagrammiSbagliati = new LinkedList<String>();
	List<String> anagrammiCorretti = new LinkedList<String>();
	
	public List<String> getAnagrammi(String parola){
		int livello = 0;
		char[] p = parola.toCharArray();
		String parziale ="";
		recursive(p,livello,parziale);
		return anagrammi;
	}
	public List<String> getAnagrammiSbagliati(List<String> temp){
		for(String s: temp){
			ParoleDAO pd = new ParoleDAO();
			if(!pd.isCorrect(s))
				anagrammiSbagliati.add(s);
		}
		return anagrammiSbagliati;
	}
	
	public List<String> getAnagrammiCorretti(List<String> temp){
		for(String s: temp){
			ParoleDAO pd = new ParoleDAO();
			if(pd.isCorrect(s))
				anagrammiCorretti.add(s);
		}
		return anagrammiCorretti;
	}
	
	public void recursive(char[] parole,int step,String parziale){

		if(step == parole.length){
			if(!anagrammi.contains(parziale))
				anagrammi.add(parziale);
		return;
		}
		
				for (int i = 0; i < parole.length; i++) {
					int maxL = this.contaLettere(parole[i],parole);
					int lettere=this.contaLettere(parole[i],parziale.toCharArray());
					if(lettere<maxL){
						parziale+=parole[i];
						recursive(parole,step+1,parziale);
						
						StringBuffer buf= new StringBuffer(parziale.length()-1);
						buf.append(parziale.toString().substring(0,step)).append(parziale.toString().substring(step+1));
						parziale = buf.toString();
					}
				}

	}
	
	private int contaLettere(char c, char[] parola) {
		int conta =0;
		for(char tmp:parola)
			if(tmp== c)
				conta++;
		return conta;
	}


	
	
}
