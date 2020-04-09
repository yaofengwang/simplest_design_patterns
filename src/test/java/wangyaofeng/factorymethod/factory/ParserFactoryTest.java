package wangyaofeng.factorymethod.factory;

import wangyaofeng.factorymethod.product.Parser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ParserFactoryTest {

    @Test
    void createParser() {
        ParserFactory factory1 = new HtmlParserFactory();
        Parser parser = factory1.createParser();
        log.debug(parser.parse("htmlFilename"));

        ParserFactory factory2 = new PdfParserFactory();
        parser = factory2.createParser();
        log.debug(parser.parse("pdfFilename"));


    }
}