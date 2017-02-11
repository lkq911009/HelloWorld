package au.edu.unsw.soacourse.validater;

import java.io.InputStream;  
import java.util.ArrayList;  
import java.util.List;  
  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node; 

/**
 * @author air
 *
 */
public class LicenceParser {
    public List<DriverLicenseBean> getRecords(InputStream inputStream) throws Exception{  
        List<DriverLicenseBean> list = new ArrayList<DriverLicenseBean>();  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder = factory.newDocumentBuilder();  
        Document document = builder.parse(inputStream);  
        Element element = document.getDocumentElement();  
          
        NodeList recordNodes = element.getElementsByTagName("Person");  
        for(int i=0;i<recordNodes.getLength();i++){  
            Element recordElement = (Element) recordNodes.item(i);  
            DriverLicenseBean record = new DriverLicenseBean();   
            NodeList childNodes = recordElement.getChildNodes();  
//          System.out.println("*****"+childNodes.getLength());  
            for(int j=0;j<childNodes.getLength();j++){  
                if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){  
                    if("fullname".equals(childNodes.item(j).getNodeName())){  
                    	record.setFullName(childNodes.item(j).getFirstChild().getNodeValue());  
                    }else if("licenceNumber".equals(childNodes.item(j).getNodeName())){  
                    	record.setLicenceNum(childNodes.item(j).getFirstChild().getNodeValue());  
                    }  
                }  
            }//end for j  
            list.add(record);  
        }//end for i  
        return list;  
    }  
}
 