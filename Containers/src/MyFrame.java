import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MyFrame extends JFrame {

	private Ship ship;
	private JPanel panel;
	private JButton buttonAdd;
	private JButton buttonCalc;
	private JList shipList;
	private JTextField textField;
	private ArrayList<Ship> ships;

	public MyFrame(ArrayList<Ship> ships) {

		this.ships = ships;

		panel = new JPanel();
		buttonAdd = new JButton("Add Container");
		buttonCalc = new JButton("Calculate Charge");
		shipList = new JList();
		textField = new JTextField(10);

		DefaultListModel listModel = new DefaultListModel();

		for(Ship s: ships) {
			String shipName = s.getName();
			listModel.addElement(shipName);
		}
		shipList.setModel(listModel);

		panel.add(buttonAdd);
		panel.add(buttonCalc);
		panel.add(shipList);
		panel.add(textField);
		this.setContentPane(panel);

		ButtonListener listener = new ButtonListener();
		buttonCalc.addActionListener(listener);
		
		NewContainerButtonListener containerListener = new NewContainerButtonListener();
		buttonAdd.addActionListener(containerListener);

		this.setVisible(true);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String selectedShipName = (String) shipList.getSelectedValue();

			for(Ship s: ships) {

				if(s.getName().equals(selectedShipName)) {
					double charge = s.getTotalCharge();
					textField.setText(Double.toString(charge));
				}   
			}
		}

	}

	class NewContainerButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			String selectedShipName = (String) shipList.getSelectedValue();
			Ship selectedShip = null;

			for(Ship s: ships) {

				if(s.getName().equals(selectedShipName)) {
					selectedShip = s;
				}   
			}
			new ContainerFrame(selectedShip);

		}


	}


}











