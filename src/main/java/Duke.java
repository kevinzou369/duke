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
        int count = 0;
        String arry[];
        arry = new String[100];
        String exit = "bye";
        String show = "list";
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arry.length; i++) {
            dataIn = scan.nextLine();
            if (dataIn.equals(exit)) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }else if (dataIn.equals(show)){
                for (int j = 0; j < count; j++){
                    System.out.println(j + 1 + ". " + arry[j]);
                }
            }else{
                arry[i] = dataIn;
                count++;
                System.out.println("added: " + arry[i]);
            }
        }
    }
}
