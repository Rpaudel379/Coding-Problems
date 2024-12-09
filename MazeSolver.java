import java.util.Stack;

class Point {
    int x, y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MazeSolver {

    public static void main(String[] args) {
        String[] maze = {
                "xxxxxxxxxx x",
                "x        x x",
                "x        x x",
                "x xxxxxxxx x",
                "x          x",
                "x xxxxxxxxxx", };

        Point start = new Point(10, 0);
        Point end = new Point(1, 5);

        mazeSolver(maze, 'x', start, end);

    }

    private static void mazeSolver(String[] maze, char wall, Point start, Point end) {

        Stack<Point> path = new Stack<Point>();
        boolean[][] seen = new boolean[maze[0].length()][maze[0].length()];

        for (int i = 0; i < maze[0].length(); i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                seen[i][j] = false;
            }
        }

        walk(maze, wall, start, end, path, seen);

        if(path.empty()){
            System.out.println("no path");
        }

        for (Point point : path) {
            System.out.print("{" + point.x + " " + point.y + "} ");
        }

    }

    static int[][] dir = {
            { 1, 0 },
            { -1, 0 },
            { 0, -1 },
            { 0, 1 },
    };

    private static boolean walk(String[] maze, char wall, Point current, Point end,
            Stack<Point> path,
            boolean[][] seen) {

        // base case

        // 1. off the wall
        if (current.x < 0 || current.y < 0 || current.x >= maze[0].length() || current.y >= maze.length) {
            return false;
        }

        // 2. hit the wall
        if (maze[current.y].charAt(current.x) == wall) {
            return false;
        }

        // 3. seen already
        if (seen[current.y][current.x] == true) {
            return false;
        }

        // 4. at the end
        if (current.x == end.x && current.y == end.y) {
            path.push(current);
            return true;
        }

        // pre
        seen[current.y][current.x] = true;
        path.push(current);

        // recurse
        for (int i = 0; i < dir.length; i++) {
            int x = dir[i][0];
            int y = dir[i][1];

            Point cur = new Point();
            cur.x = current.x + x;
            cur.y = current.y + y;

            if (walk(maze, wall, cur, end, path, seen)) {
                return true;
            }
        }

        // post
        path.pop();
        return false;

    }

}
