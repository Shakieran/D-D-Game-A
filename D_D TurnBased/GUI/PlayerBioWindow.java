import javax.swing.*;
import java.awt.*;

public class PlayerBioWindow extends JFrame
{
	private Container parent;
	private JPanel top;
	private JPanel bot;
	private JPanel botB;

	private GridBagLayout layouta;

	private GridBagConstraints constraints;

	public PlayerBioWindow()
	{
		super("Create Your Character");

		parent = getContentPane();

		//6 races
		JRadioButton[] races =
		{
			new JRadioButton("Human", true),
			new JRadioButton("Elf", false),
			new JRadioButton("Dwarf", false),
			new JRadioButton("Halfling", false),
			new JRadioButton("Changeling", false),
			new JRadioButton("Orc", false)
		};
		//8 classes
		JRadioButton[] classes =
		{
			new JRadioButton("Barbarian", true),
			new JRadioButton("Druid", false),
			new JRadioButton("Fighter", false),
			new JRadioButton("Monk", false),
			new JRadioButton("Ranger", false),
			new JRadioButton("Rogue", false),
			new JRadioButton("Sorcerer", false),
			new JRadioButton("Wizard", false)
		};

		ButtonGroup raceOps = new ButtonGroup();
		ButtonGroup classOps = new ButtonGroup();

		for(int x = 0; x < races.length; x++)
			raceOps.add(races[x]);

		for(int x = 0; x < classes.length; x++)
			classOps.add(classes[x]);

		top = new JPanel();
		layouta = new GridBagLayout();
		top.setLayout(layouta);

		bot = new JPanel();
		bot.setLayout(new BorderLayout(5,5));

		botB = new JPanel();
		botB.setLayout(new BorderLayout(1,1));

		constraints = new GridBagConstraints();

		addComponent(races[0], 1, 5, 1, 1);
		addComponent(races[1], 1, 6, 1, 1);
		addComponent(races[2], 2, 5, 1, 1);
		addComponent(races[3], 2, 6, 1, 1);
		addComponent(races[4], 3, 5, 1, 1);
		addComponent(races[5], 3, 6, 1, 1);

		addComponent(classes[0], 1, 1, 1, 1);
		addComponent(classes[1], 1, 2, 1, 1);
		addComponent(classes[2], 2, 1, 1, 1);
		addComponent(classes[3], 2, 2, 1, 1);
		addComponent(classes[4], 3, 1, 1, 1);
		addComponent(classes[5], 3, 2, 1, 1);
		addComponent(classes[6], 4, 1, 1, 1);
		addComponent(classes[7], 4, 2, 1, 1);

		addComponent(new JLabel("F. Name: "), 0, 0, 1, 1);
		addComponent(new JTextField(15), 0, 1, 2, 1);

		addComponent(new JLabel("             "), 0, 3, 1, 1);

		addComponent(new JLabel("L. Name: "), 0, 4, 1, 1);
		addComponent(new JTextField(15), 0, 5, 2, 1);

		addComponent(new JLabel("Class: "), 1, 0, 1, 1);
		addComponent(new JLabel("Race: "), 1, 4, 1, 1);

		JButton done = new JButton("Done");
		JButton random = new JButton("Random");
		JTextArea bio = new JTextArea(10,10);//change size as needed
		JLabel bLabl= new JLabel("Bio: ");

		botB.add(random, BorderLayout.WEST);
		botB.add(done, BorderLayout.EAST);

		bot.add(new JScrollPane(bio), BorderLayout.CENTER);
		bot.add(bLabl, BorderLayout.NORTH);
		bot.add(botB, BorderLayout.SOUTH);
//		bot.add(random, BorderLayout.SOUTH);
//		bot.add(done, BorderLayout.SOUTH);

//		parent.setLayout(new GridLayout(2, 1));
		parent.setLayout(new BorderLayout(5,5));

		parent.add(top, BorderLayout.NORTH);
		parent.add(bot, BorderLayout.SOUTH);

		setSize(509, 400);
		setVisible(true);
	}

	//true = top, false = bot
	private void addComponent(Component component, int row, int column, int width, int height)
	{
		constraints.gridx = column;
		constraints.gridy = row;

		constraints.gridwidth = width;
		constraints.gridheight = height;

		layouta.setConstraints(component, constraints);
		top.add(component);
	}

	public static void main(String[] args)
	{
		PlayerBioWindow test = new PlayerBioWindow();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}