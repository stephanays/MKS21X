public class Book{
    private String author;
    private String title;
    private String isbn;
    
    public Book(){
	author="";
	title="";
	isbn="";
    }
    
    public Book(String authorName, String bookName, String numbers){
	author=authorName;
	title=bookName;
	isbn=numbers;
    }
    
    public void setAuthor(String x){
	author=x;
    }
 
    public void setTitle(String x){
	title=x;
    }
    
    public void setIsbn(String x){
	isbn=x;
    }
    
    public String getAuthor(){
	String x=author;
  return x;
    }
    
    public String getTitle(){
	String x=title;
	return x;
    }
    
    public String getIsbn(){
	String x=isbn;
	return x;
    }
 
    public String toString(){
	return title+", "+author+", "+isbn;
    }
    
    public static void main(String[] args)
    {
	System.out.println("Hello world!");
    }
    
}
