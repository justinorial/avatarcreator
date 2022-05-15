//Justin Orial
//Heavy Class, subclass of CharcacterClass
//06/03/2019
//06/18/2019

public class HeavyClass extends CharacterClass
{
   private String desc, stats;
   
   //Constructor
   //pre: none
   //post: object is given General Description
   public HeavyClass()
   {
      desc = "Characters of class Heavy are big, strong, yet slow. \nThey can absorb more damage than Mediums or Lights because they have the \nmost health. They typically protect other players of low health classes.";
      stats = "HP: 300\nDP: 80\nTime Between Attacks: 3s\nSpeed/100: 50";
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