import java.awt.Frame;
import java.awt.Graphics;

public class GameFrame extends Frame{
	@Override
	public void paint(Graphics g) {
		g.draw3DRect(100, 100, 200, 100, getFocusTraversalKeysEnabled());
		super.paint(g);
	}
}
