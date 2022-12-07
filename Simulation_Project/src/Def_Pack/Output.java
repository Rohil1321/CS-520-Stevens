package Def_Pack;

import java.io.*;

import Def_Pack.*;

public class Output 
{

    public static void export(String route, String content) 
    {
        FileWriter writer = null;
        try 
        {
            // open a new writer. "true" means we add things behind.
            writer = new FileWriter(route, true);
            writer.write(content);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                if(writer != null)
                {
                    writer.close();
                }
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
}
