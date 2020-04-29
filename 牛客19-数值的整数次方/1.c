常规求幂
int pow1(int a,int b){
   int r=1;
   while(b--) r*=a;
   return r;
} 

快速求幂（一般）
int pow2(int a,int b){
    int r=1,base=a;
    while(b!=0){
    if(b%2) r*=base;
    base*=base;
    b/=2;
    }
    return r;
}

快速求幂 （递归）
int f(int m,int n){   //m^n
    if(n==1) return m;
    int temp=f(m,n/2);
    return (n%2==0 ? 1 : m)*temp*temp;
}

快速求幂（位运算）
int pow3(int x,int n){
  if(n==0) return 1;
  else {
    while((n&1)==0){
      n>>=1;
      x*=x;
    }
  }
  int result=x;
  n>>=1;
  while(n!=0){
    x*=x;
    if(n&1) result*=x;
    n>>=1;
  }
  return result;
}
完整快速幂代码
#include<bits/stdc++.h>
using namespace std;
long long quickpower(long long x,long long y)
{
    long long ans=1,cnt=x;
    while(y)
    {
        if(y&1)
        {
            ans*=cnt;
        }
        cnt*=cnt;
        y>>=1;
    }
    return ans;
}
int main()
{
    long long x,y,ans;
    cin>>x>>y;
    ans=quickpower(x,y);
    cout<<ans;
    return 0;
}