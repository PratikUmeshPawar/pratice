import java.io.BufferedReader;
import java.io.FileReader;

public class abc {
    public static void main(String args[]) throws Exception
    {
    
        BufferedReader in =new BufferedReader(new FileReader("C://Users/DELL/Documents/Desktop/dmcode/input_Norm.csv"));
        String inputline=in.readLine();
        String[] fields=inputline.split(",");
        int i=0;
        int[] arr=new int[fields.length];
        for(String str:fields)
        {
            int x=Integer.parseInt(str);
            System.out.println(x);
            arr[i++]=x;
        }
        int max1=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        for( i=0;i<arr.length;i++)
        {
            if(arr[i]>max1)
            {
                max1=arr[i];
            }
        }
        for( i=0;i<arr.length;i++)
        {
            if(arr[i]<min1)
            {
                min1=arr[i];
            }
        }
        
        System.out.println(max1);
        System.out.println(min1);
        int min2=0;
        int max2=1;
        int z=0;
        double normArray[]=new double[arr.length];
        for( i=0;i<arr.length;i++)
        {
            normArray[i]=(double)((double)(arr[i]-min1)/(double)(max1-min1));//using min_max method.
            System.out.println(normArray[i]);

        }



    }
}
