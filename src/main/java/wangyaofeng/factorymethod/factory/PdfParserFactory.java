package wangyaofeng.factorymethod.factory;

import wangyaofeng.factorymethod.product.Parser;
import wangyaofeng.factorymethod.product.PdfParser;

public class PdfParserFactory implements ParserFactory {
    @Override
    public Parser createParser() {
        return new PdfParser();
    }
}
