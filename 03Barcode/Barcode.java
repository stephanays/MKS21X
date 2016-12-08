public class Barcode implements Comparable<Barcode>{
    private String _zip;

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

    private int checkSum(){
	int sum=0;
	for(int x=0; x<_zip.length(); x++){
	    sum+=(_zip.charAt(x)-'0');
	}
	return sum%10;
    }

    public String barcodeImage(){
	String full=_zip+this.checkSum();
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

    public static String toImage(String code){
	String image="|";
	String pattern="";
	for(int x=0; x<code.length(); x++){
	    switch(code.charAt(x)){
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
	return image+"|";
    }

    public static String toCode(String image){
	String[] reference={"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
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
	    
	return code;
    }
	    
	

    public String toString(){
	String ans=_zip+this.checkSum()+"   "+"|"+this.barcodeImage()+"|";
	return ans;
    }

    public int compareTo(Barcode other){
	String a=_zip+this.checkSum();
	String b=other._zip+other.checkSum();
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
	System.out.println(toCode("|||:::|::|::|::|:|:|::::|||::|:|"));
	System.out.println(toImage("084518"));
    }
    
}
