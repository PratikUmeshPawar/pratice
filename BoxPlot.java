
import java.lang.*;
import java.util.*;
import java.io.*;
class BoxPlot
{

   public static double findMedian(int arr[],int start,int end)
   {
        int n=end-start+1;
        if(n%2==0)
        {
            return (arr[start+n/2-1]+arr[start+n/2])/2;
        }
        else
        {
            return arr[start+n/2];
        }

   }
   public static void main(String[] args) throws Exception
   {
    BufferedReader   br = new BufferedReader(new FileReader("C://Users/DELL/Documents/Desktop/dmcode/input_boxplot.csv"));

    
    String [] fields = br.readLine().trim().split(","); // Splits at the space
    int i=0;
    int [] arr=new int[fields.length];
    for(String str:fields){
    int x=Integer.parseInt(str); //prints out name
    arr[i++]=x;
    }
    
    Arrays.sort(arr);
    
    int n=arr.length;
    double median=findMedian(arr,0,n-1);
    double q1=findMedian(arr,0,n/2-1);
    double q3=0;
    
    
        q3=findMedian(arr,n/2+1,n-1);
    

    PrintWriter out=new PrintWriter(new File("output_boxplot.csv"));
    out.printf("%s,%s","Attribute","Value");
    out.printf("\n");

    out.printf("%s,%d\n","Max",arr[n-1]);
    out.printf("%s,%d\n","Min",arr[0]);
    out.printf("%s,%.3f\n","Median",median);
    out.printf("%s,%.3f\n","Q1",q1);
    out.printf("%s,%.3f\n","Q3",q3);

    double iqr=q3-q1;
    double upper_out=q3 + (1.5)*iqr;
     double lower_out=q1 - (1.5)*iqr;
    out.printf("%s,%.3f\n","upper_out",upper_out);
    out.printf("%s,%.3f\n","lower_out",lower_out);



    out.close();
   }
}
