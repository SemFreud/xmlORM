package com.flyd.xmlRel;


import com.flyd.javaobj.genobj.GenObj;
import com.flyd.utils.CharasetUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class XMLTest {

    public static void main(String[] args) {
        XMLParseObj();
    }

    public static String createXMLStr(){
        StringBuilder stringBuilder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuilder.append("<BookList>");
        stringBuilder.append("<book>");
        stringBuilder.append("<name></name>");
        stringBuilder.append("<author></author>");
        stringBuilder.append("<price></price>");
        stringBuilder.append("</book>");
        stringBuilder.append("</BookList>");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void eachNode(Node node){
        NodeList list = node.getChildNodes();
        CLASS_NAME = node.getNodeName();
        fileds = new String[list.getLength()];
        Node tempNode = null;
        for(int i = 0  ; i< list.getLength() ; i++)
        {
            tempNode = list.item(i);
            System.out.println(tempNode.getNodeName());
            fileds[i] = tempNode.getNodeName();
        }
    }
public static String CLASS_NAME;
    public static String[] fileds ;
    public static void XMLParseObj(){
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream in = new ByteArrayInputStream(createXMLStr().getBytes());
            Document document = builder.parse(in);
            Node node = document.getFirstChild();

            eachNode(node.getFirstChild());
            System.out.println(CLASS_NAME);
            System.out.println(Arrays.toString(fileds));
            GenObj.genJavaModel(CharasetUtil.toUp(CLASS_NAME),fileds);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
