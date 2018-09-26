
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Schueler
{

    public Schueler(String name, LocalDate bday)
    {
        this.name = name;
        this.bday = bday;
        this.age = LocalDate.now().getYear() - bday.getYear();
    }
    private String name;
    private int age;
    private LocalDate bday;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public LocalDate getBday()
    {
        return bday;
    }

    public void setBday(LocalDate bday)
    {
        this.bday = bday;
    }
    
    
}
