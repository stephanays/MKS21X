import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
    SuperArray data = new SuperArray();
    int location = 0;
    
    public SuperArrayIterator(SuperArray blah, int bleh){
      this.data = blah;
      this.location=bleh;
  }

  public String next(){
    if(hasNext()){
      location++;
      return data.get(location -1);
    }
    else{
      throw new NoSuchElementException();
    }
  }

  public boolean hasNext(){
      return location < data.size();
  }

  public void remove(){
    throw new UnsupportedOperationException();
  }

}
