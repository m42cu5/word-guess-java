import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    String word = new RandomWord().getWord();
    String clue = "";
    for (int i = 0; i < word.length(); i++) {
      clue = clue + "_";
    }
    ;
    char clueArray[] = clue.toCharArray();
    Scanner myScanner = new Scanner(System.in);
    String guess;
    byte nbrOfGuesses = 0;
    int index;
    do {
      nbrOfGuesses++;
      System.out.print("Guess (#" + nbrOfGuesses + ") the word \"" + clue + "\": ");
      guess = myScanner.next().toLowerCase();
      if (!guess.equals(word)) {
        if (guess.length() == 1) {
          index = 0;
          do {
            index = word.indexOf(guess, index);
            if (index != -1) {
              clueArray[index] = guess.charAt(0);
              index++;
            }
          } while (index != -1);
        }
        clue = String.valueOf(clueArray);
        guess = clue;
      }
    } while (!guess.equals(word));
    myScanner.close();
    System.out
        .println("Correct! The word was \"" + word + "\". You guessed the word in " + nbrOfGuesses + " guess(es).");
  }
}

class RandomWord {
  String words[] = { "apple", "banana", "orange" };
  double random = Math.random() * (words.length);
  String word = words[(int) random];

  public String getWord() {
    return word;
  }
}
