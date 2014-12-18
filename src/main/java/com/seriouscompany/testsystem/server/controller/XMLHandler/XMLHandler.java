package com.seriouscompany.testsystem.server.controller.XMLHandler;

/**
 *
 * @author Igor
 */
public class XMLHandler {

//     public static boolean loadData() throws JDOMException, IOException {
//        SAXBuilder builder = new SAXBuilder();
//        File xmlFile = new File("testRepository.xml");
//        if (xmlFile.exists()) {
//            Document document = (Document) builder.build(xmlFile);
//            Element rootNode = document.getRootElement();
//            List testsList = rootNode.getChildren();
//            for (int i = 0; i < testsList.size(); i++) {
//                Element test = (Element) testsList.get(i);
//                List nodesList = test.getChildren();
//                for(int j = 0; j < nodesList.size(); j++) {
//                    Element theme = (Element) nodesList.get(j);
//                    Book book = new Book(bookNode.getChildText("name"),
//                            themeNode.getAttribute("name").getValue(),
//                            bookNode.getChildText("autor"),
//                            bookNode.getChildText("year"));
//                    int position = Integer.parseInt(bookNode.getChildText("fileNameIndex"));
//                    Connect.specBookList.add(position, book);
//                    Connect.namesBooks.add(position, bookNode.getChildText("fileName"));
//                }
//            }
//            return true;
//        } else {
//            return false;
//        }
//    }
}
