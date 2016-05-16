import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerAbilitiesWindow extends JFrame
{
	private Container parent;
	private GridBagLayout layout;
	private GridBagConstraints constraints;

	private int[] rolls = {9, 10, 11, 12, 13, 14};
	private JComboBox[] abilOps = new JComboBox[6];
	private String[] options = {"--", "9", "10", "11", "12", "13", "14"};//set as 10 once done debugging
//	private String[] lastOption = {"--", "--", "--", "--", "--", "--"};
	private String[] lastOption = new String[6];
	private final int[] dsf = {0, 1, 2, 3, 4, 5};

	public PlayerAbilitiesWindow()
	{
		super("Ability Scores");
		parent = getContentPane();
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		parent.setLayout(layout);

//		abilOps = new JComboBox[6];
		for(int x = 0; x < 6; x++)
		{
			abilOps[x] = new JComboBox(options);
		}

		abilOps[dsf[0]].addActionListener(new ActionListener()
		{
			final int cpp = dsf[0];
			public void actionPerformed(ActionEvent e)
			{
				setUp(cpp);
			}
		});

		abilOps[dsf[1]].addActionListener(new ActionListener()
		{
			final int cpp = dsf[1];
			public void actionPerformed(ActionEvent e)
			{
				setUp(cpp);
			}
		});

		abilOps[dsf[2]].addActionListener(new ActionListener()
		{
			final int cpp = dsf[2];
			public void actionPerformed(ActionEvent e)
			{
				setUp(cpp);
			}
		});
		abilOps[dsf[3]].addActionListener(new ActionListener()
		{
			final int cpp = dsf[3];
			public void actionPerformed(ActionEvent e)
			{
				setUp(cpp);
			}
		});

		abilOps[dsf[4]].addActionListener(new ActionListener()
		{
			final int cpp = dsf[4];
			public void actionPerformed(ActionEvent e)
			{
				setUp(cpp);
			}
		});

		abilOps[dsf[5]].addActionListener(new ActionListener()
		{
			final int cpp = dsf[5];
			public void actionPerformed(ActionEvent e)
			{
				setUp(cpp);
			}
		});

		String[] stfHold = {"Dex","Str","Con","Int","Wis","Cha"};//0-5 are scores
		String[] stfTwo = {"", "-", "", "=", "", "+"};

		for(int x = 0; x < 6; x++)
			addComponent(new JLabel(stfHold[x]), x, 0, 1, 1);

		for(int y = 1; y < 6; y+=2)//1, 3 and 5
			for(int x = 0; x<6; x++)
				addComponent(new JLabel(stfTwo[y]), x, y, 1, 1);

		for(int x = 0; x < 6; x++)
			addComponent(abilOps[x], x, 4, 1, 1);

		setSize(300, 300);
		setVisible(true);
	}

	private void addComponent(Component component, int row, int column, int width, int height)
	{
		constraints.gridx = column;
		constraints.gridy = row;

		constraints.gridwidth = width;
		constraints.gridheight = height;

		layout.setConstraints(component, constraints);
		parent.add(component);
	}
//@SuppressWarnings("unchecked")//Try to deal with this later-->ERROR IS LINE 131, casting as a String, ect.
	public void setUp(int index)//sent the index of the box that was changed
	{
		try
		{
			int vb = Integer.parseInt(lastOption[index]);
			for(int x = 0; x < 6; x++)
			{
				if(x!=index)
					abilOps[x].addItem(lastOption[index]);
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("null pointer");
		}

//		if(lastOption[index].compareTo("--")!=0)
/*		if(lastOption[index].charAt(0)!='-')
		{
			for(int x = 0; x < 6; x++)
			{
				if(x!=index)
					abilOps[x].addItem(lastOption[index]);
			}
		}*/

//		JComboBox holdier = abilOps[index];
		lastOption[index] = (String)abilOps[index].getSelectedItem();

		for(int x = 0; x < 6; x++)
		{
			
//			abilOps[x].removeItem(lastOption[index]);
		}
	}
	//below rolls ability scores as per standard rules, 4d6 drop the lowest, reroll if 13 is biggest roll OR mods <=0
	public void getRolls()
	{
		int max = -1;
		int mods = 0;
		int roll = 0;
		int min = 19;
		int hold = 0;

		while(max<13 || mods < 1)
		{
			for(int x = 0; x < 6; x++)
			{
				roll = 0;
				min = 7;
				for(int c = 4; c < 0; c++)
				{
					hold = (int)(Math.random()*6+1);
					if(min>hold)
						min = hold;
					roll += hold;
				}
				roll-=min;
				rolls[x] = roll;
				if(roll>max)
					max = roll;
				mods += (int)((roll-10)/2.0);
			}
		}
	}

	public static void main(String[] args)
	{
		PlayerAbilitiesWindow Shak = new PlayerAbilitiesWindow();
		Shak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}