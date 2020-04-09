package wangyaofeng.factorymethod.product;

public class PdfParser implements Parser {
    @Override
    public String parse(String pdfFileName) {
        return "{'name':'zhang'}";
    }
}
