package model;
/**
 * A parent clas for all consumable/usable items like health recovery potions
 * @author Ricardo Chuy
 *
 */
public abstract class Items {
	
	protected String Name;
	protected String Description;
	protected int Type;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public void AppplyPotionEffect(MainCharacter Hero) {
		
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	
	

}
