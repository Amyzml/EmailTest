package com.zml.xml;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;



import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zml.test.Entitys;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class XMlTest {
	public static String JsonToXml(Object json ){
		 if(json==null){  
	            return null;  
	       }else{  
	    	  Element elements = new Element("xml");
	         getXMLFromObject(json,"xml",elements);  
	         XMLOutputter xmlOut = new XMLOutputter();    
	         String res=xmlOut.outputString(elements);  
	         return res;  
	       }  
	 }

	private static void getXMLFromObject(Object obj, String tag,
			Element parent) {
		
		
		 if(obj==null)  
	            return;  
	        Element child;  
	        String eleStr;  
	        Object childValue;  
	        if(obj instanceof JSONObject)  
	        {  
	            JSONObject jsonObject = (JSONObject)obj;  
	            for(Object temp:jsonObject.keySet())  
	            {  
	                eleStr=temp.toString();  
	                childValue=jsonObject.get((String) temp);  
	                child=new Element(eleStr);  
	                if(childValue instanceof JSONArray)  
	                    getXMLFromObject(childValue,eleStr,parent);  
	                else{  
	                    parent.addContent(child);  
	                    getXMLFromObject(childValue,eleStr,child);  
	                }  
	            }  
	        }else if(obj instanceof JSONArray){  
	            JSONArray jsonArray = (JSONArray)obj;  
	            for(int i=0;i<jsonArray.size();i++)  
	            {  
	                childValue=jsonArray.get(i);  
	                child=new Element(tag);  
	                parent.addContent(child);  
	                getXMLFromObject(childValue,tag,child);  
	            }  
	        }else if(obj instanceof Date){  
	            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	            parent.setText(sf.format((Date)obj));  
	        }else{  
	            parent.setText(obj.toString());  
	        }  
	    }  
		
	 public static String listtoXml(List list) throws Exception {  
		 	Document document = DocumentHelper.createDocument();  
	        //org.dom4j.Element nodesElement = document.addElement("servlers");
	        org.dom4j.Element nodesElement2 = document.addElement("servler");
	        
	        int i = 0;
	        for (Object o : list) {
	        	//org.dom4j.Element nodeElements = nodesElement.addElement("node");  
	        	 org.dom4j.Element nodeElement = nodesElement2.addElement("nodes");  
	        	for (int j = 0; j < list.size(); j++) {
	        		org.dom4j.Element nodElement = nodeElement.addElement("node");  
	        		
	        		 nodElement.setText(String.valueOf( list.get(j)));
				}
	        	
		            i++;  
			}
	 
	        
	      /*  int i = 0;  
	        for (Object o : list) {  
	            org.dom4j.Element nodeElement = nodesElement.addElement("node");  
	            if (o instanceof Map) {  
	                for (Object obj : ((Map) o).keySet()) {  
	                    org.dom4j.Element keyElement = nodeElement.addElement("key");  
	                    keyElement.addAttribute("label", String.valueOf(obj));  
	                    keyElement.setText(String.valueOf(((Map) o).get(obj)));  
	                }  
	            } else {  
	                org.dom4j.Element keyElement = nodeElement.addElement("key");  
	                keyElement.addAttribute("label", String.valueOf(i));  
	                keyElement.setText(String.valueOf(o));  
	            }  
	            i++;  
	        }  */
	        return doc2String(document); 
	    }  
	  
	  
	private static String doc2String(Document document) {
		 String s = "";  
	        try {  
	            // 使用输出流来进行转化  
	            ByteArrayOutputStream out = new ByteArrayOutputStream();  
	            // 使用UTF-8编码  
	            OutputFormat format = new OutputFormat("   ", true, "UTF-8");  
	            XMLWriter writer = new XMLWriter(out, format);  
	            writer.write(document);  
	            s = out.toString("UTF-8");  
	        } catch (Exception ex) {  
	            ex.printStackTrace();  
	        }  
	        return s;  
	    }  
	

	public static void main(String[] args) {  
		
		
	System.out.println(new Date().getTime());
		
		
		List<Entitys> entitys = new ArrayList<Entitys>();
		
		Entitys entitys2 = new Entitys("192.168.100.28", "48", "414073453@qq.com", "414073453@qq.com", "tom","123456", "ceshi",true);
		//Entitys entitys3 = new Entitys("192.168.100.28", "48", "414073453@qq.com", "414073453@qq.com", "tom","123456", "ceshi",true);
		entitys.add(entitys2);
		//entitys.add(entitys3);
		
		Document document = DocumentHelper.createDocument();  
        //org.dom4j.Element nodesElement = document.addElement("servlers");
        org.dom4j.Element nodesElement2 = document.addElement("servler");
        
        int i = 0;
        for (Object o : entitys) {
        	//org.dom4j.Element nodeElements = nodesElement.addElement("node");  
        	 org.dom4j.Element nodeElement = nodesElement2.addElement("nodes");  
        	for (int j = 0; j < entitys.size(); j++) {
        		org.dom4j.Element nodElement = nodeElement.addElement("host");  
        		
        		 nodElement.setText(String.valueOf(entitys.get(j).getHost()));
			}
        	
	            i++;  
		}
        doc2String(document); 
        
        System.out.println( doc2String(document));
        System.out.println( document);
        
        
		try {
			//listtoXml(entitys);
			//System.out.println(entitys);
			//System.out.println(listtoXml(entitys));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	/*  JSONObject rootObject=new JSONObject();  
	       
	      JSONArray dataArray=new JSONArray();  
	      JSONObject dataObject1=new JSONObject();  
	      dataObject1.put("PERSONID", "35020500200610000000000701355117");  
	      dataObject1.put("XM", "吴聪楠");  
	      dataObject1.put("SFZH","350624198908052530");  
	      dataArray.add(dataObject1); 
	      
	      JSONObject dataObject2=new JSONObject();  
	      dataObject2.put("PERSONID", "35020500200610000000000701355116");  
	      dataObject2.put("XM", "吴聪楠2");  
	      dataObject2.put("SFZH","350624198908052531");  
	      dataArray.add(dataObject2);  
	      
	      JSONObject dataRootObject=new JSONObject();  
	      dataRootObject.put("Row", dataArray);  
	      JSONObject dataObject=new JSONObject();  
	      dataObject.put("Status", "00");  
	      dataObject.put("ErrorMsg", "");  
	      dataObject.put("Data",dataRootObject);  
	      rootObject.put("ROOT", dataObject);  
	        
	      System.out.println(rootObject.toString());  
	      System.out.println(JsonToXml(rootObject));          
	          
	    }*/
	}
}
