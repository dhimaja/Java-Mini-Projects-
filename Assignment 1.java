import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


	
	public static boolean isRecordValid(String student){       // method to check if the record is valid or not 
	
			String[] stArray = student.split("\\s+"); // split the student record array
			String stName = stArray[0];              // stores the first attribute ie student name 
			System.out.println(stName);              // prints the name of student
			String studentId = stArray[1];
			Integer stMark1 = Integer.parseInt(stArray[2]);  // converts student mark1 from string to integer
			Integer stMark2 = Integer.parseInt(stArray[3]);   // converts student mark2 from string to integer
			char ch=stName.charAt(0);                        // reads the first char of name
			String regex = "^[a-zA-Z]+$";                    
			Pattern pattern = Pattern.compile(regex);
			 Matcher matcher = pattern.matcher(stName);
			if(stArray.length !=5){                          // checks the condition if the student array length is 5 or not 
				return false;                            // if not, returns false
			}else if(Character.isUpperCase(ch)){             // checks the condition if the first character of student name is uppercase or not 
				return false;                            // if not, returns false
			}else if(!matcher.matches())
			 {
				 return false;
			}else if(studentId.length()!=6){                 // checks the condition if the  student ID name is not of length 6         
				return false;                            // if satisfied , returns false 
			}else if(!(stMark1>=0 && stMark1<=40) &&!(stMark2>0 && stMark2<=70)){ // checks the condition if the  student mark1 lies in the range ,  
				return false;
			}else{	                                                                    if not , returns false.
		  return true;
			}
	}
	
	public static boolean checkRedundantRecords(String[] records)   // method to check duplicate records
	{
		String stString = new String();               //  creates a new string student object to check the redundancy
		boolean isDup = false;                        // by default the isdul is set to false 
		for(String student : records){               // loop to check the attributes of every student of the record 
			
		   String[] stArray = student.split("\\s+");    // split the student record array 
		   String st= stArray[0]+stArray[1]+stArray[4];  // takes in the studnet name, studentId and student phone number and stores them in st variable  
			if(stString.contains(st)){              // loop to check if the new string contains duplicate records 
				isDup=true;                    // the condition returns true for isDup.
				break;
			}
			stString = stString+st;                // else the attributes are added into new string object 
		}
		return isDup;
		
	}

	public static int inquiryTotalMarkWithName(String[] records, String name)  // method to inquire total marks with name
	{
		int Studentsum = 0;
		for(int i=0;i<records.length;i++){	// using for loop to increment student record 			
			String str = records[i];        // creating a string variable of records
			String[] stArray = str.split("\\s+"); // spliting the string of attributes
			String studentName = stArray[0];    // stores the first attribute ie student name 
			int mark1 = Integer.parseInt(stArray[2]); // converts student mark1 from string to integer
			int mark2 = Integer.parseInt(stArray[3]);   // converts student mark2 from string to integer
			int sum = mark1+mark2;                    // performs the sum of marks 
			System.out.println("---name---"+name +"StudentName--->>>"+studentName);
			if(name.equals(studentName)){             // checks if name equals student name 
				System.out.println("---equal");
				Studentsum = sum;                   //  assigns sum to the respective student 
				break;
			}else{
				Studentsum = -1;                   // else returns -1
			}
				
		}
		return Studentsum;
	}
	
	public static int numberOfGoodMark(String[] records)
	{
		int numOfStudents=0;                                    // initially num of students is 0
		for(int i=0;i<records.length;i++){
			
			String str = records[i];                       // using for loop to increment student record 		
			String[] stArray = str.split("\\s+");          // spliting the string of attributes
			int mark1 = Integer.parseInt(stArray[2]);       // converts student mark1 from string to integer
			int mark2 = Integer.parseInt(stArray[3]);       // converts student mark2 from string to integer
			int sum = mark1+mark2;                           // performs the sum of marks 
			if(mark1>30 && mark2>45 && sum>80){              // checks if mark1 is greater than 30 and mark2>45 and sum greater than 80 for good marks
				numOfStudents++;                         // increments the student count 
			}
				
		}
		return numOfStudents;                                 // returns num of students 
	}

	
	 
		public static int numberOfMarksInRange(String[] records, int lowMark, int highMark)  // method to check number of marks in given range 
		{
			int numOfStudents=0;                                         // initially num of students is 0
			for(int i=0;i<records.length;i++){
				
				String str = records[i];        
				String[] stArray = str.split("\\s+");       // spliting the string of attributes
				int mark1 = Integer.parseInt(stArray[2]);  // converts student mark1 from string to integer
				int mark2 = Integer.parseInt(stArray[3]);    // converts student mark2 from string to integer
				int sum = mark1+mark2;                      // performs the sum of marks 
				if(sum>=lowMark && sum<=highMark){        // checks if sum is greater than or equal to lowmarks and less than or equal to highmarks
					numOfStudents++;                // increments the student count 
				}
					
			}
			
			return numOfStudents;
		}
		
		public static int inquiryTotalMarkWithID(String[] records, String id) // method to inquire total  marks with id
		{
			int Studentsum = 0;                            // initially the student sum is set to 0
			for(int i=0;i<records.length;i++){		 // using for loop to increment student record		
				String str = records[i];                 // creating new var str with an assigned student record  
				String[] stArray = str.split("\\s+");    // spliting the string of attributes
				String studentId = stArray[1];           // assigning index 1 to the studentid in record 
				int mark1 = Integer.parseInt(stArray[2]); // converts student mark1 from string to integer
				int mark2 = Integer.parseInt(stArray[3]);   // converts student mark2 from string to integer
				int sum = mark1+mark2;                       // performs the sum of marks
				if(id.equals(studentId)){                      // checks if entered id equals studentid  
					Studentsum = sum;                     // assigns sum to the respective studnet
					break;
				}else{
					Studentsum = -1;
				}
					
			}
			return Studentsum;
			
		}
		public static int inquiryNumberOfFail(String[] records)    //method to inquire number of fails 
		{
			int numOfStudents=0;                                   // initially num of students is 0
			for(int i=0;i<records.length;i++){                  // using for loop to increment student record	
				
				String str = records[i];                    // creating new var str with an assigned student record 
				String[] stArray = str.split("\\s+");       // spliting the string of attributes
				int mark1 = Integer.parseInt(stArray[2]);   // converts student mark1 from string to integer
				int mark2 = Integer.parseInt(stArray[3]);   // converts student mark2 from string to integer
				int sum = mark1+mark2;                      // performs the sum of marks
				if(mark1<20 || mark2<30 || sum<60){         // checks if mark1 is less than 20 or mark2 is less than 30 or if the sum is less than 60 for counting the failed students
					numOfStudents++;                    // increments the studnet count if condition satisfied 
				}			
			}
			
			return numOfStudents;                              // returns the number of students           
		}

		public static int inquiryTotalMarkWithRank(String[] records, int rank)  // method to inquire total marks with rank 
		{
			int totalMark=0;                                              //initially the totalmarks is 0
			int[] studentSumArray = new int[records.length];       // assigning the record length size to the studentsumarrray
			for(int i=0;i<records.length;i++){                    // using for loop to increment student record
				
				String str = records[i];                      // creating new var str with an assigned student record 
				String[] stArray = str.split("\\s+");          // spliting the string of attributes
				int mark1 = Integer.parseInt(stArray[2]);     // converts student mark1 from string to integer
				int mark2 = Integer.parseInt(stArray[3]);     // converts student mark2 from string to integer
				int sum = mark1+mark2;                        // performs the sum of marks
				studentSumArray[i] = sum;		    // assings sum to the studentsumarray
			}
			if(rank<studentSumArray.length){                    // checks the condition if rank is less than studentsumarray length
				Arrays.sort(studentSumArray);             // sorts the array in ascending order
				int temp;
				for( int i = 0; i < studentSumArray.length/2; ++i ) // for loop to check the ranks 
				{ 
				  temp = studentSumArray[i]; 
				  studentSumArray[i] = studentSumArray[studentSumArray.length - i - 1]; 
				  studentSumArray[studentSumArray.length - i - 1] = temp; 
				}
				totalMark = studentSumArray[rank-1];  
				return totalMark;
						
			}else{
				totalMark = -1;
			}
			return totalMark;
		}



