import java.io.File;
import java.util.Scanner;

public class Main {
    //created interger variable to hold option selected
    static int option;
    //created a string variable to hold current directory
    static String currentDirectory = System.getProperty("user.dir");
    static File folder = new File(currentDirectory);
    public static void main(String[]args) {

        System.out.println("Project1 by Shafi");
       selectOption();
       input();
       menu(option);
    }
    public static void selectOption() {
        System.out.println("Project1 by Shafi");
        System.out.println("1. List all files");
        System.out.println("2. Add, Delete or Search");
        System.out.println("3. Close application");

    }
    public static void input() {
        Scanner z = new Scanner(System.in);
        System.out.println("select a number");
        int input  = z.nextInt();
    if(input == 1 || input == 2 || input == 3 ) {
        option  = input;
    }else {
        System.out.println("Select either 1,2 or 3");
        input();

    }

    }
    public static  void menu(int x )  {
        switch (x){
            case 1:
                listFiles();
                break;
            case 2:
                others();
                break;
            case 3:
                terminate();
                break;


        }

    }

    private static void terminate() {
        System.exit(0);
    }

    private static void others() {
        System.out.println("select one of the following");
        System.out.println("1.add file");
        System.out.println("2. delete file");
        System.out.println("3. search file");
        input();
        switch (option){
            case 1:
                addFile();
                break;
            case 2:
                deleteFile();
                break;
            case 3:
                searchFile();
                break;


        }
    }

    private static void searchFile() {
        System.out.println("enter file name to be searched");
        Scanner z = new Scanner(System.in);
        String input = z.next();
        File listofFiles []= folder.listFiles();
        for (File file: listofFiles){
            //if the file is not a directory and the file name does not start with a full stop
            if (! file.isDirectory()&& file.getName().charAt(0)!='.'){
                //gets input ands extension on file then checks if its equal to the file from the for loop
                if ((input+ ".txt").equals(file.getName())){
                    System.out.println(input+ " is the same as "+file.getName());
                }
                else {
                    System.out.println(input+ " is not the same as "+file.getName());

                }
            }
        }
        selectOption();
        input();
        menu(option);
    }

    private static void deleteFile() {
        System.out.println("enter file name to be deleted");
        Scanner z = new Scanner(System.in);
        String input = z.next();
        File listofFiles []= folder.listFiles();
        for (File file: listofFiles){
            //if the file is not a directory and the file name does not start with a full stop
            if (! file.isDirectory()&& file.getName().charAt(0)!='.'){
                //gets input ands extension on file then checks if its equal to the file from the for loop
            if ((input+ ".txt").equals(file.getName())){
               file.delete();
               System.out.println("file deleted");
            }
            else {
                System.out.println("file not deleted");

            }
            }
        }
        selectOption();
        input();
        menu(option);
    }

    private static void listFiles() {
        for (File file: folder.listFiles()){
            //checks if the element is a file - if the file is true then it satisfies the if statement
            if (file.isFile()){
                //It receives the file name and stores it in a string variable
                String fileName = file.getName();
                //It checks if the file system contains a fulls top and the full stop is not at the start of the file name
                if (fileName.contains(".") &&  (fileName.charAt(0)!='.')){
                    //prints file name
                    System.out.println(file.getName());
                }
            }
        }
        selectOption();
        input();
        menu(option);
    }

    private static void addFile()  {
        System.out.println("enter file name");
        Scanner z = new Scanner(System.in);
        String input = z.next();
        //created a new file with input received
        File newFile = new File(currentDirectory + "/"+ input+ ".txt");
        try {
            newFile.createNewFile();
            System.out.println("file created");
        } catch (Exception e) {
            System.out.println(e);
        }
        selectOption();
        input();
        menu(option);
    }
}
