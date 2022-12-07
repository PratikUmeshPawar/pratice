#include<bits/stdc++.h>
using namespace std;
vector<int> calmin(vector<vector<double>>arr)
{
    int tr,tc;
    vector<int>v;
    double min1=arr[1][0];
    int cnt=0;
   // cout<<arr.size()<<"hi"<<endl;

       for(int i=0;i<arr.size();i++)
       {
            for(int j=i+1;j<arr[i].size();j++)
            {
                if(min1>arr[i][j])
                {
                    min1=arr[i][j];
                    tr=j;
                    tc=i;
                }
                else if(min1==arr[i][j])
                {
                    if(cnt==0)
                    {
                        tr=j;
                        tc=i;
                    }
                    cnt++;
                }
            }
       }
       cout<<min1<<endl;
    v.push_back(tr);
    v.push_back(tc);
    return v;

}
int main()
{
    fstream fin("points.csv",ios::in);
    vector<vector<string> > content;
    vector<string> row;
    string line, word;
    if(fin.is_open())
    {
        while(getline(fin,line))
        {
           // cout<<line<<endl;
            row.clear();
            stringstream s(line);
            while(getline(s,word,','))
            {
                    row.push_back(word);
            }
            content.push_back(row);
        }
    }
    vector<vector<double>>arr(content.size(),vector<double>(content.size(),0.0));
    // vector<vector<double>>arr{{0,0.71,5.66,3.61,4.24,3.20},
    // {0.71,0,4.95,2.92,3.54,2.50},
    // {5.66,4.95,0,2.24,1.41,2.50},
    // {3.61,2.92,2.24,0,1.00,0.50},
    // {4.24,3.54,1.41,1.00,0,1.12},
    // {3.20,2.50,2.50,0.50,1.12,0}};
    for(int i=0;i<arr.size();i++)
    {
        for(int j=0;j<arr.size();j++)
        {
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
    double arr1[content.size()][content.size()];
    for(int i=0;i<content.size();i++)
    {
        for(int j=i+1;j<content.size();j++)
        {
            double ans=0;
            for(int k=0;k<content[0].size();k++)
            {
               ans+=pow(stoi(content[i][k])-stoi(content[j][k]),2);
            }
           // cout<<ans<<" ";
            ans=sqrt(ans);
            arr[i][j]=ans;
            arr[j][i]=ans;
        }
    }
    vector<string>v(arr.size(),"");
    for(int i=0;i<v.size();i++)
    {
        v[i]=to_string(i);
    }
    int tr,tc;
    double min1=arr[1][0];
    while(arr.size()!=2)
    {
        vector<int>pos=calmin(arr);
        tr=pos[0];
        tc=pos[1];
        if(tr<tc)
        {
            v[tr]="("+v[tr]+","+v[tc]+")";
            v.erase(v.begin()+tc);
        }
        else
        {
            v[tc]="("+v[tc]+","+v[tr]+")";
            v.erase(v.begin()+tr);
        }
       //cout<<tr<<tc<<endl;
       //break;
       for(int i=0;i<arr.size();i++)
       {
                if(tr<tc && tr!=i)
                {
                    arr[tr][i]=min(arr[tr][i],arr[tc][i]);
                    arr[i][tr]=arr[tr][i];
                }
                else if(tc<tr && tc!=i)
                {
                     arr[tc][i]=min(arr[tr][i],arr[tc][i]);
                    arr[i][tc]=arr[tc][i];
                }
       }
       if(tr<tc)
       {
         arr.erase(arr.begin()+tc);
          for(int i=0;i<arr.size();i++)
            {
                arr[i].erase(arr[i].begin()+tc);
            }
       }
       else
       {
            arr.erase(arr.begin()+tr);
            for(int i=0;i<arr.size();i++)
            {
                arr[i].erase(arr[i].begin()+tr);
            }
       }  
       for(int i=0;i<arr.size();i++)
       {
        for(int j=0;j<arr.size();j++)
        {
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
       }   
      
     }
     v[0]="("+v[0]+","+v[1]+")";
     cout<<v[0];

}
