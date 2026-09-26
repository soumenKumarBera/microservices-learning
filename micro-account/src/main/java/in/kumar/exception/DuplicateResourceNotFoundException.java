package in.kumar.exception;

public class DuplicateResourceNotFoundException extends RuntimeException {

    public DuplicateResourceNotFoundException(){
        super("DUPLICATE RESOURCE FOUND EXCEPTION");
    };

    public DuplicateResourceNotFoundException(String customMess ){
        super(customMess);
    };


}
