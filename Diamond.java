import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class Diamond extends Mover {

	public Diamond(){
		setColor (null);
	}
//@Override 
//		public int moveme() {
//			Location loc = this.getLocation();
//		
//			Grid<Actor> grid = getGrid();
//			Location down = loc.getAdjacentLocation(Location.SOUTH);
//			
//			if (grid.get(down) instanceof Dirt || grid.get(down)instanceof Wall ||grid.get(down) instanceof Square){
//				return 0;
//			}
//			else if (grid.get(down) instanceof Empty){
//				this.moveTo(down);
//				return 3;
//			}
//			return 0;
//		}
//	

	@Override
	public int moveme() {
		Location loc = this.getLocation();
		
		Grid<Actor>grid = getGrid();
		if (loc != null){
			
		
		Location down= loc.getAdjacentLocation(Location.SOUTH);
//		Location up = loc.getAdjacentLocation(Location.NORTH);
//		Location left = loc.getAdjacentLocation(Location.WEST);
//		Location right = loc.getAdjacentLocation(Location.EAST);
		if (grid.get(down) instanceof Dirt || grid.get(down)instanceof Wall || grid.get(down) instanceof Square){
			return 0;
		}
		else if (grid.get(down)instanceof Empty){
//			if (grid.get(up) ==null){
//				return 3;
//			}
			this.moveTo(down);
			return 3;
//			if (grid.get(up) ==null){
//				return 3;
//			}
//			else if (grid.get(down)instanceof Runner || grid.get(up) instanceof Runner|| 
//					grid.get(left)instanceof Runner || grid.get(right)instanceof Runner){
//				return 5;
//		}
		}
		}
	
		return 0;
	
	}
	}
	
