package groupwork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Registrar {
    public static void add(String category, DomainObject value) {
        if (!_cache.containsKey(category)) {
            _cache.put(category, new List<DomainObject>());
        }
        
        List<DomainObject> values = _cache.get(category);
        values.add(value);
        _cache.put(category, values);
    }
    
    public static DomainObject get(String category, String name) {
        List<DomainObject> values = _cache.get(category);
        Iterator<DomainObject> valuesIterator = values.iterator();
        while (valuesIterator.hasNext()) {
            //TODO check if what want
            DomainObject currentValue = valuesIterator.next();
            if (currentValue.name() == name) {
                return currentValue;
            }
        }
        return null;
    }
    
    private static Map<String, List<DomainObject>> _cache = new HashMap<String,List<DomainObject>>();
}
