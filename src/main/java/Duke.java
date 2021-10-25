import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
        //int index = 0;
        //String temp;
        int count = 0;
       //String arry[];
        ArrayList<Task> arry = new ArrayList<>();
        //arry = new String[100];
        String exit = "bye";
        String show = "list";
        String done = "done";
        String todo = "todo";
        String deadline = "deadline";
        String event = "event";
        Scanner scan = new Scanner(System.in);
        //for (int i = 0; i < arry.size(); i++)
        do {
            dataIn = scan.nextLine();
            if (dataIn.equals(exit)) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }else if (dataIn.equals(show)){
                System.out.println("Here are the tasks in your list:");
                for (int j = 0; j < arry.size(); j++){
                    System.out.println(j + 1 + ".[" + arry.get(j).getStatusIcon() + "] " + arry.get(j).getDescription());
                }
            }else if (dataIn.contains(done)) {
                Integer num = Integer.parseInt(dataIn.replaceAll("[\\D]",""));
                arry.get(num-1).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                //arry[num-1] = arry[num-1].substring(0,4) + "X" + arry[num-1].substring(5);
                //System.out.println("  " + arry[num-1].substring(3));
                System.out.println("  [" + arry.get(num-1).getStatusIcon() + "] " + arry.get(num-1).getDescription());
            }else if (dataIn.contains(todo)) {

            }else if (dataIn.contains(deadline)) {

            }else if (dataIn.contains(event)) {

            }else{
                //arry[i] = "[ ][ ] " + dataIn;
                //count++;
                //System.out.println("added: " + arry[i].substring(7));
                Task t = new Task(dataIn);
                arry.add(t);
                count++;
                System.out.println("added: " + arry.get(arry.size()-1).getDescription());
            }
        }while(!dataIn.equals(exit));
    }
}
