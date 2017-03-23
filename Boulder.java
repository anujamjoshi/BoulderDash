import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class Boulder extends Mover {

	public Boulder(){
		setColor (null);
	}
	

	public int moveme() {
		Location loc = this.getLocation();
		Location right = loc.getAdjacentLocation(Location.EAST);
		Location left = loc.getAdjacentLocation(Location.WEST);
		Grid<Actor> grid = getGrid();
		Location down = loc.getAdjacentLocation(Location.SOUTH);
		
		if (grid.get(down) instanceof Dirt || grid.get(down)instanceof Wall){
			return 0;
		}
		else if(grid.get(down) instanceof Runner){
			return 1;
		}
		else if(grid.get(down) instanceof Square){
			grid.remove(down);
			return 2;
		}
		else if (grid.get(down) instanceof Diamond ){
			return 5;
		}
		else if (grid.get(down) instanceof Empty){
			this.moveTo(down);
			return 3;
		}
		else if (grid.get(down) instanceof Boulder){
			if (grid.get(right) instanceof Empty){
				this.moveTo(right);
				return 4;
			}
			else if (grid.get(left) instanceof Empty){
				this.moveTo (left);
				return 4;
			}
			
		
	
	}
		return 0;
	}
}


