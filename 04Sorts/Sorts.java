public class Sorts{
    
    public static String name(){
	return "10.Zheng.Stephanie";
    }

    public static int[] selectionSort(int[] data){
	int location;
	int temp;
	for(int x=0; x<data.length; x++){
	    location=x;
	    for(int y=x;y<data.length;y++){
		if(data[y]<data[location]){
		    location=y;
		}
	    }
	    temp=data[x];
	    data[x]=data[location];
	    data[location]=temp;
	}
	return data;
    }

    public static String toString(int[] data){
	String ans="[";
	for(int x=0;x<data.length;x++){
	    if(x==data.length-1){
		ans+=data[x];
	    }else{
		ans+=data[x]+",";
	    }
	}
	return ans+="]";
    }

    public static void main(String[]args){
    }
    
}
		
    
