import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MouseMover {
    public static void main(String[] args) {
        MouseMover mover = new MouseMover();
        mover.moveMouse(400, 500, 700, 700, 10000, 100, true, 290);
    }

    public void moveMouse(int x1, int y1, int x2, int y2, int t, int n, boolean repeat, int waitSec) {
        try {
            Robot r = new Robot();
            double dx = (x2 - x1) / ((double) n);
            double dy = (y2 - y1) / ((double) n);
            double dt = t / ((double) n);
            do {
                for (int step = 1; step <= n; step++) {
                    Thread.sleep((int) dt);
                    r.mouseMove((int) (x1 + dx * step), (int) (y1 + dy * step));
                }
                TimeUnit.SECONDS.sleep(waitSec);
            } while (repeat);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
