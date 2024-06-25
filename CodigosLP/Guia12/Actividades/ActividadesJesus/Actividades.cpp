//Actividad 1
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Vector{
    private:
    vector<int> Numeros;
    public:
        void IngresarNumeros(){
            string opc=" ";
            int numero,cont;
            while (opc!="n" and opc!="N")
            {
                while (cont<=5){
                    cout<<"Ingrese un numero"<<endl;
                    cin>>numero;
                    Numeros.push_back(numero);
                    cont++;
                }
                cout<<"Seguir ingresando?S/N"<<endl;
                cin>>opc;
            }
        }
        /*int Sumar(){
            int acumulador=0;
            for(int i=0;i<Numeros.size();i++){
                acumulador+=Numeros[i];
            }
            return acumulador;
        }*/
        int Sumar1(){
            int acumulador=0;
            for(auto it=Numeros.begin();it!=Numeros.end();++it){
                acumulador+=*it;
            }
            return acumulador;
        }
        void Maximo_Minimo(){
            int mayor=-999999999;
            int menor=999999990;
            for(auto it=Numeros.begin();it!=Numeros.end();++it){
                if(*it<menor)
                    menor=*it;
                if(*it>mayor)
                    mayor=*it;
            }
            cout<<"El mayor es:"<<mayor<<endl;
            cout<<"El menor es:"<<menor<<endl;
        }
        void Ordenar_Ascedente(){
            sort(Numeros.begin(),Numeros.end());
            cout<<"Lista ordenada de forma ascendente:"<<endl;
            for(auto it=Numeros.begin();it!=Numeros.end();++it){
                cout<<*it<<" ";
            }
            cout<<endl;
        }
        void Eliminar_Pares(){
            vector<int>Numeros1;
            for(int i:Numeros){
                if(i%2!=0){
                    Numeros1.push_back(i);
                }
            }
            Numeros=move(Numeros1);
        }
        void MostrarVector(){
            cout<<"Vector:";
            for (auto it=Numeros.begin();it!=Numeros.end();++it){
                cout<<*it<<" ";
            }
            cout<<endl;
        }
};

int main(){
    int opc=0;
    Vector vector;
    
    while (opc!=7){
        cout<<"--------------------"<<endl;
        cout<<"Que desea realizar"<<endl;
        cout<<"1.Ingresar\n2.Sumar\n3.Maximo y minimo\n4.Ordenar forma ascendente\n5.Eliminar numeros pares\n6.Mostrar vector\n7.Salir"<<endl;
        cout<<"--------------------"<<endl;
        cin>>opc;
        if (opc==1){
            vector.IngresarNumeros();
        }
        else if(opc==2){
            //cout<<"La suma total es:"<<vector.Sumar()<<endl;
            cout<<"La suma total es:"<<vector.Sumar1()<<endl;
        }
        else if(opc==3){
            vector.Maximo_Minimo();
        }
        else if(opc==4){
            vector.Ordenar_Ascedente();
        }
        else if(opc==5){
            vector.Eliminar_Pares();
        }
        else if(opc==6){
            vector.MostrarVector();
        }
    }
    return 0;
}
//Actividad 3
#include <iostream>
#include <algorithm>
#include <deque>
using namespace std;

void RecorrerDeque(const deque<char>Deque){     //Recorre el deque e imprime
    cout<<"Deque:";
    for(auto it=Deque.begin();it!=Deque.end();++it){
        cout<<*it<<" ";
    }
    cout<<endl;
}

void RemoverVocales(deque<char>& Deque) {   //Cambia las vocales por "*"
    string vocales = "aeiouAEIOU";
    for (auto it = Deque.begin(); it != Deque.end(); ++it) {    //Iterador
        if (vocales.find(*it) != string::npos) {
            *it = '*';
        }
    }
}

void Inverso(const deque<char>Deque){       //Imprime en orden inverso
    cout<<"Deque:";
    for(auto it=Deque.rbegin();it!=Deque.rend();++it){
        cout<<*it<<" ";
    }
    cout<<endl;
}



int main(){
    string palabra;
    deque <char> Deque; //Contenedor deque
    cout<<"Ingrese una palabra:";
    cin>>palabra;
    for(char i:palabra){    //Itera sobre cada carácter de "palabra"
        Deque.push_back(i); //Se agrega al final del deque el carácter
    }

    RecorrerDeque(Deque);
    RemoverVocales(Deque);
    Inverso(Deque);
    RecorrerDeque(Deque);

}
