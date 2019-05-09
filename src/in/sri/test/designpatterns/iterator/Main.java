package in.sri.test.designpatterns.iterator;

public class Main {

    public static void main(String[] args) {
        LanguageCollection languageCollection = new LanguageCollection();
        languageCollection.add(new Language("tamil"));
        languageCollection.add(new Language("english"));
        languageCollection.add(new Language("hindi"));
        
        Iterator<Language> languageIterator = languageCollection.iterator();
        while (languageIterator.hasNext()) {
            Language language = languageIterator.next();
            System.out.println(language.getName());
        }
    }
    
}
