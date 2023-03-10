package tic_tac_toe;

public enum Evaluation {
  InvalidInput, NoWinner, /* valid board, but the game hasn't been won by either player yet */
  Xwins, /* valid board, and the game was won by player X */
  Owins, /* valid board, and the game was won by player O */
  UnreachableState /*string describes a board, but not a board state that is reachable from avalid game*/
}
