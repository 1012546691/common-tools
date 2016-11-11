package util.xml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 使用DOM解析XML.
 * 使用DOM解析XML通常需要加载整个文档和构造层次结构，然后才能做任何工作，适合较小的文档.
 * @author nagsh
 *
 */
public class DOMUtil {

	/**
	 * 将XML文档转为字符串.
	 * @param path 文档路径
	 * @param codeStyle  编码格式
	 * @return xml字符串
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerException
	 */
	public String parseString(String path,String codeStyle) throws ParserConfigurationException, SAXException, IOException, TransformerException{
        //获取文档
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(path);
		//转换
		TransformerFactory  transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty("encoding", codeStyle);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		transformer.transform(new DOMSource(document), new StreamResult(stream));
		return stream.toString();
	}
}
