package groupwork.refactor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RegistrarJ {
    public static void add(String category, DomainObjectJ value) {
        if (!_cache.containsKey(category)) {
            _cache.put(category, new List<DomainObjectJ>());
        }
        
        List<DomainObjectJ> values = _cache.get(category);
        values.add(value);
        _cache.put(category, values);
    }
    
    public static DomainObjectJ get(String category, String name) {
        List<DomainObjectJ> values = _cache.get(category);
        Iterator<DomainObjectJ> valuesIterator = values.iterator();
        while (valuesIterator.hasNext()) {
            //TODO check if what want
            DomainObjectJ currentValue = valuesIterator.next();
            if (currentValue.name() == name) {
                return currentValue;
            }
        }
        return null;
    }
    
    private static Map<String, List<DomainObjectJ>> _cache = new HashMap<String,List<DomainObjectJ>>();
}
