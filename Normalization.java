import java.lang.*;
import java.util.*;
import java.io.*;
public class Normalization
{
   public static void main(String[] args) throws Exception
   {
    BufferedReader   in = new BufferedReader(new FileReader("C://Users/Dell/Documents/Desktop/dmcode/input_Norm.csv"));

    String inputLine = in.readLine();
    String [] fields = inputLine.split(","); // Splits at the space
    int i=0;
    int [] arr=new int[fields.length];
    for(String str:fields){
    int x=Integer.parseInt(str); //prints out name
    arr[i++]=x;
    }
    int max1=Integer.MIN_VALUE;
    int min1=Integer.MAX_VALUE;
    for( i=0;i<arr.length;i++)
    {
       if(arr[i]>max1)
          max1=arr[i];
    }
    
    for( i=0;i<arr.length;i++)
    {
       if(arr[i]<min1)
         min1=arr[i];
    }
   
    int max2=1;
    int min2=0;
    double normArray[]=new double[arr.length];
    for( i=0;i<arr.length;i++)
    {
      normArray[i]=(double)((double)(arr[i]-min1)/(double)(max1-min1));//using min_max method.
      System.out.println(normArray[i]);

    }

    //writing data to file.
    PrintWriter out=new PrintWriter(new File("output_normalization.csv"));
    out.printf("%s,%s,%s","Value","min_max_norm","z-score_norm");
     double mean=0.0;
    double sum=0.0;
    for(i=0;i<arr.length;i++)
    {
         sum+=arr[i];
    }
    mean=sum/arr.length;
    int n=arr.length;
    double sd=0.0; 
    double sqrsum=0.0;
    for( i=0;i<n;i++)
    {
       sqrsum=sqrsum+(arr[i]-mean)*(arr[i]-mean);//calculating standard deviation
    }
    sqrsum=sqrsum/n;
    sd=Math.sqrt(sqrsum);
    double zscore[]=new double[n];
    for( i=0;i<n;i++)
    {
       zscore[i]=(arr[i]-mean)/sd;//calculating z score
    }
    
    for(i=0;i<n;i++)
    {
      out.printf("\n");
      out.printf("%d,%.3f,%.3f",arr[i],normArray[i],zscore[i]);
    }


    out.close();
  }
}   
