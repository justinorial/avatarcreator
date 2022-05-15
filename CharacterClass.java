//Justin Orial
//Base CharcacterClass Class
//06/03/2019
//06/18/2019

public class CharacterClass
{
   private String desc, stats;
   
   //Constructor
   //pre: none
   //post: object is given General Description
   public CharacterClass()
   {
      desc = "General description";
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