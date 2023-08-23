import java.util.Scanner;
class Main {
  private static final Scanner Scanner = new Scanner(System.in);
  private static final int START_WATER = 400;
  private static final int START_MILK = 540;
  private static final int START_BEANS = 120;
  private static final int START_CUPS = 9;
  private static final int START_MONEY = 550;

  private static int Water = START_WATER;
  private static int Milk = START_MILK;
  private static int Beans = START_BEANS;
  private static int Cups = START_CUPS;
  private static int Money = START_MONEY;
  
  public static void main(String[] args) {
    machine_loop();
  }
  private static void machine_loop()
  {
    boolean is_done = false;
    while(!is_done)
    {
      
      machine_messages("Write action (buy, fill, take, remaining, exit):");
      String action = Scanner.next();
      switch (action) {
        case "remaining": 
          {
            print_status();
            break;
          }
        case "exit":
            is_done = true;
            break;
        case "buy":
          {
            machine_messages("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String coffe = Scanner.next();
            switch (coffe) {
              case "1":
                espresso();
                System.out.println();
                break;
              case "2":
               latte(); 
               System.out.println();
                break;
              case "3":
               cappuccino();
               System.out.println();
                break;
              case "back":
                break;
              default:
                break;
            }
            break;
          }
        case "fill": 
          {
           fill(); 
            break;
          }
        case "take":
          {
            System.out.printf("I gave you $%d\n", Money);
            Money = 0;
            System.out.println();
            break;
          }
        default:
          break;
      }
    }
  }
  private static void machine_messages(String message)
  {
    System.out.println(message);
  }
  private static void espresso()
  {
    if (Water - 250 >= 0 && Beans - 16 >= 0 && Cups - 1 >= 0)
    {
      machine_messages("I have enough resources, making you a coffee!");
      Water -= 250;
      Beans -= 16;
      Money += 4;
      Cups -= 1;
    } else {
      not_enough(250, 0, 16);
    }
  }
  private static void latte()
  {
    if (Water - 350 >= 0 && Beans - 20 >= 0 && Milk - 75 >= 0 && Cups - 1 >= 0)
    {
      machine_messages("I have enough resources, making you a coffee!");
      Water -= 350;
      Milk -= 75;
      Beans -= 20;
      Money += 7;
      Cups -= 1;
    } else {
      not_enough(350, 75, 20);
    }
  }
  private static void cappuccino()
  {
    if (Water - 200 >= 0 && Beans - 12 >= 0 && Milk - 100 >= 0 && Cups - 1 >=0) 
    {
      machine_messages("I have enough resources, making you a coffee!");
      Water -= 200;
      Milk -= 100;
      Beans -= 12;
      Money += 6;
      Cups -= 1;
    } else {
      not_enough(200, 100, 12);
    }
  }
  private static void fill()
  {
    machine_messages("Write how many ml of water you want to add:");
    int water = Scanner.nextInt();
    machine_messages("Write how many ml of milk you want to add:");
    int milk = Scanner.nextInt();
    machine_messages("Write how many grams of coffee beans you want to add:");
    int coffee_beans = Scanner.nextInt();
    machine_messages("Write how many disposable cups of coffee you want to add:");
    int cups = Scanner.nextInt();
    Water += water;
    Milk += milk;
    Beans += coffee_beans;
    Cups += cups;
  }
  private static void print_status()
  {
      System.out.println();
      machine_messages("The coffee machine has:");
      System.out.printf("%d ml of water\n", Water);
      System.out.printf("%d ml of milk\n", Milk);
      System.out.printf("%d g of coffee beans\n", Beans);
      System.out.printf("%d disposable cups\n", Cups);
      System.out.printf("$%d of money\n", Money);
  }
  private static void not_enough(int... ingredients)
  {
    if (Water - ingredients[0] < 0) {
      machine_messages("Sorry, not enough water!");
    } else if (Milk - ingredients[1] < 0) {
      machine_messages("Sorry, not enough milk!");
    } else if (Beans - ingredients[2] < 0) {
      machine_messages("Sorry, not enough coffee beans!");
    } else {
      machine_messages("Sorry, not enough cups!");
    }
  }
}

