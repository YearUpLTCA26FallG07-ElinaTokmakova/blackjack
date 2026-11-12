package com.pluralsight.models;

public class Menu {
    public static void welcome (){
        System.out.println("""
                ╔════════════════════════════════════════╗
                ║            ♠  black jack  ♠            ║
                ║      ~~~~~~~~~~~~~~~~~~~~~~~~~~~       ║
                ║    beat the dealer. count the odds.    ║
                ╚════════════════════════════════════════╝
                """);
    }

    public static void pressEnterTo(String prompt){
        Console.promptForString("Press Enter↵ to " + prompt);
    }
}
