import java.util.Arrays;
import java.util.Scanner;

public class Alpa {
  private static final int MAX_TASKS = 100;
  private static Task[] tasks = new Task[MAX_TASKS];
  private static int taskCount = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String logo = 
              "     _    _             \n"
            + "    / \\  | |_ __   __ _ \n"
            + "   / _ \\ | | '_ \\ / _` |\n"
            + "  / ___ \\| | |_) | (_| |\n"
            + " /_/   \\_\\_| .__/ \\__,_|\n"
            + "           |_|          ";
    String[] art = {
            "⠀⠀⠀⠀⡾⣦⡀⠀⠀⡀⠀⣰⢷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⣠⠗⠛⠽⠛⠋⠉⢳⡃⢨⢧⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⣰⠋⠁⠀⠀⠀⠀⠀⠀⠙⠛⢾⡈⡏⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⣼⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠸⢦⡀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⢈⠟⠓⠶⠞⠒⢻⣿⡏⢳⡀⠀⠀⠀⠀⢸⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⡴⢉⠀⠀⠀⠀⠀⠈⠛⢁⣸⠇⠀⠀⠀⠀⢺⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⢧⣸⡁⠀⠀⣀⠀⠀⣠⠾⠀⠀⠀⠀⠀⠀⣹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠉⠓⢲⠾⣍⣀⣀⡿⠃⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⠀⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⢀⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⢸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⣸⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠺⠦⠤⠤⣤⣄⣀⣀⡀⠀⠀⠀⠀⠀",
            "⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠳⣦⣄⠀⠀",
            "⠀⠀⢀⡷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣆⠀",
            "⠀⠀⣼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣆",
            "⠀⠀⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿",
            "⠀⠀⢹⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼",
            "⠀⠀⠀⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞",
            "⠀⠀⠀⠈⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡇",
            "⠀⠀⠀⠀⠈⢻⣦⣀⠀⣏⠀⠀⠀⠀⠀⠀⢸⡆⠀⠀⢠⡄⠀⠀⠀⠀⠀⢀⡿⠀",
            "⠀⠀⠀⠀⠀⠀⠻⡉⠙⢻⡆⠀⠀⠀⠀⠀⡾⠚⠓⣖⠛⣧⡀⠀⠀⠀⢀⡾⠁⠀",
            "⠀⠀⠀⠀⠀⠀⠀⠙⡇⢀⡿⣦⡀⠀⢀⡴⠃⠀⠀⠈⣷⢈⠷⡆⠀⣴⠛⠀⠀⠀",
            "⠀⠀⠀⠀⠀⠀⠀⠀⠛⠚⠀⢸⡇⣰⠏⠁⠀⠀⠀⠀⢉⠁⢸⠷⠼⠃⠀⠀⠀⠀"
        };
    // Image scaled down by half
    StringBuilder scaledArt = new StringBuilder();
    for (int i = 0; i < art.length; i += 2) {
      for (int j = 0; j < art[i].length(); j += 2) {
        scaledArt.append(art[i].charAt(j)); 
      }   
      scaledArt.append("\n");
    }
    System.out.println("Hello Human! I am your fluffy assistant, \n" + logo + "\n the Alpaca! \n" + scaledArt);
    System.out.println("I'm here to help you sort through the woolly world of tasks.\n");
    System.out.println("෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘෴෴⚘\n");
    
    boolean exit = false;
    while (!exit) {
      try {
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        String command = parts[0];

        switch (command.toLowerCase()) {
        
          case "bye":
            handleBye();
            exit = true;
            break;
        
          case "list":
            handleList(tasks, taskCount);
            break;
        
          case "mark":
          case "unmark":
            handleMarkUnmark(parts, command);
            break;
        
          case "todo":
            addTask(handleToDo(parts));
            break;
        
          case "deadline":
            addTask(handleDeadline(parts));
            break;
        
          case "event":
            addTask(handleEvent(parts));
            break;

          default:
            throw new AlpaException("\nOh no, human! I'm sorry but that is not a valid task.");
        }
      } catch (AlpaException e) {
        printDecoratedMessage(e.getMessage());
      }
    }
    scanner.close();
  }

  private static void addTask(Task task) {
    tasks[taskCount++] = task;
    printDecoratedMessage("\nYou added a task human!\n" + task);
  }

  private static void handleBye() {
    System.out.println("\nIt's been a pleasure grazing through your tasks! Goodbye human! Stay cozy!\n");
    System.out.println("𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣𖥧𖡼.𖤣\n");
  }

  private static void handleList(Task[] tasks, int taskCount) {
    if (taskCount == 0) {
      printDecoratedMessage("\nYour list is empty, human!");
      return;
    }
    StringBuilder listOutput = new StringBuilder("\nYour list, human!\n");
    for (int i = 0; i < taskCount; i++) {
      listOutput.append("  ").append(i + 1).append(". ").append(tasks[i]).append("\n");
    }
    printDecoratedMessage(listOutput.toString());
  }

  private static void handleMarkUnmark(String[] parts, String command) throws AlpaException {
    try {
      int index = Integer.parseInt(parts[1]) - 1;
      if (index >= 0 && index < taskCount) {
        String response;
        if (command.equals("mark")) {
          tasks[index].markAsDone();
          response = "\nMarked as done, human!\n" + tasks[index];
        } else {
          tasks[index].markAsNotDone();
          response = "\nNot done with this yet, human?\n" + tasks[index];
        }
        printDecoratedMessage(response);
      } else {
        throw new AlpaException("\nInvalid task number human!!!");
      }
    } catch (NumberFormatException e) {
      throw new AlpaException("\nInvalid input human!!");
    }
  }
  
  private static Task handleToDo(String[] parts) throws AlpaException {
    if (parts.length < 2 || parts[1].trim().isEmpty()) {
      throw new AlpaException("\nBaa-ad news, human! The description of a todo cannot be empty.");
    }
    return new ToDo(String.join(" ", Arrays.copyOfRange(parts, 1, parts.length))); 
  }

  private static Task handleDeadline(String[] parts) throws AlpaException {
    int byIndex = Arrays.asList(parts).indexOf("/by");
    if (byIndex == -1 || byIndex >= parts.length - 1) {
      throw new AlpaException("\nInvalid deadline format, human! Use '/by' to specify the deadline.");
    }
    String deadlineDescription = String.join(" ", Arrays.copyOfRange(parts, 1, byIndex));
    String deadline = String.join(" ", Arrays.copyOfRange(parts, byIndex + 1, parts.length));
    return new Deadline(deadlineDescription, deadline);
  }

  private static Task handleEvent(String[] parts) throws AlpaException {
    int fromIndex = Arrays.asList(parts).indexOf("/from");
    int toIndex = Arrays.asList(parts).indexOf("/to");
    if (fromIndex == -1 || toIndex == -1|| fromIndex >= parts.length - 1 || toIndex <= fromIndex) {
      throw new AlpaException("\nInvalid event format, human! Please use '/from' and '/to' to specify the event time.");
    }
    String eventDescription = String.join(" ", Arrays.copyOfRange(parts, 1, fromIndex));
    String from = String.join(" ", Arrays.copyOfRange(parts, fromIndex + 1, toIndex));
    String to = String.join(" ", Arrays.copyOfRange(parts, toIndex + 1, parts.length));
    return new Event(eventDescription, from, to);
  }

  private static void printDecoratedMessage(String message) {
    String decoration = "\n↟ᨒᨒᨒ↟ᨒᨒᨒ↟ᨒᨒᨒ↟ᨒᨒᨒ↟↟ᨒᨒᨒ↟ᨒᨒᨒ↟↟ᨒᨒᨒ↟ᨒᨒᨒ↟↟ᨒᨒᨒ↟ᨒᨒᨒ↟↟ᨒᨒᨒ↟ᨒᨒᨒ↟ᨒᨒᨒ↟ᨒᨒᨒ↟↟ᨒᨒᨒ↟ᨒᨒᨒ↟↟ᨒᨒᨒ↟ᨒᨒᨒ↟↟ᨒᨒᨒ↟\n";
    System.out.println(message + decoration);
  }
}
