package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("key.1","value1"));
        attributes.add(new Attribute("key.2","value2"));
        attributes.add(new Attribute("key.3",null));
        Map<String,String> maps = attributes.stream().collect(Collectors.toMap(Attribute::getAttributeName,Attribute::getAttributeValue));
        System.out.println(maps);

    }
}
