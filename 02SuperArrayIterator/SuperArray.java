public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;
    
    public SuperArray(){
	size=0;
	data=new String[10];
    }
    
    public SuperArray(int initialCapacity){
	size=0;
	if(initialCapacity<0){
	    throw new IllegalArgumentException();
	}else{
       	    data=new String[initialCapacity];
	}
    }
    
    public boolean add(String n){
	if (size+1>data.length){
	    grow();
	}
	data[size]=n;
	size=size+1;
	return true;
    }

    public void add(int index, String element){
	if(index <0 || index>size()){
	    throw new IndexOutOfBoundsException();
	}
	if (size+1>data.length){
	    grow();
	}
	String[]temp=new String[data.length];
	if(index>0){
	    for(int x=0; x<index; x=x+1){
		temp[x]=data[x];
	    }
	}
	for(int x=index; x<size; x=x+1){
	    temp[x+1]=data[x];
	}
	size=size+1;
	temp[index]=element;
	data=temp;
    }
    
    public String get(int index){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }
    
    public int size(){
	return size;
    }
    
    public String toString(){
	String newstr="[";
	int x=0;
	for(x=0; x<size; x=x+1){
	    if(x==size-1){
		newstr=newstr+data[x];
	    }else{
		newstr=newstr+data[x]+",";
	    }
	}
	newstr=newstr+"]";
	return newstr;
    }
    
    public String toStringDebug(){
    	String newstr="[";
    	for(int x=0;x<data.length;x=x+1){
    	    if(x<size){
    		newstr=newstr+data[x]+",";
    	    }else{
    		if(x==data.length-1){
    		    newstr=newstr+"_";
    		}else{
    		    newstr=newstr+"_,";
    		}
    	    }
    	}
    	newstr=newstr+"]";
    	return newstr;
    }

    public void clear(){
	String[]empty=new String[10];
	size=0;
	data=empty;
    }

    public boolean isEmpty(){
	if(size==0){
	    return true;
	}else{
	    return false;
	}
    }

    public String set(int index, String element){
	data[index]=element;
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	return element;
    }

    public void grow(){
	String[]temp=new String[data.length*2];
	for(int x=0;x<size; x=x+1){
	    temp[x]=data[x];
	}
	    data=temp;
    }
    
    public String remove(int index){
	if(index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}
	String[]temp=new String[data.length];
	String ans=data[index];
	if(index>0){
	    for(int x=0; x<index; x=x+1){
		temp[x]=data[x];
	    }
	}
	for(int x=index; x<size;x=x+1){
	    temp[x]=data[x+1];
	}
	size=size-1;
	data=temp;
	return ans;
    }
    
    public String[] toArray(){
	String[] ans= new String[data.length];
	for(int x=0; x<size; x=x+1){
	    ans[x]=data[x];
	}
	return ans;
    }
    
    public int indexOf(String i){
	int ans=-1;
	for(int x=0; x<size;x=x+1){
	    if(i.compareTo(data[x])==0){
		ans=x;
		break;
	    }
	}
	return ans;
    }

    public int lastIndexOf(String i){
	int ans=-1;
	for(int x=size-1; x>=0;x=x-1){
	    if(i.compareTo(data[x])==0){
		ans=x;
		break;
	    }
	}
	return ans;
    }

    public void trimToSize(){
	String[]temp=new String[size];
	for(int x=0;x<size;x=x+1){
	    temp[x]=data[x];
	}
	data=temp;
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(data,size);
    }

    public static void main(String[] args){
	SuperArray x = new SuperArray(10);
	System.out.println(x);	
	x.add("apple");
	x.add("banana");
	x.add("cat");
	System.out.println(x);
	System.out.println(x.toStringDebug());
	x.clear();
	System.out.println(x.isEmpty());
	SuperArray y = new SuperArray();
	y.add("dog");
	y.add("hat");
	y.add("cap");
	System.out.println(y.set(2,"Gap"));
	System.out.println(y);
	System.out.println(y.remove(1));
	System.out.println(x.toArray());
	System.out.println(y.indexOf("Gap"));
	System.out.println(y.indexOf("gap"));
	y.add("dog");
	y.add("hat");
	y.add("cap");
	y.add("dog");
       	System.out.println(y);
	System.out.println(y.indexOf("dog"));	
	System.out.println(y.lastIndexOf("dog"));
	y.add(2,"XD");
	y.add(3,"Deez");
	y.add(3,"Deez");
	System.out.println(y);
	System.out.println(y.toStringDebug());
    }
}
