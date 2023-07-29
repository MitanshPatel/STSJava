
import java.util.Arrays;

public class Warnsdorff {
    final int N = 8;
    int cx[] = { 1, 1, 2, 2, -1, -1, -2, -2 };
    int cy[] = { 2, -2, 1, -1, 2, -2, 1, -1 };

    Cell nextMove(int a[], Cell cell) {
        int min_deg_idx = -1, min_deg = N + 1, c;
        int start = (int) (Math.random() * 100) % N;
        for (int count = 0; count < N; ++count) {
            int i = (start + count) % N;
            int nx = cell.x + cx[i];
            int ny = cell.y + cy[i];
            if ((isempty(a, nx, ny)) && (c = getDegree(a, nx, ny)) < min_deg) {
                min_deg_idx = i;
                min_deg = c;
            }
        }
        if (min_deg_idx == -1)
            return null;
        int nx = cell.x + cx[min_deg_idx];
        int ny = cell.y + cy[min_deg_idx];
        a[ny * N + nx] = a[cell.y * N + cell.x] + 1;
        cell.x = nx;
        cell.y = ny;
        return cell;
    }

    void print(int a[]) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j)
                System.out.printf("%d\t", a[j * N + i]);
            System.out.printf("\n");
        }
    }

    boolean isempty(int a[], int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < N && a[y * N + x] < 0);
    }

    int getDegree(int a[], int x, int y) {
        int count = 0;
        for (int i = 0; i < N; ++i)
            if (isempty(a, x + cx[i], y + cy[i]))
                count++;
        return count;
    }

    boolean neighbour(int x, int y, int xx, int yy) {
        for (int i = 0; i < N; ++i)
            if (((x + cx[i]) == xx) && ((y + cy[i]) == yy))
                return true;
        return false;
    }

    boolean findClosedTour() {
        int a[] = new int[N * N];
        Arrays.fill(a, -1);
        int sx = 3;
        int sy = 2;
        Cell cell = new Cell(sx, sy);
        a[cell.y * N + cell.x] = 1; // Mark first move.
        Cell ret = null;
        for (int i = 0; i < N * N - 1; ++i) {
            ret = nextMove(a, cell);
            if (ret == null)
                return false;
        }
        if (!neighbour(ret.x, ret.y, sx, sy))
            return false;
        print(a);
        return true;
    }

    public static void main(String[] args) {
        while (!new Warnsdorff().findClosedTour()) {
            ;
        }
    }
}

class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
