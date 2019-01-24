import commands.AnnotationCommands;
import commands.Commands;
import io.OutputWriter;

import java.util.Scanner;

public class Main {
    private static final Commands commands = new Commands();
    private static final AnnotationCommands annotationCommands = new AnnotationCommands();
    private static final OutputWriter writer = new OutputWriter();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            String[] input = scanner.nextLine().split(";");
            if(input[0].equalsIgnoreCase("End")) {
                break;
            }


            String command = input[0];
            if(command.equalsIgnoreCase("Create")){
                //Create;AXE;Axe of Misfortune
                String weaponEnum = input[1];
                String name = input[2];
                commands.createWeapon(weaponEnum,name);
            }else if(command.equalsIgnoreCase("Add")){
                //Add;Axe of Misfortune;0;RUBY
                String name = input[1];
                int index = Integer.parseInt(input[2]);
                String gemName = input[3];
                commands.addGemToWeapon(name,index,gemName);
            }else if(command.equalsIgnoreCase("Remove")){
                //Remove;Axe of Misfortune;0
                String weaponName = input[1];
                int index = Integer.parseInt(input[2]);
                commands.removeGemFromWeapon(weaponName,index);
            }else if(command.equalsIgnoreCase("Print")){
                String weaponName = input[1];
                writer.writeLine(commands.print(weaponName));
            }else if(command.equalsIgnoreCase("Compare")){
                String firstWeaponName = input[1];
                String secondWeaponName = input[2];
                writer.writeLine(commands.compareWeapons(firstWeaponName,secondWeaponName));
            }else if(command.equalsIgnoreCase("Author")){
                writer.writeLine(annotationCommands.getAuthorName());
            }else if(command.equalsIgnoreCase("Revision")){
                writer.writeLine(annotationCommands.getRevision());
            }else if(command.equalsIgnoreCase("Description")){
                writer.writeLine(annotationCommands.getDescription());
            }else if(command.equalsIgnoreCase("Reviewers")){
                writer.writeLine(annotationCommands.getReviewers());
            }

        }
    }
}
