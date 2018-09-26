
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
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
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        
            for(Schueler s : klasse)
            {
                oos.writeObject(s);

            }
            oos.flush();
        }
        catch(Exception e)
        {
            
        }
        
      
    }
    
    public void load(File f)
    {
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            
            String line = "";
            
            Object s = null;
            while((s = ois.readObject()) != null)
            {
                add((Schueler) s);
            }
        }
        
        catch(Exception e)
        {
            
        }
    }
    
    public static void main(String[] args)
    {
        SchuelerBl bl = new SchuelerBl(); 
        
        Schueler s1 = new Schueler("Hans", LocalDate.of(2000, Month.MARCH, 3));
        Schueler s2 = new Schueler("Grete", LocalDate.of(1999, Month.OCTOBER, 10));
        
        bl.add(s1);
        bl.add(s2);
        
        File f = new File("./data.bin");
        
        try{
            bl.save(f);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
