#include "stdio.h"
#include "string.h"
#include <iostream>
#include <map>
#define _A 4
#define _B 3

using namespace std;


struct state{
	int x;
	int y;

};

typedef struct state state;
typedef struct node node;

class Queue{
	state** arr;
	int pointer;
	Queue(){
		arr=new state*[40];
		pointer=-1;
	}
	int enqueue(state* snap){
		if(pointer==-1)
			pointer++;
		if(pointer>39)
			return -1;
		arr[pointer]=snap;
		pointer++;
		return 1;
	}
	state * dequeue(){
		if(pointer<0)
			return arr[0];
		return arr[pointer];
		pointer--;

	}
};

struct node{
	 node* next;
	 state* data;
};


 char* getName(state* T){
	 char* name=new char[10];
	 sprintf(name,"(%d,%d)",T->x,T->y);
	 return name;

}
void print_state(state* T){
	printf("(%d,%d)\n",T->x,T->y);
}

state* FA(state* T){
	state *ns= (state*)new state;
	ns->x=_A;
	ns->y=T->y;
	return ns;
}

state* FB(state* T){
	state *ns= new state;
		ns->x=T->x;
		ns->y=_B;
		return ns;
}

state* EA(state* T){
	state *ns= (state*) new state;
		ns->x=0;
		ns->y=T->y;
		return ns;
}

state* EB(state* T){
	state *ns= (state*)new state;
		ns->x=T->x;
		ns->y=0;
		return ns;
}

state* XAB(state* T){
	state *ns= (state*) new state;
	if((T->x)+(T->y)-_B >=0){
		ns->x=(T->x)+(T->y)-_B ;
		ns->y=_B;
	}
	else{
		ns->y=T->x+T->y;
		ns->x=0;
	}
	return ns;
}

state* XBA(state* T){
	state *ns= (state*) new state;
	if((T->x)+(T->y)-_A >=0){
		ns->y=(T->x)+(T->y)-_A ;
		ns->x=_A;
	}
	else{
		ns->x=T->x+T->y;
		ns->y=0;
	}
	return ns;
}






int main(){

	printf("Starting state generation \n");
	node *front;
	state* initial_state=(state*)new state;
	initial_state->y=0;
	initial_state->x=0;
	map<char*,char*> set;

	//set.insert(getName(initial_state),"a");
	//cout<<getName(FA(initial_state));
	//print_state(FA(initial_state));


}



