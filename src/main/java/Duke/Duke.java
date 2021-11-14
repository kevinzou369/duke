package Duke;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) throws IOException {
        String dataIn;
        int count = 0;
        ArrayList<Task> arry = new ArrayList<>();
        String exit = "bye";
        String show = "list";
        String done = "done";
        String todo = "todo";
        String deadline = "deadline";
        String event = "event";
        String delete = "delete";
        String snooze = "snooze";
        String find = "find";
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        try {
            File myFile = new File("C:\\Users\\yushan\\Desktop\\Duke\\Duke.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
                list = Files.readAllLines(Paths.get("C:\\Users\\yushan\\Desktop\\Duke\\Duke.txt"));
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke.Duke" + System.lineSeparator() + "What can I do for you?");

        do {
            FileWriter myWrite = new FileWriter("C:\\Users\\yushan\\Desktop\\Duke\\Duke.txt");
            dataIn = scan.nextLine();
            if (dataIn.equals(exit)) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }else if (dataIn.equals(show)){
                System.out.println("Here are the tasks in your list:");
                for (int j = 0; j < arry.size(); j++){
                    System.out.println(j + 1 + "." + arry.get(j).toString().substring(0,3) + "[" + arry.get(j).getStatusIcon() + "] " + arry.get(j).toString().substring(7));
                    //System.out.println(j + 1 + "." + list.get(j));
                }
            }else if (dataIn.contains(done)) {
                try {
                    Integer num = Integer.parseInt(dataIn.replaceAll("[\\D]", ""));
                    arry.get(num - 1).markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  [" + arry.get(num - 1).getStatusIcon() + "] " + arry.get(num - 1).getDescription());
                } catch (Exception e) {
                    System.out.println("☹ OOPS!!! The index of a done cannot be empty.");
                }
            }else if (dataIn.contains(todo)) {
                try {
                    Task t = new Todo(dataIn.substring(5));
                    arry.add(t);
                    count++;
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + arry.get(count - 1).toString());
                    System.out.println("Now you have " + arry.size() + " tasks in the list.");
                    myWrite.write(arry.get(count - 1).toString());
                    myWrite.close();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                }
            }else if (dataIn.contains(deadline)) {
                try {
                    int idx = dataIn.indexOf("/");
                    Task t = new Deadline(dataIn.substring(9, idx - 1), dataIn.substring(idx + 4));
                    arry.add(t);
                    count++;
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + arry.get(count - 1).toString());
                    System.out.println("Now you have " + arry.size() + " tasks in the list.");
                    LocalDateTime current = LocalDateTime.now();
                    DateTimeFormatter time = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss");
                    String formattedTime = current.format(time);
                    System.out.println("The current time is: " + formattedTime);
                    myWrite.write(arry.get(count - 1).toString());
                    myWrite.close();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                }
            }else if (dataIn.contains(event)) {
                try {
                    int idx = dataIn.indexOf("/");
                    Task t = new Event(dataIn.substring(6, idx - 1), dataIn.substring(idx + 4));
                    arry.add(t);
                    count++;
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + arry.get(count - 1).toString());
                    System.out.println("Now you have " + arry.size() + " tasks in the list.");
                    myWrite.write(arry.get(count - 1).toString());
                    myWrite.close();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                }
            }else if (dataIn.contains(delete)) {
                try {
                    Integer num = Integer.parseInt(dataIn.replaceAll("[\\D]", ""));
                    count--;
                    System.out.println("Noted. I've removed this task:");
                    System.out.println("  " + arry.get(num-1).toString());
                    arry.remove(num-1);
                    System.out.println("Now you have " + arry.size() + " tasks in the list.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The index of a delete cannot be empty.");
                }
            }else if (dataIn.contains(snooze)) {
                try {
                    Integer num = Integer.parseInt(dataIn.substring(7,8));
                    int idx = dataIn.indexOf("/");
                    String c = arry.get(num-1).toString();
                    int idx2 = c.indexOf("(");
                    Task t = new Deadline(c.substring(7,idx2-1), dataIn.substring(idx + 4));
                    System.out.println(arry.get(num-1).toString().substring(1,2));
                    if (arry.get(num-1).toString().substring(1,2).equals("D")) {
                        arry.set(num-1,t);
                        System.out.println("Noted. I've snoozed this task:");
                        System.out.println("  " + arry.get(num-1).toString());
                        System.out.println("Now you have " + arry.size() + " tasks in the list.");
                    }else {
                        System.out.println("You can only snooze the deadline tasks.");
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The index of a snooze cannot be empty.");
                }
            }else if (dataIn.contains(find)) {
                try {
                    int seq = 1;
                    System.out.println("Here are the matching tasks in your list:");
                    for (int i = 0; i < arry.size(); i++) {
                        if (arry.get(i).toString().contains(dataIn.substring(5))) {
                            System.out.println(seq + "." + arry.get(i).toString());
                            seq++;
                        }
                    }
                }catch (IndexOutOfBoundsException e) {
                    System.out.println("☹ OOPS!!! The description of a find cannot be empty.");
                }
            } else{
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }while(!dataIn.equals(exit));
    }
}
