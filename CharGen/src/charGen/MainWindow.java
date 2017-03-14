package charGen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainWindow {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlCharacterGenerator = new Shell();
		shlCharacterGenerator.setSize(450, 187);
		shlCharacterGenerator.setText("Character Generator");
		
		Label lblSelectAGame = new Label(shlCharacterGenerator, SWT.NONE);
		lblSelectAGame.setFont(SWTResourceManager.getFont(".SF NS Text", 30, SWT.NORMAL));
		lblSelectAGame.setBounds(125, 10, 247, 47);
		lblSelectAGame.setText("Select a Game");
		
		Button btnElderScrollsOnline = new Button(shlCharacterGenerator, SWT.NONE);
		btnElderScrollsOnline.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ESOWindow subwindow = new ESOWindow();
				subwindow.open();
			}
		});
		btnElderScrollsOnline.setBounds(158, 79, 149, 28);
		btnElderScrollsOnline.setText("Elder Scrolls Online");
		
		Button btnStarTrekOnline = new Button(shlCharacterGenerator, SWT.NONE);
		btnStarTrekOnline.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				STOWindow subwindow = new STOWindow();
				subwindow.open();
			}
		});
		btnStarTrekOnline.setBounds(158, 113, 149, 28);
		btnStarTrekOnline.setText("Star Trek Online");

		shlCharacterGenerator.open();
		shlCharacterGenerator.layout();
		while (!shlCharacterGenerator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
