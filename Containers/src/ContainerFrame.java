import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContainerFrame extends JFrame{

	private JPanel mainPanel = new JPanel();
	private JPanel commonInfoPanel = new JPanel();
	private JPanel specialInfoPanel = new JPanel();
	private JTextField codeTextField = new JTextField("Code");
	private JTextField destinationTextField = new JTextField("Destination");
	private JTextField weightTextField= new JTextField("Weight");
	private JTextField powerTextField = new JTextField("Power");

	private JButton bulkButton = new JButton("Create Bulk");;
	private JButton refridgeratorButton = new JButton("Create Refridg");
	private JButton doneButton = new JButton("Done");

	private Ship selectedShip;

	public ContainerFrame(Ship aShip){

		selectedShip = aShip;

		commonInfoPanel.add(codeTextField);
		commonInfoPanel.add(destinationTextField);

		specialInfoPanel.setLayout(new GridLayout(2,2));
		specialInfoPanel.add(weightTextField);
		specialInfoPanel.add(powerTextField);
		specialInfoPanel.add(bulkButton);
		specialInfoPanel.add(refridgeratorButton);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(commonInfoPanel, BorderLayout.NORTH);
		mainPanel.add(specialInfoPanel, BorderLayout.CENTER);
		mainPanel.add(doneButton, BorderLayout.SOUTH);

		this.setContentPane(mainPanel);
		
		BulkButtonListener bulkListener = new BulkButtonListener();
		RefridgeratorButtonListener refridgeratorListener = new RefridgeratorButtonListener();
		
		bulkButton.addActionListener(bulkListener);
		refridgeratorButton.addActionListener(refridgeratorListener);
		
		this.setVisible(true);
		this.setSize(250,150);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Create Containers for selected ship");
	}
	
	public void disappear() {
		this.setVisible(false);
	}

	class BulkButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
			String code = codeTextField.getText();
			String destination = destinationTextField.getText();
			String weightText = weightTextField.getText();
			int weight = Integer.parseInt(weightText);

			Bulk newContainer = new Bulk(code, destination, weight);
			selectedShip.addContainer(newContainer);
		}
	}

	class RefridgeratorButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
			String code = codeTextField.getText();
			String destination = destinationTextField.getText();
			String powerText = powerTextField.getText();
			double power = Double.parseDouble(powerText);

			Refridgerator newContainer = new Refridgerator(code, destination, power);
			selectedShip.addContainer(newContainer);
			disappear();
		}
	}
	
	
}
