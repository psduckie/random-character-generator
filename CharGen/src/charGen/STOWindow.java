package charGen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class STOWindow {

	STOGen generator = new STOGen();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			STOWindow window = new STOWindow();
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
		Shell shlStarTrekOnline = new Shell();
		shlStarTrekOnline.setSize(600, 300);
		shlStarTrekOnline.setText("Star Trek Online Character Generator");
		
		Label lblFaction = new Label(shlStarTrekOnline, SWT.NONE);
		lblFaction.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblFaction.setBounds(42, 70, 109, 37);
		lblFaction.setText("Faction:");
		
		Label lblClass = new Label(shlStarTrekOnline, SWT.NONE);
		lblClass.setText("Class:");
		lblClass.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblClass.setBounds(42, 113, 109, 37);
		
		Label lblShip = new Label(shlStarTrekOnline, SWT.NONE);
		lblShip.setText("Ship:");
		lblShip.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblShip.setBounds(42, 160, 109, 37);
				
		Label lblFactionOutput = new Label(shlStarTrekOnline, SWT.NONE);
		lblFactionOutput.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblFactionOutput.setBounds(157, 70, 433, 37);
		
		Label lblClassOutput = new Label(shlStarTrekOnline, SWT.NONE);
		lblClassOutput.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblClassOutput.setBounds(157, 113, 433, 37);
		
		Label lblShipOutput = new Label(shlStarTrekOnline, SWT.NONE);
		lblShipOutput.setFont(SWTResourceManager.getFont(".SF NS Text", 24, SWT.NORMAL));
		lblShipOutput.setBounds(157, 160, 433, 37);

		Button btnGenerate = new Button(shlStarTrekOnline, SWT.NONE);
		btnGenerate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				generator.randomCharacter();
				lblFactionOutput.setText(generator.character.faction);
				lblClassOutput.setText(generator.character.charClass);
				lblShipOutput.setText(generator.character.shipClass);
			}
		});
		btnGenerate.setBounds(279, 217, 94, 28);
		btnGenerate.setText("Generate!");

		shlStarTrekOnline.open();
		shlStarTrekOnline.layout();
		while (!shlStarTrekOnline.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
