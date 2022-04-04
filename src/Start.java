import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.Student;
import com.student.StudentDAO;

public class Start {



	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		System.out.print("Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       while(true)
       {
    	   System.out.println(" Press 1 to Add Student");
    	   System.out.println(" Press 2 to DELETE Student");
    	   System.out.println(" Press 3 to display Student");
    	   System.out.println(" Press 4 to exit Student");
    	   int c=Integer.parseInt(br.readLine());
    	   if(c==1)
    	   {
    		   //add
    		   System.out.println(" Enter name");
    		   String name=br.readLine();
    		   System.out.println(" Enter phone no");
    		   String phone=br.readLine();
    		   Student stu = new Student(name,phone);
    		  boolean ans= StudentDAO.insertStudentTODB(stu);
    		  if(ans)
    		  {
    			   System.out.println("Student added");
    		  }
    		  else
    		  {
    			  System.out.println("Something went wrong dude!");
    		  }
    		  System.out.println(stu);
    	   }
    	   else if(c==2)
    	   {
    		   //del
    		   System.out.println(" Enter studentId");
    		   int stuId=Integer.parseInt(br.readLine());
    		   boolean ans= StudentDAO.deleteStudent(stuId);
    			  if(ans)
        		  {
        			   System.out.println("Student deleted");
        		  }
        		  else
        		  {
        			  System.out.println("Something went wrong dude!");
        		  }
    		   
    	   }
    	   else if(c==3) {
    		   //display
    		   StudentDAO.showAll();
    	   }
    	   else if(c==4)
    	   {
    		   //exit 
    		   break;
    		   
    	   }
    	   else
    	   {
    		   
    	   }
       }
       System.out.println("Thankyou for using the application!");
	}

}
