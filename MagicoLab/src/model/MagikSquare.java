package model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MagikSquare {

	public final static String UP = "TOP";
	public final static String DOWN = "BOTTOM";
	public final static String RIGHT = "RIGHT";
	public final static String LEFT = "LEFT";
	public final static String NORTHWEST = "Northwest";
	public final static String NORTHEAST = "Northeast";
	public final static String SOUTHWEST = "Southwest";
	public final static String SOUTHEAST = "Southeast";

	private int magikConst;
	private int size;
	private int k;
	private int start;
	static int[][] matriz;	
	private String direction;
	private String side;

	public MagikSquare(int sizee, String sidee, String direct) {
		size = sizee;
		k = (size - 1)/2;
		matriz = new int[size][size];
		magikConst = ((size*size+1)*size)/2; 
		start = size - 1;
		side = sidee;
		direction = direct;

		one();

	}

	public void one(){		

		int c = 1;
		int i = 0;
		int j = 0;

		if(side.equals(UP)){
			i = 0;
			j = k;

			matriz[i][j] = c;
			if (direction.equals(NORTHWEST)) {
				northWest(i,j);

			}else if (direction.equals(NORTHEAST)) {
				northEast(i, j);

			}

		}else if(side.equals(DOWN)){
			i = start;
			j = k;

			matriz[i][j] = c; 
			if (direction.equals(SOUTHWEST)) {
				caseSouthWest();

			}else if (direction.equals(SOUTHEAST)) {
				southEast(i, j);
			}

		}else if(side.equals(LEFT)){
			i = k;
			j = 0;

			matriz[i][j] = c; 
			if (direction.equals(NORTHWEST)) {
				northWest(i,j);

			}else if (direction.equals(SOUTHWEST)) {
				southWest(i, j);
			}

		}else if(side.equals(RIGHT)) {
			i = k;
			j = start;

			matriz[i][j] = c; 
			if (direction.equals(NORTHEAST)) {
				northEast(i, j);

			}else if (direction.equals(SOUTHEAST)) {
				southEast(i, j);
			}
		}
	}


	public void southWest(int x, int y){
		int a = x; // fila 1 
		int b = y; // columna 1

		int count = size*size;
		int coun = 1;
		int i = x;
		int j = y;

		do{
			coun++;			
			i++;
			j--;			
			if(i == size ) {
				i = 0;
			}
			if(j < 0) {
				j = start;
			}			
			if(matriz[i][j] != 0) {

				if(side.equals(LEFT)){
					i = a;
					j = b + 1;
					matriz[i][j] = coun;
				}else if(side.equals(DOWN)) {
					i = a - 1;
					j = b;
					matriz[i][j] = coun;					
				}
			}else {
				a = i; 
				b = j;
				matriz[i][j] = coun;
			}
			count--;
		}while(count > 1);		
	}


	public void northWest(int x, int y){
		int a = x; // fila 1 
		int b = y; // columna 1

		int count = size*size;
		int coun = 1;
		int i = x;
		int j = y;

		do{
			coun++;			
			i--;
			j--;			
			if(i < 0 ) {
				i = start;
			}
			if(j < 0) {
				j = start;
			}			
			if(matriz[i][j] != 0) {

				if(side.equals(LEFT)){
					i = a;
					j = b + 1;
					matriz[i][j] = coun;
				}else if(side.equals(UP)) {
					i = a + 1;
					j = b;
					matriz[i][j] = coun;					
				}
			}else { // actualiza a y b, estan una posicion detras de i j
				a = i; 
				b = j;
				matriz[i][j] = coun;
			}
			count--;
		}while(count > 1);		
	}


	public void northEast(int x, int y){
		int a = x; // fila 1 
		int b = y; // columna 1

		int count = size*size;
		int coun = 1;
		int i = x;
		int j = y;

		do{
			coun++;			
			i--;
			j++;			
			if(i < 0 ) {
				i = start;
			}
			if(j == size) {
				j = 0;
			}			
			if(matriz[i][j] != 0) {

				if(side.equals(UP)){
					i = a + 1;
					j = b;
					matriz[i][j] = coun;
				}else if(side.equals(RIGHT)) {
					i = a;
					j = b - 1;
					matriz[i][j] = coun;					
				}
			}else { // actualiza a y b, estan una posicion detras de i j
				a = i; 
				b = j;
				matriz[i][j] = coun;
			}
			count--;
		}while(count > 1);		
	}


	public void southEast(int x, int y){
		int a = x; // fila 1 
		int b = y; // columna 1

		int count = size*size;
		int coun = 1;
		int i = x;
		int j = y;

		do{
			coun++;			
			i++;
			j++;			
			if(i == size ) {
				i = 0;
			}
			if(j == size) {
				j = 0;
			}			
			if(matriz[i][j] != 0) {

				if(side.equals(RIGHT)){
					i = a;
					j = b - 1;
					matriz[i][j] = coun;
				}else if(side.equals(DOWN)) {
					i = a - 1;
					j = b;
					matriz[i][j] = coun;					
				}
			}else { // actualiza a y b, estan una posicion detras de i j
				a = i; 
				b = j;
				matriz[i][j] = coun;
			}
			count--;
		}while(count > 1);		
	}


	public void mostrarM() {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print("" + matriz[i][j]);
			}
			System.out.println("");
		}
		//	System.out.println(""+ k);

	}

	public void grid(GridPane grid) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				Button but = new Button();
				but.setAlignment(Pos.CENTER);
				but.setPrefHeight(36);
				but.setPrefWidth(36);
				but.setText( ""+ matriz[i][j]);				
				grid.add(but, j, i);
			}
		}

	}

	public void caseSouthWest(){
		int p = k;
		int i = 0;
		int j = 0;
		int c = 1;
		int count = size*size;
		matriz[start][p] = c++;

		do {
			if(start + 1 == size && p - 1 >= 0 && matriz[0][p - 1] != 0){

				matriz[0][p-1] = c;
				i = 0;
				j = p-1;

			}else if(i + 1 < start && j - 1 < 0 && matriz[i + 1][start] != 0){

				matriz[i+1][start] = c;
				i++;
				j = start;

			}else if(i - 1 >= 0 && j - 1 >= 0 && matriz[i - 1][j - 1] != 0 ){

				matriz[i - 1][j - 1] = c;
				i--;
				j--;

			}else if(i - 1 < 0 && j + 1 > size && matriz[0][start] != 0) {

				matriz[0][start] = c;
				i--;
				j++;

			}else {
				if(side.equals(LEFT)){
					j++;
					matriz[i][j] = c;
					
				}else if(side.equals(DOWN)) {
					i--;
					if(i >0) {
						matriz[i][j] = c;

					}
				}
			}
			c++;

			//System.out.print(""+matriz[i][j]);
			count--;
		}while(count > 1);

	}

}



