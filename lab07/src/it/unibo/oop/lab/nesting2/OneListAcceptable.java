package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

    private final List<T> list;

    public OneListAcceptable(List<T> list) {
	this.list = list;
    }
    
    @Override
    public Acceptor<T> acceptor() {
	Iterator<T> iterator = list.iterator();
	return new Acceptor<T>() {

	    @Override
	    public void accept(T newElement) throws ElementNotAcceptedException {
		try {
                    if (newElement.equals(iterator.next())) {
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("no more element to be evaluated");
                }
                throw new Acceptor.ElementNotAcceptedException(newElement);
	    }

	    @Override
	    public void end() throws EndNotAcceptedException {
		try {
                    if (!iterator.hasNext()) {
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("2" + e.getMessage());
                }
                throw new Acceptor.EndNotAcceptedException();
	    }  
	};
    }

}
