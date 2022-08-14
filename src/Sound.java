import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sound {
    Scanner scanner;
    Clip clip;

    Sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        scanner = new Scanner(System.in);
        File file = new File("drivingSound.wav");
        AudioInputStream stream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(stream);

    }

    public void play(){
        clip.start();
        String str = scanner.next();
    }
    public void quite(){
        clip.close();
        String str = scanner.next();
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        new Sound();
    }
}
