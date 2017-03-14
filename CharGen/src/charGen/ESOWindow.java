package charGen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ESOWindow {

	ESOGen generator = new ESOGen();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ESOWindow window = new ESOWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlElderScrollsOnline = new Shell();
		shlElderScrollsOnline.setSize(450, 300);
		shlElderScrollsOnline.setText("Elder Scrolls Online Character Generator");
		
		Button btnAllRacesAll = new Button(shlElderScrollsOnline, SWT.CHECK);
		btnAllRacesAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				generator.araf = btnAllRacesAll.getSelection();
			}
		});
		btnAllRacesAll.setBounds(10, 10, 202, 18);
		btnAllRacesAll.setText("All Races All Factions DLC");
		
		Button btnCheckButton = new Button(shlElderScrollsOnline, SWT.CHECK);
		btnCheckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				generator.imperial = btnAllRacesAll.getSelection();
			}
		});
		btnCheckButton.setBounds(249, 10, 191, 18);
		btnCheckButton.setText("Imperial Race DLC");
		
		Label lblFaction = new Label(shlElderScrollsOnline, SWT.NONE);
		lblFaction.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblFaction.setBounds(42, 70, 109, 37);
		lblFaction.setText("Faction:");
		
		Label lblRace = new Label(shlElderScrollsOnline, SWT.NONE);
		lblRace.setText("Race:");
		lblRace.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblRace.setBounds(42, 113, 109, 37);
		
		Label lblClass = new Label(shlElderScrollsOnline, SWT.NONE);
		lblClass.setText("Class:");
		lblClass.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblClass.setBounds(42, 160, 109, 37);
				
		Label lblFactionOutput = new Label(shlElderScrollsOnline, SWT.NONE);
		lblFactionOutput.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblFactionOutput.setBounds(157, 70, 279, 37);
		
		Label lblRaceOutput = new Label(shlElderScrollsOnline, SWT.NONE);
		lblRaceOutput.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblRaceOutput.setBounds(157, 113, 283, 37);
		
		Label lblClassOutput = new Label(shlElderScrollsOnline, SWT.NONE);
		lblClassOutput.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblClassOutput.setBounds(157, 160, 283, 37);

		Button btnGenerate = new Button(shlElderScrollsOnline, SWT.NONE);
		btnGenerate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				generator.randomCharacter();
				lblFactionOutput.setText(generator.character.faction);
				lblRaceOutput.setText(generator.character.race);
				lblClassOutput.setText(generator.character.charClass);
			}
		});
		btnGenerate.setBounds(176, 216, 94, 28);
		btnGenerate.setText("Generate!");

		shlElderScrollsOnline.open();
		shlElderScrollsOnline.layout();
		while (!shlElderScrollsOnline.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
