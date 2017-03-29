package Utilities;
import java.math.BigInteger;
import java.util.Random;

public class bcp {
	boolean make=false;
	static int bitlength=1024;
	//public static final BigInteger  BigInteger.ONE;
	int certainty=1;
public class pp_para
{
	BigInteger n;
	BigInteger k;
	BigInteger g;
	 BigInteger n2;
	}
pp_para PP=new pp_para();
 public class xianmen{
	 BigInteger a;
	 BigInteger b;
 }
 xianmen s=new xianmen();//密文的两个陷门a和b 
	public  BigInteger pk,sk;
		BigInteger pp;
		BigInteger qq;
	int l;
	BigInteger supermk;
	BigInteger constant0=new BigInteger("0");
	BigInteger constant4=new BigInteger("4");
	BigInteger constant2=new BigInteger("2");
	public bcp(int certainty){
		 BigInteger pp,qq;
		 BigInteger p =BigInteger.ONE;
		 BigInteger q =BigInteger.ONE;
	do {
		do {
				pp=BigInteger.probablePrime(bitlength/2-1, new Random());
			    p=(pp.multiply(constant2)).add(BigInteger.ONE);
		} while(p.isProbablePrime(certainty)==false);
		System.out.print("pp and p have benn init\n");
		do {
				qq =BigInteger.probablePrime(bitlength/2-1, new Random());
				q=(qq.multiply(constant2)).add(BigInteger.ONE);//p=p+pp*2=2*pp+1
		} while((q.isProbablePrime(certainty)==false));//当q不为素数并且p和q不相等时 &(!((p.compareTo(q)==0)))
		PP.n=p.multiply(q);//N=p×q
	l=PP.n.bitLength();
	System.out.print("qq and q have benn init\n");;
	} while(l>1024);
	System.out.println("OK");
	PP.n2=PP.n.pow(2);
	System.out.println("N2 is               that"+PP.n2);
	
while(!make)
{
	BigInteger tmp=new BigInteger("2");
	BigInteger g=new BigInteger(bitlength,certainty,new Random());
	
	g=g.subtract(BigInteger.ONE);
	g=g.pow(2);
	g=g.mod(PP.n2);//problem?
	if(g.compareTo(BigInteger.ONE)==0){ 
		make=false;
		continue;
		}
	tmp=g.modPow(PP.n2, p);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=g.modPow(p,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=g.modPow(pp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=g.modPow(q,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=g.modPow(qq,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=p.multiply(q);
	tmp=g.modPow(tmp,PP.n2);
	
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=p.multiply(qq);
	tmp=g.modPow(tmp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=pp.multiply(q);
	tmp=g.modPow(tmp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=pp.multiply(qq);
	tmp=g.modPow(tmp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=q.multiply(qq);
	tmp=g.modPow(tmp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=p.multiply(pp);
	tmp=g.modPow(tmp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=p.multiply(pp);
	tmp=tmp.multiply(q);
	tmp=g.modPow(tmp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
	}
	tmp=p.multiply(pp);
	tmp=tmp.multiply(qq);
	tmp=g.modPow(tmp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
		continue;
		}
	tmp=p.multiply(q);
	tmp=tmp.multiply(qq);
	tmp=g.modPow(tmp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
			make=false;
			continue;
	}
	//System.out.println("yes we can");
	tmp=pp.multiply(q);
	tmp=tmp.multiply(qq);
	tmp=g.modPow(tmp,PP.n2);
	if(tmp.compareTo(BigInteger.ONE)==0){
		make=false;
	   }
	   make=true;
	PP.g=g;
	supermk=pp.multiply(qq);
	BigInteger tmp3=PP.g.modPow(supermk, PP.n2);
	tmp3=tmp3.subtract(BigInteger.ONE);
	PP.k=tmp3.divide(PP.n);
	System.out.println("PP.n is              that"+PP.n);
	System.out.println("PP.k is              that"+PP.k);
	System.out.println("PP.g is              that"+PP.g);
	System.out.println("MK is              that"+supermk);


	}
}
	
	public void Decryption(BigInteger sk,BigInteger c,pp_para PP,xianmen s)
	{
		System.out.println("begin decryption!");
		BigInteger tmp=new BigInteger("1");
		BigInteger N2=PP.n2;
		tmp=s.a.modInverse(N2);
		tmp=tmp.modPow(sk, N2);
		tmp=tmp.multiply(s.b);
		tmp=tmp.subtract(BigInteger.ONE);
		tmp=tmp.mod(N2);
		System.out.println("tmp1 is"+tmp);
		System.out.println("n2 is"+N2);
		/*if(tmp.remainder(PP.n)!=constant0)
		{
			System.out.println("Error in decryption!\n");
			return;
		}*/
		c=tmp.divide(PP.n);
		System.out.println("c is"+c);
		}
	public void KetGeneration(pp_para PP)
	{
		BigInteger a= new BigInteger(2*bitlength,new Random());
		a=a.mod(PP.n2);
		sk=a;
		System.out.println("sk is"+a);
		BigInteger h=PP.g.modPow(sk, PP.n2);
		pk=h;
		System.out.println("pk is"+h);
		
		
	}
	public void Encryption(BigInteger pk,BigInteger m,pp_para PP)
	{	
		BigInteger tmp=new BigInteger("1");
		BigInteger r=new BigInteger(2*bitlength,new Random());//
		BigInteger a=PP.g.modPow(r, PP.n2);
		s.a=a;
		tmp=m.multiply(PP.n);
		tmp=tmp.add(BigInteger.ONE);
		BigInteger b=pk.modPow(r,PP.n2);
		b=b.multiply(tmp);
		b=b.mod(PP.n2);
		s.b=b;
		System.out.println("a is"+s.a);
		System.out.println("b is"+s.b);
		
	}
	public void Decryption_mk(pp_para PP,xianmen t,BigInteger pk)
	{
		System.out.println("开始用MK来解密");
		System.out.println("运行到这儿了");
		BigInteger seita=supermk;
		seita=seita.modInverse(PP.n);//6
		BigInteger gama;
		BigInteger c;
		BigInteger a;
		BigInteger kk=PP.k.modInverse(PP.n);
		BigInteger tmp1=(pk.modPow(supermk,PP.n2).subtract(BigInteger.ONE)).mod(PP.n2);
		a=tmp1.divide(PP.n);
		a=a.multiply(kk);
		a=a.mod(PP.n);
		System.out.println("The parameter a is"+a);
		BigInteger tmp2=(t.a.modPow(supermk,PP.n2).subtract(BigInteger.ONE));
		tmp2=tmp2.mod(PP.n2);
		tmp2=tmp2.divide(PP.n);
		tmp2=tmp2.multiply(kk);
		BigInteger r=tmp2;
		r=r.mod(PP.n);
		System.out.println("The parameter r is"+r);
		gama=r.multiply(a);
		gama=gama.mod(PP.n);
		
		BigInteger tmp3=PP.g.modInverse(PP.n2); 
		tmp3=tmp3.modPow(gama, PP.n2);
		tmp3=tmp3.multiply(s.b);
		tmp3=tmp3.modPow(supermk, PP.n2);
		tmp3=tmp3.subtract(BigInteger.ONE);
		tmp3=tmp3.divide(PP.n);
		//seita=seita.mod(PP.n);
		tmp3=tmp3.multiply(seita);
		c=tmp3.mod(PP.n);
		System.out.println("c is"+c);
	}
	public void multiply(xianmen r,xianmen s1,xianmen s2)
	{
		r.a=s1.a.multiply(s2.a);
		r.a=r.a.mod(PP.n2);
		//
		r.b=s1.b.multiply(s2.a);
		r.b=r.b.mod(PP.n2);
		
		}
	public void expconstant1ntiate(xianmen r,xianmen s1,BigInteger m)
	{
		r.a=s1.a.modPow(m, PP.n2);
		r.b=s1.b.modPow(m, PP.n2);
	}
	public void randommize(BigInteger r)
	{
		
	}
	
	public void sample_uniform(BigInteger rrand,int max){
		BigInteger rand=new BigInteger(max,new Random());
	
	      }
public static void main(String[] args) 
    {
	    long startTime=System.currentTimeMillis();   //获取开始时间
		bcp bc =new bcp(100000000);
		bc.KetGeneration(bc.PP);
		BigInteger m=new BigInteger("11111111111111111");
		long kaishijiami=System.currentTimeMillis();
		bc.Encryption(bc.pk,m,bc.PP);
		long endTime1=System.currentTimeMillis(); //获取结束时间
		System.out.println("加密时间： "+0.001*(endTime1-kaishijiami)+"s");
		bc.Decryption(bc.sk,m,bc.PP,bc.s);
		long endTime2=System.currentTimeMillis(); //获取结束时间
		System.out.println("解密时间： "+0.001*(endTime2-endTime1)+"s");
		bc.Decryption_mk(bc.PP, bc.s, bc.pk);
		long endTime3=System.currentTimeMillis();
		System.out.println("MK解密实践： "+0.001*(endTime3-endTime2)+"s");
		System.out.println("程序运行时间： "+0.001*(endTime3-startTime)+"s");

	}
	}

