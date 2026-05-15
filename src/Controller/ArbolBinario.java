package Controller;

import Model.Nodo;

/**
 * Clase Controladora para el Árbol Binario de Búsqueda
 * Implementa operaciones básicas: inserción, búsqueda, recorridos y análisis
 */
public class ArbolBinario {
    private Nodo raiz;

    /**
     * Constructor del árbol binario
     * Inicializa el árbol sin raíz
     */
    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Verifica si el árbol está vacío
     * 
     * @return true si el árbol está vacío, false en caso contrario
     */
    public boolean estaVacio() {
        return raiz == null;
    }

    /**
     * Obtiene la raíz del árbol
     * 
     * @return El nodo raíz
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Inserta un valor en el árbol binario de búsqueda
     * Los valores menores van a la izquierda, mayores a la derecha
     * 
     * @param valor El valor a insertar
     */
    public void insertar(int valor) {
        if (estaVacio()) {
            raiz = new Nodo(valor);
        } else {
            insertarRecursivo(raiz, valor);
        }
    }

    /**
     * Método auxiliar recursivo para insertar
     * 
     * @param nodo Nodo actual
     * @param valor Valor a insertar
     */
    private void insertarRecursivo(Nodo nodo, int valor) {
        if (valor < nodo.getValor()) {
            if (nodo.getIzquierdo() == null) {
                nodo.setIzquierdo(new Nodo(valor));
            } else {
                insertarRecursivo(nodo.getIzquierdo(), valor);
            }
        } else if (valor > nodo.getValor()) {
            if (nodo.getDerecho() == null) {
                nodo.setDerecho(new Nodo(valor));
            } else {
                insertarRecursivo(nodo.getDerecho(), valor);
            }
        }
        // Si valor == nodo.getValor(), no se inserta (evita duplicados)
    }

    /**
     * Busca un valor en el árbol
     * 
     * @param valor El valor a buscar
     * @return true si se encuentra, false en caso contrario
     */
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    /**
     * Método auxiliar recursivo para buscar
     * 
     * @param nodo Nodo actual
     * @param valor Valor a buscar
     * @return true si se encuentra, false en caso contrario
     */
    private boolean buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return false;
        }

        if (valor == nodo.getValor()) {
            return true;
        } else if (valor < nodo.getValor()) {
            return buscarRecursivo(nodo.getIzquierdo(), valor);
        } else {
            return buscarRecursivo(nodo.getDerecho(), valor);
        }
    }

    /**
     * Recorrido InOrden (Izquierda - Raíz - Derecha)
     * Imprime los valores en orden ascendente
     */
    public void recorridoInOrden() {
        System.out.print("Recorrido InOrden: ");
        recorridoInOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorridoInOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorridoInOrdenRecursivo(nodo.getIzquierdo());
            System.out.print(nodo.getValor() + " ");
            recorridoInOrdenRecursivo(nodo.getDerecho());
        }
    }

    /**
     * Recorrido PreOrden (Raíz - Izquierda - Derecha)
     */
    public void recorridoPreOrden() {
        System.out.print("Recorrido PreOrden: ");
        recorridoPreOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorridoPreOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValor() + " ");
            recorridoPreOrdenRecursivo(nodo.getIzquierdo());
            recorridoPreOrdenRecursivo(nodo.getDerecho());
        }
    }

    /**
     * Recorrido PostOrden (Izquierda - Derecha - Raíz)
     */
    public void recorridoPostOrden() {
        System.out.print("Recorrido PostOrden: ");
        recorridoPostOrdenRecursivo(raiz);
        System.out.println();
    }

    private void recorridoPostOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorridoPostOrdenRecursivo(nodo.getIzquierdo());
            recorridoPostOrdenRecursivo(nodo.getDerecho());
            System.out.print(nodo.getValor() + " ");
        }
    }

    /**
     * Obtiene la altura del árbol
     * 
     * @return La altura del árbol (número de niveles)
     */
    public int obtenerAltura() {
        return obtenerAlturaRecursivo(raiz);
    }

    private int obtenerAlturaRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(obtenerAlturaRecursivo(nodo.getIzquierdo()),
                            obtenerAlturaRecursivo(nodo.getDerecho()));
    }

    /**
     * Cuenta el número total de nodos en el árbol
     * 
     * @return La cantidad de nodos
     */
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    private int contarNodosRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodosRecursivo(nodo.getIzquierdo()) +
               contarNodosRecursivo(nodo.getDerecho());
    }

    /**
     * Obtiene el valor mínimo del árbol
     * 
     * @return El valor mínimo (más a la izquierda)
     */
    public int obtenerMinimo() {
        if (estaVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }
        return obtenerMinimoRecursivo(raiz);
    }

    private int obtenerMinimoRecursivo(Nodo nodo) {
        if (nodo.getIzquierdo() == null) {
            return nodo.getValor();
        }
        return obtenerMinimoRecursivo(nodo.getIzquierdo());
    }

    /**
     * Obtiene el valor máximo del árbol
     * 
     * @return El valor máximo (más a la derecha)
     */
    public int obtenerMaximo() {
        if (estaVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }
        return obtenerMaximoRecursivo(raiz);
    }

    private int obtenerMaximoRecursivo(Nodo nodo) {
        if (nodo.getDerecho() == null) {
            return nodo.getValor();
        }
        return obtenerMaximoRecursivo(nodo.getDerecho());
    }
}
