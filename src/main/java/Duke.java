import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke" + System.lineSeparator() + "What can I do for you?");

        String dataIn;
        int index = 0;
        String temp;
        int count = 0;
        String arry[];
        arry = new String[100];
        String exit = "bye";
        String show = "list";
        String done = "done";
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arry.length; i++) {
            dataIn = scan.nextLine();
            if (dataIn.equals(exit)) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }else if (dataIn.equals(show)){
                System.out.println("Here are the tasks in your list:");
                for (int j = 0; j < count; j++){
                    System.out.println(j + 1 + "." + arry[j]);
                }
            }else if (dataIn.contains(done)) {
                Integer num = Integer.parseInt(dataIn.replaceAll("[\\D]",""));
                System.out.println("Nice! I've marked this task as done:");
                arry[num-1] = arry[num-1].substring(0,1) + "X" + arry[num-1].substring(2);
                System.out.println("  " + arry[num-1]);
            }else{
                arry[i] = "[ ] " + dataIn;
                count++;
                System.out.println("added: " + arry[i].substring(4));
            }
        }
    }
}
