import hashtable.MyHashTable;
import hashtable.MyHashTableImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyHashTableTest {

    @Test
    public void testHashTableBasic() {
        Persona persona1 = new Persona(1234l, "Daniel", "Rivera");
        Persona persona2 = new Persona(4567l, "Eduardo", "San Jose");
        Persona persona3 = new Persona(4444l, "Antonio", "Trinidad");
        Persona persona4 = new Persona(1234l, "Analia", "Rivera");


        MyHashTable<Long, Persona> hashPersonaCedula = new MyHashTableImpl<>();

        hashPersonaCedula.put(persona1.getCedula(), persona1);
        hashPersonaCedula.put(persona2.getCedula(), persona2);
        hashPersonaCedula.put(persona3.getCedula(), persona3);
        hashPersonaCedula.put(persona4.getCedula(), persona4);

        // se chequea que se encuentre 2 personas
        Assertions.assertNotNull(hashPersonaCedula.get(1234l));
        Assertions.assertNotNull(hashPersonaCedula.get(4444l));

        // Se verifia que la persona 1234 se haya realmente pisado el valor por la ultima persona

        Assertions.assertEquals("Analia", hashPersonaCedula.get(1234l).getNombre());
    }

}
