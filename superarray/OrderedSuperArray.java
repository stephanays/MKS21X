public class OrderedSuperArray extends SuperArray{
    
    public OrderedSuperArray(){
	super();
    }
    
    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String[]ary){
	super();
	for(int x=0;x<ary.length; x=x+1){
	    add(ary[x]);
	}
    }

    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }

    private int home(String element){
	int ans=0;
	for(int x=0; x<size()-1; x=x+1){
	    if((get(x).compareTo(element)) > 0){
		ans=0;
		break;
	    }
	    if((get(x).compareTo(element))<=0 &&
	       (get(x+1).compareTo(element))>0){
		ans=x+1;
		break;
	    }
	}
	if(size()==1 && (get(0).compareTo(element))>0){
	    ans=0;
	}
	return ans;
    }

    public boolean add(String element){
	super.add(home(element),element);
	return true;
    }

    public void add(int index, String element){
	throw new UnsupportedOperationException();
    }
    
    public static void main(String[]args){
    }
}
    
