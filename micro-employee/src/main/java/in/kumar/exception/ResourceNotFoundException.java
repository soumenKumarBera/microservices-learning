package in.kumar.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("RESOURCE NOT FOUND EXCEPTION");
    };

    public ResourceNotFoundException(String customMess ){
        super(customMess);
    };


}
