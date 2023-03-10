package tic_tac_toe;

import java.util.logging.Logger;

public class TicTacToeBoard {

  static Logger logger = Logger.getLogger("TicTacToeBoard");

  public static String evaluateBoard(String boardstate) {
    String patterns = boardstate.toLowerCase();

    if (boardstate.length() != 9) {
      return "InvalidInput";
    }

    int countx = 0;
    int counto = 0;

    for (int i = 0; i < patterns.length(); i++) {
      if (patterns.charAt(i) == 'x') {
        countx++;
      }
      if (patterns.charAt(i) == 'o') {
        counto++;
      }
    }
    if (Math.abs(counto - countx) >= 2) {
      return "UnreachableState";
    }
    Boolean xwins = win('x', patterns);
    Boolean owins = win('o', patterns);
    if ((xwins) && (owins)) {
      return "UnreachableState";
    } else if (xwins) {
      return "Xwins";
    } else if (owins) {
      return "Owins";
    } else {
      return "NoWinner";
    }
  }

  public static boolean win(char checker, String patterns) {
    int i = 0;
    while (i < 7) {
      if (patterns.charAt(i) == checker && patterns.charAt(i + 1) == checker && patterns.charAt(i + 2) == checker) {
        return true;
      }
      i += 3;
    }
    int j = 0;
    while (j < 3) {
      if (patterns.charAt(j) == checker && patterns.charAt(j + 3) == checker && patterns.charAt(j + 6) == checker) {
        return true;
      }
      j++;
    }
    if (patterns.charAt(0) == checker && patterns.charAt(4) == checker && patterns.charAt(8) == checker) {
      return true;
    }
    return (patterns.charAt(2) == checker && patterns.charAt(4) == checker && patterns.charAt(6) == checker);
  }

  public static void main(String[] args) {
    Logger logger = Logger.getLogger("TicTacToeBoard");
    logger.info("{}", evaluateBoard("O...X.X.."));
    logger.info(evaluateBoard("XXX...oo."));
    logger.info(evaluateBoard("...Xxx.oo"));
    logger.info(evaluateBoard("oo....xxx"));
    logger.info(evaluateBoard("x..x..xoo"));
    logger.info(evaluateBoard(".x..xoox."));
    logger.info(evaluateBoard("..xoox..x"));
    logger.info(evaluateBoard("x...x.oox"));
    logger.info(evaluateBoard("..x.x.xoo"));
    logger.info(evaluateBoard("ooo..xx.."));
    logger.info(evaluateBoard("O...X.X...."));
    logger.info(evaluateBoard("Oooxxx..."));
    logger.info(evaluateBoard("oxooxooxo"));
  }
}
