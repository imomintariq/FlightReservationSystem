import java.util.Scanner;

public class StartingPage {

    public void menu(){


        Scanner input = new Scanner(System.in);
        System.out.println("Select an Option\n"+
                "1. SignUp as Customer\n"+
                "2. SingnIn as Customer\n"+
                "3. LogIn as Admin\n"+
                "4. Register as Admin\n"+
                "5. Exit"
        );
        int selectedOption = input.nextInt();
        if(selectedOption>5 || selectedOption < 1){
            menu();
        }
        else{
            if(selectedOption == 1){
                //SignUp Details
                
            }
            else if(selectedOption == 2){
                //Login Details
            }
            else if(selectedOption == 3){
                //Login as Admin
            }
            else if(selectedOption == 4){
                // Register a new Admin

            }
            else if(selectedOption == 5){
               System.exit(1);
            }

        }

    }
}
