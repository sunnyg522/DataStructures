import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionPanel extends JPanel implements ActionListener		{

	JButton btnAdd;
	JButton btnDelete;
	JButton btnSearch;
	AddressBook ab;
	RecordPanel rPanel;
	
	ActionPanel(RecordPanel rPanel, AddressBook ab)	{
		this.ab = ab;
		this.rPanel = rPanel;
		prepareUI();
	}
	
	private void prepareUI()	{
		
		btnAdd = new JButton("Add");
		btnDelete = new JButton("Delete");
		btnSearch = new JButton("Search");
		
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true) ;
		
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
						.addComponent(btnAdd)
						.addComponent(btnDelete)
						.addComponent(btnSearch));

						
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(btnAdd)
					.addComponent(btnDelete)
					.addComponent(btnSearch)));

	}
	
	public void actionPerformed(ActionEvent e) {
	
		String command = e.getActionCommand();
		String name;
		Record r = null;
		
		switch(command)
		{
			case "Add" : 	name = JOptionPane.showInputDialog(this, "Please enter the name");
							String addr = JOptionPane.showInputDialog(this, "Please enter the address");
							String ph = JOptionPane.showInputDialog(this, "Please enter the Phone Number");
							
							r = ab.addRecord(name, addr, ph);
							rPanel.setRecord(r);
							
							break;
			case "Delete" : 	
							name = JOptionPane.showInputDialog(this, "Please enter the name which you want to delete");
							ab.remove(name);
							r = ab.getCurRecord();
							rPanel.setRecord(r);
							break;
			case "Search" : 	
							name = JOptionPane.showInputDialog(this, "Please enter the name which you are looking for");
							r = ab.get(name);
							rPanel.setRecord(r);
							break;
		}

		
	}

}