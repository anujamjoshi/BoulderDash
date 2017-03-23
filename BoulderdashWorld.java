import java.util.ArrayList;


import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BoulderdashWorld extends ActorWorld {
	private Timer t;
	private ArrayList <Mover> movers= new ArrayList<Mover>();
	int count =0; 
	Runner r;
	Grid <Actor> g = getGrid();
	public BoulderdashWorld (){
	super(new BoundedGrid <Actor>(10,10));
		r= new Runner ();
		t = new Timer(900, new GameMover());
		grid();
		t.start();
	}

	public void grid() {
		int a =0;
		while (a < g.getNumRows()){
			int b= 0;
			while (b <g.getNumCols()){
				//System.out.println(a + "b" +b);
				add (new Location (a,b), new Dirt());
				b++;
			}
			a++;
		}
		Boulder e = new Boulder ();
		add (new Location (1,5), e);
		movers.add(e);
		Boulder e1 = new Boulder();
		add (new Location (7,4), e1);
		movers.add(e1);
		Boulder b = new Boulder ();
		add (new Location (3,4), b);
		movers.add(b);
		add (new Location (3,1), r);
		for (int c=0; c<g.getNumRows(); c++){
			add (new Location (c,0), new Wall());
			add (new Location (c,9), new Wall());
		}
		for (int c=1; c<g.getNumCols(); c++){
			add (new Location (0,c), new Wall());
			add (new Location (9,c), new Wall());
		}
		for (int i=1; i<g.getNumCols()-1; i++){
			Diamond d = new Diamond();
			add (new Location (i,i), d);
			movers.add(d);
			count++;
			System.out.println(count);
		}
		Square s= new Square();
		add (new Location (3,5), s);
		movers.add(s);
	}


	
	@Override
	public boolean keyPressed(String s, Location loc)
	{
	        //Grid <Actor> g = getGrid();
	        Actor adjecent;
	        System.out.println(s);
	            
	        Location temp = r.getLocation();
	        Location next = r.getLocation(); 
	        System.out.println(temp);
	       
	        if (s.equals ( "LEFT"))
	        	next = temp.getAdjacentLocation(Location.WEST);
	      else if (s.equals ( "RIGHT"))
	            next = temp.getAdjacentLocation(Location.EAST);
	      else if (s.equals ( "UP"))
	            next = temp.getAdjacentLocation(Location.NORTH);
	       else if (s.equals ( "DOWN"))
	            next = temp.getAdjacentLocation(Location.SOUTH);
	        
	        adjecent = g.get(next);
	        
	        if (count == 0){
	        JOptionPane.showMessageDialog(null, "you WIN!!!");
            System.exit(0);
	        }
	            if (adjecent instanceof Wall)
	            {
	                return false;
	            }
	            else if (adjecent instanceof Boulder)
	            {
	            	
	                return false;
	            }
	            else if (adjecent instanceof Diamond)
	            {
	                count--; 
	                System.out.println(count);
	                movers.remove(adjecent);
	                r.moveTo(next);
	                add (temp, new Empty());
	            }
	            else if (adjecent instanceof Square)
	            {
	               JOptionPane.showMessageDialog(null, "you lose!");
	                System.exit(0);
	               // return false;
	            }
	            else
	           {
	                r.moveTo(next);    
	                add (temp, new Empty());
	            }        
	               return true;
	}
	class GameMover implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			moveMovers();
			setMessage ("You still need to get "+ count +"diamonds");
			show();
			// TODO Auto-generated method stub		
	}
		private void makeDiamonds(Location location) {
			
			Location north =location.getAdjacentLocation(Location.NORTH);
			Location south =location.getAdjacentLocation(Location.SOUTH);
			Location east =location.getAdjacentLocation(Location.EAST);
			Location west =location.getAdjacentLocation(Location.WEST);
			Location northWest =location.getAdjacentLocation(Location.NORTHWEST);
			Location northEast =location.getAdjacentLocation(Location.NORTHEAST);
			Location southWest =location.getAdjacentLocation(Location.SOUTHWEST);
			Location southEast =location.getAdjacentLocation(Location.SOUTHEAST);
		if (g.get(north) instanceof Empty || g.get(south) instanceof Empty || 
				g.get(east) instanceof Empty|| g.get(west) instanceof 
				Empty || g.get(northWest) instanceof Empty|| g.get(northEast) instanceof Empty|| g.get(southWest) instanceof Empty|| 
				g.get(southEast) instanceof Empty ||g.get(north) instanceof Dirt || g.get(south) instanceof Dirt || g.get(east) instanceof Dirt|| g.get(west) instanceof 
				Dirt || g.get(northWest) instanceof Dirt|| g.get(northEast) instanceof Dirt|| g.get(southWest) instanceof Dirt|| 
				g.get(southEast) instanceof Dirt){
			Diamond d = new Diamond ();
			add (north, d);
			movers.add(d);
			count++;
			Diamond d1 = new Diamond();
			add (south, d1);
			movers.add(d1);
			count++;
			Diamond d2 = new Diamond ();
			add (east, d2);
			movers.add(d2);
			count++;
			Diamond d3 = new Diamond ();
			add (west, d3);
			movers.add(d3);
			count++;
			Diamond d4 = new Diamond ();
			add (northWest, d4);
			movers.add(d4);
			count++;
			Diamond d5 = new Diamond ();
			add (northEast, d5);
			movers.add(d5);
			count++;
			Diamond d6 = new Diamond ();
			add (southEast, d6);
			movers.add(d6);
			count++;
			Diamond d7 = new Diamond ();
			add (southWest, d7);
			movers.add(d7);
			count++;
			System.out.println(count);
		}
		}
	private void moveMovers() {
		// TODO Auto-generated method stub
		for (int i = 0; i <movers.size(); i++){
			Mover m = movers.get(i);
			int moveResult;
			Location myloc = m.getLocation();
			Location adjecent = myloc.getAdjacentLocation(Location.SOUTH);
			g.get(adjecent);
			moveResult = m.moveme();
		
				if (moveResult == 0){
					
				}
				if (moveResult == 1){
					t.stop();
					JOptionPane.showMessageDialog(null, "you lose!");
					System.exit (0);
				}
				else if (moveResult == 2){
					System.out.println(" this works");
					movers.remove(adjecent);
					g.remove(adjecent);
					m.moveTo(adjecent);
					add (myloc, new Empty());
					
					makeDiamonds(adjecent);
					i++;
					System.out.println(" hi this works");
				}
				
				 if (moveResult ==3 ){
					add (myloc, new Empty());
					System.out.println(":D");
				}
				else if (moveResult ==4 ){
					add (myloc, new Empty());
					System.out.println("lo");
				}
				else if (moveResult == 5){
					System.out.println ("you have hit a diamond... diamond dies!");
					movers.remove(g.get (adjecent));
					g.remove (adjecent);
					add (adjecent, new Empty());
					count--;
					System.out.println ("you have "+ count + " dimonds left to get!");
				}
				
			}
		}
		
	}
}
