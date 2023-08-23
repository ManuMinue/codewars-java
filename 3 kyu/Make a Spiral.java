import java.util.*;

public class Spiralizor {

  public static int[][] spiralize(int size) {
    if (size < 5) {
      return null;
    }

    return spiralize(new int[size][size]);
  }

  private static int[][] spiralize(int[][] arr) {
    var fill = fill(arr);

    final var height = fill.length;
    final var width = fill[0].length;
    var lastY = height / 2;
    var lastX = width % 2 == 0 ? width / 2 - 1 : width / 2;

    // Extra variants
    if (height == 5) {
      lastX = 1;
      lastY = 3;
    } else if ((height - 5) % 4 == 0) {
      lastX--;
      lastY++;
    }

    var y = 1;
    var x = 0;
    var dirX = 1;
    var dirY = 0;
    var leftBorder = 0;
    var rightBorder = width - 1;
    var upperBorder = 0;
    var lowerBorder = height - 1;

    while (true) {
      if (x == rightBorder && y == upperBorder + 1) {
        x--;
        y++;
        dirX = 0;
        dirY = 1;
        upperBorder += 2;
      } else if (x == leftBorder && y == lowerBorder - 1) {
        x++;
        y--;
        dirX = 0;
        dirY = -1;
        lowerBorder -= 2;
      } else if (y == lowerBorder && x == rightBorder - 1) {
        y--;
        x--;
        dirX = -1;
        dirY = 0;
        rightBorder -= 2;
      } else if (y == upperBorder && x == leftBorder + 1) {
        y++;
        x++;
        dirX = 1;
        dirY = 0;
        leftBorder += 2;
      }
      fill[y][x] = 0;

      if (y == lastY && x == lastX) {
        break;
      }

      x += dirX;
      y += dirY;
    }

    return fill;
  }

  private static int[][] fill(int[][] arr) {
    for (var row : arr) {
      Arrays.fill(row, 1);
    }
    return arr;
  }
}
