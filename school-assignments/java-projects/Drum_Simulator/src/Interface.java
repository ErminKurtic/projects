
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface extends JFrame implements KeyListener {

	Soundhandler sounds = new Soundhandler();
	JLabel label;
	ImageIcon icon;
	JFrame frame;

	// - Interface draws out the frame and general layout for the acpplicationwindow.
	Interface() {

		this.setSize(1280, 720);
		this.setLayout(null);
		this.setTitle("Drum Simulator 2000");
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel();
		label.setBounds(0, 0, 1280, 720);

		icon = new ImageIcon("drumkit.jpg");
		label.setIcon(icon);

		this.add(label);
		this.setVisible(true);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// - Method for assigning different sounds to each keypress.
	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {

		case KeyEvent.VK_I:
			sounds.filePath("hihat.wav");
			break;
		case KeyEvent.VK_D:
			sounds.filePath("snare.wav");
			break;
		case KeyEvent.VK_S:
			sounds.filePath("bass_kick.wav");
			break;
		case KeyEvent.VK_P:
			sounds.filePath("ride.wav");
			break;
		case KeyEvent.VK_O:
			sounds.filePath("open_hihat.wav");
			break;
		case KeyEvent.VK_U:
			sounds.filePath("crash.wav");
			break;
		case KeyEvent.VK_E:
			sounds.filePath("tomtom1.wav");
			break;
		case KeyEvent.VK_R:
			sounds.filePath("tomtom2.wav");
			break;
		case KeyEvent.VK_T:
			sounds.filePath("wow.wav");
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
