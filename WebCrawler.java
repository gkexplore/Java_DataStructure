package com.java.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/****
* Breadth First Search - Web Crawler 
*  Downloads the web page and prints out all urls on the web page.
*  Gives an idea of how Google's spider crawls the web. Instead of
*  looking for hyperlinks, we just look for patterns of the form:
*  http:// followed by an alternating sequence of alphanumeric
*  characters and dots, ending with a sequence of alphanumeric 
*****/
public class WebCrawler {
	
	public static void main(String[] args){
		WebCrawler crawler = new WebCrawler();
		crawler.discoverWeb("http://www.bbc.com");
	}
	
	private Queue<String> queue;
	private List<String> discoveredWebsiteList;
	
	public WebCrawler(){
		this.queue = new LinkedList<String>();
		this.discoveredWebsiteList = new ArrayList<String>();
	}
	
	public void discoverWeb(String root){
		this.queue.add(root);
		this.discoveredWebsiteList.add(root);
		while(!queue.isEmpty()){
			String topUrl  = this.queue.remove();
			String rawHtml = getRawHtml(topUrl);
			String regex = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern =  Pattern.compile(regex);
			Matcher matcher = pattern.matcher(rawHtml);
			while(matcher.find()){
				String url = matcher.group();
				if(!this.discoveredWebsiteList.contains(url)){
					System.out.println("Website has been found with url:"+url);
					this.discoveredWebsiteList.add(url);
					this.queue.add(url);
				}
			}
		}
		
	}

	private String getRawHtml(String topUrl) {
		String rawHtml = "";
		try{
			URL url = new URL(topUrl);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String webContent = "";
			while((webContent = in.readLine())!= null){
				rawHtml += webContent;
			}
			in.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return rawHtml;
	}
}
