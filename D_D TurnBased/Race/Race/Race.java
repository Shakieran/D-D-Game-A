import java.math.*;
import java.util.*;
//All races are a race--> ect.
public abstract class Race
{//Dex, Str, Con, Int, Wis, Cha
	private String name;
	private int[] abilBonuses = {0, 0, 0, 0, 0, 0};//0=dex, 1=str, ect.

	public int[] getBonuses()
	{
		return abilBonuses;
	}
}