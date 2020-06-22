/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuhs_fifa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Soma
 */
public class SchuhS_Fifa 
{
    static ArrayList<FifaAdatok> FifaList=new ArrayList<>();
    static ArrayList<Integer> ValtozasList=new ArrayList<Integer>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Feladat2();System.out.println("\n-------------------------------------\n");
        Feladat3();System.out.println("\n-------------------------------------\n");
        Feladat4();System.out.println("\n-------------------------------------\n");
        Feladat5();System.out.println("\n-------------------------------------\n");
        Feladat6();System.out.println("\n-------------------------------------\n");
        Feladat7();System.out.println("\n-------------------------------------\n");
    }

    private static void Feladat2()
    {
        System.out.println("2.Feladat: Adatok beolvasása");
        try 
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fajl=new FileReader("fifa.txt");
            int db=0;
            try (BufferedReader br = new BufferedReader(fajl))
            {
                int i=0;
                String sor=null;                
                while ((sor=br.readLine())!=null) 
                {
                    String[] dbok=sor.split(";");
                    String Csapat=dbok[0];
                    int Helyezes=Integer.parseInt(dbok[1]);
                    int Valtozas=Integer.parseInt(dbok[2]);
                    int Pontszam=Integer.parseInt(dbok[3]);
                    FifaAdatok FA=new FifaAdatok(Csapat, Helyezes, Valtozas, Pontszam);
                    FifaList.add(FA);                    
                    db++;                                     
                }
            }
            if(0<db)
            {
                System.out.println("\tSikeres beolvasás, beolvasott sorok száma:  "+db);
            }
            
        } 
        catch (IOException| NumberFormatException e) 
        {
            System.out.println("Hiba: " + e);
        }
    }

    private static void Feladat3() 
    {
        System.out.println("3.Feladat: Forrásállományban lévő csapatok száma");
        int ForrasHossza=FifaList.size();
        System.out.println("\tForrás állomány hossza: "+ForrasHossza);
    }

    private static void Feladat4()
    {
        System.out.println("4.Feladat: Ranglistán szereplő csapatok átlag pontjai");
        double Osszeg=0;
        double Atlag=0;
        for (int i = 0; i < FifaList.size(); i++)
        {
        Osszeg+=FifaList.get(i).Pontszam;
        Atlag=Osszeg/FifaList.size();
        }
        System.out.println("\tA csapatok pontszámainak átlaga: "+Atlag);
    }

    private static void Feladat5() 
    {
        System.out.println("5.Feladat: A legtöbbet javító csapat");
        int MaxValtozas=Integer.MIN_VALUE;
        String MaxCsapat="Cica";
        int MaxPontszam=0;
        int MaxHelyezes=0;
        for (int i = 0; i < FifaList.size(); i++)
        {
         if(MaxValtozas<FifaList.get(i).Valtozas)
         {
             MaxValtozas=FifaList.get(i).Valtozas;
             MaxCsapat=FifaList.get(i).Csapat;
             MaxPontszam=FifaList.get(i).Pontszam;
             MaxHelyezes=FifaList.get(i).Helyezes;
         }
        }
        System.out.println("\tHelyezés: "+MaxHelyezes);
        System.out.println("\tCsapat: "+MaxCsapat);
        System.out.println("\tPontszam: "+MaxPontszam);
        
        
    }

    private static void Feladat6()
    {
        System.out.println("6.Fladat: Forrásállományban Magyarország?");
        int db=0;
        for (int i = 0; i < FifaList.size(); i++)
        {
        if(FifaList.get(i).Csapat=="Magyarország")
        {
            db++;
        }
        }
        if(db>0)
        {
            System.out.println("\tMagyarország rajta van a listán");
        }
        else
        {
            System.out.println("\tMagyarország nincs rajta a listán");
        }
    }

    private static void Feladat7()
    {
        System.out.println("7.Feladat: Statisztika a változásokról");
        //ValtozasList=new ArrayList<>();
        for (int i = 0; i < FifaList.size(); i++)
        {
        if(!ValtozasList.contains(FifaList.get(i).Valtozas))
        {
            ValtozasList.add(FifaList.get(i).Valtozas);
        }
        }
        for (Integer integer : ValtozasList)
        {
            //System.out.println("\t "+integer);    
        }
        for (Integer integer : ValtozasList)        
        {
           int db=0;
            for (FifaAdatok fifaAdatok : FifaList)
            {
                if(integer==fifaAdatok.Valtozas)
                {
                    db++;
                }
            }
            if(db>1)
            {
                System.out.println("\t"+integer+" : "+db +" csapat");
            }
            
        }
    }
    
}
