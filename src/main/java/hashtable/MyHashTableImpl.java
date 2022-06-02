package hashtable;

import java.lang.reflect.Array;

public class MyHashTableImpl<Key, Value> implements MyHashTable<Key, Value> {

    // Declaración de una constante
    // static - variable de clase
    // final - un espacio de memoria invariante
    private static final int INITIAL_SIZE = 10;

    private HashTableNode<Key, Value>[] elements;

    public MyHashTableImpl() {
        elements = new HashTableNode[MyHashTableImpl.INITIAL_SIZE];
    }

    @Override
    public void put(Key k, Value v) {
        // FIXME agregar control de facto de carga para duplicar tabla de hash

        // Aplicar mi función de hash a la key para determinar posición

        int position = k.hashCode() % elements.length;

        // Verificar si esa posición esta libre si lo esta colocar el elemento

        if (elements[position] == null || elements[position].isDeleted() ||
                elements[position].getKey().equals(k)) { // FIXME isDeleted
            HashTableNode<Key, Value> node = new HashTableNode<>(k, v);

            elements[position] = node;

        } else {
            int nroColision = 1;
            int newPosition = 0;

            do {
                newPosition = (k.hashCode() + colision(nroColision)) % elements.length;
                nroColision++;
            } while (elements[newPosition] != null && !elements[newPosition].isDeleted() &&
                    nroColision < elements.length);

            if (nroColision < elements.length) {
                HashTableNode<Key, Value> node = new HashTableNode<>(k, v);

                elements[newPosition] = node;
            }
        }

        // Si hay colisión usar función de colisión para determinar proxima posición
    }

    private int colision(int intento) {
        return intento;
    }

    @Override
    public Value get(Key k) {
        int position = k.hashCode() % elements.length;
        Value exit = null;

        if (this.elements[position] != null) {
            if (!this.elements[position].isDeleted() && this.elements[position].getKey().equals(k)) {
                exit = this.elements[position].getValue();
            } else {
                int nroColision = 1;
                int newPosition = 0;

                do {
                    newPosition = (k.hashCode() + colision(nroColision)) % elements.length;
                    nroColision++;
                } while (elements[newPosition] != null &&
                        ! this.elements[newPosition].getKey().equals(k) &&
                        nroColision < elements.length);

                if (nroColision < elements.length) {

                    if (elements[newPosition] != null && !this.elements[newPosition].isDeleted()) {

                        exit = this.elements[newPosition].getValue();

                    }

                }
            }
        }

        return exit;
    }

    @Override
    public void remove(Key k) {

    }

    @Override
    public int size() {
        return 0;
    }

}
