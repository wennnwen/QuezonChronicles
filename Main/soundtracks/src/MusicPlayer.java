public class MusicPlayer {

    public static void playMusicAsync(String filePath) {
        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream(filePath);
                Player player = new Player(fis);
                player.play();
            } catch (Exception e) {
                System.out.println("Error playing music: " + e.getMessage());
            }
        }).start();
    }
}

