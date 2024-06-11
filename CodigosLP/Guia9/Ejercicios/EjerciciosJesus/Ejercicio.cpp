//Ejercicio 1
#include <iostream>
using namespace std;
class Figuras{
    public:
    //Metodos virtuales puros
        virtual double CalcularArea()=0;
        virtual double CalcularPerimetro()=0;
        virtual void mostrarDetalles()=0;
        virtual ~Figuras(){}    //Destructor virtual
};
class Circulo:public Figuras{
    private:
        int radio;
    public:
        Circulo(int r):radio(r){}
        //Implementacion de los metodos virtuales de la clase base
        double CalcularArea(){
            return 3.1416 * (radio*radio);
        }
        double CalcularPerimetro(){
            return (2*3.1416)*radio;
        }
        void mostrarDetalles(){
            cout<<"CIRCULO"<<endl;
            cout<<"El area del circulo es:"<<Circulo::CalcularArea()<<endl;
            cout<<"El perimetro del circulo es:"<<Circulo::CalcularPerimetro()<<endl;
        }
};
class Rectangulo:public Figuras{
    private:
        int base;
        int altura;
    public:
        Rectangulo(int b,int a):base(b),altura(a){}
        double CalcularArea(){
            return base*altura;
        }
        double CalcularPerimetro(){
            return (2*base)+(2*altura);
        }
        void mostrarDetalles(){
            cout<<"RECTANGULO"<<endl;
            cout<<"El area del rectangulo es:"<<Rectangulo::CalcularArea()<<endl;
            cout<<"El perimetro del rectangulo es:"<<Rectangulo::CalcularPerimetro()<<endl;
        }
};
class Triangulo:public Figuras{
    private:
        int base;
        int altura;
        int l2,l3;
    public:
        Triangulo(int b,int a,int l2,int l3):base(b),altura(a),l2(l2),l3(l3){}
        double CalcularArea(){
            return (base*altura)/2;
        }
        double CalcularPerimetro(){
            return base+l2+l3;
        }
        void mostrarDetalles(){
            cout<<"TRIANGULO"<<endl;
            cout<<"El area del triangulo es:"<<Triangulo::CalcularArea()<<endl;
            cout<<"El perimetro del triangulo es:"<<Triangulo::CalcularPerimetro()<<endl;
        }
};
class Cuadrado:public Figuras{
    private:
        int lado;
    public:
        Cuadrado(int l):lado(l){}
        double CalcularArea(){
            return lado*lado;
        }
        double CalcularPerimetro(){
            return 4*lado;
        }
        void mostrarDetalles(){
            cout<<"CUADRADO"<<endl;
            cout<<"El area del cuadrado es:"<<Cuadrado::CalcularArea()<<endl;
            cout<<"El perimetro del cuadrado es:"<<Cuadrado::CalcularPerimetro()<<endl;
        }
};
int main(){
    int opc=0;
    while (opc!=5){
        cout<<"------------------"<<endl;
        cout<<"Elija una figura"<<endl;
        cout<<"1.Circulo\n2.Triangulo\n3.Cuadrado\n4.Rectangulo\n5.Salir"<<endl;
        cout<<"------------------"<<endl;
        cin>>opc;
        if (opc==1){
            int radio;
            cout<<"Ingrese el radio del circulo"<<endl;
            cin>>radio;
            Figuras *figura=new Circulo(radio); //Creacion dinamica de una referencia a un objeto
            figura->mostrarDetalles();
            delete figura;  //Se elimina el objeto
        }
        else if (opc==2){
            int l1,l2,l3,altura;
            cout<<"Ingrese la base triangulo"<<endl;
            cin>>l1;
            cout<<"Ingrese la altura triangulo"<<endl;
            cin>>altura;
            cout<<"Ingrese los lados laterales del triangulo"<<endl;
            cin>>l2>>l3;
            Figuras *figura=new Triangulo(l1,altura,l2,l3);     //Creacion dinamica de una referencia a un objeto
            figura->mostrarDetalles();
            delete figura;  //Se elimina el objeto
        }
        else if(opc==3){
            int lado;
            cout<<"Ingrese un lado del cuadrado"<<endl;
            cin>>lado;
            Figuras *figura=new Cuadrado(lado);     //Creacion dinamica de una referencia a un objeto
            figura->mostrarDetalles();
            delete figura;  //Se elimina el objeto
        }
        else if(opc==4){
            int base,altura;
            cout<<"Ingrese la base y altura del rectangulo"<<endl;
            cin>>base>>altura;
            Figuras *figura= new Rectangulo(base,altura);   //Creacion dinamica de una referencia a un objeto
            figura->mostrarDetalles();
            delete figura;  //Se elimina el objeto
        }
    }
    return 0;
}

//Ejercicio 2
#include <iostream>
using namespace std;
class Animales{
    public:
        //Metodos virtuales puros
        virtual void Comer()=0; 
        virtual void Dormir()=0;
        virtual void Moverse()=0;
        virtual ~Animales(){}   //Destructor virtual
};
class Mamiferos:public Animales{
    public:
        virtual void Detalles(){    //Metodo virtual que muestra los detalles en comun
            cout<<"-Respiran por pulmones"<<endl;
            cout<<"-Toman leche materna"<<endl;
        }
};
class Aves:public Animales{
    public:
        virtual void Detalles(){    //Metodo virtual que muestra los detalles en comun
            cout<<"-Tiene extremidades en forma de alas"<<endl;
            cout<<"-Respiran por pulmones"<<endl;
        }
};
class Reptiles:public Animales{
    public:
        virtual void Detalles()=0;  //Metodo virtual puro
};
class Cocodrilo:public Reptiles{
    public:
        //Implementacion y sobreescribimiento de los metodos virtuales de las clases base
        void Comer(){
            cout<<"-Son carnivoros, dependiendo de su tamanio se alimentan de animales de mayor volumen"<<endl;
        }
        void Dormir(){
            cout<<"-Duermen con un ojo abierto para permanecer vigilantes"<<endl;
        }
        void Moverse(){
            cout<<"-Se deslizan arrastrando su estomago y empujandose con los pies. Para recorrer distancias grandes, adoptan un paso alto, levantando el cuerpo del suelo y arrastrando la cola"<<endl;
        }
        void Detalles(){
            cout<<"____Datos sobre el cocodrilo____"<<endl;
            Comer();    //Se llaman a los metodos de la misma clase
            Dormir();
            Moverse();
            cout<<"______________________________"<<endl;
        }
};
class Aguila:public Aves{
    public:
        //Implementacion y sobreescribimiento de los metodos virtuales de las clases base
        void Comer(){
            cout<<"-Son carnivoros (ardillas,liebres,cuervos,etc)"<<endl;
        }
        void Dormir(){
            cout<<"-Duermen con los ojos abiertos, lo que les permite detectar facilmente posibles peligros"<<endl;
        }
        void Moverse(){
            cout<<"-Usan su fuerza solamente para iniciar el vuelo. Una vez alcanzada una buena altura, aprovechan la fuerza de los vientos y se dejan llevar por ellos"<<endl;
        }
        void Detalles(){
            cout<<"____Datos sobre el aguila____"<<endl;
            Comer();    //Se llaman a los metodos de la misma clase
            Dormir();
            Moverse();
            Aves::Detalles();   //Refinamiento
            cout<<"______________________________"<<endl;
        }
};
class Caballo:public Mamiferos{
    public:
        //Implementacion y sobreescribimiento de los metodos virtuales de las clases base
        void Comer(){
            cout<<"-Son herbivoros (alfalfa,maiz,manzanas,etc)"<<endl;
        }
        void Dormir(){
            cout<<"-Duermen parados en promedio tres horas"<<endl;
        }
        void Moverse(){
            cout<<"-Se desplaza de tres formas diferentes: al paso, al trote y al galope"<<endl;
        }
        void Detalles(){
            cout<<"____Datos sobre el caballo____"<<endl;
            Comer();      //Se llaman a los metodos de la misma clase
            Dormir();
            Moverse();
            Mamiferos::Detalles();    //Refinamiento
            cout<<"______________________________"<<endl;
        }
};
int main(){
    int opc=0;
    while (opc!=4){
        cout<<"------------------"<<endl;
        cout<<"Elija un animal"<<endl;
        cout<<"1.Caballo\n2.Aguila\n3.Cocodrilo\n4.Salir"<<endl;
        cout<<"------------------"<<endl;
        cin>>opc;
        if (opc==1){
            Mamiferos *animal=new Caballo();    //Creacion dinamica de una referencia a un objeto
            animal->Detalles();
            delete animal;  //Se elimina el objeto
        }
        else if (opc==2){
            Aves *animal=new Aguila();      //Creacion dinamica de una referencia a un objeto
            animal->Detalles();
            delete animal;  //Se elimina el objeto
        }
        else if(opc==3){
            Reptiles* animal=new Cocodrilo();       //Creacion dinamica de una referencia a un objeto
            animal->Detalles();
            delete animal;  //Se elimina el objeto
        }
    }
    return 0;
}
//Ejercicio 3
#include <iostream>
using namespace std;
class Empleados{
    public:
        //Metodos virtuales
        virtual void CalcularSalario(float)=0;
        virtual ~Empleados(){}  //Destructor virtual

};
class Asalariados:public Empleados{
    public:
        //Polimorfismo de subtipo
        void CalcularSalario(float salario){
            cout<<"Salario mensual:"<<salario<<endl;
        }
};
class PorHora:public Empleados{
    private:
        float pagoHora;
    public:
    PorHora(float ph):pagoHora(ph){} //Constructor por lista de incializacion
        void CalcularSalario(float horas){
            cout<<"Salario total:"<<pagoHora*horas<<endl;
        }
};
class Comisionista:public Empleados{
    public:
        void CalcularSalario(float comision){
            CompletarTrabajo();
            cout<<"Salario total:"<<comision<<endl;
        }
        void CompletarTrabajo(){
            cout<<"Trabajo completado"<<endl;
        }
};
int main(){
    int opc=0;
    while (opc!=4){
        cout<<"------------------"<<endl;
        cout<<"Elija una opcion para calcular salario"<<endl;
        cout<<"1.Asalariado\n2.Por hora\n3.Comisionista\n4.Salir"<<endl;
        cout<<"------------------"<<endl;
        cin>>opc;
        if (opc==1){
            float salario;
            cout<<"Ingrese el salario mensual"<<endl;
            cin>>salario;
            Empleados* empleado=new Asalariados();
            empleado->CalcularSalario(salario);
            delete empleado;  //Se elimina el objeto
        }
        else if (opc==2){
            float horas,pagohora;
            cout<<"Ingrese el pago por hora"<<endl;
            cin>>pagohora;
            cout<<"Ingrese las horas trabajadas"<<endl;
            cin>>horas;
            Empleados* empleado=new PorHora(pagohora);
            empleado->CalcularSalario(horas);
            delete empleado;  //Se elimina el objeto
        }
        else if(opc==3){
            float comision;
            cout<<"Ingrese la comision que recibira"<<endl;
            Empleados* empleado=new Comisionista();
            empleado->CalcularSalario(comision);
            delete empleado;  //Se elimina el objeto
        }
    }
    return 0;
}
//Ejercicio 4
#include <iostream>
using namespace std;
class Personajes{
    public:
        virtual void atacar(string)=0;
        virtual void defender(int)=0;
        virtual void usarHabilidades()=0;

};
class Guerrero:public Personajes{
    private:
        float Habilidad1;
        float Habilidad2;
    public:
        Guerrero(float h1,float h2):Habilidad1(h1),Habilidad2(h2){}
        void atacar(string arma){
            cout<<"Atacando con "<<arma<<endl;
        }
        void defender(int vida){
            cout<<"Escudo con "<<vida<<" puntos de vida"<<endl;
        }
        void usarHabilidades(){
            cout<<"Dano de habilidad1:"<<Habilidad1<<endl;
            cout<<"Dano de habilidad2:"<<Habilidad2<<endl;
        }
};
class Mago:public Personajes{
    private:
        float Habilidad1;
        float Habilidad2;
    public:
        Mago(float h1,float h2):Habilidad1(h1),Habilidad2(h2){}
        void atacar(string arma){
            cout<<"Atacando con "<<arma<<endl;
        }
        void defender(int vida){
            cout<<"Escudo con "<<vida<<" puntos de vida"<<endl;
        }
        void usarHabilidades(){
            cout<<"Dano de habilidad1:"<<Habilidad1<<endl;
            cout<<"Dano de habilidad2:"<<Habilidad2<<endl;
        }
};
class Arquero:public Personajes{
    private:
        float Habilidad1;
        float Habilidad2;
    public:
        Arquero(float h1,float h2):Habilidad1(h1),Habilidad2(h2){}
        void atacar(string arma){
            cout<<"Atacando con "<<arma<<endl;
        }
        void defender(int vida){
            cout<<"Escudo con "<<vida<< "puntos de vida"<<endl;
        }
        void usarHabilidades(){
            cout<<"Dano de habilidad1:"<<Habilidad1<<endl;
            cout<<"Dano de habilidad2:"<<Habilidad2<<endl;
        }
};
int main(){
    int opc=0;
    while (opc!=4){
        cout<<"------------------"<<endl;
        cout<<"Elija una opcion"<<endl;
        cout<<"1.Guerrero\n2.Mago\n3.Arquero\n4.Salir"<<endl;
        cout<<"------------------"<<endl;
        cin>>opc;
        if (opc==1){
            float h1,h2;
            string arma;
            int escudo;
            cout<<"Ingrese el arma que usara como guerrero"<<endl;
            cin>>arma;
            cout<<"Ingrese la vida del escudo"<<endl;
            cin>>escudo;
            cout<<"Ingrese el danio de la habilidad uno y dos"<<endl;
            cin>>h1>>h2;
            Personajes* personaje=new Guerrero(h1,h2);
            personaje->atacar(arma);
            personaje->defender(escudo);
            personaje->usarHabilidades();
            delete personaje;  //Se elimina el objeto
        }
        else if (opc==2){
            float h1,h2;
            string arma;
            int escudo;
            cout<<"Ingrese el arma que usara como mago"<<endl;
            cin>>arma;
            cout<<"Ingrese la vida del escudo"<<endl;
            cin>>escudo;
            cout<<"Ingrese el danio de la habilidad uno y dos"<<endl;
            cin>>h1>>h2;
            Personajes* personaje=new Mago(h1,h2);
            personaje->atacar(arma);
            personaje->defender(escudo);
            personaje->usarHabilidades();
            delete personaje;  //Se elimina el objeto
        }
        else if(opc==3){
            float h1,h2;
            string arma;
            int escudo;
            cout<<"Ingrese el arma que usara como arquero"<<endl;
            cin>>arma;
            cout<<"Ingrese la vida del escudo"<<endl;
            cin>>escudo;
            cout<<"Ingrese el danio de la habilidad uno y dos"<<endl;
            cin>>h1>>h2;
            Personajes* personaje=new Arquero(h1,h2);
            personaje->atacar(arma);
            personaje->defender(escudo);
            personaje->usarHabilidades();
            delete personaje;  //Se elimina el objeto
        }
    }
    return 0;
}

//Ejercicio 5

