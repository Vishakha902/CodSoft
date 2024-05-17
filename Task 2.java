 import java.util.*;
class student1
{
    public static void main(String args[])
    {
        //Declaring the varibles 
        int num_of_subject,marks[],sum=0,value;
        double grade;
        String sub[];

        //Declaring input class and taking input from user  to how many subject 
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the num_of_subject: ");
        num_of_subject=input.nextInt();
        value=(num_of_subject*100);
        /*Allocat the memory to string array  */
        sub=new String[num_of_subject];
        marks=new int[num_of_subject];

        /*Processing the program */
        for(int i=0; i<num_of_subject; i++)
        {
            System.out.print("Enter the name of subject :");
            sub[i]=input.next();
        }
        for(int j=0; j<num_of_subject; j++)
        {
            System.out.print("Enter the marks of subject : ");
            marks[j]=input.nextInt();
        }
        /*Sum of the all subjects  */
        for(int l=0; l<num_of_subject; l++)
        {
            if(marks[l]<100)
            {
                sum+=marks[l];
            }
        }
        /*Calculate the percentage */
        grade=(sum*100)/value; 
        
        /*Displaying data */
        /*Printing all numbers accoding to subject */
        for(int k=0; k<num_of_subject; k++)
        {
            System.out.println(sub[k]+':'+marks[k]);
        }
        System.out.println("Sum of all subject "+sum);
        System.out.println("Grade of all subject "+grade);
        /*Allocate the grade accoding percentage */
        if(grade>90.00)
        {
            System.out.print("A");
        }
        else if (grade>70) 
        {
            System.out.print("B");    
        }
        else if(grade>40)
        {
            System.out.print("C");
        }
        else if(grade<40)
        {
            System.out.print("Fail");
        }
    }
}