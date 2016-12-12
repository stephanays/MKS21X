public class Barcode implements Comparable<Barcode>{
    private String _zip;
    public static String[] reference={"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    
    public Barcode(String zip){
	if(!(zip.length()==5)){
	    throw new IllegalArgumentException("zip is not the correct length");
	}
	for(int x=0; x<zip.length();x++){
	    if(zip.charAt(x)<'0'  || zip.charAt(x)>'9'){
		throw new IllegalArgumentException("zip has non-digit elements");
	    }
	}
	_zip=zip;
    }
    
    private static int checkSum(String zip){
	int sum=0;
	for(int x=0; x<zip.length(); x++){
	    sum+=(zip.charAt(x)-'0');
	}
	return sum%10;
    }
    
    public String barcodeImage(){
	String full=_zip+checkSum(_zip);
	String image="";
	String pattern="";
	for(int x=0; x<full.length(); x++){
	    switch(full.charAt(x)){
	            case '1':
			pattern=":::||";
			break;	
		    case '2':
			pattern="::|:|";
			break;
		    case '3':
			pattern="::||:";
			break;
		    case '4':
			pattern=":|::|";
			break;
		    case '5':
			pattern=":|:|:";
			break;
		    case '6':
			pattern=":||::";
			break;
		    case '7':
			pattern="|:::|";
			break;
		    case '8':
			pattern="|::|:";
			break;
		    case '9':
			pattern="|:|::";
			break;
		    case '0':
			pattern="||:::";
			break;
		}
	    image+=pattern;
	}	
	return image;
    }
    
    public static String toCode(String zip){
	if(!(zip.length()==5)){
	    throw new IllegalArgumentException("zip is not the correct length");
	}
	for(int x=0; x<zip.length();x++){
	    if(zip.charAt(x)<'0'  || zip.charAt(x)>'9'){
		throw new IllegalArgumentException("zip has non-digit elements");
	    }
	}
	String image="|";
	String pattern="";
	for(int x=0; x<zip.length(); x++){
	    image+=reference[Integer.parseInt(zip.substring(x,x+1))];
	    image+=pattern;
	}
	return image+"|";
    }

    public static String toZip(String image){
	if(image.length()!=32){
	    throw new IllegalArgumentException("length of barcode is not 32");
	}
      	if(((image.substring(0,1)).compareTo("|")!=0) || (image.substring(31).compareTo("|")!=0)){
	  throw new IllegalArgumentException("the left and rightmost characters are not '|'");
	}
	
	for(int x=0; x<image.length();x++){
	    if((image.charAt(x)!='|') || (image.charAt(x)!=':')){
		throw new IllegalArgumentException("non-barcode characters are used");
	    }
	}
	String noEnds=image.substring(1,32);
	String code="";
	int num=0;
	for(int x=0;x<noEnds.length()-5;x=x+5){
	    for(int y=0;y<reference.length;y++){
		if((reference[y].compareTo(noEnds.substring(x,x+5)))==0){
		    num=y;
		}
	    }
	    code+=num;
	}
	if(code.length()!=6){
	    throw new IllegalArgumentException("encoded ints are invalid");
	}
	if(Integer.parseInt(code.substring(5))!=checkSum(code)){
	    throw new IllegalArgumentException("checksum is invalid");
	}
	return code;
    }
	    
	

    public String toString(){
	String ans=_zip+checkSum(_zip)+"   "+"|"+this.barcodeImage()+"|";
	return ans;
    }

    public int compareTo(Barcode other){
	String a=_zip+checkSum(_zip);
	String b=other._zip+checkSum(other._zip);
	return (Integer.valueOf(a)).compareTo(Integer.valueOf(b));
    }

    public static void main(String args[]){
	Barcode b = new Barcode("08451");
	Barcode c = new Barcode("99999");
	Barcode d = new Barcode("11111");
	System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
	System.out.println(b.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(b.compareTo(b)); //0
	System.out.println(c.compareTo(b));
	System.out.println(d.compareTo(b));
	/*length
	  Barcode e = new Barcode("123456");
	  System.out.println(e);
	*/
	/*length
	  Barcode e = new Barcode("1234");
	  System.out.println(e);
	*/
	/*type
	  Barcode e= new Barcode("12.45");
	  System.out.println(e);
	*/
	System.out.println(toZip("|||:::|::|::|::|:|:|::::|||::|:|"));
	System.out.println(toCode("084518"));
    }
    
}
