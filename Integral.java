/*подсчет интеграла 3 методами*/

import java.util.Scanner;

public class Integral{
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);

    	System.out.print("\n====> Fanction: ");
    	fanction();

    	System.out.println("\n*Enter the first value --> [liwer limit] ==> (x1)");
    	double x1=Double.parseDouble(sc.nextLine());
    	System.out.println("\n*Enter the second value --> [upper limit] ==> (x2)");
    	double x2=Double.parseDouble(sc.nextLine());
    	System.out.println("\n*Enter the amount of line ==> (n)");
    	int n=Integer.parseInt(sc.nextLine());
    	double dx=(x2-x1)/n;

    	if(x1>x2)              System.out.println("attention: X1 < X2");

    	while(true){
    		System.out.println("\nHow do you calculate the Integral? [enter 1 to 5]\n\n\t1)Rectangle method\n\t2)Trapezoid method\n\t3)Simson Method\n\t4)all :D\n\t\t\t5)stop,please");
    		String command=sc.nextLine();

    		switch(command){
    		case "1":
    			System.out.println("\n==> This is the [rectangle] method: "+calcSquare(x1,x2,dx));
    			break;

    		case "2":
    			System.out.println("==> This is the [trapezoid] method: "+calcSumTrap(x1,x2,dx,n));
    			break;

    		case "3":
    			System.out.println("==> This is the   [Simson]  method: "+calcSimson(x1,x2,n));
    			break;

    		case "4":
    			System.out.println("\n==> This is the [rectangle] method: "+calcSquare(x1,x2,dx));
    			System.out.println("==> This is the [trapezoid] method: "+calcSumTrap(x1,x2,dx,n));
    			System.out.println("==> This is the   [Simson]  method: "+calcSimson(x1,x2,n));
    			break;
    		case "5":
    			System.out.println("\n~~~ Thank you :3 ~~~\n     Goodbye");
    			System.exit(0);

    		default:
    			System.out.println("What do you want from me? Try again))");
    			break;
		    }
    	}
	}

	public static void fanction(){
		System.out.println("3x*x*x - 2x*x + x - 23");
	}

	public static double f(double x){
		double y=3*x*x*x-2*x*x+x-23.0;
		return y;
	}

	public static double calcSquare(double x1,double x2,double dx){
		double sum=0.0;
		while(x1<=x2){
			sum+=dx*f(x1);
			x1+=dx;
		}
		return sum;
	}

	public static double calcSumTrap(double x1,double x2,double dx,int n){
		double sum=0.0;
		for(double i=1;i<=n;i++){
			sum+=(f(x1)+f(x1+dx))/2*dx;
			x1+=dx;
		}
		return sum;
	}

    public static double calcSimson(double x1,double x2,int n){
		double y=((x2-x1)/6.0)*(f(x1)+4*f((x1+x2)/2.0)+f(x2));
		return y;
	}
}