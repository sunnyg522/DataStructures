import javax.swing.*;
import java.awt.*;

public class AddressBookApp extends JFrame	{

	RecordPanel rPanel;
	ActionPanel aPanel;
	NavigationPanel nPanel;
	AddressBook ab;

	AddressBookApp()	{
	
		super("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 500);
		
		ab = new AddressBook();		
		/*ab.addRecord("name1", "Addr1", "Phone1");
		ab.addRecord("name2", "Addr2", "Phone2");
		ab.addRecord("name3", "Addr3", "Phone3");
		ab.addRecord("name4", "Addr4", "Phone4");		*/
		
		prepareUI();
	}
	
	public void prepareUI()	{

		rPanel = new RecordPanel( ab);
		aPanel = new ActionPanel(rPanel, ab);
		nPanel = new NavigationPanel(rPanel, ab);
		
		Container pane = this.getContentPane();
		
		GroupLayout layout = new GroupLayout(pane);
		pane.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true) ;

		layout.setHorizontalGroup(
			layout.createSequentialGroup().addGroup( 
					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(rPanel)
						.addComponent(nPanel)
						.addComponent(aPanel)));
						
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(rPanel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(nPanel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(aPanel)));

				this.pack();
		this.setVisible(true);

	}
	
	public static void main(String args[])	{
	
		AddressBookApp book = new AddressBookApp();
		
		
	
	}
}