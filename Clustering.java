import java.lang.*;
import java.util.*;
import java.io.*;

public class Clustering
{
	public static void main(String[] args) throws Exception
	{
		List<int[]> data=new ArrayList<>();
		data.add(new int[]{7,14});
		data.add(new int[] {8,16});
		data.add(new int[]{16,3});
		data.add(new int[] {13,7});

		int n=data.size();
		int sum_x=0;
		int sum_y=0;
		for(int i=0;i<n;i++)
		{
			sum_x+=data.get(i)[0];
			sum_y+=data.get(i)[1];
		}

		sum_x/=data.size();
		sum_y/=data.size();

		int cx=sum_x;
		int cy=sum_y;

		double[][] matrix=new double[data.size()+1][data.size()];
		for(int i=0;i<data.size();i++)
		{
			int x=data.get(i)[0];
			int y=data.get(i)[1];
			matrix[0][i]=Math.sqrt((x-cx)*(x-cx) + (y-cy)*(y-cy));
		}

		for(int i=0;i<data.size();i++)
		{
			int x=data.get(i)[0];
			int y=data.get(i)[1];

			
			for(int j=i;j<data.size();j++)
			{
				int x1=data.get(j)[0];
				int y1=data.get(j)[1];
				
				matrix[i+1][j]=Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
				
			}
		}

		PrintWriter out=new PrintWriter(new File("cluster_out.csv"));
		out.printf("%s,"," ");
		for(int i=0;i<data.size();i++)
		{
			out.printf("%s,","P"+(i+1));
		}
		
		out.printf("\n");


		for(int i=0;i<=data.size();i++)
		{
			if(i==0)
				out.printf("%s,","C");
			else
				out.printf("%s,","P"+i);
			for(int j=0;j<data.size();j++)
			{
				out.printf("%.3f,",matrix[i][j]);
			}
			out.printf("\n");
		}
		out.close();
	}
}
