package com.java.datastructure;
import java.util.HashMap;
import java.util.Map;

//Hulu tech interview question - solved
public class FindWord {
	public static void main(String[] args){
		String message="ihaveyourcartdfd";
		String magazine="ihaveyourcarddddtaaaf";
		System.out.println(isAccessible(message, magazine));
		System.out.println(checkUsingHashMap(message, magazine));
	}
	public static boolean isAccessible(String message, String magazine){
		String matchedString = "";
		for(char c: message.toCharArray()){
			for(char d:magazine.toCharArray()){
				
				if(c==d){
					String tempMagazine = magazine.replaceFirst(d+"", "");
					magazine = tempMagazine;
					matchedString = matchedString+c;
					break;
				}
			}
		}
		System.out.println(matchedString);
		return (matchedString.length()==message.length())?true:false;
	}
	
	public static boolean checkUsingHashMap(String message, String magazine){
		
		HashMap<String, Integer> messageMap = new HashMap<String, Integer>();
		HashMap<String, Integer> magazineMap = new HashMap<String, Integer>();
		updateMessageMap(message, messageMap);
		updateMessageMap(magazine, magazineMap);
		for(String aMessage: messageMap.keySet()){
			if(magazineMap.get(aMessage)!=null){
				System.out.println(magazineMap.get(aMessage) +"_"+ messageMap.get(aMessage));
				if(!(magazineMap.get(aMessage)>=messageMap.get(aMessage))){
					return false;
				}
			}
			else{
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void updateMessageMap(String message, HashMap<String, Integer> messageMap){
		for(int i=0;i<message.length();i++){
			if(messageMap.get(message.charAt(i)+"")==null){
				messageMap.put(message.charAt(i)+"", 1);
			}else{
				messageMap.put(message.charAt(i)+"", messageMap.get(message.charAt(i)+"")+1);
			}
		}
	}
	
}
