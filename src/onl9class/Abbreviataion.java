package onl9class;

import java.util.Map;


public class Abbreviataion {
	
	public static String abbr3(String a, String b) {
		int alen = a.length();
		int blen = b.length();
		Boolean[][] checkAbbr = new Boolean[alen+1][blen+1];
		checkAbbr[0][0] = true;
		char achar,bchar;
		int bpos ;
		for(int j=1;j<=blen;j++)checkAbbr[0][j] = false;
		for(int i=1;i<=alen;i++) {
			achar = a.charAt(i-1);
			checkAbbr[i][0] = checkAbbr[i-1][0] && Character.isLowerCase(achar);
			for(int j=1;j<=blen;j++) {
				bchar= b.charAt(j-1);
				if(Character.isUpperCase(achar)) {
					if(achar==bchar) {
						checkAbbr[i][j] = checkAbbr[i-1][j-1];
					}else {
						bpos =b.indexOf(achar);
						if(bpos>=0)  {
							checkAbbr[i][j] = false;
						}else {
							return "NO";
						}
						
					}
				}else {
					if(achar==Character.toLowerCase(bchar)) {
						checkAbbr[i][j] = checkAbbr[i-1][j-1]||checkAbbr[i-1][j];
					}else {
						checkAbbr[i][j]=checkAbbr[i-1][j];
					}
				}
			}
		}
		return checkAbbr[alen][blen]?"YES":"NO";
	}
	
	public static String abbr(String a, String b) {
		int j = b.length()-1;
		for(int i = a.length()-1;i>=0 && j>=0;i--) {
			if(Character.isUpperCase(a.charAt(i))) {
				if(a.charAt(i)==b.charAt(j)) {
					j--;
				}else {
					System.out.println(a.charAt(i)+" "+b.charAt(j));
					//return "NO";
				}
			}else {
				if(a.charAt(i)==b.charAt(j)||Character.toUpperCase(a.charAt(i))==b.charAt(j)) {
					j--;
				}
			}
			
		}
		return j==-1?"YES":"NO";
	}
	public static Boolean abbr2(String a, String b, Map<String, Boolean> mem) {
		if(a.length()==0) {
			return b.length()==0;
		}
		int l1 = a.length()-1;
		Boolean result =false;
		if(b.length()==0) {
			if( (Character.isUpperCase(a.charAt(l1)))) {
				
				return false;
			}
			else {
				result = abbr2(a.substring(0, l1),b,mem) ;
				mem.put(l1+"-0", result);
				return result;
			}
			 
		}
		
		int l2 = b.length()-1;
		if(mem.containsKey(l1+"-"+l1)) {
			return mem.get(l1+"-"+l2);
		}
		
		if( (Character.isUpperCase(a.charAt(l1)))) {
			if(a.charAt(l1) != b.charAt(l2))
				return false;
			else {
				result = abbr2(a.substring(0, l1),b.substring(0, l2),mem);
			}
		}else if(a.charAt(l1) == b.charAt(l2) || Character.toUpperCase(a.charAt(l1))==b.charAt(l2) ){
			result = abbr2(a.substring(0, l1),b.substring(0, l2),mem) || abbr2(a.substring(0, l1),b,mem) ;
		}else {
			result = abbr2(a.substring(0, l1),b,mem);
		}
		mem.put(l1+"-"+l2, result);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//System.out.println(abbr3("ssssssssssssssssssssiisssissstsssssssssssssssssssssssssstsssslssssgsissstsssssssssslssssssssssssisssssssssisssssitssssssstslsssssssssssssssssssssstsssssssssssssbssssstsssssspssssssssssssssssssssssssssspssssssssssssssssssspssssssssssitsslissssssssssssssssssssssssssssssssssssssssssssssisssssslsslsssstsssssssssssslsssssssisssssssssssstsssssisssssssssssslsssssssssssssssssssssssssssssssssssssssssssssssssslstsssssssssssissssssssisssssssssspsssssssssssssssssssssssspsssssissssssssissssssssstspsssssstssssssssssslssslspssssssssssssssssisssssssssssssssssisssspssssssssssisssssssssssssssssstsssssssissssssssssssssssspslsssssssssstssssspsssssnssssslsssssssssssssssssssssissssssssssssssstsslssssssssssspsssssssssssisssssssssssssssstssssssssstsssslssspsssssssssssssspississspssssssssssstsssslpssssssssissssssssssssssssssssssstssssssssssssisssssssssssssslsssssssssssstsssssssssssisssssssssssssssssssssssssssstssssissssssssssssssssssssssssssspslsssssssissssssissssssssssssssspssssssssssssssssssssssssssissssssls","SSSSSSSSSSSSSSSSSIISSSSSTSSSSSSSSSSSSSSSSSSSSSSSSSSSLSSSSSISSTSSSSSSSSLSSSSSSSSSISSSSSSSSSSSITSSSSSTSLSSSSSSSSSSSSSSSSSSTSSSSSSSSSSSSSTSSSSSPSSSSSSSSSSSSSSSSSSSSSSSPSSSSSSSSSSSSSSSSSSSSITSSISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSISSSSSLSSLSSSTSSSSSSSSSLSSSSSSISSSSSSSSSSSTSSSSISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSLSTSSSSSSSSSSISSSSSSSSSSSSSSSPSSSSSSSSSSSSSSSSSSSPSSSSSSSSISSSSSSSSSPSSSSSSSSSSSSLSSSSPSSSSSSSSSSSSSSSSISSSSSSSSSSSSSSSISSSPSSSSSSSSISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSPSLSSSSSSSTSSSPSSSSSSSLSSSSSSSSSSSSSSSSISSSSSSSSSSSSSSTSLSSSSSSSSSSSPSSSSSSSISSSSSSSSSSSSSTSSSSSSSSTSSSSSSSSSSSSSSSPISSISSSPSSSSSSSSSSTSSSSLPSSSSISSSSSSSSSSSSSSSSSSSSSSTSSSSSSSSSSSISSSSSSSSLSSSSSSSSTSSSSSSSSSSSSSSSSSSSSSSSSSSSSSTSSSSSSSSSSSSSSSSSSSSSSPLSSSSSSISSSSSISSSSSSSSSSPSSSSSSSSSSSSSSSSSSSSSISSSS"));
		System.out.println(abbr3("aBrEe","BRE"));
		//System.out.println("aBrEe".charAt(4));
		System.out.println(abbr3("AfPZN","APZNC"));
		System.out.println(abbr3("LDJAN","LJJM"));
		System.out.println(abbr3("UMKFW","UMKFW"));
		System.out.println(abbr3("KXzQ","K"));
		System.out.println(abbr3("LIT","LIT"));
		System.out.println(abbr3("QYCH","QYCH"));
		System.out.println(abbr3("DFIQG","DFIQG"));
		System.out.println(abbr3("sYOCa","YOCN"));
		System.out.println(abbr3("JHMWY","HUVPW"));
		
		
		
		
		
		
		
		
	}

}
