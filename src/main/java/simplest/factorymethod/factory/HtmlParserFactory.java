package simplest.factorymethod.factory;

import simplest.factorymethod.product.HtmlParser;
import simplest.factorymethod.product.Parser;

public class HtmlParserFactory implements ParserFactory {
    @Override
    public Parser createParser() {
        return new HtmlParser();
    }
}
