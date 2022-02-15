import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Soundhandler {

	// - A method using a filepath for soundeffects and playing them.
	void filePath(String musicLocation) {

		try {

			File musicPath = new File(musicLocation);

			if (musicPath.exists()) {

				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();

			} else {

				System.out.println("Can't find the specified file!");
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

}
