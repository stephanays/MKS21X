import java.util.Arrays;
public class Sorts{
    
    public static String name(){
	return "10.Zheng.Stephanie";
    }

    public static void selectionSort(int[] data){
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
    }

    public static void bubbleSort(int[] data){
	boolean swap=true;
	int temp=0;
	while(swap){
	    swap=false;
	    for(int x=0; x<data.length-1;x++){
		if(data[x]>data[x+1]){
		    temp=data[x];
		    data[x]=data[x+1];
		    data[x+1]=temp;
		    swap=true;
		}
	    }
	}
    }
	

    public static void insertionSort(int[] data){
    	for(int x=1; x<data.length; x++){
	    int key=data[x];
	    int y=x-1;
	    for(y=x-1; y>=0 && data[y]>key; y--){
		data[y+1]=data[y];
	    }
	    data[y+1]=key;
	}
    }
    
		    

    // public static String toString(int[] data){
    // 	String ans="[";
    // 	for(int x=0;x<data.length;x++){
    // 	    if(x==data.length-1){
    // 		ans+=data[x];
    // 	    }else{
    // 		ans+=data[x]+",";
    // 	    }
    // 	}
    // 	return ans+="]";
    // }

    public static void main(String[] args) {
	int[] a = {6,3,1,7,5,9,4,0,2};
	bubbleSort(a);
	System.out.println(Arrays.toString(a));
	int[] b = {};
	bubbleSort(b);
	System.out.println(Arrays.toString(b));
	int[] c = {10};
	bubbleSort(c);
	System.out.println(Arrays.toString(c));
	int[] d = {400,303,1500,1759,1618,13,11,1436,2168,1172,5280,2016,38387};
	bubbleSort(d);
	System.out.println(Arrays.toString(d));
    }
    
}
		
    
