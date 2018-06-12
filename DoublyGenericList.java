interface Iterator{
    abstract boolean hasNext();
    Object Next();
}

class ListIterator<T> implements Iterator{

    int Position = 0;

    DoublyGenericList<T> Ls;

    public ListIterator(DoublyGenericList<T> Ls){
        this.Ls = Ls;
    }

    @Override
    public boolean hasNext() {
        return (Position >= Ls.ListSize);
    }

    @Override
    public Object Next() {
        //Recorrer con Recursividad
    }

    public GeNode<T> getNode_By_Position(int Pos,GeNode<T> TmpNode){

        if(Pos < 0){

        }
    }
}


public class DoublyGenericList<T> implements Iterator{

    int ListSize = 0;
    int Position = 0;
    GeNode<T> First;
    GeNode<T> Last;

    //(^< ............ ............ ............ Constructor: Default NULL
    DoublyGenericList(){
        this.ListSize = 0;
        this.First = null;
        this.Last = null;
    }

    //(^< ............ ............ ............ IsEmpty
    public boolean IsEmpty(){
        return (ListSize == 0);
    }

    //(^< ............ ............ ............ IndexIsValid
    public boolean IndexIsValid(int index){
        return (index >= 0 && index <= ListSize);
    }

    //(^< ............ ............ ............ InsertWhenEmpty
    public boolean InsertWhenEmpty(T Dt){

        if(IsEmpty()){
            First = Last = new GeNode<T>(Dt);
            ListSize++;
            return true;
        }

        return false;
    }

    //(^< ............ ............ ............ FontInsert
    public void FrontInsert(T Dt){

        if(InsertWhenEmpty(Dt)) {
            return;
        }
        else{
            GeNode<T> TmpNode = new GeNode<T>(Dt);

            First.Previous = TmpNode;
            TmpNode.Next = this.First;

            First = TmpNode;
            ListSize++;
        }
    }

    //(^< ............ ............ ............ EndInsert
    public void EndInsert(T Dt){

        if(InsertWhenEmpty(Dt)) {
            return;
        }
        else{
            GeNode<T> TmpNode = new GeNode<T>(Dt);

            Last.Next = TmpNode;
            TmpNode.Previous = Last;

            Last = TmpNode;
            ListSize++;
        }
    }

    //(^< ............ ............ ............ Insertar en Indice Especifico
    public boolean InsertAt(int index,T Dt){
        if(IndexIsValid(index)){

            //(^< ............ Insertar al Frente de la Lista
            if(index == 0){
                FrontInsert(Dt);
                return true;
            }

            //(^< ............ Insertar al Final de la Lista
            else if(index == ListSize){
                EndInsert(Dt);
                return true;
            }

            //(^< ............ Insertar en Indice Intermedio
            GeNode<T> TmpNode = GetNode(index - 1);
            GeNode<T> NewNode = new GeNode<T>(Dt);

            //NewNode->SetNext(TmpNode->GetNext());
            NewNode.Next = TmpNode.Next;

            //NewNode->SetPrevious(TmpNode);
            NewNode.Previous = TmpNode;

            //TmpNode->GetNext()->SetPrevious(NewNode);
            TmpNode.Next.Previous = NewNode;

            //TmpNode->SetNext(NewNode);
            TmpNode.Next = NewNode;

            ListSize++;
            return true;
        }
        else{
            return false;
        }
    }

    //(^< ............ ............ ............ GetNode
    public GeNode<T> GetNode(int index){

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object Next() {
        return null;
    }
}
