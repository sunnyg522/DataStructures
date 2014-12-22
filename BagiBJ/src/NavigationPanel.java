import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NavigationPanel extends JPanel implements ActionListener	{

	AddressBook ab;
	RecordPanel rPanel;
	
	JButton btnFirst;
	JButton btnPrev;
	JButton btnNext;
	JButton btnLast;

	NavigationPanel(RecordPanel rPanel, AddressBook ab)	{
		this.ab = ab;
		this.rPanel = rPanel;
		prepareUI();	
	}
	
	private void prepareUI()	{

		btnFirst = new JButton("First");
		btnPrev = new JButton("Previous");
		btnNext = new JButton("Next");
		btnLast = new JButton("Last");
		
		btnFirst.addActionListener(this);
		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);
		btnLast.addActionListener(this);
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true) ;
		
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
						.addComponent(btnFirst)
						.addComponent(btnPrev)
						.addComponent(btnNext)
						.addComponent(btnLast));

						
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(btnFirst)
					.addComponent(btnPrev)
					.addComponent(btnNext)
					.addComponent(btnLast)));
	}

	public void actionPerformed(ActionEvent e) {
	
		String command = e.getActionCommand();
		Record r = null;
		
		switch(command)
		{
			case "First" : r = ab.first();	break;
			case "Previous" : r = ab.previous();	break;
			case "Next" : r = ab.next();	break;
			case "Last" : r = ab.last();	break;
		}
		
		//JOptionPane.showMessageDialog(null, r.toString());
		
		rPanel.setRecord(r);
	}
}