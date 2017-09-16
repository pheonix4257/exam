class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) { //tested
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents(){
		if(students.length>0)
		  return students;
        return null;
	}

	@Override
	public void setStudents(Student[] student) throws IllegalArgumentException{
		// Add your implementation here
        if(student==null)
            throw new IllegalArgumentException();
		for(int i=0;i<student.length;i++)
			students[i]=student[i];
	}

	@Override
	public Student getStudent(int index)  throws IllegalArgumentException{
		// Add your implementation here
		if(index>=0&&index<students.length)
			return students[index];
        else
           throw new IllegalArgumentException(); 
	
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException{  //tested
		// Add your implementation here
       if(student==null)
           throw new IllegalArgumentException(); 
       if(index>=0&&index<students.length) 
		 students[index]=student;
       else
        throw new IllegalArgumentException(); 
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException{
		if(student==null)
           throw new IllegalArgumentException(); 
        int i;
		if(students.length==0)
			students[0]=student;
		else
		{ 
            Student a;
            for(i=0;i<students.length&&(a=this.getStudent(i))!=null;i++);
			for(;i>0;i--){
				students[i]=students[i-1];
            }
			students[0]=student;
		}
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException{ //tested
		// Add your implementation here
        if(student==null)
           throw new IllegalArgumentException(); 
        int i;
        Student a;
        for(i=0;i<students.length&&(a=this.getStudent(i))!=null;i++);
		this.setStudent(student, i);
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException{
		// Add your implementation here
        if(student==null)
           throw new IllegalArgumentException(); 
        if(index<0&&index>=students.length) 
            throw new IllegalArgumentException(); 
        int len;
        Student a;
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        if(index==0)
            this.addFirst(student);
        else if(index==len)
            this.addLast(student);
        else
        {
            for(int i=len;i!=index;i--)
                students[i]=students[i-1];
            this.setStudent(student,index);
        }		
	}
    public void remove(int index) throws IllegalArgumentException//tested
    {
        int len,i;
        Student a;
        if(index<0&&index>=students.length) 
            throw new IllegalArgumentException(); 
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        if(index==len-1)
           students[len-1]=null;
        else
        {
            for(i=index;i<len-1;i++)
            {
                students[i]=students[i+1];
            }
            students[len-1]=null;
        }
        
    }
	public void remove(Student student) throws IllegalArgumentException//tested
    {
        int i;
        if(student==null)
           throw new IllegalArgumentException(); 
        for(i=0;i<students.length;i++){
            if(students[i].equals(student)){
                this.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Student not exist");
    }
	public void removeFromIndex(int index) throws IllegalArgumentException//tested
    {
        int len;
        Student a;
        if(index<0&&index>=students.length) 
            throw new IllegalArgumentException(); 
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        for(int i=index+1;i<len;i++)
            students[i]=null;
    }
	public void removeFromElement(Student student) throws IllegalArgumentException//tested
    {
        
        for(int i=0;;i++){
            if(students[i].equals(student)){
                this.removeFromIndex(i);
                return;
            }
        }
    }
	public void removeToIndex(int index) throws IllegalArgumentException//tested
    {
        if(index<0&&index>=students.length) 
            throw new IllegalArgumentException(); 
        for(int i=0;i!=index;i++){
            this.remove(0);
            System.out.println(i);
        }
       
    }
	public void removeToElement(Student student) throws IllegalArgumentException//tested
    {
        for(int i=0;;i++){
            if(students[i].equals(student)){
                this.removeToIndex(i);
                return;
            }
        }
    }
	public void bubbleSort(){//tested
        int len,i,j;
        Student a;
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        for(i=0;i<len-1;i++)
        {
            for(j=i+1;j<len;j++)
            {
                if(students[i].compareTo(students[j])>0){
                    a=students[i];
                    students[i]=students[j];
                    students[j]=a;
                }
            }
        }
        
    }
	public Student[] getByBirthDate(Date date) throws IllegalArgumentException //checked
    {
        int len,i,j,count=0;
        Student a;
        if(date==null) 
            throw new IllegalArgumentException(); 
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        for(i=0;i<len;i++)
        {
            if(students[i].getBirthDate().compareTo(date)<=1)
                count++;
        }
        Student[] s=new Student[count]; 
        count=0;
        for(i=0;i<len;i++)
        {
            if(students[i].getBirthDate().compareTo(date)<=1)
                s[count++]=students[i];
        }
        return s;
    }
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws IllegalArgumentException //checked
    {
        int len,i,j,count=0;
        Student a;
        if(firstDate==null||lastDate==null) 
            throw new IllegalArgumentException(); 
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        for(i=0;i<len;i++)
        {
            if(students[i].getBirthDate().compareTo(firstDate)>=0&&students[i].getBirthDate().compareTo(lastDate)<=0)
                count++;
        }
        Student[] s=new Student[count]; 
        count=0;
        for(i=0;i<len;i++)
        {
            if(students[i].getBirthDate().compareTo(firstDate)>=0&&students[i].getBirthDate().compareTo(lastDate)<=0)
                s[count++]=students[i];
        }
        return s;
    }
	public Student[] getNearBirthDate(Date date, int days) throws IllegalArgumentException//checked
    {
        int len,i,j,count=0;
        Student a;
        if(date==null) 
            throw new IllegalArgumentException(); 
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        for(i=0;i<len;i++)
        {
            if((students[i].getBirthDate()).compareTo(date)==0)
                count++;
            else
            {
                 Calendar calendar1 = new GregorianCalendar();
                 Calendar calendar2 = new GregorianCalendar();
                 calendar1.setTime(date);
                 calendar2.setTime(students[i].getBirthDate());
                 int year1 = calendar1.get(Calendar.YEAR);
                 int year2 = calendar2.get(Calendar.YEAR);
                 int month1 = calendar1.get(Calendar.MONTH);
                 int month2 = calendar2.get(Calendar.MONTH);
                 int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
                 int day2 = calendar2.get(Calendar.DAY_OF_MONTH);
                 if(year1==year2&&month1==month2&&day1>day2&&day1<=days+day2)
                     count++;
            }
        }
        Student[] s=new Student[count]; 
        count=0;
        for(i=0;i<len;i++)
        {
            
            if((students[i].getBirthDate()).compareTo(date)==0)
                 s[count++]=students[i];
            else
            {
                 Calendar calendar1 = new GregorianCalendar();
                 Calendar calendar2 = new GregorianCalendar();
                 calendar1.setTime(date);
                 calendar2.setTime(students[i].getBirthDate());
                 int year1 = calendar1.get(Calendar.YEAR);
                 int year2 = calendar2.get(Calendar.YEAR);
                 int month1 = calendar1.get(Calendar.MONTH);
                 int month2 = calendar2.get(Calendar.MONTH);
                 int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
                 int day2 = calendar2.get(Calendar.DAY_OF_MONTH);
                 if(year1==year2&&month1==month2&&day1>day2&&day1<=days+day2)
                     s[count++]=students[i];
            }
        }
        return s;
    }
	public int getCurrentAgeByDate(int indexOfStudent) throws IllegalArgumentException //checked
    {
            if(indexOfStudent==0) 
            throw new IllegalArgumentException(); 
            Date d=students[indexOfStudent].getBirthDate();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(d);
            int year = calendar.get(Calendar.YEAR);
            return 2017-year;
        
    }
	public Student[] getStudentsByAge(int age) //checked
    {
        
        int len,i,j,count=0,max=-32768;
        Student a;
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        for(i=0;i<len;i++)
        {
            Date date=students[i].getBirthDate();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            if(2017-year==age)
                count++;
        }
        Student[] s=new Student[count]; 
        count=0;
        for(i=0;i<len;i++)
        {
            Date date=students[i].getBirthDate();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            if(2017-year==age)
                s[count++]=students[i];
        }
        return s;
        
    }
	public Student[] getStudentsWithMaxAvgMark() //checked
    {
        int len,i,j,count=0;
        double max=-32768;
        Student a;
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        for(i=0;i<len;i++)
        {
            if(students[i].getAvgMark()>max)
                max=students[i].getAvgMark();
        }
        for(i=0;i<len;i++)
        {
            if(students[i].getAvgMark()==max)
                count++;
        }
        Student[] s=new Student[count]; 
        count=0;
        for(i=0;i<len;i++)
        {
            if(students[i].getAvgMark()==max)
                s[count++]=students[i];
        }
        return s;
        
    }
	public Student getNextStudent(Student student) throws IllegalArgumentException//tested
    {
        if(student==null)
           throw new IllegalArgumentException(); 
        int len,i,j,count=0;
        Student a;
        for(len=0;len<students.length&&(a=this.getStudent(len))!=null;len++);
        for(i=0;i<len;i++)
        {
            if(students[i].equals(student))
                return students[i+1];
        }
        a=null;
        return a;
    }
    
} 