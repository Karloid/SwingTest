/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 19.11.13
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
public class Unit {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(MyDirection direction) {
        if (direction == MyDirection.UP) {
            y--;
        } else if (direction == MyDirection.DOWN) {
            y++;
        } else if (direction == MyDirection.LEFT) {
            x--;
        } else if (direction == MyDirection.RIGHT) {
            x++;
        }

    }
}
