package numberguessermain;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class UserInput extends JFrame implements ActionListener {

	int inputMod3;
	int inputMod5;
	int inputMod7;
	
	JFrame frame;
	JFrame outputFrame;
	JFrame errorFrame;
	
	JTextField txtModThree;
	JTextField txtModFive;
	JTextField txtModSeven;
	
	public UserInput() {
		
		super();		
		openInput();
		
	}
	
	public void openInput() {
		
		//create JFrame and JPanels to go inside the frame, using FlowLayout in
		//each panel and grid layout for the frame
		this.frame = new JFrame("Number Guesser");
		JPanel panelTitle = new JPanel();
		JPanel panelDescr = new JPanel();
		JPanel panelModThree = new JPanel();
		JPanel panelModFive = new JPanel();
		JPanel panelModSeven = new JPanel();
		JPanel panelExitSubmitBtns = new JPanel();
		panelTitle.setLayout(new FlowLayout());
		panelDescr.setLayout(new FlowLayout());
		panelModThree.setLayout(new FlowLayout());
		panelModFive.setLayout(new FlowLayout());
		panelModSeven.setLayout(new FlowLayout());
		panelExitSubmitBtns.setLayout(new FlowLayout());
		
		// UI Label code
		JLabel lblModThree = new JLabel();
		JLabel lblModFive = new JLabel();
		JLabel lblModSeven = new JLabel();
		JLabel lblInputDescr = new JLabel();
		JLabel lblSecondaryDescr = new JLabel();
		lblInputDescr.setText("Think of any number between '1' and '100'");
		lblSecondaryDescr.setText("This program will attempt to guess the number you're thinking of!");
		lblModThree.setText("Divide your number by 3. What is the remainder?");
		lblModFive.setText("Divide your number by 5. What is the remainder?");
		lblModSeven.setText("Divide your number by 7. What is the remainder?");
		
		Font labelFont = lblInputDescr.getFont();
		lblInputDescr.setFont(new Font(labelFont.getName(),Font.BOLD,16));
		labelFont = lblSecondaryDescr.getFont();
		lblSecondaryDescr.setFont(new Font(labelFont.getName(),Font.PLAIN,13));
		
		// UI User text field input code
		this.txtModThree = new JTextField(10);
		this.txtModFive = new JTextField(10);
		this.txtModSeven = new JTextField(10);
		
		// UI Exit and Submit buttons
		JButton btnExit = new JButton();
		JButton btnSubmit = new JButton();		
		btnExit.setText("Exit");
		btnExit.addActionListener(this);
		btnExit.setActionCommand("Exit");
		btnSubmit.setText("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setActionCommand("Submit");
		
		//add components to the appropriate panel
		panelTitle.add(lblInputDescr);
		panelDescr.add(lblSecondaryDescr);
		panelModThree.add(lblModThree);
		panelModThree.add(txtModThree);
		panelModFive.add(lblModFive);
		panelModFive.add(txtModFive);
		panelModSeven.add(lblModSeven);
		panelModSeven.add(txtModSeven);
		panelExitSubmitBtns.add(btnExit);
		panelExitSubmitBtns.add(btnSubmit);
		
		//add JPanel to the JFrame and give the frame its properties
		this.frame.setLayout(new GridLayout(6,1));
		this.frame.add(panelTitle);
		this.frame.add(panelDescr);
		this.frame.add(panelModThree);
		this.frame.add(panelModFive);
		this.frame.add(panelModSeven);
		this.frame.add(panelExitSubmitBtns);
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		
	}
	
	public void performCalculationsAndShowOutput() {
		
		this.frame.setVisible(false);
		
		Calculations c = new Calculations(
				Integer.parseInt(this.txtModThree.getText()),
				Integer.parseInt(this.txtModFive.getText()),
				Integer.parseInt(this.txtModSeven.getText())
				);
		
		this.outputFrame = new JFrame("Number Guesser");
		
		JPanel outputPanel = new JPanel(new FlowLayout());
		JPanel paddingPanel = new JPanel(new FlowLayout());
		JPanel paddingPanelTwo = new JPanel(new FlowLayout());
		JPanel messagePanel = new JPanel(new FlowLayout());
		JPanel messagePanelTwo = new JPanel(new FlowLayout());
		
		JLabel lblPreOutput = new JLabel();
		JLabel lblOutput = new JLabel();
		JLabel lblBorderTop = new JLabel();
		JLabel lblBorderBottom = new JLabel();
		JLabel lblOutputGeneralMessage = new JLabel();
		JLabel lblOutputGeneralMessageTwo = new JLabel();
		
		JButton tryAgainBtn = new JButton();
		
		lblPreOutput.setText("    The number you were thinking of was: ");
		lblOutput.setText(Integer.toString(c.getGuessedNumber()) + "    ");
		lblBorderTop.setText(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		lblBorderBottom.setText(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		lblOutputGeneralMessage.setText("If this isn't the number your were thinking of, then you didn't enter the correct remainder value for one");
		lblOutputGeneralMessageTwo.setText("or more of the inputs. Click to try again with the correct values! ==> ");
		
		tryAgainBtn.setText("Try Again");
		tryAgainBtn.addActionListener(this);
		tryAgainBtn.setActionCommand("Again");
		
		Font lblPreFont = lblPreOutput.getFont();
		Font lblOutFont = lblOutput.getFont();
		lblPreOutput.setFont(new Font(lblPreFont.getName(),Font.BOLD,18));
		lblOutput.setFont(new Font(lblOutFont.getName(),Font.BOLD,18));
		
		paddingPanel.add(lblBorderTop);
		outputPanel.add(lblPreOutput);
		outputPanel.add(lblOutput);
		paddingPanelTwo.add(lblBorderBottom);
		messagePanel.add(lblOutputGeneralMessage);
		messagePanelTwo.add(lblOutputGeneralMessageTwo);
		messagePanelTwo.add(tryAgainBtn);
		
		this.outputFrame.setLayout(new GridLayout(5,1));
		this.outputFrame.add(paddingPanel);
		this.outputFrame.add(outputPanel);
		this.outputFrame.add(paddingPanelTwo);
		this.outputFrame.add(messagePanel);
		this.outputFrame.add(messagePanelTwo);
		this.outputFrame.pack();
		this.outputFrame.setLocationRelativeTo(null);
		this.outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.outputFrame.setVisible(true);
		
	}
	
	public void showErrorMessage() {
		
		this.errorFrame = new JFrame("Error");
		JPanel errorPanelMessage = new JPanel(new FlowLayout());
		JPanel errorPanelTop = new JPanel(new FlowLayout());
		JPanel errorPanelMiddleOne = new JPanel(new FlowLayout());
		JPanel errorPanelMiddleTwo = new JPanel(new FlowLayout());
		JPanel errorPanelBottom = new JPanel(new FlowLayout());
		JPanel backPanel = new JPanel(new FlowLayout());
		
		JLabel lblErrorMessage = new JLabel();
		JLabel lblIntGreaterErrorMessage = new JLabel();
		JLabel lblIntLessErrorMessage = new JLabel();
		JLabel lblIntErrorMessage = new JLabel();
		JLabel lblEmptyErrorMessage = new JLabel();
		
		JButton backBtn = new JButton();
		
		lblErrorMessage.setText("One or more of the errors exist:");
		lblIntGreaterErrorMessage.setText("--Integer value entered greater than greatest possible integer");
		lblIntLessErrorMessage.setText("--Integer value entered less than 0");
		lblIntErrorMessage.setText("--Number entered was not an integer");
		lblEmptyErrorMessage.setText("--No value entered for one or more of the reaminder fields");
		
		Font errorMessageFont = lblErrorMessage.getFont();
		lblErrorMessage.setFont(new Font(errorMessageFont.getName(),Font.BOLD,16));
		
		backBtn.setText("Back");
		backBtn.addActionListener(this);
		backBtn.setActionCommand("Back");
		
		errorPanelMessage.add(lblErrorMessage);
		errorPanelTop.add(lblIntGreaterErrorMessage);
		errorPanelMiddleOne.add(lblIntLessErrorMessage);
		errorPanelMiddleTwo.add(lblIntErrorMessage);
		errorPanelBottom.add(lblEmptyErrorMessage);
		backPanel.add(backBtn);
		
		this.errorFrame.setLayout(new GridLayout(6,1));
		this.errorFrame.add(errorPanelMessage);
		this.errorFrame.add(errorPanelTop);
		this.errorFrame.add(errorPanelMiddleOne);
		this.errorFrame.add(errorPanelMiddleTwo);
		this.errorFrame.add(errorPanelBottom);
		this.errorFrame.add(backPanel);
		this.errorFrame.pack();
		this.errorFrame.setLocationRelativeTo(null);
		this.errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.errorFrame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String action = ae.getActionCommand();
		
		if(action.equals("Submit")) {
				
			try {
				
				if (Integer.parseInt(txtModThree.getText()) < 0
						|| Integer.parseInt(txtModFive.getText()) < 0
						|| Integer.parseInt(txtModSeven.getText()) < 0
						|| Integer.parseInt(txtModThree.getText()) > 2
						|| Integer.parseInt(txtModFive.getText()) > 4
						|| Integer.parseInt(txtModSeven.getText()) > 6) {
					
					this.frame.setVisible(false);
					showErrorMessage();
					
				} else {
					
					performCalculationsAndShowOutput();
					
				}
				
			} catch (NumberFormatException nfe) {
				
				this.frame.setVisible(false);
				showErrorMessage();
				
			}
			
		} else if(action.equals("Again")) {
			
			this.outputFrame.setVisible(false);
			openInput();
			
		} else if(action.equals("Back")) {
			
			this.errorFrame.setVisible(false);
			openInput();
			
		} else if(action.equals("Exit")) {
			
			System.exit(0);
			
		}
		
	}
	
	public int getInput3() { return this.inputMod3; }
	public int getInput5() { return this.inputMod5; }
	public int getInput7() { return this.inputMod7; }
	
}
