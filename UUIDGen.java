import java.util.UUID;

public class UUIDGen {

    public UUID run(){
        UUID id = UUID.randomUUID();
        return id;
    }

    public static void main(String[] arg){
        UUIDGen gen = new UUIDGen();
        System.out.println(gen.run());
    }   
}
