package in.sri.test.designpatterns.iterator;

public class Language {

    private String name;
    
    public Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
 
    private static class LanguageIterator implements Iterator<Language> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Language next() {
            return null;
        }
        
    }
}
