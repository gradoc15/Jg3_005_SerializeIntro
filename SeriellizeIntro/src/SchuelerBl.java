
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class SchuelerBl
{
    private ArrayList<Schueler> klasse = new ArrayList();
    
    public void add(Schueler s)
    {
        klasse.add(s);
    }
    
    public void save(File f)
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        
            for(Schueler s : klasse)
            {
                bw.write(s.toString());
                bw.write(";");
                bw.write(s.getBday().toString());
                bw.newLine();
            }
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void load(File f)
    {
        
    }
    
    public static void main(String[] args)
    {
        
    }
}
