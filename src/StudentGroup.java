import java.util.*;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */

import java.util.*;

public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		if(students!=null)
			return students;
		else
			return null;
	
		
	}

	@Override
	public void setStudents(Student[] students)throws IllegalArgumentException {
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException();
		else
			this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length){
			throw new IllegalArgumentException();
		}
		else{
		return students[index];
		}
	//return null;
	}

	@Override
	public void setStudent(Student student, int index)throws IllegalArgumentException {
		// Add your implementation here
		if(student==null || index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else{
			this.students[index]=student;
			}
		}

	@Override
	public void addFirst(Student student)throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		Student s1=students[0];
		students[0]=student;
		Student s12;
		for(int i=1;i<students.length;i++)
		{
		s12=students[i];
		students[i]=s1;
		s1=s12;
		}
	}

	@Override
	public void addLast(Student student)throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		for(int i=0;i<students.length;i++)
		{
		if(students[i]==null){
		students[i]=student;
		break;
		}
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student==null || index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		Student s1=students[index];
		students[index]=student;
		Student s12;
		for(int i=index+1;i<students.length;i++)
		{
		s12=students[i];
		students[i]=s1;
		s1=s12;
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length)
			throw new IllegalArgumentException();
		for(int i=index;i<students.length-1;i++)
		{
			students[i]=students[i+1];
		}
	}

	@Override
	public void remove(Student student)throws IllegalArgumentException {
		// Add your implementation here
		int c=0;
		if(student==null)
			throw new IllegalArgumentException();
		for(int i=0;i<students.length;i++)
		{
		if(students[i]==student)
		{
		for(int j=i;j<students.length-1;j++)
		{
			students[j]=students[j+1];
		}
		c++;
		break;
			
		}
		}
		if(c==0)
			throw new IllegalArgumentException("Student not exist");
	}

	@Override
	public void removeFromIndex(int index)throws IllegalArgumentException {
		// Add your implementation here
		if(index<0 || index>=students.length)
			throw new IllegalArgumentException();
		else{
			for(int i=index+1;i<students.length;i++)
			{
			students[i]=null;
			}
		}			
	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		for(int i=0;i<students.length;i++)
		{
		if(students[i]==student)
		{
		for(int j=i+1;j<students.length;j++)
		{
			students[j]=null;
		}
		
		break;
			
		}
		}
	}

	@Override
	public void removeToIndex(int index) throws IllegalArgumentException{
		// Add your implementation here
		int cv=0;
		if(index<0 || index>=students.length)
			throw new IllegalArgumentException();
		for(int i=index+1;i<students.length;i++)
		{
		students[cv++]=students[i];
		}
		for(int i=cv;i<students.length;i++)
		{
		students[i]=null;
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int c=0;
		if(student==null)
			throw new IllegalArgumentException();
		for(int i=0;i<students.length;i++)
		{
		if(students[i]==student)
		{
		for(int j=i+1;j<students.length;j++)
		{
			students[c++]=students[j];
		}
		
		break;
		}
			
		}
		for(int i=c;i<students.length;i++)
		{
		students[i]=null;
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		

		Student s12;
		for(int i=0;i<students.length-1;i++)
		{
			for(int j=0;j<students.length-i-1;j++)
			{
				if(students[j].compareTo(students[j+1])>0){
				s12=students[j];
				students[j]=students[j+1];
				students[j+1]=s12;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date)throws IllegalArgumentException {
		// Add your implementation here
		Student[] s1=new Student[students.length];
		int c=0;
		if(date==null)
			throw new IllegalArgumentException();
		else
		{
		Date d;
		for(int i=0;i<students.length;i++)
		{
		d=students[i].getBirthDate();
			if(d.before(date) || d.equals(date))
				s1[c++]=students[i];
		}
		}
		return s1;	
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate){
		// Add your implementation here

       
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) throws IllegalArgumentException {
		// Add your implementation here
		Calendar c= Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		Date d=new Date();
		if(indexOfStudent==0)
			throw new IllegalArgumentException();
		else{
 		//Calendar cal = Calendar.getInstance();
                c.setTime(d);
		c1.setTime(students[indexOfStudent].getBirthDate());
                int year = c.get(Calendar.YEAR);
		int year1 = c1.get(Calendar.YEAR);
                 
		return year-year1;
		}
	}

	@Override
	public Student[] getStudentsByAge(int age) {
	//int a[]=new int[students.length];		
	// Add your implementation here
	//	for(int i=0;i<students.length;i++){
	//			int age=students[i].
	//}
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
	// Add your implementation here
             double max=0;
		Student[] s1=new Student[students.length];
		int check=0;
		
		for(int i=0;i<students.length;i++)
		{
			if(max<students[i].getAvgMark())
				max=students[i].getAvgMark();
		}
		for(int i=0;i<students.length;i++)
		{
		if(students[i].getAvgMark()==max)
			s1[check++]=students[i];
		}
		return s1;
	}

	@Override
	public Student getNextStudent(Student student)throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
		for(int i=0;i<students.length;i++)
		{
		if(students[i]==student)
		{
		
		return students[i+1];
		
		
		}	
		}
		}
			
		return null;
	}
}
