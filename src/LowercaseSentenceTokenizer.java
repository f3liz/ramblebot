import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A tokenizer that converts text input to lowercase and splits it 
 * into a list of tokens, where each token is either a word or a period.
 */
public class LowercaseSentenceTokenizer implements Tokenizer {
  /**
   * Tokenizes the text from the given Scanner. The method should 
   * convert the text to lowercase and split it into words and periods.
   * Words are separated by spaces, and periods are treated as separate tokens.
   * 
   * For example:
   * If the input text is: "Hello world. This is an example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "an", "example", "."]
   * 
   * Notice that the text is converted to lowercase, and each period is treated as a separate token.
   * 
   * However, a period should only be considered a separate token if it occurs at the end
   * of a word. For example:
   * 
   * If the input text is: "Hello world. This is Dr.Smith's example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "dr.smith's", "example", "."]
   * 
   * The internal period in Dr.Smith's is not treated as its own token because it does not occur at the end of the word.
   * 
   * @param scanner the Scanner to read the input text from
   * @return a list of tokens, where each token is a word or a period
   */
  public List<String> tokenize(Scanner scanner) {
    // TODO: Implement this function to convert the scanner's input to a list of words and periods

    // initialize list
    List<String> inputStrings = new ArrayList<>();

    // https://howtodoinjava.com/java/string/java-string-split-example/
    // learned patterns for useDelimiter method here and applied using trial and error to find the right combo
    // planned to use "useDelimiter", however I could not figure out the regex patterns for what I wanted, also learned it wouldn't be as effecient as what I have below
    // scanner.useDelimiter("[,\\s]+|(?<=\\.)\\s+|(?=\\.)\\w+");

    // loop to check if file has next line
    while (scanner.hasNextLine()){
      // store next word in string variable
      String word = scanner.next();
      // String endsWith method to check end of word if it has "."
      if (word.endsWith(".")) {
        // take only the word not the period and add that word and period as separate tokens
        String wordNoPeriod = word.substring(0, word.length()-1);
        // need to add to lowercase here, bug found in testing
        inputStrings.add(wordNoPeriod.toLowerCase());
        inputStrings.add(".");
      } else {
        // add into list if doesn't end in period
        inputStrings.add(word.toLowerCase());
      }
    }
    return inputStrings;
  }
}

