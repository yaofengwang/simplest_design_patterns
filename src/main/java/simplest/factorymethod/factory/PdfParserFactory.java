package simplest.factorymethod.factory;

import simplest.factorymethod.product.Parser;
import simplest.factorymethod.product.PdfParser;

public class PdfParserFactory implements ParserFactory {
    @Override
    public Parser createParser() {
        return new PdfParser();
    }
}
