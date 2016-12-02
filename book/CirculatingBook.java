public class CirculatingBook extends LibraryBook{
    String currentHolder;
    String dueDate;

    public CirculatingBook(String authorName, String bookName, String numbers, String numberCall){
	setTitle(bookName);
	setAuthor(authorName);
	setIsbn(numbers);
	setCallNumber(numberCall);
	currentHolder=null;
	dueDate=null;
    }

    public String getCurrentHolder(){
	String x=currentHolder;
	return x;
    }

    public String getDueDate(){
	String x=dueDate;
	return x;
    }

    public void setCurrentHolder(String x){
	currentHolder=x;
    }

    public void setDueDate(String x){
	dueDate=x;
    }

    public void checkout(String patron, String due){
	setCurrentHolder(patron);
	setDueDate(due);
    }

    public void returned(){
	setCurrentHolder(null);
	setDueDate(null);
    }

    public String circulationStatus(){
	if(currentHolder==null){
	    return "book available on shelves";
	}else{
	    return this.toString();
	}
    }

    public String toString(){
	return currentHolder+", "+dueDate;
    }

}
