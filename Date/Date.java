// 13184648
// agodda02@mail.bbk.ac.uk

public class Date {
    
    public int day;
    public int month;
	public int maxDays;
	public String dateRepresentation;

    Date( int d, int m )
    {
		this.day = d;
		this.month = m;
		this.updateFields();
		this.validateDay();
    }
	
	public void updateFields(){
		this.setMaxDays();
		this.setStringRepresentation();
	}

	public void setMaxDays(){
		switch(this.month){
			case 2:
				this.maxDays = 28;
				break;
			case 4:
				this.maxDays = 30;
				break;
			case 6:
				this.maxDays = 30;
				break;				
			case 9:
				this.maxDays = 30;
				break;				
			case 11:
				this.maxDays = 30;
				break;	
			default:
				this.maxDays = 31;
				break;
		}
	}
	
	public void setStringRepresentation(){
		this.dateRepresentation = "";
		if (day < 10) this.dateRepresentation += "0";
		this.dateRepresentation += day;
		this.dateRepresentation += "/";
		if (month < 10) this.dateRepresentation += "0";
		this.dateRepresentation += month;
	}
	
	public void validateDay(){
		if (this.day > this.maxDays || this.month > 12){
			this.day = 1;
			this.month = 1;
			this.updateFields();
		}
	}
	
    void addDays( int n )
    {
		if (n + this.day <= this.maxDays){
			this.day += n;
		} else if (this.month == 12 && n + this.day > this.maxDays) {
			this.day = 1;
			this.month = 1;
		} else {	
			int daysUsed = this.maxDays - this.day + 1;
			int remainingDays = n - daysUsed;
			this.day = 1;
			this.month += 1;
			this.updateFields();
			if (remainingDays > 0) this.addDays(remainingDays);
		}
		
		this.updateFields();
    }

    public String toString()
    {
		return this.dateRepresentation;	
    }
	

}