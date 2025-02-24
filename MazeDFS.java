/**
 Time Complexity = O(4*mn) for each direction
 Space complexity = O(mn)
 */
class Solution {
    int[][] dirs;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        return dfs(maze, destination, start[0], start[1]);
    }

    private boolean dfs(int[][] maze, int[] destination, int x, int y) {
        // base case
        if (destination[0] == x && destination[1] == y) {
            return true;
        }
        // already visited
        if (maze[x][y] == 2) {
            return false;
        }
        maze[x][y] = 2;
        for (int[] dir : dirs) {
            int nr = x;
            int nc = y;
            while (nr >=0 && nc >=0 && nr <m && nc <n && maze[nr][nc] != 1) {
                nr += dir[0];
                nc += dir[1];
            }
            nr -= dir[0];
            nc -= dir[1];
            if (dfs(maze, destination, nr, nc)) {
                return true;
            }
        }
        return false;
    }
}