import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Random;

//import jdk.nashorn.internal.ir.ThrowNode;

class Main {
    
  public static void main(String[] args) {
    System.out.println("Hello world!");
                //Datatype specifier... what's gonna be in the priority queue??


    ///easter eggs
    String lyricsYourReality[] = {"Every day, I imagine a future where I can be with you",
    "In my hand is a pen that will write a poem of me and you",
    "The ink flows down into a dark puddle","Just move your hand, write the way into his heart",
    "But in this world of infinite choices",
    "What will it take just to find that special day",
    "What will it take just to find that special day",
    "Have I found everybody a fun assignment to do today",
    "When you're here, everything that we do is fun for them anyway",
    "When I can't even read my own feelings",
    "What good are words when a smile says it all",
    "And if this world won't write me an ending",
    "What will it take just for me to have it all",
    "Does my pen only write bitter words for those who are dear to me",
    "Is it love if I take you, or is it love if I set you free",
    "The ink flows down into a dark puddle","How can I write love into reality?",
    "If I can't hear the sound of your heartbeat",
    "What do you call love in your reality",
    "And in your reality, if I don't know how to love you",
    "I'll leave you be."};
    int line = 0;
    int wait = 2;
    PriorityQueue<Person> q = new PriorityQueue<Person>();

    //Setting the parameters for each person
    Person pablo = new Person(5,"Pablo",0.0);
    Person KingHotdog = new Person(1,"Sir Hotdog",1.1);
    Person ButterDog = new Person(609,"Budda dog",91.8);
    
    //now its time to add in our persons to the queue
    addToQueue(pablo, q);
    addToQueue(ButterDog, q);
    addToQueue(KingHotdog, q);
    addToQueue(KingHotdog, q);
    printQueueMenu(q);
    Scanner e = new Scanner(System.in);
    int something = getOperator(e, 1, 4);
    while(true){
    if(something == 4){break;}
    operationPotat(q, something);
    printQueueMenu(q);
    something = getOperator(e,1,4);
    }
    waiting(wait);
    System.out.println("PriorityQueue.exe successfuly deleted\n");
    while(lyricsYourReality.length>line){
    waiting(wait);
    System.out.println(lyricsYourReality[line]);
    line++;
}
    waiting(wait);
    System.out.println("Goodbye!");
  }

  public static void waiting(int wait){
    try {
      Thread.sleep(wait*1000);
      }catch(InterruptedException ex){
      Thread.currentThread().interrupt();
    }
  }

  public static int getOperator(Scanner input, int min, int max){
    //easter egg
    int tries = 0;
    int a = 0;
    int i = 5;
    boolean invalid = false;
    do{
    while (!input.hasNextInt()){
      input.nextLine();
      if(tries==0){
      System.out.println("Oh nonononono, you can't do that here person. You must put an integer or a number. You fail to do so, by the power invested in me and the court of Hotdogs, you will be placed underarrest!");
      tries++;
      System.out.print(": ");
    }
    else if(tries<=i){
      System.out.println("Hey, please put a number!");
      tries++;
    }
      else{
        tries = 0;
        System.out.println("What did I tell you!!!!!! AhHhHhhhhhhh!!!");
        System.out.print(": ");
        i++;
      }
    }
      a = input.nextInt();
      if(a>max||a<min){
        invalid=true;
        System.out.print("Congragulations! \n You gave me a non valid number, please input a whole number from ");
        System.out.print(min);
        System.out.print(" - ");
        System.out.println(max);
      } else{
        invalid=false;
      }
    }while(invalid);
    return a;
  }

  public static void operationPotat(PriorityQueue<Person> q, int o){
    //1) pulling
    //2) removing
    //3) adding
    //Random rnd = new Random();

    //int newRnd = rnd.nextInt(q.size());
    Scanner in = new Scanner(System.in);
    //System.out.println("Operation Potat Online");

    if(o==1){
      System.out.println("Polling");
      q.poll();
    } else if(o==2){
      Object [] ar = q.toArray(); // creates and sets toArray to the variable ar...
        System.out.println("Which person do you want to remove?");
        for (int i = 0; i < ar.length; i++) {
        System.out.print(i+1);
        System.out.println(") " + ar[i].toString()+1);
      }
      int input = getOperator(new Scanner(System.in), 1, q.size());
      System.out.println("Removing");
      if(!q.remove(ar[input-1])){
        System.out.println("Something went wrong..... Now what?\n Maybe let's try again");
      }else{
        System.out.println("Wow it actully worked!!!! Yay!");
      }
    }else{
      System.out.println("Okay, so whats this new person's name?");
      String name = in.nextLine();
      System.out.println("Wow... Thats an intresting name. \n So what do you want your rank to be?");
      int rank = in.nextInt();
      System.out.println("Okay, how much Hotdogese are you? \n If you don't know, uhhh well good luck!");
      double pofH = in.nextDouble();
      while(pofH > 100 ){
        System.out.println("Thats impossible, please reinput your number. An example is 90.10");
        pofH = in.nextDouble();
      }
      if(pofH == 100){
        System.out.println("Intresting...");
      } else{
        System.out.println("Thankyou for your information");
      }
      Person temmie = new Person(rank, name, pofH);
      addToQueue(temmie, q);
    }
}

  public static void printQueueMenu(PriorityQueue<Person> q) {
    //Print out the entirety of the queue, and then poll....
    // q.toArray(); --> Person []
    // for (int i = 0; i < q.toArray().length; i++)
      // q.toArray()[i]; Why we sometimes want a middleman....
    Object [] ar = q.toArray(); // creates and sets toArray to the variable ar...
    System.out.println("Here is the menu...\n");
    for (int i = 0; i < ar.length; i++) {
        System.out.println(ar[i].toString()); //Which means any object gets the toString...
    }
    //poll "1) poll"
    System.out.println("1) Pulling you into the party!");
    //remove a random person from queue
    System.out.println("2) Grab a random person and throw them to this party.");
    //add a random Person that we made
    System.out.println("3) add a innocent bystander to the queue");
    System.out.println("4) Exit this awesome program. But why would you do that? = ) You have no reason to.");
    System.out.print(": ");
  }


  public static void addToQueue(Person p, PriorityQueue<Person> q ) {
    //make sure that person to be added, is not already in the priority queue....

    //contains takes in a object to see if its in the queue
    //returns a true or false
    //boolean inQueue =  false;
            //True or False
    //inQueue = q.contains(p);

    if (q.contains(p) == true) {
      System.out.println("Already in queue skipping. There's an impasta here.");
    }
    else{

      System.out.println("Adding to queue....");
      System.out.println(p.toString());
      
      //q.add returns a true or false depending on if the add function worked on not...
      // if q.add works let us know that the add was successful
      //otherwise tell us that it failed

      if ( q.add(p) == true ) {
        System.out.println("The add was successful!");
      } else {
        System.out.println("The queue was unsuccessful, please call 295-HOT-DOGS.");
      }
    }
  }


}