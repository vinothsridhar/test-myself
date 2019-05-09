package in.sri.test.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class LanguageCollection implements Collection<Language> {

    private List<Language> list;
    
    public LanguageCollection() {
        list = new ArrayList<Language>();
    }

    @Override
    public void add(Language t) {
        list.add(t);
    }

    @Override
    public Iterator<Language> iterator() {
        return new Iterator<Language>() {
            
            int position;
            
            @Override
            public Language next() {
                return list.get(position++);
            }
            
            @Override
            public boolean hasNext() {
                return position < list.size();
            }
        };
    }
    
}
