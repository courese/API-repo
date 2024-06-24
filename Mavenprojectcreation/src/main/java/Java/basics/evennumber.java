package Java.basics;

public class evennumber {
	int n; //global variable
	public void even(int n) //method with parameter
	{ 
		if (n>= 40) {
			
	        for (int i=n; i<=60; i++) {
	        	if(i%2==0) 	{
	        		System.out.println(i);
	        	}
	        	
	        }
	}
		else
    	{
    		System.out.println("Number is less than 40");
    	}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("even numbers are :");
		evennumber sample = new evennumber();
		sample.even(49);

	}

}
