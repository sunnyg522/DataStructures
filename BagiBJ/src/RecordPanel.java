import javax.swing.*;
import java.awt.*;

public class RecordPanel extends JPanel	{

	JTextField txtName;
	JTextField txtAddress;
	JTextField txtPhone;
	AddressBook ab;

	RecordPanel(AddressBook ab)	{
		this.ab = ab;
		prepareUI();	

		setRecord(ab.first());
	}
	
	public void prepareUI()	{
	
		//Container pane = this.getContentPane();
	
		JLabel lblName = new JLabel("Name");
		txtName = new JTextField(20);
		
		JLabel lblAddress = new JLabel("Address");
		txtAddress = new JTextField(20);
		
		JLabel lblPhone = new JLabel("Phone Number");
		txtPhone = new JTextField(20);
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true) ;

		layout.setHorizontalGroup(
			layout.createSequentialGroup().addGroup( 
					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblAddress)
						.addComponent(lblPhone))
				.addGroup(
					layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(txtName)
						.addComponent(txtAddress)
						.addComponent(txtPhone)));
						
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblName)
					.addComponent(txtName))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblAddress)
					.addComponent(txtAddress))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(lblPhone)
					.addComponent(txtPhone)));
	}
	
	public void setRecord(Record r)	{
	
		String name = (r!=null) ? r.getName() : "";
		String addr = (r!=null) ? r.getAddress() : "";
		String phoneNum = (r!=null) ? r.getPhoneNumber() : "";

			txtName.setText(name);
			txtAddress.setText(addr);
			txtPhone.setText(phoneNum);
	}
	
	public Record getRecord()	{
		return new Record( txtName.getText(),
							txtAddress.getText(),
							txtPhone.getText());
	}
}