//Justin Orial
//Light Class, subclass of CharcacterClass
//06/03/2019
//06/18/2019

public class LightClass extends CharacterClass
{
   private String desc, stats;
   
   //Constructor
   //pre: none
   //post: object is given General Description
   public LightClass()
   {
      desc = "Characters of class Light are very fast, are the smallest, but have the least health. \nTheir attacks have the least damage, but release them the quickest. They typically \nflank behind enemy lines and use their speed to enter and escape.";
      stats = "HP: 125\nDP: 20\nTime Between Attacks: 0.5s\nSpeed/100: 100";
   }
   
   //Returns the description of the class
   //pre: none
   //post: description is returned
   public String getDescription()
   {
      return(desc);
   }
   
   //Returns the statistics of the class
   //pre: none
   //post: statistics are returned
   public String getStats()
   {
      return(stats);
   }
} 