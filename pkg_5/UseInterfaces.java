package pkg_5;
interface CanReadLiterature<Litarature> {
    public void read( Literature text );
}
interface CanWriteLiterature {
    public void write( Literature text );
}
abstract class Literature implements CanReadLiterature, CanWriteLiterature {
    
    private     String  art;
    private     String  title;
    private     int     page;

    public Literature buyLiterature(Literature readable, double money){
        // check book is available, money is enough, etc ...
        return readable;
    }

}

class Newspaper extends Literature {
    public void read(Literature text ){  }
    public void write(Literature text){ }
    
}

class Book extends Literature {
    public void read(Literature text ){  }
    public void write(Literature text){ }
}

class Letter extends Literature {
    public void read(Literature text ){  }
    public void write(Literature text){ }

}

public class UseInterfaces{


    public static void main(String[] args){
        Book JulesVerne_20kMilesBelowSea = new Book();  
    }

}
