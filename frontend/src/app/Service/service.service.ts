import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Task } from '../model/Task';
import { Transition } from '../model/Transition';
@Injectable( {
    providedIn: 'root'
} )
export class ServiceService {
  

    constructor( private http: HttpClient ) { }

    Url = 'http://localhost:8080/tasks';
    
    httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json',
          'accept':'application/json'
        })
      };
      
    getTasks() {
        return this.http.get<Task[]>( this.Url );
    }

    createTask(task:Task)
    {
        return this.http.post<Task>(this.Url,task,this.httpOptions); 
    }

    getTaskById(id:number)
    {
        return this.http.get<Task>(this.Url+"/"+id);
    }

    update(task:Task)
    {
       return this.http.put<Task>(this.Url+"/"+task.id,task);
    }

    getTransitions() {
        return this.http.get<Transition[]>( this.Url.replace("task","transition") );
      }

}
