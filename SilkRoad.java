import java.io.*;
import java.util.*;

public class SilkRoad {

  //disclaimer, I tried to highlight goods not talked about in my paragraphs

  public static void main(String[] args) {
    //   String xd = "       X        ";
    //Mahayanna buddhism
     String[][] options = {
      { " Printing/Paper ", "    Buddhism    ", "  Roman Empire  ", "    Chang’an    ", "Temperate Forest",},
      { "      Silk      ", "    Disease     ", "   Han Dynasty  ", "    Samarkand   ", "     Desert     ",},
      { "     Compass    ", "      Spices    ", "  Kushan Empire ", "    Damascus    ", "     Steppe     ",},
      { "      Glass     ", "   Gold/Silver  ", "Byzantine Empire", " Constantinople ", "wwwwwwwwwwwwwwww",},
      { "   Porcelain    ", " Precious stones", "  Mongol Empire ", "      Merv      ", "wwwwwwwwwwwwwwww",},
    };

    printGreeting();


    String[][] funFacts = {
      {
        "The printing press appeared in Europe 150 years after moveable printing was invented in China by Wang Chen",
        "The Laba Festival, on the 8th day of the 12th month of the Luna Year, celebrates the day the Buddha became enlightened. It is common to eat congee on this day.  ",
        "A lot of silk road items had to travel by the Mediterannean for at least part of the route to make it to Rome, which, of course, they called Mare Nostrum or our sea. ",
        " The easternmost city on the Silk Road!",
        "Think Greenwich CT climate: not tropical, but not the taiga either. Encompasses Eastern China and almost all of Europe.",
      },
      {
        "Rome tried and failed numerous times to ban silk, as it was both draining their economy and thought to be too revealing. ",
        "The Black Death started in China and would eventually make its way to Europe and kill 1/3 of the population.",
        "This is the dynasty during which China was able to connect with the Middle East and the Meditteranean!",
        "Located in an oasis, was a strategic trading point on the Silk Road located in modern-day Uzbekistan.",
        "Deserts are obviously dry, but oasis and monasteries became rest stops, learning centers, and eventually major cities.",
      },
      {
        "The compass was a key factor in helping Europeans navigate sea routes to Asia, bypassing land routes.",
        "Rome, India, China, and many more civilizations all had astronomers. The Silk Road brought many of these separate ideas together. Octavian Caesar may have used a comet to verify that Julius Caesar had become a deity after death!",
        "Secured Northern India and made it possible for goods to safely get to China. As it was on the Silk Road, diverse cultures and beliefs flourished in this empire.",
        "The location of Damascus near the Mediterannean made it a major stop for goods to and from Rome. ",
        "Your favorite controversial conquerors were originally from the steppe. Pastoralism, not agriculture, reigned supreme. ",
      },
      {
        "The Chinese started experimenting with making glass after they received it from the Mediterranean world. ",
        " Gold and silver coils were widely used as currency. According to the Book of the Later Han by Fan Ye, 10 silver coins were equivalent to one cold coin.",
        "Successor to the Roman Empire or it's own entity? Regardless, Rome would kill for what the Byzantine Empire had: the secret of silk...",
        "Capital of the Byzantine Empire! Great location on the western edge of the Silk Road, and taxing all the trade meant $$$",
        "wwwwwwwwwwwwwwww",
      },
      {
        "Porcelain was used in some of the first gunpowder warfare weapons, specifically the thunderclap bomb. ",
        "Came from all over the Silk Road, but especially India and Central Asia. ",
        "Largest continuous empire in history! They assimilated into some of the cultures they conquered all while keeping the Silk Road intact. A lot of good and a lot of bad, but I'm not writing an essay on it right now, sorry.",
        " A lost city on the Silk Road, not much remains of it. However, its significance as a major stop of the Silk Road at an oasis cannot be understated",
        "wwwwwwwwwwwwwwww",
      },
    };

    String[] categories = {
      "Technology",
      "Not Tech, but spread",
      "Empires",
      "Cities",
      "Environment",
    };

    runGame(options, categories, funFacts);
    //printBoard(options, categories);
    //   //String[] test = { "tt", "t", "t", "t", "t" };

    //   System.out.println(checkWin(options));

    //System.out.println((int)((6)*Math.random()));

    //int randNum = (int)((6)*Math.random());
  }

  public static void printBoard(String[][] arr, String[] categories) {
    for (int i = 0; i < categories.length; i++) {
      System.out.print(categories[i] + "         ");
    }

    System.out.println();
    //System.out.println();

    for (int i = 0; i < arr.length; i++) {
      String curRow = "";

      for (int j = 0; j < arr[i].length; j++) {
        if (i == 0) {}

        if (j == 0) {
          curRow = curRow + "| " + arr[i][j];
        } else if (j == arr[i].length - 1) {
          curRow = curRow + " | " + arr[i][j] + " |";
        } else {
          curRow = curRow + " | " + arr[i][j];
        }
      }

      System.out.println(
        "________________________________________________________________________________________________"
      );

      System.out.println(
        "|                  |                  |                  |                  |                  |"
      );
      System.out.println(
        "|                  |                  |                  |                  |                  |"
      );
      System.out.println(curRow);
      System.out.println(
        "|                  |                  |                  |                  |                  |"
      );
      System.out.println(
        "|                  |                  |                  |                  |                  |"
      );
    }
  }

  //shuffle board?

  //check rows, check columns, check diagonals?
  public static boolean checkWin(String[][] arr) {
    //one array, just keep reinitializing it

    String[] hor = new String[arr.length];
    String[] ver = new String[arr.length];
    String[] dia = new String[arr.length];

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        hor[j] = arr[i][j];
        ver[j] = arr[j][i];

        if (i == 0) {
          dia[j] = arr[i + j][arr.length - 1 - j];
        } else if (i == 2) {
          dia[j] = arr[j][j];
        }
      }

      if (allSame(dia) || allSame(ver) || allSame(hor)) {
        return true;
      }
    }

    return false;
  }

  public static boolean allSame(String[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (!arr[i].equals(arr[i - 1])) {
        return false;
      }
    }

    return true;
  }

  public static int[] generateRandom(String[][] options, String taken) {
    int i1;
    int i2;

    int[] arr = new int[2];

    do {
      i1 = (int) (5 * Math.random());
      i2 = (int) (5 * Math.random());
    } while (options[i1][i2].equals(taken));

    arr[0] = i1;
    arr[1] = i2;
    return arr;
  }

  public static void crossOut(String[][] options, int[] arr, String xd) {
    options[arr[0]][arr[1]] = xd;
    
  }


  public static void printGreeting(){

    System.out.println("Disclamer: if you don't like a little sass, please do not play this game. You have been warned.");

    System.out.println("Welcome to Silk Road bingo! While a new Silk Road has been made that is a black market cryptocurrency site,  this bingo is on the ancient Silk Road. This bingo is not going to go super in-depth into all of the topics. If you wanted that, you should read my paragraphs instead. This bingo game works like all other bingo games do: by luck.  Smooth sailing...or smooth caravan-ing, I guess? Perhaps both.");

}

public static void runGame(String[][] options, String[] categories, String[][] funFacts){

String xd = "       X        ";
String[][] o = options;
String[] c = categories;
String[][] f = funFacts;
int[] arr = new int[2];

printGreeting();

printBoard(o, c);

  Scanner key = new Scanner (System.in);


  System.out.println("Are you ready?  (Y/N)");
  String enter = key.next();

  System.out.print("Ready or not, here we go! ");

  while (checkWin(options) == false){
  
  Scanner sc = new Scanner (System.in);
  System.out.println("Type in anything if you are ready for the next option: ");
  String enter2 = sc.next();

  arr = generateRandom(options, xd);
  System.out.println("\n" + o[arr[0]][arr[1]]);

  crossOut(o, arr, xd);

  System.out.println("\n" + f[arr[0]][arr[1]]);

  printBoard(o, c);

}

System.out.println("Game over!");


}


}


