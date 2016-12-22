public class ReferenceBook extends LibraryBook{
    String collection;

    public void Book(String authorName, String bookName, String numbers, String numberCall, String collectionName){
	setTitle(bookName);
	setAuthor(authorName);
	setIsbn(numbers);
	setCallNumber(numberCall);
	collection=collectionName;
    }

    public String getCollection(){
	String x=collection;
	return x;
    }

    public void setCollection(String x){
	collection=x;
    }

    public void checkout(String patron, String due){
        System.out.println("cannot check out a reference book");
    }

    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
	return getTitle()+", "+getAuthor()+", "+getIsbn()+", "+circulationStatus()+", "+callNumber+", "+collection;
    }

    
	

    

    
}
