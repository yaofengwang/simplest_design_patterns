package factorymethod.factory;

import factorymethod.product.Parser;
import factorymethod.product.PdfParser;

public class PdfParserFactory implements ParserFactory {
    @Override
    public Parser createParser() {
        return new PdfParser();
    }
}
