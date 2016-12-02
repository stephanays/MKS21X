abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    String callNumber;

    public void Book(String authorName, String bookName, String numbers, String numberCall){
	setTitle(bookName);
	setAuthor(authorName);
	setIsbn(numbers);
	callNumber=numberCall;
    }

    public String getCallNumber(){
	String x=callNumber;
	return x;
    }

    public void setCallNumber(String x){
	callNumber=x;
    }

    abstract void checkout(String patron, String due);

    abstract void returned();

    abstract String circulationStatus();

    public int compareTo(LibraryBook x){
	return this.getCallNumber().compareTo(x.getCallNumber());
     }

    public String toString(){
	return getTitle()+", "+getAuthor()+", "+getIsbn()+", "+circulationStatus()+", "+callNumber;
    }

}
