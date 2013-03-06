package com.caimingqin.app.util;


public class XmlUtil {

	private StringBuffer xml = null;

	
    public XmlUtil(StringBuffer xml) {
		this.xml = xml;
	}

	public String getXml()
    {
        return "<Root>"+this.xml.toString()+"</Root>";
    }

    public  void addNode(String strNode)
    {
    	this.xml.append("<"+ strNode+" ");
    }

    public  void addNodeEnd()
    {
    	this.xml.append(" />");
    }

    public  void addNodeValue(String strKey, String strValue)
    {
    	this.xml.append(" " + strKey + "=\"" + strValue+"\"");
    		
    }
}
