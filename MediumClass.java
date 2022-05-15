//Justin Orial
//Medium Class, subclass of CharcacterClass
//06/03/2019
//06/18/2019

public class MediumClass extends CharacterClass
{
   private String desc, stats;
   
   //Constructor
   //pre: none
   //post: object is given General Description
   public MediumClass()
   {
      desc = "Characters of class Medium have attacks less devastating than Heavies, \nbut can release them quicker. They are faster and smaller than Heavies, but \nhave less health. They typically stay behind the Heavies but fight the enemy head on.";
      stats = "HP: 200\nDP: 50\nTime Between Attacks: 1s\nSpeed/100: 75";
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