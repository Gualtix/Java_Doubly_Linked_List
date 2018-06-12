public class GeNode<T> {

    T Dt;
    GeNode<T> Previous;
    GeNode<T> Next;

    //(^< ............ ............ ............ Constructor: Default NULL
    GeNode(){
        this.Dt = null;
        this.Previous = null;
        this.Next = null;
    }

    //(^< ............ ............ ............ Constructor: Set
    GeNode(T Dt){
        this.Dt = Dt;
        this.Previous = null;
        this.Next = null;
    }

}
