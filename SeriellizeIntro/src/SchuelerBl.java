
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        
            for(Schueler s : klasse)
            {
                bw.write(s.toString());
                bw.write(";");
                bw.write(s.getBday().toString());
                bw.newLine();
            }
            
            bw.flush();
        }
        catch(Exception e)
        {
            
        }
        
      
    }
    
    public void load(File f)
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            String line = "";
            
            while((line = br.readLine()) != null)
            {
                try{
                    
                
                String[] p = line.split(";");
                
                add(new Schueler(p[0], LocalDate.parse(p[1])));
                }
                catch(Exception ex)
                {
                    System.out.println(line);
                }
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
        
        File f = new File("./data.csv");
        
        try{
            bl.save(f);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
