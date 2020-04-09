package simplest.factorymethod.factory;

import simplest.factorymethod.product.Parser;

public interface ParserFactory {
    Parser createParser();
}
