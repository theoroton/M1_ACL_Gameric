package com.gameric.mazegame.model.personnage;

import java.awt.image.BufferedImage;
import com.gameric.mazegame.model.*;
import com.gameric.mazegame.graphique.*;

/**
 *
 * @author Maeva Touchet
 *
 */
public abstract class Personnage{

	//Attributs

	int pointsVie;			//Points de vie courants du personnage
	int vieMax;				//Points de vie max du personnage
	int degats;				//Dégats courants du personnage
	int degatsDefaut;		 //Dégats par défaut du personnage
	int portee;				//Portée de l'attaque du personnage
	Case position;			//Position du personnage
	Labyrinthe labyrinthe;

	String direction;		//direction dans laquelle le personnage regarde
	public static final String N = "Nord";	//Serviront à changer la direction du Personnage
	public static final String E = "Est";
	public static final String S = "Sud";
	public static final String O = "Ouest";

	protected BufferedImage[] walkingUp;
	protected BufferedImage[] walkingRight;
	protected BufferedImage[] walkingLeft;
	protected BufferedImage[] walkingDown;
	protected Animation standing;

	protected BufferedImage[] attaqueUp;
	protected BufferedImage[] attaqueDown;
	protected BufferedImage[] attaqueLeft;
	protected BufferedImage[] attaqueRight;

	protected Animation attaqueU;
	protected Animation attaqueD;
	protected Animation attaqueL;
	protected Animation attaqueR;

	private Animation animation = stand;	//animation courante du personnage

	//Constructeurs
	public Personnage(){
		direction = E;

		walkingUp = new BufferedImage[9];
		walkingRight = new BufferedImage[9];
		walkingLeft = new BufferedImage[9];
		walkingDown = new BufferedImage[9];
		standing = new BufferedImage[1];

		attaqueUp = new BufferedImage[12];
		attaqueDown = new BufferedImage[12];
		attaqueLeft = new BufferedImage[12];
		attaqueRight = new BufferedImage[12];

		for (int i = 0; i < 9; i++ ) {
			walkingDown[i] = new Sprite().getSprite(i, 10, this.getClass());
			walkingLeft[i] = new Sprite().getSprite(i, 9, this.getClass());
			walkingRight[i] = new Sprite().getSprite(i, 11, this.getClass());
			walkingUp[i] = new Sprite().getSprite(i, 8, this.getClass());
		}
		standing[0] = new Sprite().getSprite(0, 2, this.getClass());

		for (int i = 0; i < 12; i++ ) {
			attaqueUp[i] = new Sprite().getSprite(i, 16, this.getClass());
			attaqueDown[i] = new Sprite().getSprite(i, 18, this.getClass());
			attaqueLeft[i] = new Sprite().getSprite(i, 17, this.getClass());
			attaqueRight[i] = new Sprite().getSprite(i, 19, this.getClass());
		}

		walkingUp = new Animation(walkingUp, 10);
		walkingDown = new Animation(walkingDown, 10);
		walkingLeft = new Animation(walkingLeft, 10);
		walkingRight = new Animation(walkingRight, 10);
		standing = new Animation(standing, 10);

		attaqueU = new Animation(attaqueUp, 10);
		attaqueD = new Animation(attaqueDown, 10);
		attaqueL = new Animation(attaqueLeft, 10);
		attaqueR= new Animation(attaqueRight, 10);

	}

	//Méthodes

	/**
	 * Gère le déplacement du personnage, via les coefficients dx et dy
	 * @param dx : déplacement en x
	 * @param dy : déplacement en y
	 * @return Retourne 1 si le déplacement est possible et que la position a été mise à jour,
	 * 0 sinon.
	 */
	public void deplacer(int dx, int dy){
		int new_x = position.getPx() + dx;
		int new_y = position.getPy() + dy;

		if((new_x >= 0) && (new_x < labyrinthe.getLargeur())){			//Vérification: 0 < x < largeur
			if( (new_y >= 0) && (new_y < labyrinthe.getHauteur()) ){	//Vérification: 0 < y < hauteur
				Case new_position = labyrinthe.getCase(new_x,new_y);
				if(new_position != null) {								//Vérification: Case existante

					if(new_position.getClass() != Mur.class){
						//Vérification: CaseVide
						if(!labyrinthe.estCaseOccupee(new_x,new_y)){	//Vérification: Case non occupée
							position = new_position;

							//Si la case sur lequel le personnage se déplace est une case à effet
							if (new_position.getClass().getSuperclass() == CaseEffet.class) {
								//On exécute l'effet de la case
								((CaseEffet) new_position).faireEffet(this);
							}
						}
						else {											//S'il y a collision
							for(Monstre m: labyrinthe.getMonstres()) {			//On boucle sur les monstres
								if(m.getPos_x() == new_x) {						//On cherche celui se trouvant sur la case ou on veut aller
									if(m.getPos_y() == new_y) {
										setPointsVie(pointsVie - m.getDegats());	//On ajuste les points de vie (personnage se prend les dégâts du monstre)
									}
								}
							}									//Le personnage ne va pas sur la case car elle est occupée par le monstre
						}
					}
				}
			}
		}
	}

	public boolean estMort() {
		return pointsVie <= 0;
	}

	public void ramasserObjet(){
		if( position.getClass() == CaseObjet.class ){
			position.ramasserObjet();
		}
	}
	/**
	 * Teste si un monstre est présent sur la case (x,y)
	 **/
	private boolean testMonstre(int x, int y){
		boolean present = false;
		for(Monstre m: labyrinthe.getMonstres()) {			//On boucle sur les monstres
			if(m.getPos_x() == x) {						//On cherche celui se trouvant sur la case
				if(m.getPos_y() == y) {
					present = true;
				}
			}
		}
		return present;
	}

	/**
	 * Récupère le monstre à la position (x,y)
	 **/
	private Monstre getMonstre(int x, int y){
		for(Monstre m: labyrinthe.getMonstres()) {			//On boucle sur les monstres
			if(m.getPos_x() == x) {						//On cherche celui se trouvant sur la case
				if(m.getPos_y() == y) {
					return m;
				}
			}
		}
	}

	private abstract void capaciteSpe();
	/**
	 * Attaque un monstre à portée avec direction d'attaque)
	 **/
	public void attaquer(){
		int distance = 0;
		//On teste chaque case
		for(int i=0; i<labyrinthe.getHauteur(); i++){
			for(int j=0; j<labyrinthe.getLargeur() ; j++){
				Case c = labyrinthe.getCase(i,j);
				distance = Math.abs(position.getPx() - c.getPx() + position.getPy() - c.getPy());
				//Si la case est à portée
				if(distance <= portee){
					//On attaque dans la direction dans laquelle on regarde
					if( ((direction == N) && (c.getPy() >= position.getPy()) )
							|| ((direction == E) && (c.getPx() >= position.getPx()) )
							|| ((direction == S) && (c.getPy() <= position.getPy()) )
							|| ((direction == O) && (c.getPx() <= position.getPx()) ) ){
						//Si la case est vide ou un mur(fantômes)
						if( (c.getClass().getSuperclass() == CaseVide.class)
								|| (c.getClass().getSuperclass() == Mur.class) ){
							//S'il y a un monstre dessus
							if(testMonstre(c.getPx(), c.getPy())){
								//On récupère le monstre
								Monstre m = getMonstre(c.getPx(), c.getPy());
								//On vérifie qu'il n'y a pas d'obstacle entre le monstre et le personnage
								if(m.checkLineBresenham(c.getPx(),c.getPy(),position.getPx(),position.Py())) {
									//On lui fait des dégats
									m.setPointsVie(m.getPointsVie() - this.degats);
									//On active la capacité spéciale de la classe
									capaciteSpe();
								}
							}
						}
					}
				}
			}
		}
	}

	//Setters
	public void setAnimation(Animation anim){
		animation = anim;
	}

	public void setPosition(int x, int y) {
		position = labyrinthe.getCase(x, y);
	}

	public void setLabyrinthe(Labyrinthe labyrinthe) {
		this.labyrinthe = labyrinthe;
	}

	public void setPointsVie(int pointsVie) {
		if (pointsVie < 0) {
			this.pointsVie = 0;
		} else {
			if(pointsVie > vieMax){
				this.pointsVie = vieMax;
			}
			else{
				this.pointsVie = pointsVie;
			}
		}
	}

	public void setVieMax(int newVie){
		vieMax = newVie;
	}

	public void setDegats(int degats){
		this.degats = degats;
	}

	public void setPortee(int portee){ this.portee = portee; }

	public void setDirection(String dir){
		if(dir.equals("N"))	direction = N;
		if(dir.equals("E"))	direction = E;
		if(dir.equals("S"))	direction = S;
		if(dir.equals("O"))	direction = O;
	}

	//Getters
	public Animation getAnimationUp(){
		return walkingUp;
	}

	public Animation getAnimationRight(){
		return walkingRight;
	}

	public Animation getAnimationDown(){
		return walkingDown;
	}

	public Animation getAnimationLeft(){
		return walkingLeft;
	}

	public Animation getAnimationStand(){
		return standing;
	}

	public Animation getAnimation(){
		return animation;
	}

	public Animation getAnimationAtkUp(){
		return attaqueU;
	}

	public Animation getAnimationAtkDown(){
		return attaqueD;
	}

	public Animation getAnimationAtkLeft(){
		return attaqueL;
	}

	public Animation getAnimationAtkRight(){
		return attaqueR;
	}

	public String getStringPosition(){
		return "(" + position.getPx() + "," +  position.getPy() + ")";
	}

	public Case getPosition() {
		return position;
	}

	public int getPos_x() { return position.getPx(); }

	public int getPos_y() {
		return position.getPy();
	}

	public String getDirection(){ return direction; }

	public int getPointsVie() {
		return pointsVie;
	}

	public int getDegats() {
		return degats;
	}

	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}

	public int getVieMax() {
		return vieMax;
	}

	public int getPortee() {
		return portee;
	}
}