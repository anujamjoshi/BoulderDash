import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class Square extends Mover {
	public Square(){
		setColor (null);
		Location location = this.getLocation();
	}
	@Override
	public int moveme() {
		Location loc = this.getLocation();
		Grid<Actor>grid = getGrid();
		if (loc != null){
		Location left = loc.getAdjacentLocation(Location.WEST);
		Location right = loc.getAdjacentLocation(Location.EAST);
		Location down = loc.getAdjacentLocation(Location.SOUTH);
		Location up = loc.getAdjacentLocation(Location.NORTH);
		
//		if (grid.get(left) instanceof Dirt || grid.get(left)instanceof Wall || grid.get(left) instanceof Diamond
//				|| grid.get(right) instanceof Dirt || grid.get(right)instanceof Wall || grid.get(right) instanceof Diamond){
//			return 0;
//		}
		 if (grid.get(right)instanceof Runner || grid.get(left)instanceof Runner){
			return 1;
		}
		 else if (grid.get(left)instanceof Diamond|| grid.get(left)instanceof Wall || grid.get(left)instanceof Dirt||grid.get(right)instanceof Diamond|| grid.get(right)instanceof Wall|| grid.get(right)instanceof Dirt){
			 System.out.println("hey this doesn't eatme)");
			 if (grid.get (down) instanceof Empty){
				 this.moveTo(down);
				 return 3;
			 }
			 else if (grid.get(right)instanceof Empty){
				 this.moveTo(right);
				 return 3;
			 }
			 else if (grid.get(left)instanceof Empty){
				 this.moveTo(left);
				 return 3;
			 }
			 else if (grid.get(up)instanceof Empty){
				 this.moveTo(up);
				 return 3;
			 }
			 return 0;
			 
		 }
		 else if (grid.get(right)instanceof Diamond|| grid.get(right)instanceof Wall|| grid.get(right)instanceof Dirt){
			 System.out.println("hey this doesn't eatme)");
			 if (grid.get(left)instanceof Empty){
				 this.moveTo(left);
				 return 3;
			 }
			 return 0;
			 
		 }
		 
		 else if (grid.get(left)instanceof Empty|| grid.get(right)instanceof Empty){
			 this.moveTo(right);
			 return 3;
		 }
		 else if (grid.get(left)instanceof Boulder|| grid.get(right)instanceof Boulder){
			this.removeSelfFromGrid();
			return 4;
		 }
		 
		
		}
	
		return 0;
	
	}
	
}
