/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.math.BigInteger;
import pos_project.classes.Formats;

/**
 *
 * @author Cifer
 */
public class FractionAction {
    
    
    public static String convertToFraction(Double quantity){
        String quant = String.valueOf(quantity);
        
//        if(quant.contains(".")){

////            System.out.println(quant.split("\\."));
            String[] values = quant.split("\\.");
//            String whole = values[0];
//            int frac = Integer.parseInt(values[1]);
//            String fraction = new String();
//            if(frac != 0){
//              String num = "1/";
//              frac = 1/frac;
//              fraction = num+frac;
//            } 
//            System.out.println(fraction);
            
             String neg = "";
            double dblDecimal = quantity;
           
            long whole = Long.parseLong(values[0]);
           
            
            if (whole == dblDecimal) {
                return (whole+""); //return no if it's not a decimal
            }
             if (dblDecimal < 0)
            {
                dblDecimal = Math.abs(dblDecimal);
                neg = "-";
            }
            String decpart = values[1];
            long rN = Long.parseLong(decpart);
            int rD = (int) Math.pow(10, decpart.length());

            String rd = Recur(decpart);
            int rel = Integer.parseInt(rd);
            if (rel != 0)
            {
                rN = rel;
                rD = (int) Math.pow(10, rd.length()) - 1;
            }
            //just a few prime factors for testing purposes
            int[] primes = new int[] {47, 43, 37, 31, 29, 23, 19, 17, 13, 11, 7, 5, 3, 2};
            int GCD = BigInteger.valueOf(rN).gcd(BigInteger.valueOf(rD)).intValue();
            rD /= GCD;
            rN /= GCD;
//            for(int i : primes){
//                
//                
//                rD = reduceNo(i, rD, rN);
//                rN = reduceNo(i, rN, rD);
//            }
            if(whole ==0){
                return (neg+rN+"/"+rD);
            } else{
                String w = Formats.pesoDecimal.format(whole);
                return (w+rN+"/"+rD);
            }
            
            
        
//            return quant;
        }
    
    
    private static double reduceNo(int i, double value, double value2){
        int newVal = 0;
        int newVal2 = 0;
        try{
           newVal = (int) value/i;
           Integer.parseInt(String.valueOf(newVal));
           
           newVal2 = (int) value2/i;
           Integer.parseInt(String.valueOf(newVal2));
            
        } catch(Exception e){
            return value;
        }
        
        return newVal;
    }
    
    private static String Recur(String db)
{
    if (db.length() < 7) return "0";
    StringBuilder sb = new StringBuilder(); 
    char[] dbchar = db.toCharArray();
    for (int i = 0; i < 7; i++)
    {
        
        sb.append(dbchar[i]);
        int dlength = (db.length()/sb.toString().length()); 
        int occur = Occurence(sb.toString(), db);
        if (dlength == occur || dlength == occur - sb.toString().length())
        {
            return sb.toString();
        }
    } 
    return "0";
}   
        
private static int Occurence(String s, String check)
{
    int i = 0;
    int d = s.length();
    String ds = check;
    for (int n = (ds.length()/d); n > 0; n--)
    {
        int si = ds.indexOf(s);
        if (si != -1)
        {
            i++;
//            ds = ds.substring(0,si);
//            remove(si, d);
        }
    }
    return i;
}
        
        
    
    
    
    public static Double convertToDouble(String quantity){
        Double quant = 0.0;
                
            
            Double whole =0.0;
            Double numerator = 0.0;
            Double denominator = 0.0;
            try{
            if(quantity.contains(".")){
                String[] value = quantity.split("\\.");
                String w;
                if(value[0].contains(",")){
                     w = value[0].replace(",", "");
//                    whole = (Double) Formats.pesoDecimal.parse(value[0]);
//                    whole = Double.parseDouble(w);
                }else{
//                    whole = Double.parseDouble(value[0]);
                    w = value[0];
                }
                String v = w+"."+value[1];
                Double rem = Double.parseDouble(v);
                        
                return rem;
            }
            else if(quantity.contains(" ")){
                String[] value = quantity.split(" ");
                
                if(value[0].contains(",")){
                    whole = (Double) Formats.pesoDecimal.parse(value[0]);
                }else{
                    whole = Double.parseDouble(value[0]);
                }
                String fraction = value[1];
                String[] ratio =  fraction.split("/");
                numerator = Double.parseDouble(ratio[0]);
                denominator =Double.parseDouble(ratio[1]);
            }else if (quantity.contains("/")){
                String[] ratio =  quantity.split("/");
                numerator = Double.parseDouble(ratio[0]);
                denominator = Double.parseDouble(ratio[1]);
            }else{
                return Double.parseDouble(quantity);
            }
            if(denominator!=0){
             double remainder = numerator/denominator;
             quant = whole+remainder;
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        return quant;
    }
    
      public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
               System.out.println("convertToFraction(.5): "+convertToFraction(0.5));
               System.out.println("convertToFraction(1231.5): "+convertToFraction(1231.5));
               System.out.println("convertToFraction(-.5): "+convertToFraction(-0.25));
               System.out.println("convertToFraction(-1231.5): "+convertToFraction(-1231.5));
               System.out.println("convertToFraction(5.0): "+convertToFraction(5.0));
               System.out.println("convertToFraction(-5.0): "+convertToFraction(-5.0));
               System.out.println("convertToFraction(1231.5): "+convertToFraction(10.33333333333333333333333333333333333333333333333333333333333333333333333));
//               System.out.println("convertToDecimal(3 1/3): "+convertToDouble("3 3/4"));
//               System.out.println("convertToDecimal(2.25): "+convertToDouble("2.25"));
//               System.out.println("convertToDecimal(1): "+convertToDouble("1"));
//               System.out.println("convertToDecimal(1/2): "+convertToDouble("1/2"));
//               System.out.println("convertToDecimal(21,111.25): "+convertToDouble("21,111.25"));
            }
        });
    }
    
    
}
