package Model;

/**
 * Clase Nodo para el Árbol Binario de Búsqueda
 * Representa cada nodo del árbol con valor y referencias a nodos izquierdo y derecho
 */
public class Nodo {
    private int valor;
    private Nodo izquierdo;
    private Nodo derecho;

    /**
     * Constructor por defecto
     * Inicializa un nodo sin valor ni hijos
     */
    public Nodo() {
        this.valor = 0;
        this.izquierdo = null;
        this.derecho = null;
    }

    /**
     * Constructor con valor
     * Inicializa un nodo con un valor específico sin hijos
     * 
     * @param valor El valor que contendrá el nodo
     */
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    /**
     * Constructor completo
     * Inicializa un nodo con valor y referencias a nodos hijos
     * 
     * @param valor El valor que contendrá el nodo
     * @param izquierdo Referencia al nodo hijo izquierdo
     * @param derecho Referencia al nodo hijo derecho
     */
    public Nodo(int valor, Nodo izquierdo, Nodo derecho) {
        this.valor = valor;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    // Getters y Setters
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    /**
     * Método para representar el nodo como string
     * 
     * @return String con la representación del nodo
     */
    @Override
    public String toString() {
        return "Nodo{" +
                "valor=" + valor +
                '}';
    }
}
